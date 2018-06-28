package com.api.inoutfactory.controller;

import com.api.base.controller.BaseController;
import com.api.inoutfactory.dto.InFactoryDTO;
import com.common.constants.OperationEnum;
import com.common.pojo.*;
import com.common.utils.OrderNumHandler;
import com.common.vo.*;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.common.IAuthCustomerService;
import com.service.common.IDjItrnAkpService;
import com.service.common.IDjOwnerAkpService;
import com.service.impower.IImpowerRecorderService;
import com.service.inoutFactory.IInOutFactoryService;
import com.service.inoutFactory.InOutFactoryComent;
import com.service.inoutFactory.bo.InOutGrindingBO;
import com.service.inoutFactory.vo.InOutQueryVO;
import com.service.inoutFactory.vo.InsideVO;
import com.service.inoutFactory.vo.OutSideVO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private IFlowCheckService flowCheckService;
    @Autowired
    private IImpowerRecorderService impowerRecorderService;
    @Autowired
    private IDjItrnAkpService djItrnAkpService;


    /**
     * 为厂外刃磨查询信息
     * @param
     * @throws Exception
     */
    @RequestMapping("queryForOutGrinding")
    @ResponseBody
    public InOutQueryVO queryForOutGrinding() throws Exception{
        InOutQueryVO inOutQueryVO = new InOutQueryVO();

        DjOwnerAkpVO djOwnerAkpVO = new DjOwnerAkpVO();
        inOutQueryVO.setDjOwnerAkps(djOwnerAkpService.getDjOwnerAkpByPage(djOwnerAkpVO));
        String wwcode = djItrnAkpService.getMaxWWOrderNum();
        if(StringUtils.isBlank(wwcode)){
            wwcode = OrderNumHandler.orderNumInit();
        }else {
            wwcode = OrderNumHandler.getNextOrderNum(wwcode);
        }
        inOutQueryVO.setWwcode(wwcode);
        return inOutQueryVO;
    }

    /**
     * 扫码获取材料刀信息
     * @param cuttingToolBindVO 材料刀具信息
     * @param response 添加授权
     * @param request 获取操作
     * @return
     * @throws Exception
     */
    @RequestMapping("getCuttingToolBind")
    @ResponseBody
    public CuttingToolBind getCuttingToolBind(@RequestBody CuttingToolBindVO cuttingToolBindVO, HttpServletResponse response, HttpServletRequest request) throws Exception{
        if (null !=request.getHeader("impower")){
            Integer impowerkey = Integer.parseInt(request.getHeader("impower"));
            ObjectMapper mapper = new ObjectMapper();
            FlowCheckVO flowCheckVO = new FlowCheckVO();
            flowCheckVO.setOperationCode(impowerkey);
            flowCheckVO.setRfidContainerVO(cuttingToolBindVO.getRfidContainerVO());
            response.addHeader("impower",mapper.writeValueAsString(flowCheckService.checkFlow(flowCheckVO)));
        }
        return inOutFactoryService.getCuttingToolBind(cuttingToolBindVO, OperationEnum.Cutting_tool_OutSide.getKey());
    }

    /**
     * 输入查询材料刀信息
     * @param cuttingToolVO 材料刀具信息
     * @return
     * @throws Exception
     */
    @RequestMapping("getCuttingTool")
    @ResponseBody
    public CuttingTool getCuttingTool(@RequestBody CuttingToolVO cuttingToolVO) throws Exception{
        return inOutFactoryService.getCuttingTool(cuttingToolVO, OperationEnum.Cutting_tool_OutSide);
    }

    /**
     * 根据合成刀T号查询材料刀信息
     * @param synthesisCuttingToolVO 合成刀信息
     * @return
     * @throws Exception
     */
    @RequestMapping("getCuttingToolByTCode")
    @ResponseBody
    public List<CuttingTool> getCuttingToolByTCode(@RequestBody SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception{
        return inOutFactoryService.getCuttingToolByTCode(synthesisCuttingToolVO, OperationEnum.Cutting_tool_OutSide);
    }


    /**
     * 厂外刃磨
     * @param inFactoryDTO 刃磨信息
     * @param authCustomerCode 登陆用户
     * @throws Exception
     */
    @RequestMapping("outsideGrinding")
    @ResponseBody
    public void outsideGrinding(@RequestBody InFactoryDTO inFactoryDTO, @RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        AuthCustomerVO loginUserVO = new AuthCustomerVO();
        loginUserVO.setCode(authCustomerCode);
        InOutGrindingBO inOutGrindingBO = new InOutGrindingBO();
        inOutGrindingBO.setGrindingEquipment(inFactoryDTO.getGrindingEquipment());
        inOutGrindingBO.setGrindingVOS(inFactoryDTO.getGrindingVOS());
        inOutGrindingBO.setLoginUser(authCustomerService.getAuthCustomer(loginUserVO));
        inOutGrindingBO.setOrderNum(inFactoryDTO.getOrderNum());
        inOutGrindingBO.setZcCode(inFactoryDTO.getZcCode());
        inOutGrindingBO.setQmSharpenProviderCode(inFactoryDTO.getSharpenProviderCode());
        inOutGrindingBO.setQmSharpenProviderName(inFactoryDTO.getQmSharpenProviderName());
        inOutGrindingBO.setOutWay(inFactoryDTO.getOutWay());
        inOutGrindingBO.setHandlers(inFactoryDTO.getHandlers());
        inOutGrindingBO.setSender(inFactoryDTO.getHandlers());
        inOutFactoryComent.outSideGrinding(inOutGrindingBO);
    }



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



    @RequestMapping("countOutsideFactory")
    @ResponseBody
    public Integer countOutsideFactory(@RequestBody OutsideFactoryVO outsideFactoryVO) throws Exception{
        return inOutFactoryService.countOutSideFactory(outsideFactoryVO);
    }

    @RequestMapping("addOutsideFactory")
    @ResponseBody
    public void addOutsideFactory(@RequestBody OutSideVO outSideVO, @RequestHeader("loginUserCode") String authCustomerCode, @RequestHeader("impower") String impowerRecorderJson) throws Exception{
        if (!StringUtils.isBlank(impowerRecorderJson)){
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, ImpowerRecorder.class);
            List<ImpowerRecorder> impowerRecorders = objectMapper.readValue(impowerRecorderJson,javaType);
            impowerRecorderService.addImpowerRecorders(impowerRecorders);
        }
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomerCode);
        outSideVO.setAuthCustomer(authCustomerService.getAuthCustomer(authCustomerVO));
//        inOutFactoryComent.OutSideFactory(outSideVO);
//        inOutFactoryService.addOutsideFactory(outSideVO);
    }

    @RequestMapping("addOutsideFactoryHistory")
    @ResponseBody
    public void addOutsideFactoryHistory(@RequestBody OutsideFactory outsideFactory) throws Exception{
        inOutFactoryService.addOutsideFactoryHistory(outsideFactory);
    }
}
