package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.QimingRecords;
import com.common.vo.QimingRecordsVO;
import com.service.common.IQimingRecordsService;
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
* @ClassName QimingRecordsController
* @Description QimingRecordsController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("qimingRecords")
public class QimingRecordsController extends BaseController{

    @Autowired
    private IQimingRecordsService qimingRecordsService;


    /**
    * @Title: add
    * @Description: 添加QimingRecords
    * @param qimingRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody QimingRecords qimingRecords) throws Exception{
        this.qimingRecordsService.addQimingRecords(qimingRecords);
    }

    /**
    * @Title: update
    * @Description: 修改QimingRecords
    * @param qimingRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody QimingRecords qimingRecords) throws  Exception{
        this.qimingRecordsService.updQimingRecords(qimingRecords);
    }

    /**
    * @Title: del
    * @Description: 删除QimingRecords
    * @param qimingRecords
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody QimingRecords qimingRecords) throws  Exception{
        this.qimingRecordsService.delQimingRecordsForLogic(qimingRecords);
    }

    /**
    * @Title: getQimingRecordsByVo
    * @Description: 根据查询条件查询
    * @param qimingRecordsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public QimingRecords getQimingRecordsByVo(@RequestBody QimingRecordsVO qimingRecordsVO) throws  Exception{
        return this.qimingRecordsService.getQimingRecords(qimingRecordsVO);
    }

    /**
    * @Title: getQimingRecordsByPage
    * @Description: 根据查询条件查询
    * @param qimingRecordsVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getQimingRecordsByPage(@RequestBody QimingRecordsVO qimingRecordsVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.qimingRecordsService.getQimingRecordsByPage(qimingRecordsVO));
        result.put("vo",qimingRecordsVO);
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
        return "/qimingRecords/qimingRecordsList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/qimingRecords/qimingRecordsInsAndUpd";
    }

}
