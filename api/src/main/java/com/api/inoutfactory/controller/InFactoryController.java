package com.api.inoutfactory.controller;

import com.api.base.controller.BaseController;
import com.common.pojo.AuthCustomer;
import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.InsideFactory;
import com.common.vo.AuthCustomerVO;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.common.vo.InsideFactoryVO;
import com.service.common.IAuthCustomerService;
import com.service.inoutFactory.IInOutFactoryService;
import com.service.inoutFactory.InOutFactoryComent;
import com.service.inoutFactory.vo.HistoryVO;
import com.service.inoutFactory.vo.InsideVO;
import com.service.inoutFactory.vo.SharpenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by logan on 2018/5/6.
 */
@Controller
@RequestMapping("inFactoryBusiness")
public class InFactoryController extends BaseController {

    @Autowired
    private IInOutFactoryService inOutFactoryService;
    @Autowired
    private IAuthCustomerService authCustomerService;
    @Autowired
    private InOutFactoryComent inOutFactoryComent;

    @RequestMapping("getCuttingToolBind")
    @ResponseBody
    public CuttingToolBind getCuttingToolBind(@RequestBody CuttingToolBindVO cuttingToolBindVO) throws Exception{
        return inOutFactoryService.getCuttingToolBind(cuttingToolBindVO);
    }

    @RequestMapping("countInsideFactory")
    @ResponseBody
    public Integer countInsideFactory(@RequestBody InsideFactoryVO insideFactoryVO) throws Exception{
        return inOutFactoryService.countInsideFactory(insideFactoryVO);
    }

    @RequestMapping("addInsideFactory")
    @ResponseBody
    public void addInsideFactory(@RequestBody InsideVO insideVO, @RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomerCode);
        insideVO.setAuthCustomer(authCustomerService.getAuthCustomer(authCustomerVO));
        inOutFactoryComent.inSideFactory(insideVO);
//        inOutFactoryService.addInsideFactory(insideFactories);
    }

    @RequestMapping("addInsideFactoryHistory")
    @ResponseBody
    public void addInsideFactory(@RequestBody HistoryVO historyVO,@RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
//        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
//        authCustomerVO.setCode(authCustomerCode);
//        historyVO.setAuthCustomer(authCustomerService.getAuthCustomer(authCustomerVO));
//        inOutFactoryService.addInsideFactoryHistory(historyVO);
    }


    @RequestMapping("getCuttingTool")
    @ResponseBody
    public CuttingTool getCuttingTool(@RequestBody CuttingToolVO cuttingToolVO) throws Exception{
        return inOutFactoryService.getCuttingTool(cuttingToolVO);
    }

}
