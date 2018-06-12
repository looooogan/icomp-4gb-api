package com.service.orders.vo;

import com.common.pojo.AuthCustomer;
import com.common.pojo.CuttingToolBind;

import java.util.List;

/**
 * Created by logan on 2018/5/11.
 */
public class WBCuttingToolBindVO extends WriteBaseVO{

    private CuttingToolBind cuttingToolBind;

    private List<CuttingToolBind> cuttingToolBinds;

    private AuthCustomer authCustomer;



    public AuthCustomer getAuthCustomer() {
        return authCustomer;
    }

    public void setAuthCustomer(AuthCustomer authCustomer) {
        this.authCustomer = authCustomer;
    }

    public CuttingToolBind getCuttingToolBind() {
        return cuttingToolBind;
    }

    public void setCuttingToolBind(CuttingToolBind cuttingToolBind) {
        this.cuttingToolBind = cuttingToolBind;
    }
}
