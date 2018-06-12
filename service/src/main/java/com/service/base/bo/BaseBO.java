package com.service.base.bo;

import com.common.pojo.AuthCustomer;

/**
 * Created by logan on 2018/6/12.
 */
public class BaseBO {

    private AuthCustomer loginUser;

    public AuthCustomer getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(AuthCustomer loginUser) {
        this.loginUser = loginUser;
    }
}
