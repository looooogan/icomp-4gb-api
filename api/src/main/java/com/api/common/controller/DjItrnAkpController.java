package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.DjItrnAkp;
import com.common.vo.DjItrnAkpVO;
import com.service.common.IDjItrnAkpService;
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
* @ClassName DjItrnAkpController
* @Description DjItrnAkpController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("djItrnAkp")
public class DjItrnAkpController extends BaseController{

    @Autowired
    private IDjItrnAkpService djItrnAkpService;


    /**
    * @Title: add
    * @Description: 添加DjItrnAkp
    * @param djItrnAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody DjItrnAkp djItrnAkp) throws Exception{
        this.djItrnAkpService.addDjItrnAkp(djItrnAkp);
    }

    /**
    * @Title: update
    * @Description: 修改DjItrnAkp
    * @param djItrnAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody DjItrnAkp djItrnAkp) throws  Exception{
        this.djItrnAkpService.updDjItrnAkp(djItrnAkp);
    }

    /**
    * @Title: del
    * @Description: 删除DjItrnAkp
    * @param djItrnAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody DjItrnAkp djItrnAkp) throws  Exception{
        this.djItrnAkpService.delDjItrnAkpForLogic(djItrnAkp);
    }

    /**
    * @Title: getDjItrnAkpByVo
    * @Description: 根据查询条件查询
    * @param djItrnAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public DjItrnAkp getDjItrnAkpByVo(@RequestBody DjItrnAkpVO djItrnAkpVO) throws  Exception{
        return this.djItrnAkpService.getDjItrnAkp(djItrnAkpVO);
    }

    /**
    * @Title: getDjItrnAkpByPage
    * @Description: 根据查询条件查询
    * @param djItrnAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDjItrnAkpByPage(@RequestBody DjItrnAkpVO djItrnAkpVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.djItrnAkpService.getDjItrnAkpByPage(djItrnAkpVO));
        result.put("vo",djItrnAkpVO);
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
        return "/djItrnAkp/djItrnAkpList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/djItrnAkp/djItrnAkpInsAndUpd";
    }

}
