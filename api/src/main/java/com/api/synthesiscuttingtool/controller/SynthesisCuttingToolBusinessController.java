package com.api.synthesiscuttingtool.controller;

import com.api.base.controller.BaseController;
import com.common.pojo.ImpowerRecorder;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.pojo.SynthesisCuttingToolConfig;
import com.common.vo.AuthCustomerVO;
import com.common.vo.RfidContainerVO;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.common.IAuthCustomerService;
import com.service.impower.IImpowerRecorderService;
import com.service.synthesiscuttingtool.synthesiscuttingtoolComent;
import com.service.orders.vo.WBUnInstallVO;
import com.service.rfid.IFlowCheckService;
import com.service.rfid.vo.FlowCheckVO;
import com.service.synthesiscuttingtool.ISynthesisCuttingToolBusinessService;
import com.service.synthesiscuttingtool.vo.*;
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
 * Created by logan on 2018/4/30.
 */
@Controller
@RequestMapping("synthesisCuttingToolBusiness")
public class SynthesisCuttingToolBusinessController extends BaseController{

    @Autowired
    private ISynthesisCuttingToolBusinessService synthesisCuttingToolBusinessService;

    @Autowired
    private synthesiscuttingtoolComent synthesiscuttingtoolComent;
    @Autowired
    private IAuthCustomerService authCustomerService;
    @Autowired
    private IFlowCheckService flowCheckService;
    @Autowired
    private IImpowerRecorderService impowerRecorderService;


    /**
     * 获取刀具配置
     * @param synthesisCuttingToolInitVO
     * @return
     * @throws Exception
     */
    @RequestMapping("getConfig")
    @ResponseBody
    public SynthesisCuttingToolConfig getSynthesisCuttingToolConfig(@RequestBody  SynthesisCuttingToolInitVO synthesisCuttingToolInitVO, HttpServletResponse response, HttpServletRequest request) throws Exception{
        if (null !=request.getHeader("impower")){
            Integer impowerkey = Integer.parseInt(request.getHeader("impower"));
            ObjectMapper mapper = new ObjectMapper();
            FlowCheckVO flowCheckVO = new FlowCheckVO();
            flowCheckVO.setOperationCode(impowerkey);
            flowCheckVO.setRfidLaserCode(synthesisCuttingToolInitVO.getRfidCode());
            response.addHeader("impower",mapper.writeValueAsString(flowCheckService.checkFlow(flowCheckVO)));
        }
        return synthesisCuttingToolBusinessService.getSynthesisCuttingToolForInit(synthesisCuttingToolInitVO);
    }

    /**
     * 获取刀具配置
     * @param synthesisCuttingToolInitVO
     * @return
     * @throws Exception
     */
    @RequestMapping("getBind")
    @ResponseBody
    public SynthesisCuttingToolBind getBind(@RequestBody  SynthesisCuttingToolInitVO synthesisCuttingToolInitVO, HttpServletResponse response, HttpServletRequest request) throws Exception{
        if (null !=request.getHeader("impower")){
            Integer impowerkey = Integer.parseInt(request.getHeader("impower"));
            ObjectMapper mapper = new ObjectMapper();
            FlowCheckVO flowCheckVO = new FlowCheckVO();
            flowCheckVO.setOperationCode(impowerkey);
            flowCheckVO.setRfidLaserCode(synthesisCuttingToolInitVO.getRfidCode());
            response.addHeader("impower",mapper.writeValueAsString(flowCheckService.checkFlow(flowCheckVO)));
        }
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBusinessService.getSynthesisCuttingBind(synthesisCuttingToolInitVO);

        return synthesisCuttingToolBind;
    }

    /**
     * 合成刀初始化
     * @param synthesisCuttingToolBinds
     * @throws Exception
     */
    @RequestMapping("init")
    @ResponseBody
    public void initSynthesisCuttingTool(@RequestBody  List<SynthesisCuttingToolBind> synthesisCuttingToolBinds) throws Exception{
        synthesiscuttingtoolComent.init(synthesisCuttingToolBinds);
//        synthesisCuttingToolBusinessService.addInitSynthesisCuttingTool(synthesisCuttingToolBinds);
    }

    /**
     * 刀具换装
     * @param exChangeVO
     * @throws Exception
     */
    @RequestMapping("exChange")
    @ResponseBody
    public void exChange(@RequestBody ExChangeVO exChangeVO, @RequestHeader("loginUserCode") String authCustomerCode, @RequestHeader("impower") String impowerRecorderJson) throws Exception{
        if (!StringUtils.isBlank(impowerRecorderJson)){
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, ImpowerRecorder.class);
            List<ImpowerRecorder> impowerRecorders = objectMapper.readValue(impowerRecorderJson,javaType);
            impowerRecorderService.addImpowerRecorders(impowerRecorders);
        }
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomerCode);
        synthesiscuttingtoolComent.exChange(exChangeVO,authCustomerService.getAuthCustomer(authCustomerVO));
