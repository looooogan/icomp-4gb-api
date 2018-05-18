package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.DjCircleKanbanAkp;
import com.common.vo.DjCircleKanbanAkpVO;
import com.service.common.IDjCircleKanbanAkpService;
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
* @ClassName DjCircleKanbanAkpController
* @Description DjCircleKanbanAkpController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("djCircleKanbanAkp")
public class DjCircleKanbanAkpController extends BaseController{

    @Autowired
    private IDjCircleKanbanAkpService djCircleKanbanAkpService;


    /**
    * @Title: add
    * @Description: 添加DjCircleKanbanAkp
    * @param djCircleKanbanAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody DjCircleKanbanAkp djCircleKanbanAkp) throws Exception{
        this.djCircleKanbanAkpService.addDjCircleKanbanAkp(djCircleKanbanAkp);
    }

    /**
    * @Title: update
    * @Description: 修改DjCircleKanbanAkp
    * @param djCircleKanbanAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody DjCircleKanbanAkp djCircleKanbanAkp) throws  Exception{
        this.djCircleKanbanAkpService.updDjCircleKanbanAkp(djCircleKanbanAkp);
    }

    /**
    * @Title: del
    * @Description: 删除DjCircleKanbanAkp
    * @param djCircleKanbanAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody DjCircleKanbanAkp djCircleKanbanAkp) throws  Exception{
        this.djCircleKanbanAkpService.delDjCircleKanbanAkpForLogic(djCircleKanbanAkp);
    }

    /**
    * @Title: getDjCircleKanbanAkpByVo
    * @Description: 根据查询条件查询
    * @param djCircleKanbanAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public DjCircleKanbanAkp getDjCircleKanbanAkpByVo(@RequestBody DjCircleKanbanAkpVO djCircleKanbanAkpVO) throws  Exception{
        return this.djCircleKanbanAkpService.getDjCircleKanbanAkp(djCircleKanbanAkpVO);
    }

    /**
    * @Title: getDjCircleKanbanAkpByPage
    * @Description: 根据查询条件查询
    * @param djCircleKanbanAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDjCircleKanbanAkpByPage(@RequestBody DjCircleKanbanAkpVO djCircleKanbanAkpVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.djCircleKanbanAkpService.getDjCircleKanbanAkpByPage(djCircleKanbanAkpVO));
        result.put("vo",djCircleKanbanAkpVO);
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
        return "/djCircleKanbanAkp/djCircleKanbanAkpList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/djCircleKanbanAkp/djCircleKanbanAkpInsAndUpd";
    }

}
