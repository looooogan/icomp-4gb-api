package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SynthesisCuttingToolAdjust;
import com.common.vo.SynthesisCuttingToolAdjustVO;
import com.service.common.ISynthesisCuttingToolAdjustService;
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
* @ClassName SynthesisCuttingToolAdjustController
* @Description SynthesisCuttingToolAdjustController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisCuttingToolAdjust")
public class SynthesisCuttingToolAdjustController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolAdjustService synthesisCuttingToolAdjustService;


    /**
    * @Title: add
    * @Description: 添加SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjust
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisCuttingToolAdjust synthesisCuttingToolAdjust) throws Exception{
        this.synthesisCuttingToolAdjustService.addSynthesisCuttingToolAdjust(synthesisCuttingToolAdjust);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjust
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisCuttingToolAdjust synthesisCuttingToolAdjust) throws  Exception{
        this.synthesisCuttingToolAdjustService.updSynthesisCuttingToolAdjust(synthesisCuttingToolAdjust);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjust
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisCuttingToolAdjust synthesisCuttingToolAdjust) throws  Exception{
        this.synthesisCuttingToolAdjustService.delSynthesisCuttingToolAdjustForLogic(synthesisCuttingToolAdjust);
    }

    /**
    * @Title: getSynthesisCuttingToolAdjustByVo
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolAdjustVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolAdjust getSynthesisCuttingToolAdjustByVo(@RequestBody SynthesisCuttingToolAdjustVO synthesisCuttingToolAdjustVO) throws  Exception{
        return this.synthesisCuttingToolAdjustService.getSynthesisCuttingToolAdjust(synthesisCuttingToolAdjustVO);
    }

    /**
    * @Title: getSynthesisCuttingToolAdjustByPage
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolAdjustVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisCuttingToolAdjustByPage(@RequestBody SynthesisCuttingToolAdjustVO synthesisCuttingToolAdjustVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisCuttingToolAdjustService.getSynthesisCuttingToolAdjustByPage(synthesisCuttingToolAdjustVO));
        result.put("vo",synthesisCuttingToolAdjustVO);
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
        return "/synthesisCuttingToolAdjust/synthesisCuttingToolAdjustList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisCuttingToolAdjust/synthesisCuttingToolAdjustInsAndUpd";
    }

}
