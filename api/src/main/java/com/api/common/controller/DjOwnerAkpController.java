package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.DjOwnerAkp;
import com.common.vo.DjOwnerAkpVO;
import com.service.common.IDjOwnerAkpService;
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
* @ClassName DjOwnerAkpController
* @Description DjOwnerAkpController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("djOwnerAkp")
public class DjOwnerAkpController extends BaseController{

    @Autowired
    private IDjOwnerAkpService djOwnerAkpService;


    /**
    * @Title: add
    * @Description: 添加DjOwnerAkp
    * @param djOwnerAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody DjOwnerAkp djOwnerAkp) throws Exception{
        this.djOwnerAkpService.addDjOwnerAkp(djOwnerAkp);
    }

    /**
    * @Title: update
    * @Description: 修改DjOwnerAkp
    * @param djOwnerAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody DjOwnerAkp djOwnerAkp) throws  Exception{
        this.djOwnerAkpService.updDjOwnerAkp(djOwnerAkp);
    }

    /**
    * @Title: del
    * @Description: 删除DjOwnerAkp
    * @param djOwnerAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody DjOwnerAkp djOwnerAkp) throws  Exception{
        this.djOwnerAkpService.delDjOwnerAkpForLogic(djOwnerAkp);
    }

    /**
    * @Title: getDjOwnerAkpByVo
    * @Description: 根据查询条件查询
    * @param djOwnerAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public DjOwnerAkp getDjOwnerAkpByVo(@RequestBody DjOwnerAkpVO djOwnerAkpVO) throws  Exception{
        return this.djOwnerAkpService.getDjOwnerAkp(djOwnerAkpVO);
    }

    /**
    * @Title: getDjOwnerAkpByPage
    * @Description: 根据查询条件查询
    * @param djOwnerAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDjOwnerAkpByPage(@RequestBody DjOwnerAkpVO djOwnerAkpVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.djOwnerAkpService.getDjOwnerAkpByPage(djOwnerAkpVO));
        result.put("vo",djOwnerAkpVO);
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
        return "/djOwnerAkp/djOwnerAkpList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/djOwnerAkp/djOwnerAkpInsAndUpd";
    }

}
