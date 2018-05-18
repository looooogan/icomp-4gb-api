package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.ProductLineProcess;
import com.common.vo.ProductLineProcessVO;
import com.service.common.IProductLineAssemblylineService;
import com.service.common.IProductLineProcessService;
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
* @ClassName ProductLineProcessController
* @Description ProductLineProcessController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("productLineProcess")
public class ProductLineProcessController extends BaseController{

    @Autowired
    private IProductLineProcessService productLineProcessService;

    @Autowired
    private IProductLineAssemblylineService productLineAssemblylineService;

    /**
    * @Title: add
    * @Description: 添加ProductLineProcess
    * @param productLineProcess
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody ProductLineProcess productLineProcess) throws Exception{
        this.productLineProcessService.addProductLineProcess(productLineProcess);
    }

    /**
    * @Title: update
    * @Description: 修改ProductLineProcess
    * @param productLineProcess
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody ProductLineProcess productLineProcess) throws  Exception{
        this.productLineProcessService.updProductLineProcess(productLineProcess);
    }

    /**
    * @Title: del
    * @Description: 删除ProductLineProcess
    * @param productLineProcess
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody ProductLineProcess productLineProcess) throws  Exception{
        this.productLineProcessService.delProductLineProcessForLogic(productLineProcess);
    }

    /**
    * @Title: getProductLineProcessByVo
    * @Description: 根据查询条件查询
    * @param productLineProcessVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public ProductLineProcess getProductLineProcessByVo(@RequestBody ProductLineProcessVO productLineProcessVO) throws  Exception{
        return this.productLineProcessService.getProductLineProcess(productLineProcessVO);
    }

    /**
    * @Title: getProductLineProcessByPage
    * @Description: 根据查询条件查询
    * @param productLineProcessVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getProductLineProcessByPage(@RequestBody ProductLineProcessVO productLineProcessVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.productLineProcessService.getProductLineProcessByPage(productLineProcessVO));
        result.put("vo",productLineProcessVO);
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
        return "/productLineProcess/productLineProcessList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/productLineProcess/productLineProcessInsAndUpd";
    }

}
