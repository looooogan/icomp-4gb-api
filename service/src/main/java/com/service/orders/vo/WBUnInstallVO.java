package com.service.orders.vo;

import com.common.pojo.AuthCustomer;
import com.common.pojo.RfidContainer;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.vo.RfidContainerVO;
import com.common.vo.SynthesisCuttingToolBindVO;
import com.service.synthesiscuttingtool.vo.UnBindEquipmentVO;

/**
 * Created by logan on 2018/5/11.
 */
public class WBUnInstallVO extends WriteBaseVO {

    private UnBindEquipmentVO unBindEquipmentVO;

    private SynthesisCuttingToolBind synthesisCuttingToolBind;

    private RfidContainer rfidContainer;

    public UnBindEquipmentVO getUnBindEquipmentVO() {
        return unBindEquipmentVO;
    }

    public void setUnBindEquipmentVO(UnBindEquipmentVO unBindEquipmentVO) {
        this.unBindEquipmentVO = unBindEquipmentVO;
    }

    public SynthesisCuttingToolBind getSynthesisCuttingToolBind() {
        return synthesisCuttingToolBind;
    }

    public void setSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) {
        this.synthesisCuttingToolBind = synthesisCuttingToolBind;
    }

    public RfidContainer getRfidContainer() {
        return rfidContainer;
    }

    public void setRfidContainer(RfidContainer rfidContainer) {
        this.rfidContainer = rfidContainer;
    }
}
