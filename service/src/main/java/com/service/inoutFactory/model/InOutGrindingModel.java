package com.service.inoutFactory.model;

import com.common.constants.GrindingEnum;
import com.common.constants.GrindingStatusEnum;
import com.common.constants.OutWayEnum;
import com.common.mapper.*;
import com.common.pojo.*;
import com.common.utils.UUID;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.common.vo.ProductLineEquipmentVO;
import com.service.inoutFactory.bo.InOutGrindingBO;
import com.service.inoutFactory.vo.GrindingVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by logan on 2018/6/14.
 */
@Component("InOutGrindingModel")
public class InOutGrindingModel {

    @Autowired
    private IInsideFactoryMapper insideFactoryMapper;
    @Autowired
    private IOutsideFactoryMapper outsideFactoryMapper;
    @Autowired
    private ICuttingToolMapper cuttingToolMapper;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private IProductLineEquipmentMapper equipmentMapper;

    /**
     * 场内刃磨
     * @param inOutGrindingBO 业务数据
     * @throws Exception
     */
    public void inGrinding(InOutGrindingBO inOutGrindingBO)throws Exception{
        InsideFactory insideFactory = null;
        CuttingToolVO cuttingToolVO = null;
        CuttingTool cuttingTool = null;
        CuttingToolBindVO cuttingToolBindVO = null;
        CuttingToolBind cuttingToolBind = null;
        ProductLineEquipmentVO equipmentVO = new ProductLineEquipmentVO();
        equipmentVO.setCode(inOutGrindingBO.getGrindingEquipment().getCode());
        ProductLineEquipment equipment = equipmentMapper.getProductLineEquipment(equipmentVO);
        for (GrindingVO grindingVO : inOutGrindingBO.getGrindingVOS()) {
            insideFactory = new InsideFactory();
            cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setCode(grindingVO.getCuttingTool().getCode());
            cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
            grindingVO.setCuttingTool(cuttingTool);
            insideFactory.setCuttingToolCode(cuttingTool.getCode());
            insideFactory.setMaterialNum(cuttingTool.getBusinessCode());
            insideFactory.setToolType(cuttingTool.getConsumeType());
            insideFactory.setNumberGrinding(grindingVO.getGrindingCount());
            insideFactory.setEquipmentCode(equipment.getCode());
            insideFactory.setEquipmentName(equipment.getName());
            insideFactory.setOprator(inOutGrindingBO.getLoginUser().getCode());
            insideFactory.setOpratorName(inOutGrindingBO.getLoginUser().getName());
            insideFactory.setIsDel(0);
            if (cuttingTool.getGrinding().equals(GrindingEnum.outside_tuceng.getKey())){
                insideFactory.setRepairState(GrindingStatusEnum.To_Grinding.getKey());
            }else{
                insideFactory.setRepairState(GrindingStatusEnum.Grinded.getKey());
            }
//            insideFactory.setApprover(insideVO.getAuthCustomer().getCode());
            insideFactory.setCreateTime(new Timestamp(System.currentTimeMillis()));

            //修改刀具绑定的信息
            if (!StringUtils.isBlank(grindingVO.getCuttingToolBind().getCode())){
                cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setCode(grindingVO.getCuttingToolBind().getCode());
                cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
                grindingVO.setCuttingToolBind(cuttingToolBind);
                if (cuttingTool.getGrinding().equals(GrindingEnum.inside.getKey())){
                    cuttingToolBind.setLhcs(cuttingToolBind.getLhcs()==null?1:cuttingToolBind.getLhcs()+1);
                }
                cuttingToolBind.setSharpenTimes(cuttingToolBind.getSharpenTimes()==null?1:cuttingToolBind.getSharpenTimes()+1);
                cuttingToolBind.setQimingSharpenTimes(cuttingToolBind.getQimingSharpenTimes()==null?1:cuttingToolBind.getQimingSharpenTimes()+1);
                cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
            }
            insideFactoryMapper.addInsideFactory(insideFactory);
        }
    }


    /**
     * 场外刃磨
     * @param inOutGrindingBO 业务数据
     * @throws Exception
     */
    public void outGrinding(InOutGrindingBO inOutGrindingBO)throws Exception{
        OutsideFactory outsideFactory = null;
        CuttingToolVO cuttingToolVO = null;
        CuttingTool cuttingTool = null;
        CuttingToolBindVO cuttingToolBindVO = null;
        CuttingToolBind cuttingToolBind = null;
        for (GrindingVO grindingVO : inOutGrindingBO.getGrindingVOS()) {
            outsideFactory = new OutsideFactory();
            cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setCode(grindingVO.getCuttingTool().getCode());
            cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
            grindingVO.setCuttingTool(cuttingTool);

            outsideFactory.setCuttingToolCode(cuttingTool.getCode());
            outsideFactory.setMaterialNum(cuttingTool.getBusinessCode());
            outsideFactory.setGrindingType(cuttingTool.getGrinding());
            outsideFactory.setManufactureDate(new Timestamp(System.currentTimeMillis()));
//            outsideFactory.setSharpenProviderCode(outSideVO.getSharpenProviderCode());
            outsideFactory.setToolType(cuttingTool.getConsumeType());
            outsideFactory.setNumberGrinding(grindingVO.getGrindingCount());
            outsideFactory.setZcCode(inOutGrindingBO.getZcCode());
            outsideFactory.setOrderNum(inOutGrindingBO.getOrderNum());
            outsideFactory.setQmSharpenProviderCode(inOutGrindingBO.getQmSharpenProviderCode());
            outsideFactory.setQmSharpenProviderName(inOutGrindingBO.getQmSharpenProviderName());
            outsideFactory.setOutWay(inOutGrindingBO.getOutWay());
            outsideFactory.setOpratorCode(inOutGrindingBO.getLoginUser().getCode());
            outsideFactory.setOpratorName(inOutGrindingBO.getLoginUser().getName());
            outsideFactory.setCode(UUID.getInstance());
            outsideFactory.setHandlers(inOutGrindingBO.getHandlers());
            outsideFactory.setSender(inOutGrindingBO.getSender());
            outsideFactory.setIsDel(0);
            if (null!=grindingVO.getCuttingToolBind()&&!StringUtils.isBlank(grindingVO.getCuttingToolBind().getBladeCode())){
                cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setBladeCode(grindingVO.getCuttingToolBind().getBladeCode());
                cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
                if (inOutGrindingBO.getOutWay().equals(OutWayEnum.tuceng.getKey())){
                    cuttingToolBind.setSharpenTimes(cuttingToolBind.getSharpenTimes()==null?1:cuttingToolBind.getSharpenTimes()+1);
                }
                cuttingToolBind.setLhcs(cuttingToolBind.getLhcs()==null?1:cuttingToolBind.getLhcs()+1);
                cuttingToolBind.setQimingSharpenTimes(cuttingToolBind.getQimingSharpenTimes()==null?1:cuttingToolBind.getQimingSharpenTimes()+1);
                cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
            }
            outsideFactoryMapper.addOutsideFactory(outsideFactory);
        }
    }

}
