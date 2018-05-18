package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.WarningSetting;
import com.common.vo.WarningSettingVO;
import com.service.common.IWarningSettingService;
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
* @ClassName WarningSettingController
* @Description WarningSettingController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("warningSetting")
public class WarningSettingController extends BaseController{

    @Autowired
    private IWarningSettingService warningSettingService;


    /**
    * @Title: add
    * @Description: 添加WarningSetting
    * @param warningSetting
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody WarningSetting warningSetting) throws Exception{
        this.warningSettingService.addWarningSetting(warningSetting);
    }

    /**
    * @Title: update
    * @Description: 修改WarningSetting
    * @param warningSetting
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody WarningSetting warningSetting) throws  Exception{
        this.warningSettingService.updWarningSetting(warningSetting);
    }

    /**
    * @Title: del
    * @Description: 删除WarningSetting
    * @param warningSetting
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody WarningSetting warningSetting) throws  Exception{
        this.warningSettingService.delWarningSettingForLogic(warningSetting);
    }

    /**
    * @Title: getWarningSettingByVo
    * @Description: 根据查询条件查询
    * @param warningSettingVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public WarningSetting getWarningSettingByVo(@RequestBody WarningSettingVO warningSettingVO) throws  Exception{
        return this.warningSettingService.getWarningSetting(warningSettingVO);
    }

    /**
    * @Title: getWarningSettingByPage
    * @Description: 根据查询条件查询
    * @param warningSettingVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getWarningSettingByPage(@RequestBody WarningSettingVO warningSettingVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.warningSettingService.getWarningSettingByPage(warningSettingVO));
        result.put("vo",warningSettingVO);
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
        return "/warningSetting/warningSettingList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/warningSetting/warningSettingInsAndUpd";
    }

}
