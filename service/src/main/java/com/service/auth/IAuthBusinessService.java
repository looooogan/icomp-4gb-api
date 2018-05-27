package com.service.auth;

import com.common.pojo.AuthCustomer;
import com.common.vo.AuthCustomerVO;
/**
 * Created by logan on 2018/5/6.
 */
public interface IAuthBusinessService {

    /**
     * 根据员工号查询员工
     * @param authCustomerVO 员工信息
     * @throws Exception
     */
    public AuthCustomer queryAuthCustomerByEmployeeCode(AuthCustomerVO authCustomerVO) throws Exception;


    /**
     * 初始化员工卡
     * @param authCustomer 换装结果
     * @throws Exception
     */
    public void addInitAuthCustomer(AuthCustomer authCustomer) throws Exception;

    /**
     * pda设备登陆
     * @param authCustomerVO
     * @return
     * @throws Exception
     */
    public AuthCustomer loginForPDA(AuthCustomerVO authCustomerVO) throws Exception;



}
