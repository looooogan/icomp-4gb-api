package com.service.inoutFactory.vo;

import com.common.pojo.AuthCustomer;
import com.common.pojo.InsideFactory;
import com.service.orders.vo.WriteBaseVO;

import java.util.List;

/**
 * Created by logan on 2018/5/12.
 */
public class InsideVO extends WriteBaseVO{

    private List<InsideFactory> insideFactories;

    private List<SharpenVO> sharpenVOS;

    private AuthCustomer authCustomer;

    private String equipmentCode;

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public List<InsideFactory> getInsideFactories() {
        return insideFactories;
    }

    public void setInsideFactories(List<InsideFactory> insideFactories) {
        this.insideFactories = insideFactories;
    }

    public AuthCustomer getAuthCustomer() {
        return authCustomer;
    }

    public void setAuthCustomer(AuthCustomer authCustomer) {
        this.authCustomer = authCustomer;
    }

    public List<SharpenVO> getSharpenVOS() {
        return sharpenVOS;
    }

    public void setSharpenVOS(List<SharpenVO> sharpenVOS) {
        this.sharpenVOS = sharpenVOS;
    }
}
