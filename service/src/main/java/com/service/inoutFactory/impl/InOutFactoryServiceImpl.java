package com.service.inoutFactory.impl;

import com.common.constants.CuttingToolConsumeTypeEnum;
import com.common.constants.GrindingEnum;
import com.common.constants.OperationEnum;
import com.common.constants.OutWayEnum;
import com.common.mapper.*;
import com.common.pojo.*;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.service.inoutFactory.IInOutFactoryService;
import com.service.inoutFactory.vo.HistoryVO;
import com.service.inoutFactory.vo.InsideVO;
import com.service.inoutFactory.vo.OutSideVO;
import com.service.inoutFactory.vo.SharpenVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by logan on 2018/5/6.
 */
@Service("inOutFactoryService")
public class InOutFactoryServiceImpl implements IInOutFactoryService{

    @Autowired
    private IInsideFactoryMapper insideFactoryMapper;

    @Autowired
    private IOutsidefactoryhistoryMapper outsidefactoryhistoryMapper;

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
            if (!cuttingToolBind.getCuttingTool().getGrinding().equals(GrindingEnum.inside.getKey())){
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

    @Override
    public Integer countInsideFactory(InsideFactoryVO insideFactoryVO) throws Exception {
        return insideFactoryMapper.getInsideFactoryCount(insideFactoryVO);
    }

    @Override
    public void addInsideFactory(InsideVO insideVO) throws Exception {

        InsideFactory insideFactory = null;
        CuttingToolVO cuttingToolVO = null;
        CuttingTool cuttingTool = null;
        for (SharpenVO sharpenVO : insideVO.getSharpenVOS()) {
            insideFactory = new InsideFactory();
            cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setBusinessCode(sharpenVO.getCuttingToolBusinessCode());
            cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
            insideFactory.setIsDel(0);
            insideFactory.setRepairState("1");
            insideFactory.setNumberGrinding(sharpenVO.getCount());
            insideFactory.setMaterialNum(cuttingTool.getBusinessCode());
            insideFactory.setToolType(cuttingTool.getConsumeType());
//            insideFactory.setApprover(insideVO.getAuthCustomer().getCode());
            insideFactory.setCreateTime(new Timestamp(System.currentTimeMillis()));
            insideFactory.setCuttingToolCode(cuttingTool.getCode());
            insideFactory.setOprator(insideVO.getAuthCustomer().getCode());
            insideFactory.setOpratorName(insideVO.getAuthCustomer().getName());
            //修改刀具绑定的信息
            if (!StringUtils.isBlank(sharpenVO.getCuttingToolBladeCode())){
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setBladeCode(sharpenVO.getCuttingToolBladeCode());
                CuttingToolBind cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
                cuttingToolBind.setLhcs(cuttingToolBind.getLhcs()==null?1:cuttingToolBind.getLhcs()+1);
                cuttingToolBind.setSharpenTimes(cuttingToolBind.getSharpenTimes()==null?1:cuttingToolBind.getSharpenTimes()+1);
                cuttingToolBind.setQimingSharpenTimes(cuttingToolBind.getQimingSharpenTimes()==null?1:cuttingToolBind.getQimingSharpenTimes()+1);
                cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
            }
            insideFactoryMapper.addInsideFactory(insideFactory);
            //刀片暂无单品管理

            //修改材料刀库存
            MaterialInventoryVO materialInventoryVO = new MaterialInventoryVO();
            materialInventoryVO.setCuttingToolCode(sharpenVO.getCuttingToolCode());
            MaterialInventory materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
            if (null  == materialInventory){
                materialInventory = new MaterialInventory();
                materialInventory.setIsDel(0);
                materialInventory.setCuttingToolCode(cuttingTool.getCode());
                materialInventory.setPrepareLibraryCount(0);
                materialInventory.setProductLineCount(0);
                materialInventory.setToExchangeCount(0);
                materialInventory.setGrindingOutCount(0);
                materialInventory.setScrapCount(0);
                materialInventory.setForGrindingInCount(0);
                materialInventory.setForGrindingOutCount(0);
                materialInventoryMapper.addMaterialInventory(materialInventory);
            }
            if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_zt.getKey())
                    ||cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_zt.getKey())){
                materialInventory.setForGrindingInCount(materialInventory.getForGrindingInCount()-1<=0?0:materialInventory.getForGrindingInCount()-1);
                if (cuttingTool.getGrinding().equals(GrindingEnum.outside_tuceng.getKey())){
                    materialInventory.setForGrindingOutCount(materialInventory.getForGrindingOutCount()+sharpenVO.getCount());
                }else{
                    materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()+sharpenVO.getCount());
                }
            }
            materialInventoryMapper.updMaterialInventory(materialInventory);
        }
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

    @Override
    public CuttingTool getCuttingTool(CuttingToolVO cuttingToolVO) throws Exception {
        return cuttingToolMapper.getCuttingTool(cuttingToolVO);
    }
}
