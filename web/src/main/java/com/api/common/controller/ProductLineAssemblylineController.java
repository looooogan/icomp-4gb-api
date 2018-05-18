package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.ProductLineAssemblyline;
import com.common.vo.ProductLineAssemblylineVO;
import com.service.common.IProductLineAssemblylineService;
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
* @ClassName ProductLineAssemblylineController
* @Description ProductLineAssemblylineController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("productLineAssemblyline")
public class ProductLineAssemblylineController extends BaseController{

    @Autowired
    private IProductLineAssemblylineService productLineAssemblylineService;


    /**
    * @Title: add
    * @Description: 添加ProductLineAssemblyline
    * @param productLineAssemblyline
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody ProductLineAssemblyline productLineAssemblyline) throws Exception{
        this.productLineAssemblylineService.addProductLineAssemblyline(productLineAssemblyline);
    }

    /**
    * @Title: update
    * @Description: 修改ProductLineAssemblyline
    * @param productLineAssemblyline
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody ProductLineAssemblyline productLineAssemblyline) throws  Exception{
        this.productLineAssemblylineService.updProductLineAssemblyline(productLineAssemblyline);
    }

    /**
    * @Title: del
    * @Description: 删除ProductLineAssemblyline
    * @param productLineAssemblyline
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody ProductLineAssemblyline productLineAssemblyline) throws  Exception{
        this.productLineAssemblylineService.delProductLineAssemblylineForLogic(productLineAssemblyline);
    }

    /**
    * @Title: getProductLineAssemblylineByVo
    * @Description: 根据查询条件查询
    * @param productLineAssemblylineVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public ProductLineAssemblyline getProductLineAssemblylineByVo(@RequestBody ProductLineAssemblylineVO productLineAssemblylineVO) throws  Exception{
        return this.productLineAssemblylineService.getProductLineAssemblyline(productLineAssemblylineVO);
    }

    /**
    * @Title: getProductLineAssemblylineByPage
    * @Description: 根据查询条件查询
    * @param productLineAssemblylineVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getProductLineAssemblylineByPage(@RequestBody ProductLineAssemblylineVO productLineAssemblylineVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.productLineAssemblylineService.getProductLineAssemblylineByPage(productLineAssemblylineVO));
        result.put("vo",productLineAssemblylineVO);
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
        return "/productLineAssemblyline/productLineAssemblylineList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/productLineAssemblyline/productLineAssemblylineInsAndUpd";
    }

}
