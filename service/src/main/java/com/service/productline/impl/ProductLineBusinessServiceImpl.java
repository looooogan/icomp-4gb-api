package com.service.productline.impl;

import com.common.constants.OperationEnum;
import com.common.constants.RFIDEnum;
import com.common.mapper.*;
import com.common.pojo.*;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.service.productline.IProductLineBusinessService;
import com.service.productline.vo.QueryEquipmentByRfidVO;
import com.service.productline.vo.QuerySynthesisCuttingToolVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by logan on 2018/4/30.
 */
@Service("productLineBusinessService")
public class ProductLineBusinessServiceImpl implements IProductLineBusinessService{

    @Autowired
    private IProductLineAssemblylineMapper assemblylineMapper;

    @Autowired
    private IProductLineMapper productLineMapper;

    @Autowired
    private IProductLineEquipmentMapper equipmentMapper;

    @Autowired
    private IRfidContainerMapper rfidContainerMapper;

    @Autowired
    private ISynthesisCuttingToolBindMapper synthesisCuttingToolBindMapper;

    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;

    /**
     * 获取所有流水线
     * @return 流水线列表
     * @throws Exception
     */
    @Override
    public List<ProductLineAssemblyline> getAllAssemblyline() throws Exception {
        ProductLineAssemblylineVO assemblylineVO = new ProductLineAssemblylineVO();
        return assemblylineMapper.getProductLineAssemblylineByPage(assemblylineVO);
    }

    /**
     *  根据流水线查询生产关联关系中的设备
     * @param productLineVO 生产关联关系查询条件封装
     * @return 设备列表
     * @throws Exception
     */
    @Override
    public List<ProductLineEquipment> getEquipmentByAssemblyline(ProductLineVO productLineVO) throws Exception {
        List<ProductLine> productLines = productLineMapper.getProductLineByPage(productLineVO);
        List<ProductLineEquipment> productLineEquipments = new ArrayList<>();
        Map<Integer,ProductLineEquipment> map = new HashMap<>();

        for(ProductLine productLine : productLines){
            if (null == productLine.getProductLineEquipment()){
                continue;
            }
            if (null != productLine.getProductLineEquipment().getRfidContainerCode()){
                continue;
            }
            if (map.containsKey(productLine.getProductLineEquipment().getId())){
                continue;
            }
            map.put(productLine.getProductLineEquipment().getId(),productLine.getProductLineEquipment());
            productLineEquipments.add(productLine.getProductLineEquipment());
        }
        return productLineEquipments;
    }

    /**
     * 初始化设备
     * @param productLineEquipment 设备列表
     * @throws Exception
     */
    @Override
    public void addInitEquipment(ProductLineEquipment productLineEquipment) throws Exception {

        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(productLineEquipment.getRfidContainer().getLaserCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
        if (rfidContainer == null){
            rfidContainer = new RfidContainer();
            rfidContainer.setIsDel(0);
            rfidContainer.setUseCount(1);
            rfidContainer.setCode(UUID.getInstance());
            rfidContainer.setLaserCode(productLineEquipment.getRfidContainer().getLaserCode());
            rfidContainer.setLabelType(RFIDEnum.equipment.getKey());
            rfidContainer.setOperatorCode(OperationEnum.Equipment_Init.getKey());
            rfidContainer.setOperatorName(OperationEnum.Equipment_Init.getName());
            rfidContainerMapper.addRfidContainer(rfidContainer);
        }else if (rfidContainer.getOperatorCode()==null || rfidContainer.getOperatorCode() == 0){
            rfidContainer.setPrevKey(rfidContainer.getOperatorCode());
            rfidContainer.setPrevOperation(rfidContainer.getOperatorName());
            rfidContainer.setUseCount(rfidContainer.getUseCount()+1);
            rfidContainer.setLabelType(RFIDEnum.equipment.getKey());
            rfidContainer.setOperatorCode(OperationEnum.Equipment_Init.getKey());
            rfidContainer.setOperatorName(OperationEnum.Equipment_Init.getName());
            rfidContainerMapper.updRfidContainer(rfidContainer);
        }else {
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_IN_USE));
        }
        productLineEquipment.setStatues(1);
        productLineEquipment.setRfidContainerCode(rfidContainer.getCode());
        equipmentMapper.updProductLineEquipment(productLineEquipment);
    }

    /**
     * 根据RFID查询合成刀信息
     * @param querySynthesisCuttingToolVO 查询条件
     * @throws Exception
     */
    @Override
    public SynthesisCuttingToolBind querySynthesisCuttingTool(QuerySynthesisCuttingToolVO querySynthesisCuttingToolVO) throws Exception {
        SynthesisCuttingToolBindVO bindVO = new SynthesisCuttingToolBindVO();
        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(querySynthesisCuttingToolVO.getRfidCode());
        bindVO.setRfidContainerVO(rfidContainerVO);
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(bindVO);
        return synthesisCuttingToolBind;
    }

    @Override
    public QueryEquipmentByRfidVO queryEquipmentByRFID(QueryEquipmentByRfidVO queryEquipmentByRfidVO) throws Exception {
        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(queryEquipmentByRfidVO.getRfidCode());
        ProductLineEquipmentVO equipmentVO = new ProductLineEquipmentVO();
        equipmentVO.setRfidContainerVO(rfidContainerVO);
        queryEquipmentByRfidVO.setProductLineEquipment(equipmentMapper.getProductLineEquipment(equipmentVO));

        ProductLineVO productLineVO = new ProductLineVO();
        productLineVO.setSynthesisCuttingToolCode(queryEquipmentByRfidVO.getSynthesisCuttingToolCode());
        productLineVO.setEquipmentCode(queryEquipmentByRfidVO.getProductLineEquipment().getCode());
        queryEquipmentByRfidVO.setProductLines(productLineMapper.getProductLineByPage(productLineVO));
        return queryEquipmentByRfidVO;
    }
}
