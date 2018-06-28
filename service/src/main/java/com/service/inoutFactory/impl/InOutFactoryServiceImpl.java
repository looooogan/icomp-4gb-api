package com.service.inoutFactory.impl;

import com.common.constants.*;
import com.common.mapper.*;
import com.common.pojo.*;
import com.common.utils.OrderNumHandler;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.service.inoutFactory.IInOutFactoryService;
import com.service.inoutFactory.bo.InOutGrindingBO;
import com.service.inoutFactory.model.InOutGrindingModel;
import com.service.inoutFactory.vo.HistoryVO;
import com.service.inoutFactory.vo.InsideVO;
import com.service.inoutFactory.vo.OutSideVO;
import com.service.inoutFactory.vo.SharpenVO;
import com.service.materialInventory.MaterialInventoryModel;
import com.service.materialInventory.bo.MaterialInventoryBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by logan on 2018/5/6.
 */
@Service("inOutFactoryService")
public class InOutFactoryServiceImpl implements IInOutFactoryService{

    @Autowired
    private IInsideFactoryMapper insideFactoryMapper;
    @Autowired
    private IOutsideFactoryMapper outsideFactoryMapper;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private ISharpenProviderMapper sharpenProviderMapper;
    @Autowired
    private IMaterialInventoryMapper materialInventoryMapper;
    @Autowired
    private ICuttingToolMapper cuttingToolMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;
    @Autowired
    private IProductLineEquipmentMapper equipmentMapper;
    @Autowired
    private InOutGrindingModel grindingModel;
    @Autowired
    private MaterialInventoryModel materialInventoryModel;
    @Autowired
    private ISynthesisCuttingToolMapper synthesisCuttingToolMapper;
    @Autowired
    private ISynthesisCuttingToolConfigMapper configMapper;
    @Autowired
    private ISynthesisCuttingToolLocationConfigMapper locationConfigMapper;

