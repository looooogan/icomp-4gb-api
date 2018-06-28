package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SynthesisBladeCode;
import com.common.vo.SynthesisBladeCodeVO;
import com.service.common.ISynthesisBladeCodeService;
import com.service.common.ISynthesisCuttingToolService;
import com.service.synthesiscuttingtool.ISynthesisBladeBusinessService;
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
* @ClassName SynthesisBladeCodeController
* @Description SynthesisBladeCodeController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisBladeCode")
public class SynthesisBladeCodeController extends BaseController{

    @Autowired
    private ISynthesisBladeCodeService synthesisBladeCodeService;

    @Autowired
    private ISynthesisCuttingToolService synthesisCuttingToolService;
    @Autowired
    private ISynthesisBladeBusinessService bladeBusinessService;

    /**
    * @Title: add
    * @Description: 添加SynthesisBladeCode
    * @param synthesisBladeCodeVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception{
        bladeBusinessService.addBladeCode(synthesisBladeCodeVO);
//        this.synthesisBladeCodeService.addSynthesisBladeCode(synthesisBladeCode);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisBladeCode
    * @param synthesisBladeCode
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisBladeCode synthesisBladeCode) throws  Exception{
        this.synthesisBladeCodeService.updSynthesisBladeCode(synthesisBladeCode);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisBladeCode
    * @param synthesisBladeCode
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisBladeCode synthesisBladeCode) throws  Exception{
        this.synthesisBladeCodeService.delSynthesisBladeCodeForLogic(synthesisBladeCode);
    }

    /**
    * @Title: getSynthesisBladeCodeByVo
    * @Description: 根据查询条件查询
    * @param synthesisBladeCodeVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisBladeCode getSynthesisBladeCodeByVo(@RequestBody SynthesisBladeCodeVO synthesisBladeCodeVO) throws  Exception{
        return this.synthesisBladeCodeService.getSynthesisBladeCode(synthesisBladeCodeVO);
    }

    /**
    * @Title: getSynthesisBladeCodeByPage
    * @Description: 根据查询条件查询
    * @param synthesisBladeCodeVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisBladeCodeByPage(@RequestBody SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisBladeCodeService.getSynthesisBladeCodeByPage(synthesisBladeCodeVO));
        result.put("vo",synthesisBladeCodeVO);
        return result;
    }


    /**
     * @Title: getSynthesisBladeCodeByPage
     * @Description: 根据查询条件查询
     * @param synthesisBladeCodeVO
     * @throws Exception
     * @return: void
     */
    @RequestMapping(value = "listForGroup",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> queryGroupBladeCode(@RequestBody SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.bladeBusinessService.queryGroupBladeCode(synthesisBladeCodeVO));
        result.put("vo",synthesisBladeCodeVO);
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
        return "/synthesisBladeCode/synthesisBladeCodeList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisBladeCode/synthesisBladeCodeInsAndUpd";
    }

}
