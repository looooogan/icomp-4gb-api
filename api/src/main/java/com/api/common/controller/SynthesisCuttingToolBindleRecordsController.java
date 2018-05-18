package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.ProductLine;
import com.common.pojo.SynthesisCuttingToolBindleRecords;
import com.common.vo.ProductLineVO;
import com.common.vo.SynthesisCuttingToolBindleRecordsVO;
import com.service.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
*
* @ClassName SynthesisCuttingToolBindleRecordsController
* @Description SynthesisCuttingToolBindleRecordsController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisCuttingToolBindleRecords")
public class SynthesisCuttingToolBindleRecordsController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolBindleRecordsService synthesisCuttingToolBindleRecordsService;

    @Autowired
    private IProductLineAssemblylineService productLineAssemblylineService;
    @Autowired
    private IProductLineAxleService productLineAxleService;
    @Autowired
    private IProductLineEquipmentService productLineEquipmentService;
    @Autowired
    private IProductLinePartsService productLinePartsService;
    @Autowired
    private IProductLineProcessService productLineProcessService;
    @Autowired
    private ISynthesisCuttingToolService synthesisCuttingToolService;

    /**
    * @Title: add
    * @Description: 添加SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords) throws Exception{
        this.synthesisCuttingToolBindleRecordsService.addSynthesisCuttingToolBindleRecords(synthesisCuttingToolBindleRecords);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords) throws  Exception{
        this.synthesisCuttingToolBindleRecordsService.updSynthesisCuttingToolBindleRecords(synthesisCuttingToolBindleRecords);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords) throws  Exception{
        this.synthesisCuttingToolBindleRecordsService.delSynthesisCuttingToolBindleRecordsForLogic(synthesisCuttingToolBindleRecords);
    }

    /**
    * @Title: getSynthesisCuttingToolBindleRecordsByVo
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolBindleRecordsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolBindleRecords getSynthesisCuttingToolBindleRecordsByVo(@RequestBody SynthesisCuttingToolBindleRecordsVO synthesisCuttingToolBindleRecordsVO) throws  Exception{
        return this.synthesisCuttingToolBindleRecordsService.getSynthesisCuttingToolBindleRecords(synthesisCuttingToolBindleRecordsVO);
    }

    @RequestMapping(value = "searchLast",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolBindleRecords searchLast(@RequestBody SynthesisCuttingToolBindleRecordsVO synthesisCuttingToolBindleRecordsVO) throws  Exception{
        return this.synthesisCuttingToolBindleRecordsService.getLastRecords(synthesisCuttingToolBindleRecordsVO);
    }

    @RequestMapping(value = "getParts",method = RequestMethod.POST)
    @ResponseBody
    public List<ProductLine> getParts(@RequestBody ProductLineVO productLineVO) throws  Exception{
        return this.synthesisCuttingToolBindleRecordsService.getParts(productLineVO);
    }

    /**
    * @Title: getSynthesisCuttingToolBindleRecordsByPage
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolBindleRecordsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisCuttingToolBindleRecordsByPage(@RequestBody SynthesisCuttingToolBindleRecordsVO synthesisCuttingToolBindleRecordsVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisCuttingToolBindleRecordsService.getSynthesisCuttingToolBindleRecordsByPage(synthesisCuttingToolBindleRecordsVO));
        result.put("vo",synthesisCuttingToolBindleRecordsVO);
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
        return "/synthesisCuttingToolBindleRecords/synthesisCuttingToolBindleRecordsList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisCuttingToolBindleRecords/synthesisCuttingToolBindleRecordsInsAndUpd";
    }

}
