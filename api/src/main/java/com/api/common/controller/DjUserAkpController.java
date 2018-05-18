package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.DjUserAkp;
import com.common.vo.DjUserAkpVO;
import com.service.common.IDjUserAkpService;
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
* @ClassName DjUserAkpController
* @Description DjUserAkpController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("djUserAkp")
public class DjUserAkpController extends BaseController{

    @Autowired
    private IDjUserAkpService djUserAkpService;


    /**
    * @Title: add
    * @Description: 添加DjUserAkp
    * @param djUserAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody DjUserAkp djUserAkp) throws Exception{
        this.djUserAkpService.addDjUserAkp(djUserAkp);
    }

    /**
    * @Title: update
    * @Description: 修改DjUserAkp
    * @param djUserAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody DjUserAkp djUserAkp) throws  Exception{
        this.djUserAkpService.updDjUserAkp(djUserAkp);
    }

    /**
    * @Title: del
    * @Description: 删除DjUserAkp
    * @param djUserAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody DjUserAkp djUserAkp) throws  Exception{
        this.djUserAkpService.delDjUserAkpForLogic(djUserAkp);
    }

    /**
    * @Title: getDjUserAkpByVo
    * @Description: 根据查询条件查询
    * @param djUserAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public DjUserAkp getDjUserAkpByVo(@RequestBody DjUserAkpVO djUserAkpVO) throws  Exception{
        return this.djUserAkpService.getDjUserAkp(djUserAkpVO);
    }

    /**
    * @Title: getDjUserAkpByPage
    * @Description: 根据查询条件查询
    * @param djUserAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDjUserAkpByPage(@RequestBody DjUserAkpVO djUserAkpVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.djUserAkpService.getDjUserAkpByPage(djUserAkpVO));
        result.put("vo",djUserAkpVO);
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
        return "/djUserAkp/djUserAkpList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/djUserAkp/djUserAkpInsAndUpd";
    }

}
