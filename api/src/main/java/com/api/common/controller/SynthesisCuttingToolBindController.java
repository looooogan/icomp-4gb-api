package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.vo.SynthesisCuttingToolBindVO;
import com.service.common.IRfidContainerService;
import com.service.common.ISynthesisCuttingToolBindService;
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
* @ClassName SynthesisCuttingToolBindController
* @Description SynthesisCuttingToolBindController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("synthesisCuttingToolBind")
public class SynthesisCuttingToolBindController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolBindService synthesisCuttingToolBindService;

    @Autowired
    private ISynthesisCuttingToolService synthesisCuttingToolService;
    @Autowired
    private IRfidContainerService rfidContainerService;

    /**
    * @Title: add
    * @Description: 添加SynthesisCuttingToolBind
    * @param synthesisCuttingToolBind
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody SynthesisCuttingToolBind synthesisCuttingToolBind) throws Exception{
        this.synthesisCuttingToolBindService.addSynthesisCuttingToolBind(synthesisCuttingToolBind);
    }

    /**
    * @Title: update
    * @Description: 修改SynthesisCuttingToolBind
    * @param synthesisCuttingToolBind
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody SynthesisCuttingToolBind synthesisCuttingToolBind) throws  Exception{
        this.synthesisCuttingToolBindService.updSynthesisCuttingToolBind(synthesisCuttingToolBind);
    }

    /**
    * @Title: del
    * @Description: 删除SynthesisCuttingToolBind
    * @param synthesisCuttingToolBind
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody SynthesisCuttingToolBind synthesisCuttingToolBind) throws  Exception{
        this.synthesisCuttingToolBindService.delSynthesisCuttingToolBindForLogic(synthesisCuttingToolBind);
    }

    /**
    * @Title: getSynthesisCuttingToolBindByVo
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolBindVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public SynthesisCuttingToolBind getSynthesisCuttingToolBindByVo(@RequestBody SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) throws  Exception{
        return this.synthesisCuttingToolBindService.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
    }

    /**
    * @Title: getSynthesisCuttingToolBindByPage
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolBindVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSynthesisCuttingToolBindByPage(@RequestBody SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.synthesisCuttingToolBindService.getSynthesisCuttingToolBindByPage(synthesisCuttingToolBindVO));
        result.put("vo",synthesisCuttingToolBindVO);
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
        return "/synthesisCuttingToolBind/synthesisCuttingToolBindList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/synthesisCuttingToolBind/synthesisCuttingToolBindInsAndUpd";
    }

}
