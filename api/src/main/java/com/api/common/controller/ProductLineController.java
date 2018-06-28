package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.ProductLine;
import com.common.vo.ProductLineVO;
import com.service.common.*;
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
* @ClassName ProductLineController
* @Description ProductLineController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("productLine")
public class ProductLineController extends BaseController{

    @Autowired
    private IProductLineService productLineService;

    /**
    * @Title: add
    * @Description: 添加ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody ProductLine productLine) throws Exception{
        this.productLineService.addProductLine(productLine);
    }

    /**
    * @Title: update
    * @Description: 修改ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody ProductLine productLine) throws  Exception{
        this.productLineService.updProductLine(productLine);
    }

    /**
    * @Title: del
    * @Description: 删除ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody ProductLine productLine) throws  Exception{
        this.productLineService.delProductLineForLogic(productLine);
    }

    /**
    * @Title: getProductLineByVo
    * @Description: 根据查询条件查询
    * @param productLineVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public ProductLine getProductLineByVo(@RequestBody ProductLineVO productLineVO) throws  Exception{
        return this.productLineService.getProductLine(productLineVO);
    }

    /**
    * @Title: getProductLineByPage
    * @Description: 根据查询条件查询
    * @param productLineVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getProductLineByPage(@RequestBody ProductLineVO productLineVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.productLineService.getProductLineByPage(productLineVO));
        result.put("vo",productLineVO);
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
        return "/productLine/productLineList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/productLine/productLineInsAndUpd";
    }

}
