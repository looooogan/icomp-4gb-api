package com.api.power.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.PowerGroup;
import com.common.vo.PowerGroupVO;
import com.service.power.IPowerGroupService;
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
* @ClassName PowerGroupController
* @Description PowerGroupController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("powerGroup")
public class PowerGroupController extends BaseController{

    @Autowired
    private IPowerGroupService powerGroupService;


    /**
    * @Title: add
    * @Description: 添加PowerGroup
    * @param powerGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody PowerGroup powerGroup) throws Exception{
        this.powerGroupService.addPowerGroup(powerGroup);
    }

    /**
    * @Title: update
    * @Description: 修改PowerGroup
    * @param powerGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody PowerGroup powerGroup) throws  Exception{
        this.powerGroupService.updPowerGroup(powerGroup);
    }

    /**
    * @Title: del
    * @Description: 删除PowerGroup
    * @param powerGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody PowerGroup powerGroup) throws  Exception{
        this.powerGroupService.delPowerGroupForLogic(powerGroup);
    }

    /**
    * @Title: getPowerGroupByVo
    * @Description: 根据查询条件查询
    * @param powerGroupVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public PowerGroup getPowerGroupByVo(@RequestBody PowerGroupVO powerGroupVO) throws  Exception{
        return this.powerGroupService.getPowerGroup(powerGroupVO);
    }

    /**
    * @Title: getPowerGroupByPage
    * @Description: 根据查询条件查询
    * @param powerGroupVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getPowerGroupByPage(@RequestBody PowerGroupVO powerGroupVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.powerGroupService.getPowerGroupByPage(powerGroupVO));
        result.put("vo",powerGroupVO);
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
        return "/powerGroup/powerGroupList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/powerGroup/powerGroupInsAndUpd";
    }

}
