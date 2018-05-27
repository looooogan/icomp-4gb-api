package com.service.rfid.vo;

import com.common.pojo.AuthCustomer;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.ProductLineEquipment;
import com.common.pojo.SynthesisCuttingToolBind;

/**
 * Created by logan on 2018/5/27.
 */
public class FastQueryVO {

    private String rfidLaserCode;

    private CuttingToolBind cuttingToolBind;

    private ProductLineEquipment equipment;

    private AuthCustomer authCustomer;

    private SynthesisCuttingToolBind synthesisCuttingToolBind;

    private String type;

    public CuttingToolBind getCuttingToolBind() {
        return cuttingToolBind;
    }

    public void setCuttingToolBind(CuttingToolBind cuttingToolBind) {
        this.cuttingToolBind = cuttingToolBind;
    }

    public ProductLineEquipment getEquipment() {
        return equipment;
    }

    public void setEquipment(ProductLineEquipment equipment) {
        this.equipment = equipment;
    }

    public AuthCustomer getAuthCustomer() {
        return authCustomer;
    }

    public void setAuthCustomer(AuthCustomer authCustomer) {
        this.authCustomer = authCustomer;
    }

    public SynthesisCuttingToolBind getSynthesisCuttingToolBind() {
        return synthesisCuttingToolBind;
    }

    public void setSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) {
        this.synthesisCuttingToolBind = synthesisCuttingToolBind;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRfidLaserCode() {
        return rfidLaserCode;
    }

    public void setRfidLaserCode(String rfidLaserCode) {
        this.rfidLaserCode = rfidLaserCode;
    }
}
