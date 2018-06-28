package com.api.auth.controller;

import com.api.base.controller.BaseController;
import com.common.pojo.AuthCustomer;
import com.common.pojo.Power;
import com.common.vo.AuthCustomerVO;
import com.service.auth.IAuthBusinessService;
import com.service.auth.bo.AuthBO;
import com.service.common.IAuthCustomerService;
import com.service.power.IPowerService;
import com.service.power.vo.PowerSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by logan on 2018/5/6.
 */
@Controller
@RequestMapping("auth")
public class AuthController extends BaseController{

    @Autowired
    private IAuthBusinessService authBusinessService;
    @Autowired
    private IPowerService powerService;
    @Autowired
    private IAuthCustomerService authCustomerService;


    @RequestMapping("query")
    @ResponseBody
    public AuthCustomer query(@RequestBody AuthCustomerVO authCustomerVO) throws Exception{
        return authBusinessService.queryAuthCustomerByEmployeeCode(authCustomerVO);
    }

    @RequestMapping("init")
    @ResponseBody
    public void init(@RequestBody AuthCustomerVO authCustomerVO, @RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        AuthCustomerVO loginUserVO = new AuthCustomerVO();
        loginUserVO.setCode(authCustomerCode);
        AuthBO authBO = new AuthBO();
        authBO.setLoginUser(authCustomerService.getAuthCustomer(loginUserVO));
        authBO.setAuthCustomerVO(authCustomerVO);
        authBusinessService.addInitAuthCustomer(authBO);
    }

    @RequestMapping("loganForPDA")
    @ResponseBody
    public AuthCustomer loganByAccount(@RequestBody AuthCustomerVO authCustomerVO) throws Exception{
        return authBusinessService.loginForPDA(authCustomerVO);
    }

    @RequestMapping("getPowers")
    @ResponseBody
    public List<Power> getPowers(@RequestBody PowerSearchVO powerSearchVO) throws Exception{
        return powerService.getPowerByVO(powerSearchVO);
    }

}
