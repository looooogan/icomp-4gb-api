package com.service.cuttingtool;

import com.common.constants.ConsumeTypeEnum;
import com.common.constants.OperationEnum;
import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.ICuttingToolMapper;
import com.common.pojo.CuttingToolBind;
import com.common.utils.UUID;
import com.common.vo.RfidContainerVO;
import com.service.cuttingtool.bo.CuttingToolBindBO;
import com.service.cuttingtool.vo.CuttingToolModelBO;
import com.service.rfid.RfidModel;
import com.service.rfid.vo.RFIDBindVO;
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
                cuttingToolBind.setBladeCode(cuttingToolBindBO.getMaxDJH()+"");
                //刀具第一次领用 llcs为1
                cuttingToolBind.setLhcs(1);
            }
            if (!StringUtils.isBlank(cuttingToolBind.getRfidContainer().getLaserCode())){
                RFIDBindVO rfidBindVO = new RFIDBindVO();
                rfidBindVO.setAuthCustomer(cuttingToolBindBO.getLoginUser());
                rfidBindVO.setOperationEnum(OperationEnum.Cutting_tool_Bind);
                RfidContainerVO rfidContainerVO = new RfidContainerVO();
                rfidContainerVO.setLaserCode(cuttingToolBind.getRfidContainer().getLaserCode());
                rfidBindVO.setRfidContainerVO(rfidContainerVO);
                cuttingToolBind.setRfidContainer(rfidModel.bindRFID(rfidBindVO));
            }
            cuttingToolBind.setCode(UUID.getInstance());
            cuttingToolBind.setLltm(cuttingToolBindBO.getLltm());
            cuttingToolBind.setIsDel(0);
            cuttingToolBindMapper.addCuttingToolBind(cuttingToolBind);
            return cuttingToolBind;
        }
        return null;

    }


}
