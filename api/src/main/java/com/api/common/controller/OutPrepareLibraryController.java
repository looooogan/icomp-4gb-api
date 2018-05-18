package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.OutPrepareLibrary;
import com.common.vo.OutPrepareLibraryVO;
import com.service.common.ICuttingToolService;
import com.service.common.IOutPrepareLibraryService;
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
* @ClassName OutPrepareLibraryController
* @Description OutPrepareLibraryController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("outPrepareLibrary")
public class OutPrepareLibraryController extends BaseController{

    @Autowired
    private IOutPrepareLibraryService outPrepareLibraryService;

    @Autowired
    private ICuttingToolService cuttingToolService;

    /**
    * @Title: add
    * @Description: 添加OutPrepareLibrary
    * @param outPrepareLibrary
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody OutPrepareLibrary outPrepareLibrary) throws Exception{
        this.outPrepareLibraryService.addOutPrepareLibrary(outPrepareLibrary);
    }

    /**
    * @Title: update
    * @Description: 修改OutPrepareLibrary
    * @param outPrepareLibrary
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody OutPrepareLibrary outPrepareLibrary) throws  Exception{
        this.outPrepareLibraryService.updOutPrepareLibrary(outPrepareLibrary);
    }

    /**
    * @Title: del
    * @Description: 删除OutPrepareLibrary
    * @param outPrepareLibrary
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody OutPrepareLibrary outPrepareLibrary) throws  Exception{
        this.outPrepareLibraryService.delOutPrepareLibraryForLogic(outPrepareLibrary);
    }

    /**
    * @Title: getOutPrepareLibraryByVo
    * @Description: 根据查询条件查询
    * @param outPrepareLibraryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public OutPrepareLibrary getOutPrepareLibraryByVo(@RequestBody OutPrepareLibraryVO outPrepareLibraryVO) throws  Exception{
        return this.outPrepareLibraryService.getOutPrepareLibrary(outPrepareLibraryVO);
    }

    /**
    * @Title: getOutPrepareLibraryByPage
    * @Description: 根据查询条件查询
    * @param outPrepareLibraryVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getOutPrepareLibraryByPage(@RequestBody OutPrepareLibraryVO outPrepareLibraryVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.outPrepareLibraryService.getOutPrepareLibraryByPage(outPrepareLibraryVO));
        result.put("vo",outPrepareLibraryVO);
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
        return "/outPrepareLibrary/outPrepareLibraryList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/outPrepareLibrary/outPrepareLibraryInsAndUpd";
    }

}
