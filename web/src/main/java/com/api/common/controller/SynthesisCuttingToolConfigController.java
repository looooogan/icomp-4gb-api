package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SynthesisCuttingToolConfig;
import com.common.vo.SynthesisCuttingToolConfigVO;
import com.service.common.ISynthesisCuttingToolConfigService;
import com.service.common.ISynthesisCuttingToolLocationConfigService;
import com.service.common.ISynthesisCuttingToolService;
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
* @ClassName SynthesisCuttingToolConfigController
* @Description SynthesisCuttingToolConfigController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisCuttingToolConfig")
public class SynthesisCuttingToolConfigController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolConfigService synthesisCuttingToolConfigService;

    @Autowired
    private ISynthesisCuttingToolService synthesisCuttingToolService;
    @Autowired
    private ISynthesisCuttingToolTypeService synthesisCuttingToolTypeService;
    @Autowired
    private ISynthesisCuttingToolLocationConfigService synthesisCuttingToolLocationConfigService;

    /**
    * @Title: add
    * @Description: 添加SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfig
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisCuttingToolConfig synthesisCuttingToolConfig) throws Exception{
        this.synthesisCuttingToolConfigService.addSynthesisCuttingToolConfig(synthesisCuttingToolConfig);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfig
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisCuttingToolConfig synthesisCuttingToolConfig) throws  Exception{
        this.synthesisCuttingToolConfigService.updSynthesisCuttingToolConfig(synthesisCuttingToolConfig);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfig
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisCuttingToolConfig synthesisCuttingToolConfig) throws  Exception{
        this.synthesisCuttingToolConfigService.delSynthesisCuttingToolConfigForLogic(synthesisCuttingToolConfig);
    }

    /**
    * @Title: getSynthesisCuttingToolConfigByVo
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolConfigVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolConfig getSynthesisCuttingToolConfigByVo(@RequestBody SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws  Exception{
        return this.synthesisCuttingToolConfigService.getSynthesisCuttingToolConfig(synthesisCuttingToolConfigVO);
    }

    /**
     * @Title: getSynthesisCuttingToolConfigByVo
     * @Description: 根据查询条件查询
     * @param synthesisCuttingToolConfigVO
     * @throws Exception
     * @return: void
     */
    @RequestMapping(value = "searchAndLocations",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolConfig searchAndLocations(@RequestBody SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws  Exception{
        return this.synthesisCuttingToolConfigService.searchAndLocations(synthesisCuttingToolConfigVO);
    }

    /**
    * @Title: getSynthesisCuttingToolConfigByPage
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolConfigVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisCuttingToolConfigByPage(@RequestBody SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisCuttingToolConfigService.getSynthesisCuttingToolConfigByPage(synthesisCuttingToolConfigVO));
        result.put("vo",synthesisCuttingToolConfigVO);
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
        return "/synthesisCuttingToolConfig/synthesisCuttingToolConfigList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisCuttingToolConfig/synthesisCuttingToolConfigInsAndUpd";
    }

}
