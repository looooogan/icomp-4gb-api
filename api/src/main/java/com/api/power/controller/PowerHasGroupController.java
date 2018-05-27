package com.api.power.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.PowerHasGroup;
import com.common.vo.PowerHasGroupVO;
import com.service.power.IPowerGroupService;
import com.service.power.IPowerHasGroupService;
import com.service.power.IPowerService;
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
* @ClassName PowerHasGroupController
* @Description PowerHasGroupController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("powerHasGroup")
public class PowerHasGroupController extends BaseController{

    @Autowired
    private IPowerHasGroupService powerHasGroupService;

    @Autowired
    private IPowerGroupService powerGroupService;
    @Autowired
    private IPowerService powerService;

    /**
    * @Title: add
    * @Description: 添加PowerHasGroup
    * @param powerHasGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody PowerHasGroup powerHasGroup) throws Exception{
        this.powerHasGroupService.addPowerHasGroup(powerHasGroup);
    }

    /**
    * @Title: update
    * @Description: 修改PowerHasGroup
    * @param powerHasGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody PowerHasGroup powerHasGroup) throws  Exception{
        this.powerHasGroupService.updPowerHasGroup(powerHasGroup);
    }

    /**
    * @Title: del
    * @Description: 删除PowerHasGroup
    * @param powerHasGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody PowerHasGroup powerHasGroup) throws  Exception{
        this.powerHasGroupService.delPowerHasGroupForLogic(powerHasGroup);
    }

    /**
    * @Title: getPowerHasGroupByVo
    * @Description: 根据查询条件查询
    * @param powerHasGroupVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public PowerHasGroup getPowerHasGroupByVo(@RequestBody PowerHasGroupVO powerHasGroupVO) throws  Exception{
        return this.powerHasGroupService.getPowerHasGroup(powerHasGroupVO);
    }

    /**
    * @Title: getPowerHasGroupByPage
    * @Description: 根据查询条件查询
    * @param powerHasGroupVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getPowerHasGroupByPage(@RequestBody PowerHasGroupVO powerHasGroupVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.powerHasGroupService.getPowerHasGroupByPage(powerHasGroupVO));
        result.put("vo",powerHasGroupVO);
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
        return "/powerHasGroup/powerHasGroupList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/powerHasGroup/powerHasGroupInsAndUpd";
    }

}
