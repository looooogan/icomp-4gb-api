package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.DjOutapplyAkp;
import com.common.vo.DjOutapplyAkpVO;
import com.service.common.IDjOutapplyAkpService;
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
* @ClassName DjOutapplyAkpController
* @Description DjOutapplyAkpController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("djOutapplyAkp")
public class DjOutapplyAkpController extends BaseController{

    @Autowired
    private IDjOutapplyAkpService djOutapplyAkpService;


    /**
    * @Title: add
    * @Description: 添加DjOutapplyAkp
    * @param djOutapplyAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody DjOutapplyAkp djOutapplyAkp) throws Exception{
        this.djOutapplyAkpService.addDjOutapplyAkp(djOutapplyAkp);
    }

    /**
    * @Title: update
    * @Description: 修改DjOutapplyAkp
    * @param djOutapplyAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody DjOutapplyAkp djOutapplyAkp) throws  Exception{
        this.djOutapplyAkpService.updDjOutapplyAkp(djOutapplyAkp);
    }

    /**
    * @Title: del
    * @Description: 删除DjOutapplyAkp
    * @param djOutapplyAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody DjOutapplyAkp djOutapplyAkp) throws  Exception{
        this.djOutapplyAkpService.delDjOutapplyAkpForLogic(djOutapplyAkp);
    }

    /**
    * @Title: getDjOutapplyAkpByVo
    * @Description: 根据查询条件查询
    * @param djOutapplyAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public DjOutapplyAkp getDjOutapplyAkpByVo(@RequestBody DjOutapplyAkpVO djOutapplyAkpVO) throws  Exception{
        return this.djOutapplyAkpService.getDjOutapplyAkp(djOutapplyAkpVO);
    }

    /**
    * @Title: getDjOutapplyAkpByPage
    * @Description: 根据查询条件查询
    * @param djOutapplyAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDjOutapplyAkpByPage(@RequestBody DjOutapplyAkpVO djOutapplyAkpVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.djOutapplyAkpService.getDjOutapplyAkpByPage(djOutapplyAkpVO));
        result.put("vo",djOutapplyAkpVO);
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
        return "/djOutapplyAkp/djOutapplyAkpList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/djOutapplyAkp/djOutapplyAkpInsAndUpd";
    }

}
