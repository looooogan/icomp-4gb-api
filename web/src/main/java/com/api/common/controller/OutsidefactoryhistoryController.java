package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.Outsidefactoryhistory;
import com.common.vo.OutsidefactoryhistoryVO;
import com.service.common.ICuttingToolService;
import com.service.common.IOutsidefactoryhistoryService;
import com.service.common.ISharpenProviderService;
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
* @ClassName OutsidefactoryhistoryController
* @Description OutsidefactoryhistoryController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("outsidefactoryhistory")
public class OutsidefactoryhistoryController extends BaseController{

    @Autowired
    private IOutsidefactoryhistoryService outsidefactoryhistoryService;

    @Autowired
    private ISharpenProviderService sharpenProviderService;
    @Autowired
    private ICuttingToolService cuttingToolService;

    /**
    * @Title: add
    * @Description: 添加Outsidefactoryhistory
    * @param outsidefactoryhistory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody Outsidefactoryhistory outsidefactoryhistory) throws Exception{
        this.outsidefactoryhistoryService.addOutsidefactoryhistory(outsidefactoryhistory);
    }

    /**
    * @Title: update
    * @Description: 修改Outsidefactoryhistory
    * @param outsidefactoryhistory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody Outsidefactoryhistory outsidefactoryhistory) throws  Exception{
        this.outsidefactoryhistoryService.updOutsidefactoryhistory(outsidefactoryhistory);
    }

    /**
    * @Title: del
    * @Description: 删除Outsidefactoryhistory
    * @param outsidefactoryhistory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody Outsidefactoryhistory outsidefactoryhistory) throws  Exception{
        this.outsidefactoryhistoryService.delOutsidefactoryhistoryForLogic(outsidefactoryhistory);
    }

    /**
    * @Title: getOutsidefactoryhistoryByVo
    * @Description: 根据查询条件查询
    * @param outsidefactoryhistoryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public Outsidefactoryhistory getOutsidefactoryhistoryByVo(@RequestBody OutsidefactoryhistoryVO outsidefactoryhistoryVO) throws  Exception{
        return this.outsidefactoryhistoryService.getOutsidefactoryhistory(outsidefactoryhistoryVO);
    }

    /**
    * @Title: getOutsidefactoryhistoryByPage
    * @Description: 根据查询条件查询
    * @param outsidefactoryhistoryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getOutsidefactoryhistoryByPage(@RequestBody OutsidefactoryhistoryVO outsidefactoryhistoryVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.outsidefactoryhistoryService.getOutsidefactoryhistoryByPage(outsidefactoryhistoryVO));
        result.put("vo",outsidefactoryhistoryVO);
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
        return "/outsidefactoryhistory/outsidefactoryhistoryList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/outsidefactoryhistory/outsidefactoryhistoryInsAndUpd";
    }

}
