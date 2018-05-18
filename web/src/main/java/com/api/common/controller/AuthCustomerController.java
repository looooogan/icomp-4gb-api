package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.AuthCustomer;
import com.common.vo.AuthCustomerVO;
import com.service.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
*
* @ClassName AuthCustomerController
* @Description AuthCustomerController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("authCustomer")
public class AuthCustomerController extends BaseController{

    @Autowired
    private IAuthCustomerService authCustomerService;

    @Autowired
    private IAuthPositionService authPositionService;
    @Autowired
    private IRfidContainerService rfidContainerService;
    @Autowired
    private IAuthDepartmentService authDepartmentService;
    @Autowired
    private IAuthAgencyService authAgencyService;

    /**
    * @Title: add
    * @Description: 添加AuthCustomer
    * @param authCustomer
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody AuthCustomer authCustomer) throws Exception{
        this.authCustomerService.addAuthCustomer(authCustomer);
    }

    /**
    * @Title: update
    * @Description: 修改AuthCustomer
    * @param authCustomer
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody AuthCustomer authCustomer) throws  Exception{
        this.authCustomerService.updAuthCustomer(authCustomer);
    }

    /**
    * @Title: del
    * @Description: 删除AuthCustomer
    * @param authCustomer
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody AuthCustomer authCustomer) throws  Exception{
        this.authCustomerService.delAuthCustomerForLogic(authCustomer);
    }

    /**
    * @Title: getAuthCustomerByVo
    * @Description: 根据查询条件查询
    * @param authCustomerVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public AuthCustomer getAuthCustomerByVo(@RequestBody AuthCustomerVO authCustomerVO) throws  Exception{
        return this.authCustomerService.getAuthCustomer(authCustomerVO);
    }

    /**
    * @Title: getAuthCustomerByPage
    * @Description: 根据查询条件查询
    * @param authCustomerVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAuthCustomerByPage(@RequestBody AuthCustomerVO authCustomerVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.authCustomerService.getAuthCustomerByPage(authCustomerVO));
        result.put("vo",authCustomerVO);
        return result;
    }

    /**
    * @Title: toListPage
    * @Description: 跳转到列表页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toListPage")
    public String toListPage() throws Exception{
        return "/authCustomer/authCustomerList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/authCustomer/authCustomerInsAndUpd";
    }

}
