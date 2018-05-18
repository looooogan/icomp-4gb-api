package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SynthesisCuttingToolMaterialInventory;
import com.common.vo.SynthesisCuttingToolMaterialInventoryVO;
import com.service.common.ISynthesisCuttingToolMaterialInventoryService;
import com.service.common.ISynthesisCuttingToolService;
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
* @ClassName SynthesisCuttingToolMaterialInventoryController
* @Description SynthesisCuttingToolMaterialInventoryController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisCuttingToolMaterialInventory")
public class SynthesisCuttingToolMaterialInventoryController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolMaterialInventoryService synthesisCuttingToolMaterialInventoryService;

    @Autowired
    private ISynthesisCuttingToolService synthesisCuttingToolService;

    /**
    * @Title: add
    * @Description: 添加SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory) throws Exception{
        this.synthesisCuttingToolMaterialInventoryService.addSynthesisCuttingToolMaterialInventory(synthesisCuttingToolMaterialInventory);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory) throws  Exception{
        this.synthesisCuttingToolMaterialInventoryService.updSynthesisCuttingToolMaterialInventory(synthesisCuttingToolMaterialInventory);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory) throws  Exception{
        this.synthesisCuttingToolMaterialInventoryService.delSynthesisCuttingToolMaterialInventoryForLogic(synthesisCuttingToolMaterialInventory);
    }

    /**
    * @Title: getSynthesisCuttingToolMaterialInventoryByVo
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolMaterialInventoryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolMaterialInventory getSynthesisCuttingToolMaterialInventoryByVo(@RequestBody SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO) throws  Exception{
        return this.synthesisCuttingToolMaterialInventoryService.getSynthesisCuttingToolMaterialInventory(synthesisCuttingToolMaterialInventoryVO);
    }

    /**
    * @Title: getSynthesisCuttingToolMaterialInventoryByPage
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolMaterialInventoryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisCuttingToolMaterialInventoryByPage(@RequestBody SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisCuttingToolMaterialInventoryService.getSynthesisCuttingToolMaterialInventoryByPage(synthesisCuttingToolMaterialInventoryVO));
        result.put("vo",synthesisCuttingToolMaterialInventoryVO);
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
        return "/synthesisCuttingToolMaterialInventory/synthesisCuttingToolMaterialInventoryList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisCuttingToolMaterialInventory/synthesisCuttingToolMaterialInventoryInsAndUpd";
    }

}
