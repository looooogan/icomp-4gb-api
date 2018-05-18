package com.api.auth.controller;

import com.api.base.controller.BaseController;
import com.common.pojo.AuthCustomer;
import com.common.vo.AuthCustomerVO;
import com.common.vo.RfidContainerVO;
import com.service.auth.IAuthBusinessService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by logan on 2018/5/6.
 */
@Controller
@RequestMapping("auth")
public class AuthController extends BaseController{

    @Autowired
    private IAuthBusinessService authBusinessService;


    @RequestMapping("query")
    @ResponseBody
    public AuthCustomer query(@RequestBody AuthCustomerVO authCustomerVO) throws Exception{
        return authBusinessService.queryAuthCustomerByEmployeeCode(authCustomerVO);
    }

    @RequestMapping("init")
    @ResponseBody
    public void init(@RequestBody AuthCustomer authCustomer) throws Exception{
        authBusinessService.addInitAuthCustomer(authCustomer);
    }

    @RequestMapping("loganForPDA")
    @ResponseBody
    public AuthCustomer loganByAccount(@RequestBody AuthCustomerVO authCustomerVO) throws Exception{
        return authBusinessService.loginForPDA(authCustomerVO);
    }



}
