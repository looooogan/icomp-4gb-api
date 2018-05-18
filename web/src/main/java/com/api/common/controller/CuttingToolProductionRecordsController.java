package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.CuttingToolProductionRecords;
import com.common.vo.CuttingToolProductionRecordsVO;
import com.service.common.ICuttingToolProductionRecordsService;
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
* @ClassName CuttingToolProductionRecordsController
* @Description CuttingToolProductionRecordsController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("cuttingToolProductionRecords")
public class CuttingToolProductionRecordsController extends BaseController{

    @Autowired
    private ICuttingToolProductionRecordsService cuttingToolProductionRecordsService;


    /**
    * @Title: add
    * @Description: 添加CuttingToolProductionRecords
    * @param cuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody CuttingToolProductionRecords cuttingToolProductionRecords) throws Exception{
        this.cuttingToolProductionRecordsService.addCuttingToolProductionRecords(cuttingToolProductionRecords);
    }

    /**
    * @Title: update
    * @Description: 修改CuttingToolProductionRecords
    * @param cuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody CuttingToolProductionRecords cuttingToolProductionRecords) throws  Exception{
        this.cuttingToolProductionRecordsService.updCuttingToolProductionRecords(cuttingToolProductionRecords);
    }

    /**
    * @Title: del
    * @Description: 删除CuttingToolProductionRecords
    * @param cuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody CuttingToolProductionRecords cuttingToolProductionRecords) throws  Exception{
        this.cuttingToolProductionRecordsService.delCuttingToolProductionRecordsForLogic(cuttingToolProductionRecords);
    }

    /**
    * @Title: getCuttingToolProductionRecordsByVo
    * @Description: 根据查询条件查询
    * @param cuttingToolProductionRecordsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public CuttingToolProductionRecords getCuttingToolProductionRecordsByVo(@RequestBody CuttingToolProductionRecordsVO cuttingToolProductionRecordsVO) throws  Exception{
        return this.cuttingToolProductionRecordsService.getCuttingToolProductionRecords(cuttingToolProductionRecordsVO);
    }

    /**
    * @Title: getCuttingToolProductionRecordsByPage
    * @Description: 根据查询条件查询
    * @param cuttingToolProductionRecordsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getCuttingToolProductionRecordsByPage(@RequestBody CuttingToolProductionRecordsVO cuttingToolProductionRecordsVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.cuttingToolProductionRecordsService.getCuttingToolProductionRecordsByPage(cuttingToolProductionRecordsVO));
        result.put("vo",cuttingToolProductionRecordsVO);
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
        return "/cuttingToolProductionRecords/cuttingToolProductionRecordsList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/cuttingToolProductionRecords/cuttingToolProductionRecordsInsAndUpd";
    }

}
