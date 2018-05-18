package com.api.system.controller;

import com.api.base.controller.BaseController;
import com.service.system.ISystemBusinessService;
import com.service.system.vo.ChangeRFIDVO;
import com.service.system.vo.RFIDQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by logan on 2018/5/6.
 */
@Controller
@RequestMapping("SystemBusiness")
public class SystemBusinessController extends BaseController{

    @Autowired
    private ISystemBusinessService systemBusinessService;

    @RequestMapping("changeRFIDForToll")
    @ResponseBody
    public void changeRFIDForToll(@RequestBody ChangeRFIDVO changeRFIDVO) throws Exception{
        systemBusinessService.chagneRFIDForTool(changeRFIDVO);
    }


    @RequestMapping("clearRFID")
    @ResponseBody
    public void clearRFID(@RequestBody RFIDQueryVO rfidQueryVO) throws Exception{
        systemBusinessService.clearRFID(rfidQueryVO);
    }

    @RequestMapping("queryByRFID")
    @ResponseBody
    public RFIDQueryVO queryByRFID(@RequestBody RFIDQueryVO rfidQueryVO) throws Exception{
        return systemBusinessService.queryByRFID(rfidQueryVO);
    }

}
