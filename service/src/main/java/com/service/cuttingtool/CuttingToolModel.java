package com.service.cuttingtool;

import com.common.constants.ConsumeTypeEnum;
import com.common.constants.OperationEnum;
import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.ICuttingToolMapper;
import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.RfidContainer;
import com.common.utils.BladeCodeHandler;
import com.common.utils.UUID;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.common.vo.RfidContainerVO;
import com.service.cuttingtool.bo.CuttingToolBindBO;
import com.service.cuttingtool.vo.CuttingToolModelBO;
import com.service.rfid.RfidModel;
import com.service.rfid.vo.RFIDBindVO;
import com.service.synthesiscuttingtool.vo.DownCuttingToolVO;
import com.service.synthesiscuttingtool.vo.UpCuttingToolVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logan on 2018/5/29.
 */
@Component("CuttingToolModel")
public class CuttingToolModel {

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private RfidModel rfidModel;

    /**
     * 创建刀具绑定信息
     * @param cuttingToolBindBO
     * @throws Exception
     */
    public CuttingToolBind bindCuttingToolOnOutApply(CuttingToolBindBO cuttingToolBindBO) throws Exception{
        if (cuttingToolBindBO.getCuttingTool().getConsumeType().equals(ConsumeTypeEnum.Applicable_Bit.getKey())){
            //可刃磨钻头
            //创建材料刀bind
            CuttingToolBind cuttingToolBind = cuttingToolBindBO.getCuttingToolBind();
            cuttingToolBind.setCuttingToolCode(cuttingToolBindBO.getCuttingTool().getCode());
            if (StringUtils.isBlank(cuttingToolBind.getBladeCode())){
                cuttingToolBind.setBladeCode(cuttingToolBindBO.getCuttingTool().getBusinessCode()+"-"+ BladeCodeHandler.create(cuttingToolBindBO.getMaxDJH()+""));
            }else {
                cuttingToolBind.setBladeCode(cuttingToolBindBO.getCuttingTool().getBusinessCode()+"-"+ cuttingToolBind.getBladeCode());
            }

            //刀具第一次领用 llcs为1
            cuttingToolBind.setLhcs(1);
            cuttingToolBind.setCode(UUID.getInstance());
            cuttingToolBind.setLltm(cuttingToolBindBO.getLltm());
            cuttingToolBind.setIsDel(0);
            cuttingToolBind.setQimingSharpenTimes(0);
            cuttingToolBind.setJgcs(0);
            cuttingToolBind.setSharpenTimes(0);
            cuttingToolBind.setJgsm(0);
            if (!StringUtils.isBlank(cuttingToolBind.getRfidContainer().getLaserCode())){
                RFIDBindVO rfidBindVO = new RFIDBindVO();
                rfidBindVO.setLoginUser(cuttingToolBindBO.getLoginUser());
                rfidBindVO.setOperationEnum(OperationEnum.Cutting_tool_Bind);
                RfidContainerVO rfidContainerVO = new RfidContainerVO();
                rfidContainerVO.setLaserCode(cuttingToolBind.getRfidContainer().getLaserCode());
                rfidBindVO.setRfidContainerVO(rfidContainerVO);
                RfidContainer rfidContainer = rfidModel.bindRFID(rfidBindVO);
                cuttingToolBind.setRfidContainerCode(rfidContainer.getCode());
            }
            cuttingToolBindMapper.addCuttingToolBind(cuttingToolBind);
            return cuttingToolBind;
        }
        return null;
    }

    /**
     * 刀具绑定标签
     * @param cuttingToolBindBO
     * @throws Exception
     */
    public void bindRFIDForExchange(CuttingToolBindBO cuttingToolBindBO) throws Exception{
        if (null == cuttingToolBindBO.getDownCuttingToolVOS() || cuttingToolBindBO.getDownCuttingToolVOS().size()<=0){
            return;
        }
        RfidContainerVO rfidContainerVO = null;
        RFIDBindVO rfidBindVO = null;
        CuttingToolBindVO cuttingToolBindVO = null;
        CuttingToolBind cuttingToolBind = null;
        for (DownCuttingToolVO downCuttingToolVO : cuttingToolBindBO.getDownCuttingToolVOS()) {
            if (StringUtils.isBlank(downCuttingToolVO.getDownRfidLaserCode())){
                continue;
            }
            if (StringUtils.isBlank(downCuttingToolVO.getBladeCode())){
                continue;
            }
            cuttingToolBindVO = new CuttingToolBindVO();
            cuttingToolBindVO.setBladeCode(downCuttingToolVO.getBladeCode());
            cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
            if (null == cuttingToolBind){
                continue;
            }
            rfidBindVO = new RFIDBindVO();
            rfidBindVO.setLoginUser(cuttingToolBindBO.getLoginUser());
            rfidBindVO.setOperationEnum(OperationEnum.Cutting_tool_Bind);
            rfidContainerVO = new RfidContainerVO();
            rfidContainerVO.setLaserCode(downCuttingToolVO.getDownRfidLaserCode());
            rfidBindVO.setRfidContainerVO(rfidContainerVO);
            cuttingToolBind.setRfidContainer(rfidModel.replaceRFID(rfidBindVO));
            cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
        }
    }

    /**
     * 刀具解绑标签
     * @param cuttingToolBindBO
     * @throws Exception
     */
    public void unBindRFID(CuttingToolBindBO cuttingToolBindBO) throws Exception{
        if (null == cuttingToolBindBO.getUpCuttingToolVOS() || cuttingToolBindBO.getUpCuttingToolVOS().size()<=0){
            return;
        }
        RfidContainerVO rfidContainerVO = null;
        RFIDBindVO rfidBindVO = null;
        CuttingToolBindVO cuttingToolBindVO = null;
        CuttingToolBind cuttingToolBind = null;
        for (UpCuttingToolVO upCuttingToolVO : cuttingToolBindBO.getUpCuttingToolVOS()) {
            if (StringUtils.isBlank(upCuttingToolVO.getUpRfidLaserCode())){
                continue;
            }
            if (StringUtils.isBlank(upCuttingToolVO.getBladeCode())){
                continue;
            }
            cuttingToolBindVO = new CuttingToolBindVO();
            cuttingToolBindVO.setBladeCode(upCuttingToolVO.getBladeCode());
            cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
            if (null == cuttingToolBind){
                continue;
            }
            rfidBindVO = new RFIDBindVO();
            rfidBindVO.setLoginUser(cuttingToolBindBO.getLoginUser());
            rfidBindVO.setOperationEnum(OperationEnum.UnBindRFID);
            rfidContainerVO = new RfidContainerVO();
            rfidContainerVO.setLaserCode(upCuttingToolVO.getUpRfidLaserCode());
            rfidBindVO.setRfidContainerVO(rfidContainerVO);
            rfidModel.unBindRFID(rfidBindVO);
            cuttingToolBind.setRfidContainerCode("0");
            cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
        }
    }


}
