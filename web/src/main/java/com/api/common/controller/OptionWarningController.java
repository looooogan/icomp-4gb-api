package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.OptionWarning;
import com.common.vo.OptionWarningVO;
import com.service.common.IOptionWarningService;
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
* @ClassName OptionWarningController
* @Description OptionWarningController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("optionWarning")
public class OptionWarningController extends BaseController{

    @Autowired
    private IOptionWarningService optionWarningService;


    /**
    * @Title: add
    * @Description: 添加OptionWarning
    * @param optionWarning
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody OptionWarning optionWarning) throws Exception{
        this.optionWarningService.addOptionWarning(optionWarning);
    }

    /**
    * @Title: update
    * @Description: 修改OptionWarning
    * @param optionWarning
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody OptionWarning optionWarning) throws  Exception{
        this.optionWarningService.updOptionWarning(optionWarning);
    }

    /**
    * @Title: del
    * @Description: 删除OptionWarning
    * @param optionWarning
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody OptionWarning optionWarning) throws  Exception{
        this.optionWarningService.delOptionWarningForLogic(optionWarning);
    }

    /**
    * @Title: getOptionWarningByVo
    * @Description: 根据查询条件查询
    * @param optionWarningVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public OptionWarning getOptionWarningByVo(@RequestBody OptionWarningVO optionWarningVO) throws  Exception{
        return this.optionWarningService.getOptionWarning(optionWarningVO);
    }

    /**
    * @Title: getOptionWarningByPage
    * @Description: 根据查询条件查询
    * @param optionWarningVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getOptionWarningByPage(@RequestBody OptionWarningVO optionWarningVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.optionWarningService.getOptionWarningByPage(optionWarningVO));
        result.put("vo",optionWarningVO);
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
        return "/optionWarning/optionWarningList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/optionWarning/optionWarningInsAndUpd";
    }

}
