package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.CuttingToolsScrap;
import com.common.vo.CuttingToolsScrapVO;
import com.service.common.ICuttingToolService;
import com.service.common.ICuttingToolsScrapService;
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
* @ClassName CuttingToolsScrapController
* @Description CuttingToolsScrapController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("cuttingToolsScrap")
public class CuttingToolsScrapController extends BaseController{

    @Autowired
    private ICuttingToolsScrapService cuttingToolsScrapService;

    @Autowired
    private ICuttingToolService cuttingToolService;

    /**
    * @Title: add
    * @Description: 添加CuttingToolsScrap
    * @param cuttingToolsScrap
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody CuttingToolsScrap cuttingToolsScrap) throws Exception{
        this.cuttingToolsScrapService.addCuttingToolsScrap(cuttingToolsScrap);
    }

    /**
    * @Title: update
    * @Description: 修改CuttingToolsScrap
    * @param cuttingToolsScrap
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody CuttingToolsScrap cuttingToolsScrap) throws  Exception{
        this.cuttingToolsScrapService.updCuttingToolsScrap(cuttingToolsScrap);
    }

    /**
    * @Title: del
    * @Description: 删除CuttingToolsScrap
    * @param cuttingToolsScrap
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody CuttingToolsScrap cuttingToolsScrap) throws  Exception{
        this.cuttingToolsScrapService.delCuttingToolsScrapForLogic(cuttingToolsScrap);
    }

    /**
    * @Title: getCuttingToolsScrapByVo
    * @Description: 根据查询条件查询
    * @param cuttingToolsScrapVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public CuttingToolsScrap getCuttingToolsScrapByVo(@RequestBody CuttingToolsScrapVO cuttingToolsScrapVO) throws  Exception{
        return this.cuttingToolsScrapService.getCuttingToolsScrap(cuttingToolsScrapVO);
    }

    /**
    * @Title: getCuttingToolsScrapByPage
    * @Description: 根据查询条件查询
    * @param cuttingToolsScrapVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getCuttingToolsScrapByPage(@RequestBody CuttingToolsScrapVO cuttingToolsScrapVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.cuttingToolsScrapService.getCuttingToolsScrapByPage(cuttingToolsScrapVO));
        result.put("vo",cuttingToolsScrapVO);
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
        return "/cuttingToolsScrap/cuttingToolsScrapList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/cuttingToolsScrap/cuttingToolsScrapInsAndUpd";
    }

}
