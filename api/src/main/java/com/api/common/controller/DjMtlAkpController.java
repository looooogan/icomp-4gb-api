package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.DjMtlAkp;
import com.common.vo.DjMtlAkpVO;
import com.service.common.IDjMtlAkpService;
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
* @ClassName DjMtlAkpController
* @Description DjMtlAkpController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("djMtlAkp")
public class DjMtlAkpController extends BaseController{

    @Autowired
    private IDjMtlAkpService djMtlAkpService;


    /**
    * @Title: add
    * @Description: 添加DjMtlAkp
    * @param djMtlAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody DjMtlAkp djMtlAkp) throws Exception{
        this.djMtlAkpService.addDjMtlAkp(djMtlAkp);
    }

    /**
    * @Title: update
    * @Description: 修改DjMtlAkp
    * @param djMtlAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody DjMtlAkp djMtlAkp) throws  Exception{
        this.djMtlAkpService.updDjMtlAkp(djMtlAkp);
    }

    /**
    * @Title: del
    * @Description: 删除DjMtlAkp
    * @param djMtlAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody DjMtlAkp djMtlAkp) throws  Exception{
        this.djMtlAkpService.delDjMtlAkpForLogic(djMtlAkp);
    }

    /**
    * @Title: getDjMtlAkpByVo
    * @Description: 根据查询条件查询
    * @param djMtlAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public DjMtlAkp getDjMtlAkpByVo(@RequestBody DjMtlAkpVO djMtlAkpVO) throws  Exception{
        return this.djMtlAkpService.getDjMtlAkp(djMtlAkpVO);
    }

    /**
    * @Title: getDjMtlAkpByPage
    * @Description: 根据查询条件查询
    * @param djMtlAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDjMtlAkpByPage(@RequestBody DjMtlAkpVO djMtlAkpVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.djMtlAkpService.getDjMtlAkpByPage(djMtlAkpVO));
        result.put("vo",djMtlAkpVO);
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
        return "/djMtlAkp/djMtlAkpList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/djMtlAkp/djMtlAkpInsAndUpd";
    }

}
