package com.service.rfid.vo;

import com.common.constants.OperationEnum;
import com.common.pojo.AuthCustomer;
import com.common.vo.AuthCustomerVO;
import com.common.vo.RfidContainerVO;

/**
 * Created by logan on 2018/6/9.
 */
public class RFIDBindVO {

    private RfidContainerVO rfidContainerVO;
    private AuthCustomer loginUser;
    private AuthCustomerVO authCustomerVO;
    private OperationEnum operationEnum;

    public RfidContainerVO getRfidContainerVO() {
        return rfidContainerVO;
    }

    public void setRfidContainerVO(RfidContainerVO rfidContainerVO) {
        this.rfidContainerVO = rfidContainerVO;
    }

    public AuthCustomer getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(AuthCustomer loginUser) {
        this.loginUser = loginUser;
    }

    public AuthCustomerVO getAuthCustomerVO() {
        return authCustomerVO;
    }

    public void setAuthCustomerVO(AuthCustomerVO authCustomerVO) {
        this.authCustomerVO = authCustomerVO;
    }

    public OperationEnum getOperationEnum() {
        return operationEnum;
    }

    public void setOperationEnum(OperationEnum operationEnum) {
        this.operationEnum = operationEnum;
    }
}
