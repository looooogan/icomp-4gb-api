package com.api.inoutfactory.controller;

import com.api.base.controller.BaseController;
import com.common.constants.OperationEnum;
import com.common.pojo.*;
import com.common.vo.AuthCustomerVO;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.common.vo.InsideFactoryVO;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.common.IAuthCustomerService;
import com.service.impower.IImpowerRecorderService;
import com.service.inoutFactory.IInOutFactoryService;
import com.service.inoutFactory.InOutFactoryComent;
import com.service.inoutFactory.vo.HistoryVO;
import com.service.inoutFactory.vo.InsideVO;
import com.service.inoutFactory.vo.SharpenVO;
import com.service.rfid.IFlowCheckService;
import com.service.rfid.vo.FlowCheckVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Autowired
    private IFlowCheckService flowCheckService;
    @Autowired
    private IImpowerRecorderService impowerRecorderService;

    @RequestMapping("getCuttingToolBind")
    @ResponseBody
    public CuttingToolBind getCuttingToolBind(@RequestBody CuttingToolBindVO cuttingToolBindVO, HttpServletResponse response, HttpServletRequest request) throws Exception{
        if (null !=request.getHeader("impower")){
            Integer impowerkey = Integer.parseInt(request.getHeader("impower"));
            ObjectMapper mapper = new ObjectMapper();
            FlowCheckVO flowCheckVO = new FlowCheckVO();
            flowCheckVO.setOperationCode(impowerkey);
            flowCheckVO.setRfidLaserCode(cuttingToolBindVO.getRfidContainerVO().getLaserCode());
            response.addHeader("impower",mapper.writeValueAsString(flowCheckService.checkFlow(flowCheckVO)));
        }
        return inOutFactoryService.getCuttingToolBind(cuttingToolBindVO, OperationEnum.Cutting_tool_Inside.getKey());
    }

    @RequestMapping("countInsideFactory")
    @ResponseBody
    public Integer countInsideFactory(@RequestBody InsideFactoryVO insideFactoryVO) throws Exception{
        return inOutFactoryService.countInsideFactory(insideFactoryVO);
    }

    @RequestMapping("addInsideFactory")
    @ResponseBody
    public void addInsideFactory(@RequestBody InsideVO insideVO, @RequestHeader("loginUserCode") String authCustomerCode, @RequestHeader("impower") String impowerRecorderJson) throws Exception{
        if (!StringUtils.isBlank(impowerRecorderJson)){
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, ImpowerRecorder.class);
            List<ImpowerRecorder> impowerRecorders = objectMapper.readValue(impowerRecorderJson,javaType);
            impowerRecorderService.addImpowerRecorders(impowerRecorders);
        }
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
