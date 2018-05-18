package com.api.productline.controller;

import com.api.base.controller.BaseController;
import com.common.pojo.*;
import com.common.vo.ProductLineVO;
import com.service.productline.IProductLineBusinessService;
import com.service.productline.vo.QueryEquipmentByRfidVO;
import com.service.productline.vo.QuerySynthesisCuttingToolVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by logan on 2018/4/30.
 */
@Controller
@RequestMapping("productlineBusiness")
public class ProductLineBusinessController extends BaseController {

    @Autowired
    private IProductLineBusinessService productLineBusinessService;

    @RequestMapping("getAssemblylines")
    @ResponseBody
    public List<ProductLineAssemblyline> getAllAssemblyline() throws Exception{
        return productLineBusinessService.getAllAssemblyline();
    }

    @RequestMapping("getEquipmentByAssemblyline")
    @ResponseBody
    public List<ProductLineEquipment> getEquipmentByAssemblyline(@RequestBody  ProductLineVO productLineVO) throws Exception{
        return  productLineBusinessService.getEquipmentByAssemblyline(productLineVO);
    }

    @RequestMapping("initEquipment")
    @ResponseBody
    public void initEquipment(@RequestBody  ProductLineEquipment productLineEquipment) throws Exception{
        productLineBusinessService.addInitEquipment(productLineEquipment);
    }

    @RequestMapping("querySynthesisCuttingTool")
    @ResponseBody
    public SynthesisCuttingToolBind querySynthesisCuttingTool(@RequestBody QuerySynthesisCuttingToolVO querySynthesisCuttingToolVO) throws Exception{
        return productLineBusinessService.querySynthesisCuttingTool(querySynthesisCuttingToolVO);
    }

    @RequestMapping("queryEquipmentByRFID")
    @ResponseBody
    public QueryEquipmentByRfidVO querySynthesisCuttingTool(@RequestBody QueryEquipmentByRfidVO querySynthesisCuttingToolVO) throws Exception{
        return productLineBusinessService.queryEquipmentByRFID(querySynthesisCuttingToolVO);
    }
}
