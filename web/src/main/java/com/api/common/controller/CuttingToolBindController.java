package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.CuttingToolBind;
import com.common.vo.CuttingToolBindVO;
import com.service.common.ICuttingToolBindService;
import com.service.common.ICuttingToolService;
import com.service.common.IRfidContainerService;
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
* @ClassName CuttingToolBindController
* @Description CuttingToolBindController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("cuttingToolBind")
public class CuttingToolBindController extends BaseController{

    @Autowired
    private ICuttingToolBindService cuttingToolBindService;

    @Autowired
    private ICuttingToolService cuttingToolService;
    @Autowired
    private IRfidContainerService rfidContainerService;

    /**
    * @Title: add
    * @Description: 添加CuttingToolBind
    * @param cuttingToolBind
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody CuttingToolBind cuttingToolBind) throws Exception{
        this.cuttingToolBindService.addCuttingToolBind(cuttingToolBind);
    }

    /**
    * @Title: update
    * @Description: 修改CuttingToolBind
    * @param cuttingToolBind
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody CuttingToolBind cuttingToolBind) throws  Exception{
        this.cuttingToolBindService.updCuttingToolBind(cuttingToolBind);
    }

    /**
    * @Title: del
    * @Description: 删除CuttingToolBind
    * @param cuttingToolBind
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody CuttingToolBind cuttingToolBind) throws  Exception{
        this.cuttingToolBindService.delCuttingToolBindForLogic(cuttingToolBind);
    }

    /**
    * @Title: getCuttingToolBindByVo
    * @Description: 根据查询条件查询
    * @param cuttingToolBindVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public CuttingToolBind getCuttingToolBindByVo(@RequestBody CuttingToolBindVO cuttingToolBindVO) throws  Exception{
        return this.cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
    }

    /**
    * @Title: getCuttingToolBindByPage
    * @Description: 根据查询条件查询
    * @param cuttingToolBindVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getCuttingToolBindByPage(@RequestBody CuttingToolBindVO cuttingToolBindVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.cuttingToolBindService.getCuttingToolBindByPage(cuttingToolBindVO));
        result.put("vo",cuttingToolBindVO);
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
        return "/cuttingToolBind/cuttingToolBindList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/cuttingToolBind/cuttingToolBindInsAndUpd";
    }

}
