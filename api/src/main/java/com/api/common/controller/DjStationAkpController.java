package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.DjStationAkp;
import com.common.vo.DjStationAkpVO;
import com.service.common.IDjStationAkpService;
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
* @ClassName DjStationAkpController
* @Description DjStationAkpController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("djStationAkp")
public class DjStationAkpController extends BaseController{

    @Autowired
    private IDjStationAkpService djStationAkpService;


    /**
    * @Title: add
    * @Description: 添加DjStationAkp
    * @param djStationAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody DjStationAkp djStationAkp) throws Exception{
        this.djStationAkpService.addDjStationAkp(djStationAkp);
    }

    /**
    * @Title: update
    * @Description: 修改DjStationAkp
    * @param djStationAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody DjStationAkp djStationAkp) throws  Exception{
        this.djStationAkpService.updDjStationAkp(djStationAkp);
    }

    /**
    * @Title: del
    * @Description: 删除DjStationAkp
    * @param djStationAkp
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody DjStationAkp djStationAkp) throws  Exception{
        this.djStationAkpService.delDjStationAkpForLogic(djStationAkp);
    }

    /**
    * @Title: getDjStationAkpByVo
    * @Description: 根据查询条件查询
    * @param djStationAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public DjStationAkp getDjStationAkpByVo(@RequestBody DjStationAkpVO djStationAkpVO) throws  Exception{
        return this.djStationAkpService.getDjStationAkp(djStationAkpVO);
    }

    /**
    * @Title: getDjStationAkpByPage
    * @Description: 根据查询条件查询
    * @param djStationAkpVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDjStationAkpByPage(@RequestBody DjStationAkpVO djStationAkpVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.djStationAkpService.getDjStationAkpByPage(djStationAkpVO));
        result.put("vo",djStationAkpVO);
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
        return "/djStationAkp/djStationAkpList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/djStationAkp/djStationAkpInsAndUpd";
    }

}
