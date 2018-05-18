package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.ProductLineEquipment;
import com.common.vo.ProductLineEquipmentVO;
import com.service.common.IProductLineEquipmentService;
import com.service.common.IRfidContainerService;
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
* @ClassName ProductLineEquipmentController
* @Description ProductLineEquipmentController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("productLineEquipment")
public class ProductLineEquipmentController extends BaseController{

    @Autowired
    private IProductLineEquipmentService productLineEquipmentService;

    @Autowired
    private IRfidContainerService rfidContainerService;

    /**
    * @Title: add
    * @Description: 添加ProductLineEquipment
    * @param productLineEquipment
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody ProductLineEquipment productLineEquipment) throws Exception{
        this.productLineEquipmentService.addProductLineEquipment(productLineEquipment);
    }

    /**
    * @Title: update
    * @Description: 修改ProductLineEquipment
    * @param productLineEquipment
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody ProductLineEquipment productLineEquipment) throws  Exception{
        this.productLineEquipmentService.updProductLineEquipment(productLineEquipment);
    }

    /**
    * @Title: del
    * @Description: 删除ProductLineEquipment
    * @param productLineEquipment
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody ProductLineEquipment productLineEquipment) throws  Exception{
        this.productLineEquipmentService.delProductLineEquipmentForLogic(productLineEquipment);
    }

    /**
    * @Title: getProductLineEquipmentByVo
    * @Description: 根据查询条件查询
    * @param productLineEquipmentVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public ProductLineEquipment getProductLineEquipmentByVo(@RequestBody ProductLineEquipmentVO productLineEquipmentVO) throws  Exception{
        return this.productLineEquipmentService.getProductLineEquipment(productLineEquipmentVO);
    }

    /**
    * @Title: getProductLineEquipmentByPage
    * @Description: 根据查询条件查询
    * @param productLineEquipmentVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getProductLineEquipmentByPage(@RequestBody ProductLineEquipmentVO productLineEquipmentVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.productLineEquipmentService.getProductLineEquipmentByPage(productLineEquipmentVO));
        result.put("vo",productLineEquipmentVO);
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
        return "/productLineEquipment/productLineEquipmentList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/productLineEquipment/productLineEquipmentInsAndUpd";
    }

}
