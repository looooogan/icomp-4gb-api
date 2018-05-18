package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.ProductLineParts;
import com.common.vo.ProductLinePartsVO;
import com.service.common.IProductLinePartsService;
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
* @ClassName ProductLinePartsController
* @Description ProductLinePartsController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("productLineParts")
public class ProductLinePartsController extends BaseController{

    @Autowired
    private IProductLinePartsService productLinePartsService;


    /**
    * @Title: add
    * @Description: 添加ProductLineParts
    * @param productLineParts
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody ProductLineParts productLineParts) throws Exception{
        this.productLinePartsService.addProductLineParts(productLineParts);
    }

    /**
    * @Title: update
    * @Description: 修改ProductLineParts
    * @param productLineParts
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody ProductLineParts productLineParts) throws  Exception{
        this.productLinePartsService.updProductLineParts(productLineParts);
    }

    /**
    * @Title: del
    * @Description: 删除ProductLineParts
    * @param productLineParts
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody ProductLineParts productLineParts) throws  Exception{
        this.productLinePartsService.delProductLinePartsForLogic(productLineParts);
    }

    /**
    * @Title: getProductLinePartsByVo
    * @Description: 根据查询条件查询
    * @param productLinePartsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public ProductLineParts getProductLinePartsByVo(@RequestBody ProductLinePartsVO productLinePartsVO) throws  Exception{
        return this.productLinePartsService.getProductLineParts(productLinePartsVO);
    }

    /**
    * @Title: getProductLinePartsByPage
    * @Description: 根据查询条件查询
    * @param productLinePartsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getProductLinePartsByPage(@RequestBody ProductLinePartsVO productLinePartsVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.productLinePartsService.getProductLinePartsByPage(productLinePartsVO));
        result.put("vo",productLinePartsVO);
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
        return "/productLineParts/productLinePartsList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/productLineParts/productLinePartsInsAndUpd";
    }

}
