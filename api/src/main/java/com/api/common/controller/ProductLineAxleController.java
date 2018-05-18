package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.ProductLineAxle;
import com.common.vo.ProductLineAxleVO;
import com.service.common.IProductLineAxleService;
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
* @ClassName ProductLineAxleController
* @Description ProductLineAxleController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("productLineAxle")
public class ProductLineAxleController extends BaseController{

    @Autowired
    private IProductLineAxleService productLineAxleService;


    /**
    * @Title: add
    * @Description: 添加ProductLineAxle
    * @param productLineAxle
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody ProductLineAxle productLineAxle) throws Exception{
        this.productLineAxleService.addProductLineAxle(productLineAxle);
    }

    /**
    * @Title: update
    * @Description: 修改ProductLineAxle
    * @param productLineAxle
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody ProductLineAxle productLineAxle) throws  Exception{
        this.productLineAxleService.updProductLineAxle(productLineAxle);
    }

    /**
    * @Title: del
    * @Description: 删除ProductLineAxle
    * @param productLineAxle
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody ProductLineAxle productLineAxle) throws  Exception{
        this.productLineAxleService.delProductLineAxleForLogic(productLineAxle);
    }

    /**
    * @Title: getProductLineAxleByVo
    * @Description: 根据查询条件查询
    * @param productLineAxleVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public ProductLineAxle getProductLineAxleByVo(@RequestBody ProductLineAxleVO productLineAxleVO) throws  Exception{
        return this.productLineAxleService.getProductLineAxle(productLineAxleVO);
    }

    /**
    * @Title: getProductLineAxleByPage
    * @Description: 根据查询条件查询
    * @param productLineAxleVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getProductLineAxleByPage(@RequestBody ProductLineAxleVO productLineAxleVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.productLineAxleService.getProductLineAxleByPage(productLineAxleVO));
        result.put("vo",productLineAxleVO);
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
        return "/productLineAxle/productLineAxleList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/productLineAxle/productLineAxleInsAndUpd";
    }

}
