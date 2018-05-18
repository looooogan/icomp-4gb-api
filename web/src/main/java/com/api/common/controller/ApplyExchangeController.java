package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.ApplyExchange;
import com.common.vo.ApplyExchangeVO;
import com.service.common.IApplyExchangeService;
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
* @ClassName ApplyExchangeController
* @Description ApplyExchangeController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("applyExchange")
public class ApplyExchangeController extends BaseController{

    @Autowired
    private IApplyExchangeService applyExchangeService;


    /**
    * @Title: add
    * @Description: 添加ApplyExchange
    * @param applyExchange
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody ApplyExchange applyExchange) throws Exception{
        this.applyExchangeService.addApplyExchange(applyExchange);
    }

    /**
    * @Title: update
    * @Description: 修改ApplyExchange
    * @param applyExchange
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody ApplyExchange applyExchange) throws  Exception{
        this.applyExchangeService.updApplyExchange(applyExchange);
    }

    /**
    * @Title: del
    * @Description: 删除ApplyExchange
    * @param applyExchange
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody ApplyExchange applyExchange) throws  Exception{
        this.applyExchangeService.delApplyExchangeForLogic(applyExchange);
    }

    /**
    * @Title: getApplyExchangeByVo
    * @Description: 根据查询条件查询
    * @param applyExchangeVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public ApplyExchange getApplyExchangeByVo(@RequestBody ApplyExchangeVO applyExchangeVO) throws  Exception{
        return this.applyExchangeService.getApplyExchange(applyExchangeVO);
    }

    /**
    * @Title: getApplyExchangeByPage
    * @Description: 根据查询条件查询
    * @param applyExchangeVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getApplyExchangeByPage(@RequestBody ApplyExchangeVO applyExchangeVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.applyExchangeService.getApplyExchangeByPage(applyExchangeVO));
        result.put("vo",applyExchangeVO);
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
        return "/applyExchange/applyExchangeList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/applyExchange/applyExchangeInsAndUpd";
    }

}
