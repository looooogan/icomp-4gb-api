package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.AuthPosition;
import com.common.vo.AuthPositionVO;
import com.service.common.IAuthDepartmentService;
import com.service.common.IAuthPositionService;
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
* @ClassName AuthPositionController
* @Description AuthPositionController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("authPosition")
public class AuthPositionController extends BaseController{

    @Autowired
    private IAuthPositionService authPositionService;

    @Autowired
    private IAuthDepartmentService authDepartmentService;

    /**
    * @Title: add
    * @Description: 添加AuthPosition
    * @param authPosition
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody AuthPosition authPosition) throws Exception{
        this.authPositionService.addAuthPosition(authPosition);
    }

    /**
    * @Title: update
    * @Description: 修改AuthPosition
    * @param authPosition
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody AuthPosition authPosition) throws  Exception{
        this.authPositionService.updAuthPosition(authPosition);
    }

    /**
    * @Title: del
    * @Description: 删除AuthPosition
    * @param authPosition
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody AuthPosition authPosition) throws  Exception{
        this.authPositionService.delAuthPositionForLogic(authPosition);
    }

    /**
    * @Title: getAuthPositionByVo
    * @Description: 根据查询条件查询
    * @param authPositionVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public AuthPosition getAuthPositionByVo(@RequestBody AuthPositionVO authPositionVO) throws  Exception{
        return this.authPositionService.getAuthPosition(authPositionVO);
    }

    /**
    * @Title: getAuthPositionByPage
    * @Description: 根据查询条件查询
    * @param authPositionVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAuthPositionByPage(@RequestBody AuthPositionVO authPositionVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.authPositionService.getAuthPositionByPage(authPositionVO));
        result.put("vo",authPositionVO);
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
        return "/authPosition/authPositionList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/authPosition/authPositionInsAndUpd";
    }

}
