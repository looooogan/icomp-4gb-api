package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.AuthAgency;
import com.common.vo.AuthAgencyVO;
import com.service.common.IAuthAgencyService;
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
* @ClassName AuthAgencyController
* @Description AuthAgencyController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("authAgency")
public class AuthAgencyController extends BaseController{

    @Autowired
    private IAuthAgencyService authAgencyService;


    /**
    * @Title: add
    * @Description: 添加AuthAgency
    * @param authAgency
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody AuthAgency authAgency) throws Exception{
        this.authAgencyService.addAuthAgency(authAgency);
    }

    /**
    * @Title: update
    * @Description: 修改AuthAgency
    * @param authAgency
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody AuthAgency authAgency) throws  Exception{
        this.authAgencyService.updAuthAgency(authAgency);
    }

    /**
    * @Title: del
    * @Description: 删除AuthAgency
    * @param authAgency
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody AuthAgency authAgency) throws  Exception{
        this.authAgencyService.delAuthAgencyForLogic(authAgency);
    }

    /**
    * @Title: getAuthAgencyByVo
    * @Description: 根据查询条件查询
    * @param authAgencyVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public AuthAgency getAuthAgencyByVo(@RequestBody AuthAgencyVO authAgencyVO) throws  Exception{
        return this.authAgencyService.getAuthAgency(authAgencyVO);
    }

    /**
    * @Title: getAuthAgencyByPage
    * @Description: 根据查询条件查询
    * @param authAgencyVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAuthAgencyByPage(@RequestBody AuthAgencyVO authAgencyVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.authAgencyService.getAuthAgencyByPage(authAgencyVO));
        result.put("vo",authAgencyVO);
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
        return "/authAgency/authAgencyList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/authAgency/authAgencyInsAndUpd";
    }

}
