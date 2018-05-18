package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.AuthAuthorization;
import com.common.vo.AuthAuthorizationVO;
import com.service.common.IAuthAuthorizationService;
import com.service.common.IAuthCustomerService;
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
* @ClassName AuthAuthorizationController
* @Description AuthAuthorizationController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("authAuthorization")
public class AuthAuthorizationController extends BaseController{

    @Autowired
    private IAuthAuthorizationService authAuthorizationService;

    @Autowired
    private IAuthCustomerService authCustomerService;

    /**
    * @Title: add
    * @Description: 添加AuthAuthorization
    * @param authAuthorization
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody AuthAuthorization authAuthorization) throws Exception{
        this.authAuthorizationService.addAuthAuthorization(authAuthorization);
    }

    /**
    * @Title: update
    * @Description: 修改AuthAuthorization
    * @param authAuthorization
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody AuthAuthorization authAuthorization) throws  Exception{
        this.authAuthorizationService.updAuthAuthorization(authAuthorization);
    }

    /**
    * @Title: del
    * @Description: 删除AuthAuthorization
    * @param authAuthorization
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody AuthAuthorization authAuthorization) throws  Exception{
        this.authAuthorizationService.delAuthAuthorizationForLogic(authAuthorization);
    }

    /**
    * @Title: getAuthAuthorizationByVo
    * @Description: 根据查询条件查询
    * @param authAuthorizationVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public AuthAuthorization getAuthAuthorizationByVo(@RequestBody AuthAuthorizationVO authAuthorizationVO) throws  Exception{
        return this.authAuthorizationService.getAuthAuthorization(authAuthorizationVO);
    }

    /**
    * @Title: getAuthAuthorizationByPage
    * @Description: 根据查询条件查询
    * @param authAuthorizationVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAuthAuthorizationByPage(@RequestBody AuthAuthorizationVO authAuthorizationVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.authAuthorizationService.getAuthAuthorizationByPage(authAuthorizationVO));
        result.put("vo",authAuthorizationVO);
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
        return "/authAuthorization/authAuthorizationList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/authAuthorization/authAuthorizationInsAndUpd";
    }

}
