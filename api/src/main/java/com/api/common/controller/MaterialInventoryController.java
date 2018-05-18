package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.MaterialInventory;
import com.common.vo.MaterialInventoryVO;
import com.service.common.ICuttingToolService;
import com.service.common.IMaterialInventoryService;
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
* @ClassName MaterialInventoryController
* @Description MaterialInventoryController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("materialInventory")
public class MaterialInventoryController extends BaseController{

    @Autowired
    private IMaterialInventoryService materialInventoryService;

    @Autowired
    private ICuttingToolService cuttingToolService;

    /**
    * @Title: add
    * @Description: 添加MaterialInventory
    * @param materialInventory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody MaterialInventory materialInventory) throws Exception{
        this.materialInventoryService.addMaterialInventory(materialInventory);
    }

    /**
    * @Title: update
    * @Description: 修改MaterialInventory
    * @param materialInventory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody MaterialInventory materialInventory) throws  Exception{
        this.materialInventoryService.updMaterialInventory(materialInventory);
    }

    /**
    * @Title: del
    * @Description: 删除MaterialInventory
    * @param materialInventory
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody MaterialInventory materialInventory) throws  Exception{
        this.materialInventoryService.delMaterialInventoryForLogic(materialInventory);
    }

    /**
    * @Title: getMaterialInventoryByVo
    * @Description: 根据查询条件查询
    * @param materialInventoryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public MaterialInventory getMaterialInventoryByVo(@RequestBody MaterialInventoryVO materialInventoryVO) throws  Exception{
        return this.materialInventoryService.getMaterialInventory(materialInventoryVO);
    }

    /**
    * @Title: getMaterialInventoryByPage
    * @Description: 根据查询条件查询
    * @param materialInventoryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getMaterialInventoryByPage(@RequestBody MaterialInventoryVO materialInventoryVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.materialInventoryService.getMaterialInventoryByPage(materialInventoryVO));
        result.put("vo",materialInventoryVO);
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
        return "/materialInventory/materialInventoryList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/materialInventory/materialInventoryInsAndUpd";
    }

}
