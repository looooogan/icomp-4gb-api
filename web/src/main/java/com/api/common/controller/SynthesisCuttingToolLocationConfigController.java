package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SynthesisCuttingToolLocationConfig;
import com.common.vo.SynthesisCuttingToolLocationConfigVO;
import com.service.common.ICuttingToolService;
import com.service.common.ISynthesisCuttingToolLocationConfigService;
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
* @ClassName SynthesisCuttingToolLocationConfigController
* @Description SynthesisCuttingToolLocationConfigController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisCuttingToolLocationConfig")
public class SynthesisCuttingToolLocationConfigController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolLocationConfigService synthesisCuttingToolLocationConfigService;

    @Autowired
    private ICuttingToolService cuttingToolService;

    /**
    * @Title: add
    * @Description: 添加SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfig
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig) throws Exception{
        this.synthesisCuttingToolLocationConfigService.addSynthesisCuttingToolLocationConfig(synthesisCuttingToolLocationConfig);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfig
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig) throws  Exception{
        this.synthesisCuttingToolLocationConfigService.updSynthesisCuttingToolLocationConfig(synthesisCuttingToolLocationConfig);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfig
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig) throws  Exception{
        this.synthesisCuttingToolLocationConfigService.delSynthesisCuttingToolLocationConfigForLogic(synthesisCuttingToolLocationConfig);
    }

    /**
    * @Title: getSynthesisCuttingToolLocationConfigByVo
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolLocationConfigVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolLocationConfig getSynthesisCuttingToolLocationConfigByVo(@RequestBody SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO) throws  Exception{
        return this.synthesisCuttingToolLocationConfigService.getSynthesisCuttingToolLocationConfig(synthesisCuttingToolLocationConfigVO);
    }

    /**
    * @Title: getSynthesisCuttingToolLocationConfigByPage
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolLocationConfigVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisCuttingToolLocationConfigByPage(@RequestBody SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisCuttingToolLocationConfigService.getSynthesisCuttingToolLocationConfigByPage(synthesisCuttingToolLocationConfigVO));
        result.put("vo",synthesisCuttingToolLocationConfigVO);
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
        return "/synthesisCuttingToolLocationConfig/synthesisCuttingToolLocationConfigList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisCuttingToolLocationConfig/synthesisCuttingToolLocationConfigInsAndUpd";
    }

}
