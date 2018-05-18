package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SynthesisCuttingToolType;
import com.common.vo.SynthesisCuttingToolTypeVO;
import com.service.common.ISynthesisCuttingToolTypeService;
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
* @ClassName SynthesisCuttingToolTypeController
* @Description SynthesisCuttingToolTypeController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisCuttingToolType")
public class SynthesisCuttingToolTypeController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolTypeService synthesisCuttingToolTypeService;


    /**
    * @Title: add
    * @Description: 添加SynthesisCuttingToolType
    * @param synthesisCuttingToolType
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisCuttingToolType synthesisCuttingToolType) throws Exception{
        this.synthesisCuttingToolTypeService.addSynthesisCuttingToolType(synthesisCuttingToolType);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisCuttingToolType
    * @param synthesisCuttingToolType
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisCuttingToolType synthesisCuttingToolType) throws  Exception{
        this.synthesisCuttingToolTypeService.updSynthesisCuttingToolType(synthesisCuttingToolType);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisCuttingToolType
    * @param synthesisCuttingToolType
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisCuttingToolType synthesisCuttingToolType) throws  Exception{
        this.synthesisCuttingToolTypeService.delSynthesisCuttingToolTypeForLogic(synthesisCuttingToolType);
    }

    /**
    * @Title: getSynthesisCuttingToolTypeByVo
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolTypeVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolType getSynthesisCuttingToolTypeByVo(@RequestBody SynthesisCuttingToolTypeVO synthesisCuttingToolTypeVO) throws  Exception{
        return this.synthesisCuttingToolTypeService.getSynthesisCuttingToolType(synthesisCuttingToolTypeVO);
    }

    /**
    * @Title: getSynthesisCuttingToolTypeByPage
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolTypeVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisCuttingToolTypeByPage(@RequestBody SynthesisCuttingToolTypeVO synthesisCuttingToolTypeVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisCuttingToolTypeService.getSynthesisCuttingToolTypeByPage(synthesisCuttingToolTypeVO));
        result.put("vo",synthesisCuttingToolTypeVO);
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
        return "/synthesisCuttingToolType/synthesisCuttingToolTypeList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisCuttingToolType/synthesisCuttingToolTypeInsAndUpd";
    }

}
