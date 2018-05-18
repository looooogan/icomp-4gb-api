package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SynthesisCuttingToolExchange;
import com.common.vo.SynthesisCuttingToolExchangeVO;
import com.service.common.ISynthesisCuttingToolExchangeService;
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
* @ClassName SynthesisCuttingToolExchangeController
* @Description SynthesisCuttingToolExchangeController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisCuttingToolExchange")
public class SynthesisCuttingToolExchangeController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolExchangeService synthesisCuttingToolExchangeService;


    /**
    * @Title: add
    * @Description: 添加SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchange
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisCuttingToolExchange synthesisCuttingToolExchange) throws Exception{
        this.synthesisCuttingToolExchangeService.addSynthesisCuttingToolExchange(synthesisCuttingToolExchange);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchange
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisCuttingToolExchange synthesisCuttingToolExchange) throws  Exception{
        this.synthesisCuttingToolExchangeService.updSynthesisCuttingToolExchange(synthesisCuttingToolExchange);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchange
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisCuttingToolExchange synthesisCuttingToolExchange) throws  Exception{
        this.synthesisCuttingToolExchangeService.delSynthesisCuttingToolExchangeForLogic(synthesisCuttingToolExchange);
    }

    /**
    * @Title: getSynthesisCuttingToolExchangeByVo
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolExchangeVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolExchange getSynthesisCuttingToolExchangeByVo(@RequestBody SynthesisCuttingToolExchangeVO synthesisCuttingToolExchangeVO) throws  Exception{
        return this.synthesisCuttingToolExchangeService.getSynthesisCuttingToolExchange(synthesisCuttingToolExchangeVO);
    }

    /**
    * @Title: getSynthesisCuttingToolExchangeByPage
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolExchangeVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisCuttingToolExchangeByPage(@RequestBody SynthesisCuttingToolExchangeVO synthesisCuttingToolExchangeVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisCuttingToolExchangeService.getSynthesisCuttingToolExchangeByPage(synthesisCuttingToolExchangeVO));
        result.put("vo",synthesisCuttingToolExchangeVO);
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
        return "/synthesisCuttingToolExchange/synthesisCuttingToolExchangeList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisCuttingToolExchange/synthesisCuttingToolExchangeInsAndUpd";
    }

}
