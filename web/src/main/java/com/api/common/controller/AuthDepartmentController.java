package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.AuthDepartment;
import com.common.vo.AuthDepartmentVO;
import com.service.common.IAuthDepartmentService;
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
* @ClassName AuthDepartmentController
* @Description AuthDepartmentController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("authDepartment")
public class AuthDepartmentController extends BaseController{

    @Autowired
    private IAuthDepartmentService authDepartmentService;


    /**
    * @Title: add
    * @Description: 添加AuthDepartment
    * @param authDepartment
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody AuthDepartment authDepartment) throws Exception{
        this.authDepartmentService.addAuthDepartment(authDepartment);
    }

    /**
    * @Title: update
    * @Description: 修改AuthDepartment
    * @param authDepartment
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody AuthDepartment authDepartment) throws  Exception{
        this.authDepartmentService.updAuthDepartment(authDepartment);
    }

    /**
    * @Title: del
    * @Description: 删除AuthDepartment
    * @param authDepartment
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody AuthDepartment authDepartment) throws  Exception{
        this.authDepartmentService.delAuthDepartmentForLogic(authDepartment);
    }

    /**
    * @Title: getAuthDepartmentByVo
    * @Description: 根据查询条件查询
    * @param authDepartmentVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public AuthDepartment getAuthDepartmentByVo(@RequestBody AuthDepartmentVO authDepartmentVO) throws  Exception{
        return this.authDepartmentService.getAuthDepartment(authDepartmentVO);
    }

    /**
    * @Title: getAuthDepartmentByPage
    * @Description: 根据查询条件查询
    * @param authDepartmentVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAuthDepartmentByPage(@RequestBody AuthDepartmentVO authDepartmentVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.authDepartmentService.getAuthDepartmentByPage(authDepartmentVO));
        result.put("vo",authDepartmentVO);
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
        return "/authDepartment/authDepartmentList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/authDepartment/authDepartmentInsAndUpd";
    }

}
