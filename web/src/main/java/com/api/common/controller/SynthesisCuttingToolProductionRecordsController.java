package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SynthesisCuttingToolProductionRecords;
import com.common.vo.SynthesisCuttingToolProductionRecordsVO;
import com.service.common.ISynthesisCuttingToolProductionRecordsService;
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
* @ClassName SynthesisCuttingToolProductionRecordsController
* @Description SynthesisCuttingToolProductionRecordsController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisCuttingToolProductionRecords")
public class SynthesisCuttingToolProductionRecordsController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolProductionRecordsService synthesisCuttingToolProductionRecordsService;


    /**
    * @Title: add
    * @Description: 添加SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords) throws Exception{
        this.synthesisCuttingToolProductionRecordsService.addSynthesisCuttingToolProductionRecords(synthesisCuttingToolProductionRecords);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords) throws  Exception{
        this.synthesisCuttingToolProductionRecordsService.updSynthesisCuttingToolProductionRecords(synthesisCuttingToolProductionRecords);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords) throws  Exception{
        this.synthesisCuttingToolProductionRecordsService.delSynthesisCuttingToolProductionRecordsForLogic(synthesisCuttingToolProductionRecords);
    }

    /**
    * @Title: getSynthesisCuttingToolProductionRecordsByVo
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolProductionRecordsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolProductionRecords getSynthesisCuttingToolProductionRecordsByVo(@RequestBody SynthesisCuttingToolProductionRecordsVO synthesisCuttingToolProductionRecordsVO) throws  Exception{
        return this.synthesisCuttingToolProductionRecordsService.getSynthesisCuttingToolProductionRecords(synthesisCuttingToolProductionRecordsVO);
    }

    /**
    * @Title: getSynthesisCuttingToolProductionRecordsByPage
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolProductionRecordsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisCuttingToolProductionRecordsByPage(@RequestBody SynthesisCuttingToolProductionRecordsVO synthesisCuttingToolProductionRecordsVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisCuttingToolProductionRecordsService.getSynthesisCuttingToolProductionRecordsByPage(synthesisCuttingToolProductionRecordsVO));
        result.put("vo",synthesisCuttingToolProductionRecordsVO);
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
        return "/synthesisCuttingToolProductionRecords/synthesisCuttingToolProductionRecordsList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisCuttingToolProductionRecords/synthesisCuttingToolProductionRecordsInsAndUpd";
    }

}
