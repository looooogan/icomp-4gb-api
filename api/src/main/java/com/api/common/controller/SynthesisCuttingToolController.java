package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SynthesisCuttingTool;
import com.common.vo.SynthesisCuttingToolVO;
import com.service.common.ISynthesisCuttingToolService;
import com.service.common.ISynthesisCuttingToolTypeService;
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
* @ClassName SynthesisCuttingToolController
* @Description SynthesisCuttingToolController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisCuttingTool")
public class SynthesisCuttingToolController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolService synthesisCuttingToolService;

    @Autowired
    private ISynthesisCuttingToolTypeService synthesisCuttingToolTypeService;

    /**
    * @Title: add
    * @Description: 添加SynthesisCuttingTool
    * @param synthesisCuttingTool
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisCuttingTool synthesisCuttingTool) throws Exception{
        this.synthesisCuttingToolService.addSynthesisCuttingTool(synthesisCuttingTool);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisCuttingTool
    * @param synthesisCuttingTool
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisCuttingTool synthesisCuttingTool) throws  Exception{
        this.synthesisCuttingToolService.updSynthesisCuttingTool(synthesisCuttingTool);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisCuttingTool
    * @param synthesisCuttingTool
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisCuttingTool synthesisCuttingTool) throws  Exception{
        this.synthesisCuttingToolService.delSynthesisCuttingToolForLogic(synthesisCuttingTool);
    }

    /**
    * @Title: getSynthesisCuttingToolByVo
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingTool getSynthesisCuttingToolByVo(@RequestBody SynthesisCuttingToolVO synthesisCuttingToolVO) throws  Exception{
        return this.synthesisCuttingToolService.getSynthesisCuttingTool(synthesisCuttingToolVO);
    }

    /**
    * @Title: getSynthesisCuttingToolByPage
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisCuttingToolByPage(@RequestBody SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisCuttingToolService.getSynthesisCuttingToolByPage(synthesisCuttingToolVO));
        result.put("vo",synthesisCuttingToolVO);
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
        return "/synthesisCuttingTool/synthesisCuttingToolList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisCuttingTool/synthesisCuttingToolInsAndUpd";
    }

}
