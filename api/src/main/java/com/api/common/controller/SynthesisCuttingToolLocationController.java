package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SynthesisCuttingToolLocation;
import com.common.vo.SynthesisCuttingToolLocationVO;
import com.service.common.ICuttingToolService;
import com.service.common.ISynthesisCuttingToolLocationService;
import com.service.common.ISynthesisCuttingToolService;
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
* @ClassName SynthesisCuttingToolLocationController
* @Description SynthesisCuttingToolLocationController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisCuttingToolLocation")
public class SynthesisCuttingToolLocationController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolLocationService synthesisCuttingToolLocationService;

    @Autowired
    private ISynthesisCuttingToolService synthesisCuttingToolService;
    @Autowired
    private ICuttingToolService cuttingToolService;

    /**
    * @Title: add
    * @Description: 添加SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocation
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisCuttingToolLocation synthesisCuttingToolLocation) throws Exception{
        this.synthesisCuttingToolLocationService.addSynthesisCuttingToolLocation(synthesisCuttingToolLocation);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocation
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisCuttingToolLocation synthesisCuttingToolLocation) throws  Exception{
        this.synthesisCuttingToolLocationService.updSynthesisCuttingToolLocation(synthesisCuttingToolLocation);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocation
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisCuttingToolLocation synthesisCuttingToolLocation) throws  Exception{
        this.synthesisCuttingToolLocationService.delSynthesisCuttingToolLocationForLogic(synthesisCuttingToolLocation);
    }

    /**
    * @Title: getSynthesisCuttingToolLocationByVo
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolLocationVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolLocation getSynthesisCuttingToolLocationByVo(@RequestBody SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO) throws  Exception{
        return this.synthesisCuttingToolLocationService.getSynthesisCuttingToolLocation(synthesisCuttingToolLocationVO);
    }

    /**
    * @Title: getSynthesisCuttingToolLocationByPage
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolLocationVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisCuttingToolLocationByPage(@RequestBody SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisCuttingToolLocationService.getSynthesisCuttingToolLocationByPage(synthesisCuttingToolLocationVO));
        result.put("vo",synthesisCuttingToolLocationVO);
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
        return "/synthesisCuttingToolLocation/synthesisCuttingToolLocationList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisCuttingToolLocation/synthesisCuttingToolLocationInsAndUpd";
    }

}
