package com.api.impower.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.ImpowerRecorder;
import com.common.vo.ImpowerRecorderVO;
import com.service.impower.IImpowerRecorderService;
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
* @ClassName ImpowerRecorderController
* @Description ImpowerRecorderController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("impowerRecorder")
public class ImpowerRecorderController extends BaseController{

    @Autowired
    private IImpowerRecorderService impowerRecorderService;


    /**
    * @Title: add
    * @Description: 添加ImpowerRecorder
    * @param impowerRecorder
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody ImpowerRecorder impowerRecorder) throws Exception{
        this.impowerRecorderService.addImpowerRecorder(impowerRecorder);
    }

    /**
    * @Title: update
    * @Description: 修改ImpowerRecorder
    * @param impowerRecorder
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody ImpowerRecorder impowerRecorder) throws  Exception{
        this.impowerRecorderService.updImpowerRecorder(impowerRecorder);
    }

    /**
    * @Title: del
    * @Description: 删除ImpowerRecorder
    * @param impowerRecorder
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody ImpowerRecorder impowerRecorder) throws  Exception{
        this.impowerRecorderService.delImpowerRecorderForLogic(impowerRecorder);
    }

    /**
    * @Title: getImpowerRecorderByVo
    * @Description: 根据查询条件查询
    * @param impowerRecorderVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public ImpowerRecorder getImpowerRecorderByVo(@RequestBody ImpowerRecorderVO impowerRecorderVO) throws  Exception{
        return this.impowerRecorderService.getImpowerRecorder(impowerRecorderVO);
    }

    /**
    * @Title: getImpowerRecorderByPage
    * @Description: 根据查询条件查询
    * @param impowerRecorderVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getImpowerRecorderByPage(@RequestBody ImpowerRecorderVO impowerRecorderVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.impowerRecorderService.getImpowerRecorderByPage(impowerRecorderVO));
        result.put("vo",impowerRecorderVO);
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
        return "/impowerRecorder/impowerRecorderList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/impowerRecorder/impowerRecorderInsAndUpd";
    }

}
