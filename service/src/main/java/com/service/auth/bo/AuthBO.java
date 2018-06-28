package com.service.auth.bo;

import com.common.pojo.AuthCustomer;
import com.common.vo.AuthCustomerVO;
import com.service.base.bo.BaseBO;

/**
 * Created by logan on 2018/6/13.
 */
public class AuthBO extends BaseBO{

    private AuthCustomerVO authCustomerVO;

    private AuthCustomer authCustomer;

    public AuthCustomerVO getAuthCustomerVO() {
        return authCustomerVO;
    }

    public void setAuthCustomerVO(AuthCustomerVO authCustomerVO) {
        this.authCustomerVO = authCustomerVO;
    }

    public AuthCustomer getAuthCustomer() {
        return authCustomer;
    }

    public void setAuthCustomer(AuthCustomer authCustomer) {
        this.authCustomer = authCustomer;
    }
}
