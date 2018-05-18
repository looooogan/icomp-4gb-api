package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.DjLineAkp;
import com.common.vo.DjLineAkpVO;
import com.service.common.IDjLineAkpService;
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
* @ClassName DjLineAkpController
* @Description DjLineAkpController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("djLineAkp")
public class DjLineAkpController extends BaseController{

    @Autowired
    private IDjLineAkpService djLineAkpService;


    /**
    * @Title: add
    * @Description: 添加DjLineAkp
    * @param djLineAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody DjLineAkp djLineAkp) throws Exception{
        this.djLineAkpService.addDjLineAkp(djLineAkp);
    }

    /**
    * @Title: update
    * @Description: 修改DjLineAkp
    * @param djLineAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody DjLineAkp djLineAkp) throws  Exception{
        this.djLineAkpService.updDjLineAkp(djLineAkp);
    }

    /**
    * @Title: del
    * @Description: 删除DjLineAkp
    * @param djLineAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody DjLineAkp djLineAkp) throws  Exception{
        this.djLineAkpService.delDjLineAkpForLogic(djLineAkp);
    }

    /**
    * @Title: getDjLineAkpByVo
    * @Description: 根据查询条件查询
    * @param djLineAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public DjLineAkp getDjLineAkpByVo(@RequestBody DjLineAkpVO djLineAkpVO) throws  Exception{
        return this.djLineAkpService.getDjLineAkp(djLineAkpVO);
    }

    /**
    * @Title: getDjLineAkpByPage
    * @Description: 根据查询条件查询
    * @param djLineAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDjLineAkpByPage(@RequestBody DjLineAkpVO djLineAkpVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.djLineAkpService.getDjLineAkpByPage(djLineAkpVO));
        result.put("vo",djLineAkpVO);
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
        return "/djLineAkp/djLineAkpList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/djLineAkp/djLineAkpInsAndUpd";
    }

}
