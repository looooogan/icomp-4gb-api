package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.OutsideFactory;
import com.common.vo.OutsideFactoryVO;
import com.service.common.ICuttingToolService;
import com.service.common.IOutsideFactoryService;
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
* @ClassName OutsideFactoryController
* @Description OutsideFactoryController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("outsideFactory")
public class OutsideFactoryController extends BaseController{

    @Autowired
    private IOutsideFactoryService outsideFactoryService;

    @Autowired
    private ISharpenProviderService sharpenProviderService;
    @Autowired
    private ICuttingToolService cuttingToolService;

    /**
    * @Title: add
    * @Description: 添加OutsideFactory
    * @param outsideFactory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody OutsideFactory outsideFactory) throws Exception{
        this.outsideFactoryService.addOutsideFactory(outsideFactory);
    }

    /**
    * @Title: update
    * @Description: 修改OutsideFactory
    * @param outsideFactory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody OutsideFactory outsideFactory) throws  Exception{
        this.outsideFactoryService.updOutsideFactory(outsideFactory);
    }

    /**
    * @Title: del
    * @Description: 删除OutsideFactory
    * @param outsideFactory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody OutsideFactory outsideFactory) throws  Exception{
        this.outsideFactoryService.delOutsideFactoryForLogic(outsideFactory);
    }

    /**
    * @Title: getOutsideFactoryByVo
    * @Description: 根据查询条件查询
    * @param outsideFactoryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public OutsideFactory getOutsideFactoryByVo(@RequestBody OutsideFactoryVO outsideFactoryVO) throws  Exception{
        return this.outsideFactoryService.getOutsideFactory(outsideFactoryVO);
    }

    /**
    * @Title: getOutsideFactoryByPage
    * @Description: 根据查询条件查询
    * @param outsideFactoryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getOutsideFactoryByPage(@RequestBody OutsideFactoryVO outsideFactoryVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.outsideFactoryService.getOutsideFactoryByPage(outsideFactoryVO));
        result.put("vo",outsideFactoryVO);
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
        return "/outsideFactory/outsideFactoryList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/outsideFactory/outsideFactoryInsAndUpd";
    }

}
