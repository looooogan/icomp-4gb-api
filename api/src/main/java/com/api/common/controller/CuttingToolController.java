package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.CuttingTool;
import com.common.vo.CuttingToolVO;
import com.service.common.ICuttingToolService;
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
* @ClassName CuttingToolController
* @Description CuttingToolController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("cuttingTool")
public class CuttingToolController extends BaseController{

    @Autowired
    private ICuttingToolService cuttingToolService;


    /**
    * @Title: add
    * @Description: 添加CuttingTool
    * @param cuttingTool
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody CuttingTool cuttingTool) throws Exception{
        this.cuttingToolService.addCuttingTool(cuttingTool);
    }

    /**
    * @Title: update
    * @Description: 修改CuttingTool
    * @param cuttingTool
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody CuttingTool cuttingTool) throws  Exception{
        this.cuttingToolService.updCuttingTool(cuttingTool);
    }

    /**
    * @Title: del
    * @Description: 删除CuttingTool
    * @param cuttingTool
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody CuttingTool cuttingTool) throws  Exception{
        this.cuttingToolService.delCuttingToolForLogic(cuttingTool);
    }

    /**
    * @Title: getCuttingToolByVo
    * @Description: 根据查询条件查询
    * @param cuttingToolVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public CuttingTool getCuttingToolByVo(@RequestBody CuttingToolVO cuttingToolVO) throws  Exception{
        return this.cuttingToolService.getCuttingTool(cuttingToolVO);
    }

    /**
    * @Title: getCuttingToolByPage
    * @Description: 根据查询条件查询
    * @param cuttingToolVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getCuttingToolByPage(@RequestBody CuttingToolVO cuttingToolVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.cuttingToolService.getCuttingToolByPage(cuttingToolVO));
        result.put("vo",cuttingToolVO);
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
        return "/cuttingTool/cuttingToolList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/cuttingTool/cuttingToolInsAndUpd";
    }

}
