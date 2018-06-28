package com.service.productline.impl;

import com.common.constants.EquipmentBindStatus;
import com.common.constants.EquipmentTypeEnum;
import com.common.constants.EquipmentUseEnum;
import com.common.constants.OperationEnum;
import com.common.mapper.*;
import com.common.pojo.*;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.materialInventory.MaterialInventoryModel;
import com.service.materialInventory.SynthesisInventoryModel;
import com.service.materialInventory.bo.MaterialInventoryBO;
import com.service.materialInventory.bo.SynthesisMaterialInventoryBO;
import com.service.productline.bo.ToolBindleRecordsBO;
import com.service.productline.model.BindleRecordsModel;
import com.service.productline.IProductLineBusinessService;
import com.service.productline.bo.BindleRecordsBO;
import com.service.productline.bo.ProductLineBO;
import com.service.productline.model.ToolBindleRecordsModel;
import com.service.productline.vo.QueryVO;
import com.service.rfid.RfidModel;
import com.service.rfid.vo.RFIDBindVO;
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
    private ISynthesisCuttingToolBindMapper synthesisCuttingToolBindMapper;
    @Autowired
    private ISynthesisCuttingToolLocationMapper locationMapper;
    @Autowired
    private ISynthesisCuttingToolConfigMapper configMapper;
    @Autowired
    private ISynthesisCuttingToolLocationConfigMapper locationConfigMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;
    @Autowired
    private RfidModel rfidModel;
    @Autowired
    private BindleRecordsModel bindleRecordsModel;
    @Autowired
    private SynthesisInventoryModel synthesisInventoryModel;
    @Autowired
    private MaterialInventoryModel materialInventoryModel;
    @Autowired
    private ToolBindleRecordsModel toolBindleRecordsModel;

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
        Map<String,ProductLineEquipment> map = new HashMap<>();

        for(ProductLine productLine : productLines){
            if (null == productLine.getProductLineEquipment()){
                continue;
            }
            if (null != productLine.getProductLineEquipment().getRfidContainerCode()){
                continue;
            }
            if (!StringUtils.isBlank(productLine.getProductLineEquipment().getRfidContainerCode())){
                continue;
            }
            if (map.containsKey(productLine.getProductLineEquipment().getCode())){
                continue;
            }
            map.put(productLine.getProductLineEquipment().getCode(),productLine.getProductLineEquipment());
            productLineEquipments.add(productLine.getProductLineEquipment());
        }
        return productLineEquipments;
    }

    /**
     * 初始化设备
     * @param productLineBO 设备业务数据封装
     * @throws Exception
     */
    @Override
    public void addInitEquipment(ProductLineBO productLineBO) throws Exception {
        //处理rfid信息
        RFIDBindVO rfidBindVO = new RFIDBindVO();
        rfidBindVO.setLoginUser(productLineBO.getLoginUser());
        rfidBindVO.setOperationEnum(OperationEnum.Equipment_Init);
        rfidBindVO.setRfidContainerVO(productLineBO.getProductLineEquipmentVO().getRfidContainerVO());
        RfidContainer rfidContainer = rfidModel.bindRFID(rfidBindVO);

        //更新设备信息
        ProductLineEquipmentVO productLineEquipmentVO = new ProductLineEquipmentVO();
        productLineEquipmentVO.setCode(productLineBO.getProductLineEquipmentVO().getCode());
        ProductLineEquipment productLineEquipment = equipmentMapper.getProductLineEquipment(productLineEquipmentVO);
        productLineEquipment.setRfidContainerCode(rfidContainer.getCode());
//        productLineEquipment.setStatues(EquipmentBindStatus.Bind.getKey());
        equipmentMapper.updProductLineEquipment(productLineEquipment);
    }

    /**
     * 为安上设备查询设备列表
     * @param productLineBO 设备
     * @return
     * @throws Exception
     */
    @Override
    public QueryVO queryForInstall(ProductLineBO productLineBO) throws Exception {
        QueryVO queryVO = new QueryVO();
        //查询合成刀绑定信息
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(productLineBO.getSynthesisCuttingToolBindVO());
        SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO = new SynthesisCuttingToolLocationVO();
        synthesisCuttingToolLocationVO.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
        synthesisCuttingToolBind.setSynthesisCuttingToolLocationList(locationMapper.getSynthesisCuttingToolLocationByPage(synthesisCuttingToolLocationVO));
        queryVO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        //查询合成刀配置信息
        SynthesisCuttingToolConfigVO configVO = new SynthesisCuttingToolConfigVO();
        configVO.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
        SynthesisCuttingToolConfig config = configMapper.getSynthesisCuttingToolConfig(configVO);
        SynthesisCuttingToolLocationConfigVO locationConfigVO = new SynthesisCuttingToolLocationConfigVO();
        locationConfigVO.setSynthesisCuttingToolConfigId(config.getId());
        List<SynthesisCuttingToolLocationConfig> locationConfigList = locationConfigMapper.getSynthesisCuttingToolLocationConfigByPage(locationConfigVO);
        config.setSynthesisCuttingToolLocationConfigList(locationConfigList);
        queryVO.setConfig(config);

        //查询加工设备信息
        ProductLineVO productLineVO = new ProductLineVO();
        productLineVO.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingTool().getCode());
        List<ProductLine> productLines = productLineMapper.getProductLineByPage(productLineVO);
        Map<String,ProductLineEquipment> tmp = new HashMap<>();
        List<ProductLineEquipment> equipmentList = new ArrayList<>();
        for (ProductLine productLine : productLines) {
            if (null == productLine.getProductLineEquipment()){
                continue;
            }
            if (tmp.containsKey(productLine.getProductLineEquipment().getCode())){
                continue;
            }
            if (productLine.getProductLineEquipment().getType().equals(EquipmentTypeEnum.Grinding.getKey())){
                continue;
            }
            if (productLine.getProductLineEquipment().getStatues() == EquipmentUseEnum.InUse.getKey()){
                continue;
            }
            tmp.put(productLine.getProductLineEquipment().getCode(),productLine.getProductLineEquipment());
            equipmentList.add(productLine.getProductLineEquipment());
        }
        queryVO.setEquipmentList(equipmentList);
        return queryVO;
    }

    /**
     * 安上设备
     * @param productLineBO
     * @throws Exception
     */
    @Override
    public void installData(ProductLineBO productLineBO) throws Exception {
        //查询合成刀信息
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(productLineBO.getSynthesisCuttingToolBindVO());
        ProductLineEquipment equipment = equipmentMapper.getProductLineEquipment(productLineBO.getProductLineEquipmentVO());
        equipment.setStatues(EquipmentUseEnum.InUse.getKey());
        equipmentMapper.updProductLineEquipment(equipment);

        ProductLineVO productLineVO = new ProductLineVO();
        productLineVO.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingTool().getCode());
        productLineVO.setEquipmentCode(equipment.getCode());
        ProductLine productLine = productLineMapper.getAssemblylineByEquipmentAndAxle(productLineVO);

        //添加调刀记录
        BindleRecordsBO bindleRecordsBO = new BindleRecordsBO();
        bindleRecordsBO.setProductLine(productLine);
        bindleRecordsBO.setLoginUser(productLineBO.getLoginUser());
        bindleRecordsBO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        bindleRecordsModel.addBindleRecords(bindleRecordsBO);
        //更新合成刀库存
        SynthesisMaterialInventoryBO synthesisMaterialInventoryBO = new SynthesisMaterialInventoryBO();
        synthesisMaterialInventoryBO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        synthesisInventoryModel.updateInventoryForInstall(synthesisMaterialInventoryBO);

        //更新材料刀库存
        MaterialInventoryBO materialInventoryBO = new MaterialInventoryBO();
        materialInventoryBO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        materialInventoryModel.updateInventoryForInstall(materialInventoryBO);

        //更新标签状态
        RFIDBindVO rfidBindVO = new RFIDBindVO();
        rfidBindVO.setLoginUser(productLineBO.getLoginUser());
        rfidBindVO.setOperationEnum(OperationEnum.SynthesisCuttingTool_Install);
        rfidBindVO.setRfidContainerVO(productLineBO.getSynthesisCuttingToolBindVO().getRfidContainerVO());
        rfidModel.upRFIDStatus(rfidBindVO);

    }


    /**
     * 为卸下设备查询数据
     * @param productLineBO 业务数据封装
     * @return
     * @throws Exception
     */
    @Override
    public QueryVO queryForUnInstall(ProductLineBO productLineBO) throws Exception {
        QueryVO queryVO = new QueryVO();
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(productLineBO.getSynthesisCuttingToolBindVO());
        queryVO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        //查询调刀记录
        BindleRecordsBO bindleRecordsBO = new BindleRecordsBO();
        bindleRecordsBO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        SynthesisCuttingToolBindleRecords bindleRecords = bindleRecordsModel.queryByRFID(bindleRecordsBO);
        if (null != bindleRecords){
            queryVO.setAssemblyline(bindleRecords.getProductLineAssemblyline());
            queryVO.setEquipment(bindleRecords.getProductLineEquipment());
            queryVO.setProcess(bindleRecords.getProductLineProcess());

            //查询生产线信息
            ProductLineVO productLineVO = new ProductLineVO();
            productLineVO.setAssemblylineCode(bindleRecords.getProductLineAssemblylineCode());
            productLineVO.setProcessCode(bindleRecords.getProductLineProcessCode());
            productLineVO.setEquipmentCode(bindleRecords.getProductLineEquipmentCode());
            productLineVO.setSynthesisCuttingToolCode(bindleRecords.getSynthesisCuttingToolCode());
            Map<String,ProductLineParts> tmp = new HashMap<>();
            List<ProductLine> partsList = new ArrayList<>();
            List<ProductLine> productLines = productLineMapper.getProductLineByPage(productLineVO);
            for (ProductLine line : productLines) {
                if (null == line.getProductLineParts()){
                    continue;
                }
                if (tmp.containsKey(line.getPartsCode())){
                    continue;
                }
                tmp.put(line.getPartsCode(),line.getProductLineParts());
                partsList.add(line);
            }
            queryVO.setPartsList(partsList);
        }

        return queryVO;
    }

    /**
     * 卸下设备
     * @param productLineBO
     * @throws Exception
     */
    @Override
    public ProductLineBO unInstallData(ProductLineBO productLineBO) throws Exception {
        //查询合成刀信息
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(productLineBO.getSynthesisCuttingToolBindVO());

        //更新设备状态
        ProductLineEquipment productLineEquipment = equipmentMapper.getProductLineEquipment(productLineBO.getProductLineEquipmentVO());
        productLineEquipment.setStatues(EquipmentUseEnum.UnUse.getKey());
        equipmentMapper.updProductLineEquipment(productLineEquipment);

        //更新调刀记录
        BindleRecordsBO bindleRecordsBO = new BindleRecordsBO();
        bindleRecordsBO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        bindleRecordsBO.setProcessingCount(productLineBO.getProcessingCount());
        bindleRecordsBO.setReason(productLineBO.getUnBindReason());
        SynthesisCuttingToolBindleRecords bindleRecords = bindleRecordsModel.updBindleRecords(bindleRecordsBO);
        productLineBO.setBindleRecords(bindleRecords);
        //更新合成刀累计加工数
        if (null == synthesisCuttingToolBind.getProcessingCount()){
            synthesisCuttingToolBind.setProcessingCount(0);
        }
        synthesisCuttingToolBind.setProcessingCount(synthesisCuttingToolBind.getProcessingCount()+bindleRecords.getProcessingCount());
        synthesisCuttingToolBindMapper.updSynthesisCuttingToolBind(synthesisCuttingToolBind);

        //更新合成刀库存
        SynthesisMaterialInventoryBO synthesisMaterialInventoryBO = new SynthesisMaterialInventoryBO();
        synthesisMaterialInventoryBO.setSynthesisCuttingTool(synthesisCuttingToolBind.getSynthesisCuttingTool());
        synthesisInventoryModel.updateInventoryForUnInstall(synthesisMaterialInventoryBO);
        //更新材料刀库存
        MaterialInventoryBO materialInventoryBO = new MaterialInventoryBO();
        materialInventoryBO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        materialInventoryModel.updateInventoryForUnInstall(materialInventoryBO);
        //更新材料刀生产记录
        ToolBindleRecordsBO toolBindleRecordsBO = new ToolBindleRecordsBO();
        toolBindleRecordsBO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        toolBindleRecordsBO.setBindleRecords(bindleRecords);
        toolBindleRecordsModel.addToolBindleRecords(toolBindleRecordsBO);

        //更新合成刀RFID状态
        RFIDBindVO rfidBindVO = new RFIDBindVO();
        rfidBindVO.setLoginUser(productLineBO.getLoginUser());
        rfidBindVO.setOperationEnum(OperationEnum.SynthesisCuttingTool_UnInstall);
        rfidBindVO.setRfidContainerVO(productLineBO.getSynthesisCuttingToolBindVO().getRfidContainerVO());
        rfidModel.upRFIDStatus(rfidBindVO);

        return productLineBO;
    }
}
