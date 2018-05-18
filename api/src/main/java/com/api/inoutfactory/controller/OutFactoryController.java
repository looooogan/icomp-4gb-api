package com.api.inoutfactory.controller;

import com.api.base.controller.BaseController;
import com.common.pojo.*;
import com.common.vo.*;
import com.service.common.IAuthCustomerService;
import com.service.common.IDjOwnerAkpService;
import com.service.inoutFactory.IInOutFactoryService;
import com.service.inoutFactory.InOutFactoryComent;
import com.service.inoutFactory.vo.InsideVO;
import com.service.inoutFactory.vo.OutSideVO;
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
@RequestMapping("outFactoryBusiness")
public class OutFactoryController extends BaseController {

    @Autowired
    private IInOutFactoryService inOutFactoryService;
    @Autowired
    private IAuthCustomerService authCustomerService;
    @Autowired
    private InOutFactoryComent inOutFactoryComent;
    @Autowired
    private IDjOwnerAkpService djOwnerAkpService;

    @RequestMapping("addSharpenProvider")
    @ResponseBody
    public void addSharpenProvider(@RequestBody SharpenProvider sharpenProvider) throws Exception{
        inOutFactoryService.addSharpenProvider(sharpenProvider);
    }

    @RequestMapping("getSharpenProvider")
    @ResponseBody
    public List<DjOwnerAkp> getSharpenProvider() throws Exception{
        DjOwnerAkpVO djOwnerAkpVO = new DjOwnerAkpVO();
        return djOwnerAkpService.getDjOwnerAkpByPage(djOwnerAkpVO);
//        return inOutFactoryService.getSharpenProvider();
    }


    @RequestMapping("getCuttingToolBind")
    @ResponseBody
    public CuttingToolBind getCuttingToolBind(@RequestBody CuttingToolBindVO cuttingToolBindVO) throws Exception{
        return inOutFactoryService.getCuttingToolBind(cuttingToolBindVO);
    }

    @RequestMapping("countOutsideFactory")
    @ResponseBody
    public Integer countOutsideFactory(@RequestBody OutsideFactoryVO outsideFactoryVO) throws Exception{
        return inOutFactoryService.countOutSideFactory(outsideFactoryVO);
    }

    @RequestMapping("addOutsideFactory")
    @ResponseBody
    public void addOutsideFactory(@RequestBody OutSideVO outSideVO, @RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomerCode);
        outSideVO.setAuthCustomer(authCustomerService.getAuthCustomer(authCustomerVO));
        inOutFactoryComent.OutSideFactory(outSideVO);
//        inOutFactoryService.addOutsideFactory(outSideVO);
    }

    @RequestMapping("addOutsideFactoryHistory")
    @ResponseBody
    public void addOutsideFactoryHistory(@RequestBody OutsideFactory outsideFactory) throws Exception{
        inOutFactoryService.addOutsideFactoryHistory(outsideFactory);
    }

    @RequestMapping("getCuttingTool")
    @ResponseBody
    public CuttingTool getCuttingTool(@RequestBody CuttingToolVO cuttingToolVO) throws Exception{
        return inOutFactoryService.getCuttingTool(cuttingToolVO);
    }
}
