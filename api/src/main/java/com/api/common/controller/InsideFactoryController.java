package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.InsideFactory;
import com.common.vo.InsideFactoryVO;
import com.service.common.ICuttingToolService;
import com.service.common.IInsideFactoryService;
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
* @ClassName InsideFactoryController
* @Description InsideFactoryController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("insideFactory")
public class InsideFactoryController extends BaseController{

    @Autowired
    private IInsideFactoryService insideFactoryService;

    @Autowired
    private ICuttingToolService cuttingToolService;

    /**
    * @Title: add
    * @Description: 添加InsideFactory
    * @param insideFactory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody InsideFactory insideFactory) throws Exception{
        this.insideFactoryService.addInsideFactory(insideFactory);
    }

    /**
    * @Title: update
    * @Description: 修改InsideFactory
    * @param insideFactory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody InsideFactory insideFactory) throws  Exception{
        this.insideFactoryService.updInsideFactory(insideFactory);
    }

    /**
    * @Title: del
    * @Description: 删除InsideFactory
    * @param insideFactory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody InsideFactory insideFactory) throws  Exception{
        this.insideFactoryService.delInsideFactoryForLogic(insideFactory);
    }

    /**
    * @Title: getInsideFactoryByVo
    * @Description: 根据查询条件查询
    * @param insideFactoryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public InsideFactory getInsideFactoryByVo(@RequestBody InsideFactoryVO insideFactoryVO) throws  Exception{
        return this.insideFactoryService.getInsideFactory(insideFactoryVO);
    }

    /**
    * @Title: getInsideFactoryByPage
    * @Description: 根据查询条件查询
    * @param insideFactoryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getInsideFactoryByPage(@RequestBody InsideFactoryVO insideFactoryVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.insideFactoryService.getInsideFactoryByPage(insideFactoryVO));
        result.put("vo",insideFactoryVO);
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
        return "/insideFactory/insideFactoryList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/insideFactory/insideFactoryInsAndUpd";
    }

}
