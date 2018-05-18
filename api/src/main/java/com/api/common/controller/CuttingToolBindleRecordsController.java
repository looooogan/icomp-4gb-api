package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.CuttingToolBindleRecords;
import com.common.vo.CuttingToolBindleRecordsVO;
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
* @ClassName CuttingToolBindleRecordsController
* @Description CuttingToolBindleRecordsController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("cuttingToolBindleRecords")
public class CuttingToolBindleRecordsController extends BaseController{

    @Autowired
    private ICuttingToolBindleRecordsService cuttingToolBindleRecordsService;

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
    * @Description: 添加CuttingToolBindleRecords
    * @param cuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody CuttingToolBindleRecords cuttingToolBindleRecords) throws Exception{
        this.cuttingToolBindleRecordsService.addCuttingToolBindleRecords(cuttingToolBindleRecords);
    }

    /**
    * @Title: update
    * @Description: 修改CuttingToolBindleRecords
    * @param cuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody CuttingToolBindleRecords cuttingToolBindleRecords) throws  Exception{
        this.cuttingToolBindleRecordsService.updCuttingToolBindleRecords(cuttingToolBindleRecords);
    }

    /**
    * @Title: del
    * @Description: 删除CuttingToolBindleRecords
    * @param cuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody CuttingToolBindleRecords cuttingToolBindleRecords) throws  Exception{
        this.cuttingToolBindleRecordsService.delCuttingToolBindleRecordsForLogic(cuttingToolBindleRecords);
    }

    /**
    * @Title: getCuttingToolBindleRecordsByVo
    * @Description: 根据查询条件查询
    * @param cuttingToolBindleRecordsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public CuttingToolBindleRecords getCuttingToolBindleRecordsByVo(@RequestBody CuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws  Exception{
        return this.cuttingToolBindleRecordsService.getCuttingToolBindleRecords(cuttingToolBindleRecordsVO);
    }

    /**
    * @Title: getCuttingToolBindleRecordsByPage
    * @Description: 根据查询条件查询
    * @param cuttingToolBindleRecordsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getCuttingToolBindleRecordsByPage(@RequestBody CuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.cuttingToolBindleRecordsService.getCuttingToolBindleRecordsByPage(cuttingToolBindleRecordsVO));
        result.put("vo",cuttingToolBindleRecordsVO);
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
        return "/cuttingToolBindleRecords/cuttingToolBindleRecordsList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/cuttingToolBindleRecords/cuttingToolBindleRecordsInsAndUpd";
    }

}
