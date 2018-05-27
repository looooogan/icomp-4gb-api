package com.api.power.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.PowerUserHasGroup;
import com.common.vo.PowerUserHasGroupVO;
import com.service.common.IAuthCustomerService;
import com.service.power.IPowerGroupService;
import com.service.power.IPowerUserHasGroupService;
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
* @ClassName PowerUserHasGroupController
* @Description PowerUserHasGroupController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("powerUserHasGroup")
public class PowerUserHasGroupController extends BaseController{

    @Autowired
    private IPowerUserHasGroupService powerUserHasGroupService;

    @Autowired
    private IAuthCustomerService authCustomerService;
    @Autowired
    private IPowerGroupService powerGroupService;

    /**
    * @Title: add
    * @Description: 添加PowerUserHasGroup
    * @param powerUserHasGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody PowerUserHasGroup powerUserHasGroup) throws Exception{
        this.powerUserHasGroupService.addPowerUserHasGroup(powerUserHasGroup);
    }

    /**
    * @Title: update
    * @Description: 修改PowerUserHasGroup
    * @param powerUserHasGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody PowerUserHasGroup powerUserHasGroup) throws  Exception{
        this.powerUserHasGroupService.updPowerUserHasGroup(powerUserHasGroup);
    }

    /**
    * @Title: del
    * @Description: 删除PowerUserHasGroup
    * @param powerUserHasGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody PowerUserHasGroup powerUserHasGroup) throws  Exception{
        this.powerUserHasGroupService.delPowerUserHasGroupForLogic(powerUserHasGroup);
    }

    /**
    * @Title: getPowerUserHasGroupByVo
    * @Description: 根据查询条件查询
    * @param powerUserHasGroupVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public PowerUserHasGroup getPowerUserHasGroupByVo(@RequestBody PowerUserHasGroupVO powerUserHasGroupVO) throws  Exception{
        return this.powerUserHasGroupService.getPowerUserHasGroup(powerUserHasGroupVO);
    }

    /**
    * @Title: getPowerUserHasGroupByPage
    * @Description: 根据查询条件查询
    * @param powerUserHasGroupVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getPowerUserHasGroupByPage(@RequestBody PowerUserHasGroupVO powerUserHasGroupVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.powerUserHasGroupService.getPowerUserHasGroupByPage(powerUserHasGroupVO));
        result.put("vo",powerUserHasGroupVO);
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
        return "/powerUserHasGroup/powerUserHasGroupList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/powerUserHasGroup/powerUserHasGroupInsAndUpd";
    }

}