//        synthesisCuttingToolBusinessService.SynthesisCuttingToolExChange(exChangeVO);
    }

    /**
     * 刀具拆分
     * @param breakUpVO
     * @throws Exception
     */
    @RequestMapping("breakUp")
    @ResponseBody
    public void breakUp(@RequestBody BreakUpVO breakUpVO, @RequestHeader("loginUserCode") String authCustomerCode, @RequestHeader("impower")String impowerRecorderJson) throws Exception{
        if (!StringUtils.isBlank(impowerRecorderJson)){
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, ImpowerRecorder.class);
            List<ImpowerRecorder> impowerRecorders = objectMapper.readValue(impowerRecorderJson,javaType);
            impowerRecorderService.addImpowerRecorders(impowerRecorders);
        }
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomerCode);

        synthesiscuttingtoolComent.BreakUp(breakUpVO,authCustomerService.getAuthCustomer(authCustomerVO));
//        synthesisCuttingToolBusinessService.SynthesisCuttingToolBreakUp(breakUpVO);
    }

    /**
     * 刀具安装
     * @param packageUpVO
     * @throws Exception
     */
    @RequestMapping("packageUp")
    @ResponseBody
    public void packageUp(@RequestBody PackageUpVO packageUpVO, @RequestHeader("loginUserCode") String authCustomerCode, @RequestHeader("impower")String impowerRecorderJson) throws Exception{
        if (!StringUtils.isBlank(impowerRecorderJson)){
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, ImpowerRecorder.class);
            List<ImpowerRecorder> impowerRecorders = objectMapper.readValue(impowerRecorderJson,javaType);
            impowerRecorderService.addImpowerRecorders(impowerRecorders);
        }
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomerCode);
        synthesiscuttingtoolComent.packageUp(packageUpVO,authCustomerService.getAuthCustomer(authCustomerVO));
//        synthesisCuttingToolBusinessService.SynthesisCuttingToolPackageUp(packageUpVO);
    }

    /**
     * 绑定设备
     * @param bindEquipmentVO
     * @throws Exception
     */
    @RequestMapping("bindEquipment")
    @ResponseBody
    public void bindEquipment(@RequestBody BindEquipmentVO bindEquipmentVO, @RequestHeader("loginUserCode") String authCustomerCode, @RequestHeader("impower")String impowerRecorderJson) throws Exception{
        if (!StringUtils.isBlank(impowerRecorderJson)){
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, ImpowerRecorder.class);
            List<ImpowerRecorder> impowerRecorders = objectMapper.readValue(impowerRecorderJson,javaType);
            impowerRecorderService.addImpowerRecorders(impowerRecorders);
        }
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomerCode);
        synthesiscuttingtoolComent.bindEquipment(bindEquipmentVO,authCustomerService.getAuthCustomer(authCustomerVO));
//        synthesisCuttingToolBusinessService.SynthesisCuttingToolBindEquipment(bindEquipmentVO);
    }

    /**
     * 卸下设备
     * @param unBindEquipmentVO
     * @throws Exception
     */
    @RequestMapping("unBindEquipment")
    @ResponseBody
    public void bindEquipment(@RequestBody UnBindEquipmentVO unBindEquipmentVO, @RequestHeader("loginUserCode") String authCustomerCode, @RequestHeader("impower")String impowerRecorderJson) throws Exception{
        if (!StringUtils.isBlank(impowerRecorderJson)){
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, ImpowerRecorder.class);
            List<ImpowerRecorder> impowerRecorders = objectMapper.readValue(impowerRecorderJson,javaType);
            impowerRecorderService.addImpowerRecorders(impowerRecorders);
        }
        WBUnInstallVO wbUnInstallVO = new WBUnInstallVO();
        wbUnInstallVO.setUnBindEquipmentVO(unBindEquipmentVO);
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomerCode);
        wbUnInstallVO.setAuthCustomer(authCustomerService.getAuthCustomer(authCustomerVO));
        synthesiscuttingtoolComent.unBindEquipment(wbUnInstallVO);
//        synthesisCuttingToolBusinessService.getProductLineByToolCode(unBindEquipmentVO);
    }


    /**
     * 扫描标签盒
     * @param rfidContainerVO
     * @throws Exception
     */
    @RequestMapping("queryRFIDForUnConfig")
    @ResponseBody
    public void queryRFIDForUnConfig(@RequestBody RfidContainerVO rfidContainerVO) throws Exception{
        synthesisCuttingToolBusinessService.queryRFIDForUnConfig(rfidContainerVO);
    }


}
