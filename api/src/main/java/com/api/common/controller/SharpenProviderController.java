package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SharpenProvider;
import com.common.vo.SharpenProviderVO;
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
* @ClassName SharpenProviderController
* @Description SharpenProviderController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("sharpenProvider")
public class SharpenProviderController extends BaseController{

    @Autowired
    private ISharpenProviderService sharpenProviderService;


    /**
    * @Title: add
    * @Description: 添加SharpenProvider
    * @param sharpenProvider
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SharpenProvider sharpenProvider) throws Exception{
        this.sharpenProviderService.addSharpenProvider(sharpenProvider);
    }

    /**
    * @Title: update
    * @Description: 修改SharpenProvider
    * @param sharpenProvider
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SharpenProvider sharpenProvider) throws  Exception{
        this.sharpenProviderService.updSharpenProvider(sharpenProvider);
    }

    /**
    * @Title: del
    * @Description: 删除SharpenProvider
    * @param sharpenProvider
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SharpenProvider sharpenProvider) throws  Exception{
        this.sharpenProviderService.delSharpenProviderForLogic(sharpenProvider);
    }

    /**
    * @Title: getSharpenProviderByVo
    * @Description: 根据查询条件查询
    * @param sharpenProviderVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SharpenProvider getSharpenProviderByVo(@RequestBody SharpenProviderVO sharpenProviderVO) throws  Exception{
        return this.sharpenProviderService.getSharpenProvider(sharpenProviderVO);
    }

    /**
    * @Title: getSharpenProviderByPage
    * @Description: 根据查询条件查询
    * @param sharpenProviderVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSharpenProviderByPage(@RequestBody SharpenProviderVO sharpenProviderVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.sharpenProviderService.getSharpenProviderByPage(sharpenProviderVO));
        result.put("vo",sharpenProviderVO);
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
        return "/sharpenProvider/sharpenProviderList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/sharpenProvider/sharpenProviderInsAndUpd";
    }

}
