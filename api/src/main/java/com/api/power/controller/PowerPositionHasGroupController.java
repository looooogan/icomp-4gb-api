package com.api.power.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.PowerPositionHasGroup;
import com.common.vo.PowerPositionHasGroupVO;
import com.service.common.IAuthPositionService;
import com.service.power.IPowerGroupService;
import com.service.power.IPowerPositionHasGroupService;
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
* @ClassName PowerPositionHasGroupController
* @Description PowerPositionHasGroupController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("powerPositionHasGroup")
public class PowerPositionHasGroupController extends BaseController{

    @Autowired
    private IPowerPositionHasGroupService powerPositionHasGroupService;

    @Autowired
    private IAuthPositionService authPositionService;
    @Autowired
    private IPowerGroupService powerGroupService;

    /**
    * @Title: add
    * @Description: 添加PowerPositionHasGroup
    * @param powerPositionHasGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody PowerPositionHasGroup powerPositionHasGroup) throws Exception{
        this.powerPositionHasGroupService.addPowerPositionHasGroup(powerPositionHasGroup);
    }

    /**
    * @Title: update
    * @Description: 修改PowerPositionHasGroup
    * @param powerPositionHasGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody PowerPositionHasGroup powerPositionHasGroup) throws  Exception{
        this.powerPositionHasGroupService.updPowerPositionHasGroup(powerPositionHasGroup);
    }

    /**
    * @Title: del
    * @Description: 删除PowerPositionHasGroup
    * @param powerPositionHasGroup
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody PowerPositionHasGroup powerPositionHasGroup) throws  Exception{
        this.powerPositionHasGroupService.delPowerPositionHasGroupForLogic(powerPositionHasGroup);
    }

    /**
    * @Title: getPowerPositionHasGroupByVo
    * @Description: 根据查询条件查询
    * @param powerPositionHasGroupVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public PowerPositionHasGroup getPowerPositionHasGroupByVo(@RequestBody PowerPositionHasGroupVO powerPositionHasGroupVO) throws  Exception{
        return this.powerPositionHasGroupService.getPowerPositionHasGroup(powerPositionHasGroupVO);
    }

    /**
    * @Title: getPowerPositionHasGroupByPage
    * @Description: 根据查询条件查询
    * @param powerPositionHasGroupVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getPowerPositionHasGroupByPage(@RequestBody PowerPositionHasGroupVO powerPositionHasGroupVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.powerPositionHasGroupService.getPowerPositionHasGroupByPage(powerPositionHasGroupVO));
        result.put("vo",powerPositionHasGroupVO);
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
        return "/powerPositionHasGroup/powerPositionHasGroupList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/powerPositionHasGroup/powerPositionHasGroupInsAndUpd";
    }

}