    /**
     * 根据RFID 获取刀具信息
     * @param cuttingToolBindVO
     * @return
     * @throws Exception
     */
    @Override
    public CuttingToolBind getCuttingToolBind(CuttingToolBindVO cuttingToolBindVO,Integer operationKey) throws Exception {
        CuttingToolBind cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
        if (StringUtils.isBlank(cuttingToolBind.getCuttingTool().getGrinding())){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.GRINDING_TYPE_ERROR_MESSAGE));
        }
        if (operationKey == OperationEnum.Cutting_tool_Inside.getKey()){
            if (cuttingToolBind.getCuttingTool().getGrinding().equals(GrindingEnum.outside.getKey())){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.GRINDING_TYPE_ERROR_MESSAGE));
            }
        }
        if (operationKey == OperationEnum.Cutting_tool_OutSide.getKey()){
            if (cuttingToolBind.getCuttingTool().getGrinding().equals(GrindingEnum.inside.getKey())){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.GRINDING_TYPE_ERROR_MESSAGE));
            }
        }
        return cuttingToolBind;
    }

    /**
     * 获取刃磨设备
     * @return
     * @throws Exception
     */
    @Override
    public List<ProductLineEquipment> getGrindingEquipment() throws Exception {
        ProductLineEquipmentVO productLineEquipmentVO = new ProductLineEquipmentVO();
        productLineEquipmentVO.setType(EquipmentTypeEnum.Grinding.getKey());
        return equipmentMapper.getProductLineEquipmentByPage(productLineEquipmentVO);
    }

    /**
     * 根据rfid获取刃磨设备信息
     * @param equipmentVO 查询信息
     * @return
     * @throws Exception
     */
    @Override
    public ProductLineEquipment getGrindingEquipmentByRFID(ProductLineEquipmentVO equipmentVO) throws Exception {
        equipmentVO.setType(EquipmentTypeEnum.Grinding.getKey());
        return equipmentMapper.getProductLineEquipment(equipmentVO);
    }

    /**
     * 场内刃磨
     * @param inOutGrindingBO 业务数据
     * @throws Exception
     */
    @Override
    public void insideGrindingData(InOutGrindingBO inOutGrindingBO) throws Exception {
        //添加场内刃磨记录
        grindingModel.inGrinding(inOutGrindingBO);
        //修改材料刀库存
        MaterialInventoryBO materialInventoryBO = new MaterialInventoryBO();
        materialInventoryBO.setGrindingVOS(inOutGrindingBO.getGrindingVOS());
        materialInventoryModel.updateInventoryForInGrinding(materialInventoryBO);
    }

    /**
     * 场外刃磨
     * @param inOutGrindingBO 业务数据
     * @throws Exception
     */
    @Override
    public void outsideGrindingData(InOutGrindingBO inOutGrindingBO) throws Exception {
        //添加场外刃磨记录
        grindingModel.outGrinding(inOutGrindingBO);
        //修改材料刀库存
        MaterialInventoryBO materialInventoryBO = new MaterialInventoryBO();
        materialInventoryBO.setGrindingVOS(inOutGrindingBO.getGrindingVOS());
        materialInventoryModel.updateInventoryForOutGrinding(materialInventoryBO);
    }

    @Override
    public Integer countInsideFactory(InsideFactoryVO insideFactoryVO) throws Exception {
        return insideFactoryMapper.getInsideFactoryCount(insideFactoryVO);
    }


    @Override
    public void addInsideFactoryHistory(HistoryVO historyVO) throws Exception {
        CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
        cuttingToolBindVO.setBladeCode(historyVO.getCuttingToolBind().getBladeCode());
        CuttingToolBind cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
        if (null!=cuttingToolBind){
            cuttingToolBind.setJgcs(historyVO.getCount());
            cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
        }
    }


    @Override
    public void addSharpenProvider(SharpenProvider sharpenProvider) throws Exception {
        sharpenProviderMapper.addSharpenProvider(sharpenProvider);
    }

    @Override
    public Integer countOutSideFactory(OutsideFactoryVO outsideFactoryVO) throws Exception {
        return outsideFactoryMapper.getOutsideFactoryCount(outsideFactoryVO);
    }

    @Override
    public void addOutsideFactory(OutSideVO outSideVO) throws Exception {
        OutsideFactory outsideFactory = null;
        CuttingToolVO cuttingToolVO = null;
        CuttingTool cuttingTool = null;
        for (SharpenVO sharpenVO : outSideVO.getSharpenVOS()) {
            outsideFactory = new OutsideFactory();
            cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setBusinessCode(sharpenVO.getCuttingToolBusinessCode());
            cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);

            outsideFactory.setCuttingToolCode(cuttingTool.getCode());
            outsideFactory.setMaterialNum(cuttingTool.getBusinessCode());
            outsideFactory.setGrindingType(cuttingTool.getGrinding());
            outsideFactory.setManufactureDate(new Timestamp(System.currentTimeMillis()));
//            outsideFactory.setSharpenProviderCode(outSideVO.getSharpenProviderCode());
            outsideFactory.setToolType(cuttingTool.getConsumeType());
            outsideFactory.setNumberGrinding(sharpenVO.getCount());
            outsideFactory.setZcCode(outSideVO.getZcCode());
            outsideFactory.setOrderNum(outSideVO.getWwcode());
            outsideFactory.setQmSharpenProviderCode(outSideVO.getQmSharpenProviderCode());
            outsideFactory.setQmSharpenProviderName(outSideVO.getQmSharpenProviderName());
            outsideFactory.setOutWay(outSideVO.getOutWay());
            outsideFactory.setOpratorCode(outSideVO.getAuthCustomer().getCode());
            outsideFactory.setOpratorName(outSideVO.getAuthCustomer().getName());
            outsideFactory.setCode(UUID.getInstance());
            outsideFactory.setHandlers(outSideVO.getHandlers());
            outsideFactory.setSender(outSideVO.getSender());
            outsideFactory.setIsDel(0);
            //修改刀具绑定的信息
            if (!StringUtils.isBlank(sharpenVO.getCuttingToolBladeCode())){
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setBladeCode(sharpenVO.getCuttingToolBladeCode());
                CuttingToolBind cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
                if (outSideVO.getOutWay().equals(OutWayEnum.tuceng.getKey())){
                    cuttingToolBind.setSharpenTimes(cuttingToolBind.getSharpenTimes()==null?1:cuttingToolBind.getSharpenTimes()+1);
                }
                cuttingToolBind.setLhcs(cuttingToolBind.getLhcs()==null?1:cuttingToolBind.getLhcs()+1);
                cuttingToolBind.setQimingSharpenTimes(cuttingToolBind.getQimingSharpenTimes()==null?2:cuttingToolBind.getQimingSharpenTimes()+2);
                cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
            }
            outsideFactoryMapper.addOutsideFactory(outsideFactory);
            //刀片暂无单品管理

            //修改材料刀库存
            MaterialInventoryVO materialInventoryVO = new MaterialInventoryVO();
            materialInventoryVO.setCuttingToolCode(sharpenVO.getCuttingToolCode());
            MaterialInventory materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
            if (null == materialInventory) {
                materialInventory = new MaterialInventory();
                materialInventory.setIsDel(0);
                materialInventory.setCuttingToolCode(cuttingTool.getCode());
                materialInventory.setPrepareLibraryCount(0);
                materialInventory.setProductLineCount(0);
                materialInventory.setToExchangeCount(0);
                materialInventory.setGrindingOutCount(sharpenVO.getCount());
                materialInventory.setScrapCount(0);
                materialInventory.setForGrindingInCount(0);
                materialInventory.setForGrindingOutCount(0);
                materialInventoryMapper.addMaterialInventory(materialInventory);
            }
            if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_zt.getKey())
                    ||cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_dp.getKey())){
                materialInventory.setForGrindingOutCount(materialInventory.getForGrindingOutCount()-sharpenVO.getCount()<0?0:materialInventory.getForGrindingOutCount()-sharpenVO.getCount());
                materialInventory.setGrindingOutCount(materialInventory.getGrindingOutCount()+sharpenVO.getCount());
                materialInventoryMapper.updMaterialInventory(materialInventory);
            }

        }
    }

    @Override
    public void addOutsideFactoryHistory(OutsideFactory outsideFactory) throws Exception {
        outsideFactoryMapper.addOutsideFactory(outsideFactory);
    }

    @Override
    public List<SharpenProvider> getSharpenProvider() throws Exception {
        SharpenProviderVO sharpenProviderVO = new SharpenProviderVO();
        return sharpenProviderMapper.getSharpenProviderByPage(sharpenProviderVO);
    }

    /**
     * 根据物料号查询材料刀具信息
     * @param cuttingToolVO 材料刀信息
     * @param operationEnum 操作
     * @return
     * @throws Exception
     */
    @Override
    public CuttingTool getCuttingTool(CuttingToolVO cuttingToolVO,OperationEnum operationEnum) throws Exception {
        CuttingTool cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
        if (StringUtils.isBlank(cuttingTool.getGrinding())){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.GRINDING_TYPE_ERROR_MESSAGE));
        }
        //判断刃磨类型
        if (operationEnum.getKey() == OperationEnum.Cutting_tool_Inside.getKey()){
            if (cuttingTool.getGrinding().equals(GrindingEnum.outside.getKey())){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.GRINDING_TYPE_ERROR_MESSAGE));
            }
        }
        if (operationEnum.getKey() == OperationEnum.Cutting_tool_OutSide.getKey()){
            if (cuttingTool.getGrinding().equals(GrindingEnum.inside.getKey())){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.GRINDING_TYPE_ERROR_MESSAGE));
            }
        }
        return cuttingToolMapper.getCuttingTool(cuttingToolVO);
    }

    /**
     * 根据合成刀T号查询材料刀信息
     * @param synthesisCuttingToolVO 合成刀查询条件
     * @param operationEnum 操作
     * @return
     * @throws Exception
     */
    @Override
    public List<CuttingTool> getCuttingToolByTCode(SynthesisCuttingToolVO synthesisCuttingToolVO, OperationEnum operationEnum) throws Exception {
        List<CuttingTool> cuttingToolList = new ArrayList<>();
        //查询合成刀配置信息
        SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO = new SynthesisCuttingToolConfigVO();
        SynthesisCuttingTool synthesisCuttingTool = synthesisCuttingToolMapper.getSynthesisCuttingTool(synthesisCuttingToolVO);
        if (null == synthesisCuttingTool){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_NOT_EXISTS));
        }
        synthesisCuttingToolConfigVO.setSynthesisCuttingToolVO(synthesisCuttingToolVO);
        SynthesisCuttingToolConfig config = configMapper.getSynthesisCuttingToolConfig(synthesisCuttingToolConfigVO);
        SynthesisCuttingToolLocationConfigVO locationConfigVO = new SynthesisCuttingToolLocationConfigVO();
        locationConfigVO.setSynthesisCuttingToolConfigId(config.getId());
        List<SynthesisCuttingToolLocationConfig> locationConfigs = locationConfigMapper.getSynthesisCuttingToolLocationConfigByPage(locationConfigVO);
        for (SynthesisCuttingToolLocationConfig locationConfig : locationConfigs) {
            if (checkGrinding(locationConfig.getCuttingTool(),operationEnum)){
                cuttingToolList.add(locationConfig.getCuttingTool());
            }

            if (null != locationConfig.getReplaceCuttingTool1()){
                if (checkGrinding(locationConfig.getReplaceCuttingTool1(),operationEnum)){
                    cuttingToolList.add(locationConfig.getReplaceCuttingTool1());
                }
            }
            if (null != locationConfig.getReplaceCuttingTool2()){
                if (checkGrinding(locationConfig.getReplaceCuttingTool2(),operationEnum)){
                    cuttingToolList.add(locationConfig.getReplaceCuttingTool2());
                }
            }
        }
        return cuttingToolList;
    }

    /**
     * 校验刃磨类型
     * @param cuttingTool 材料刀
     * @param operationEnum 操作 厂外 场内
     * @return
     * @throws Exception
     */
    public boolean checkGrinding(CuttingTool cuttingTool,OperationEnum operationEnum) throws Exception{
        boolean flag = true;
        if (StringUtils.isBlank(cuttingTool.getGrinding())){
            return false;
        }
        if (operationEnum.getKey() == OperationEnum.Cutting_tool_Inside.getKey()){
            if (cuttingTool.getGrinding().equals(GrindingEnum.outside.getKey())){
                flag =false;
            }
        }
        if (operationEnum.getKey() == OperationEnum.Cutting_tool_OutSide.getKey()){
            if (cuttingTool.getGrinding().equals(GrindingEnum.inside.getKey())){
                flag =false;
            }
        }
        return flag;
    }
}
