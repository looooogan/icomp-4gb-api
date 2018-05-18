package com.api.common.controller;


import com.api.base.controller.BaseController;
import com.common.pojo.RfidContainer;
import com.common.vo.RfidContainerVO;
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
* @ClassName RfidContainerController
* @Description RfidContainerController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("rfidContainer")
public class RfidContainerController extends BaseController{

    @Autowired
    private IRfidContainerService rfidContainerService;


    /**
    * @Title: add
    * @Description: 添加RfidContainer
    * @param rfidContainer
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody RfidContainer rfidContainer) throws Exception{
        this.rfidContainerService.addRfidContainer(rfidContainer);
    }

    /**
    * @Title: update
    * @Description: 修改RfidContainer
    * @param rfidContainer
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody RfidContainer rfidContainer) throws  Exception{
        this.rfidContainerService.updRfidContainer(rfidContainer);
    }

    /**
    * @Title: del
    * @Description: 删除RfidContainer
    * @param rfidContainer
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody RfidContainer rfidContainer) throws  Exception{
        this.rfidContainerService.delRfidContainerForLogic(rfidContainer);
    }

    /**
    * @Title: getRfidContainerByVo
    * @Description: 根据查询条件查询
    * @param rfidContainerVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public RfidContainer getRfidContainerByVo(@RequestBody RfidContainerVO rfidContainerVO) throws  Exception{
        return this.rfidContainerService.getRfidContainer(rfidContainerVO);
    }

    /**
    * @Title: getRfidContainerByPage
    * @Description: 根据查询条件查询
    * @param rfidContainerVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getRfidContainerByPage(@RequestBody RfidContainerVO rfidContainerVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.rfidContainerService.getRfidContainerByPage(rfidContainerVO));
        result.put("vo",rfidContainerVO);
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
        return "/rfidContainer/rfidContainerList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/rfidContainer/rfidContainerInsAndUpd";
    }

}
