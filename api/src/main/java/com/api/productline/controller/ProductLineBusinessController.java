package com.api.productline.controller;

import com.api.base.controller.BaseController;
import com.api.productline.dto.LineDTO;
import com.common.pojo.*;
import com.common.vo.AuthCustomerVO;
import com.common.vo.ProductLineEquipmentVO;
import com.common.vo.ProductLineVO;
import com.common.vo.SynthesisCuttingToolBindVO;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.common.IAuthCustomerService;
import com.service.impower.IImpowerRecorderService;
import com.service.productline.IProductLineBusinessService;
import com.service.productline.ProductLineCompent;
import com.service.productline.bo.ProductLineBO;
import com.service.productline.vo.QueryVO;
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
import java.util.Map;

/**
 * Created by logan on 2018/4/30.
 */
@Controller
@RequestMapping("productlineBusiness")
public class ProductLineBusinessController extends BaseController {

    @Autowired
    private IProductLineBusinessService productLineBusinessService;
    @Autowired
    private IFlowCheckService flowCheckService;
    @Autowired
    private IAuthCustomerService authCustomerService;
    @Autowired
    private IImpowerRecorderService impowerRecorderService;
    @Autowired
    private ProductLineCompent productLineCompent;

    /**
     * 查询所有流水线
     * @return
     * @throws Exception
     */
    @RequestMapping("getAssemblylines")
    @ResponseBody
    public List<ProductLineAssemblyline> getAllAssemblyline() throws Exception{
        return productLineBusinessService.getAllAssemblyline();
    }

    /**
     * 根据流水线查询设备信息
     * @param productLineVO 查询条件
     * @return 生产关联关系中的设备信息
     * @throws Exception
     */
    @RequestMapping("getEquipmentByAssemblyline")
    @ResponseBody
    public List<ProductLineEquipment> getEquipmentByAssemblyline(@RequestBody  ProductLineVO productLineVO) throws Exception{
        return  productLineBusinessService.getEquipmentByAssemblyline(productLineVO);
    }

    /**
     * 设备初始化
     * @param productLineEquipmentVO 设备信息
     * @param authCustomerCode 当前登陆用户
     * @throws Exception
     */
    @RequestMapping("initEquipment")
    @ResponseBody
    public void initEquipment(@RequestBody ProductLineEquipmentVO productLineEquipmentVO, @RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        AuthCustomerVO loginUserVO = new AuthCustomerVO();
        loginUserVO.setCode(authCustomerCode);
        ProductLineBO productLineBO = new ProductLineBO();
        productLineBO.setLoginUser(authCustomerService.getAuthCustomer(loginUserVO));
        productLineBO.setProductLineEquipmentVO(productLineEquipmentVO);
        productLineBusinessService.addInitEquipment(productLineBO);
    }


    /**
     * 为安上设备查询设备列表
     * @param synthesisCuttingToolBindVO
     * @return
     * @throws Exception
     */
    @RequestMapping("queryForInstall")
    @ResponseBody
    public QueryVO queryEquipmentForInstall(@RequestBody SynthesisCuttingToolBindVO synthesisCuttingToolBindVO, HttpServletResponse response, HttpServletRequest request) throws Exception{
        if (null !=request.getHeader("impower")){
            Integer impowerkey = Integer.parseInt(request.getHeader("impower"));
            ObjectMapper mapper = new ObjectMapper();
            FlowCheckVO flowCheckVO = new FlowCheckVO();
            flowCheckVO.setOperationCode(impowerkey);
            flowCheckVO.setRfidContainerVO(synthesisCuttingToolBindVO.getRfidContainerVO());
            response.addHeader("impower",mapper.writeValueAsString(flowCheckService.checkFlow(flowCheckVO)));
        }
        ProductLineBO productLineBO = new ProductLineBO();
        productLineBO.setSynthesisCuttingToolBindVO(synthesisCuttingToolBindVO);
        return productLineBusinessService.queryForInstall(productLineBO);
    }


    /**
     * 安上设备
     * @param lineDTO 生产线信息
     * @param authCustomerCode 登陆用户
     * @param impowerRecorderJson 授权信息
     * @return
     * @throws Exception
     */
    @RequestMapping("install")
    @ResponseBody
    public void queryEquipmentForInstall(@RequestBody LineDTO lineDTO, @RequestHeader("loginUserCode") String authCustomerCode, @RequestHeader("impower")String impowerRecorderJson) throws Exception{
        if (!StringUtils.isBlank(impowerRecorderJson)){
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, ImpowerRecorder.class);
            List<ImpowerRecorder> impowerRecorders = objectMapper.readValue(impowerRecorderJson,javaType);
            impowerRecorderService.addImpowerRecorders(impowerRecorders);
        }
        AuthCustomerVO loginUserVO = new AuthCustomerVO();
        loginUserVO.setCode(authCustomerCode);
        ProductLineBO productLineBO = new ProductLineBO();
        productLineBO.setLoginUser(authCustomerService.getAuthCustomer(loginUserVO));
        productLineBO.setSynthesisCuttingToolBindVO(lineDTO.getSynthesisCuttingToolBindVO());
        productLineBO.setProductLineEquipmentVO(lineDTO.getEquipmentVO());
        productLineCompent.install(productLineBO);
    }

    /**
     * 为卸下设备查询设备列表
     * @param synthesisCuttingToolBindVO
     * @return
     * @throws Exception
     */
    @RequestMapping("queryForUnInstall")
    @ResponseBody
    public QueryVO queryForUnInstall(@RequestBody SynthesisCuttingToolBindVO synthesisCuttingToolBindVO, HttpServletResponse response, HttpServletRequest request) throws Exception{
        if (null !=request.getHeader("impower")){
            Integer impowerkey = Integer.parseInt(request.getHeader("impower"));
            ObjectMapper mapper = new ObjectMapper();
            FlowCheckVO flowCheckVO = new FlowCheckVO();
            flowCheckVO.setOperationCode(impowerkey);
            flowCheckVO.setRfidContainerVO(synthesisCuttingToolBindVO.getRfidContainerVO());
            response.addHeader("impower",mapper.writeValueAsString(flowCheckService.checkFlow(flowCheckVO)));
        }
        ProductLineBO productLineBO = new ProductLineBO();
        productLineBO.setSynthesisCuttingToolBindVO(synthesisCuttingToolBindVO);
        return productLineBusinessService.queryForUnInstall(productLineBO);
    }

    /**
     * 卸下设备
     * @param lineDTO 卸下设备值
     * @param authCustomerCode 登陆用户
     * @param impowerRecorderJson 授权记录
     * @return
     * @throws Exception
     */
    @RequestMapping("unInstall")
    @ResponseBody
    public void queryForUnInstall(@RequestBody LineDTO lineDTO, @RequestHeader("loginUserCode") String authCustomerCode, @RequestHeader("impower")String impowerRecorderJson) throws Exception{
        if (!StringUtils.isBlank(impowerRecorderJson)){
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, ImpowerRecorder.class);
            List<ImpowerRecorder> impowerRecorders = objectMapper.readValue(impowerRecorderJson,javaType);
            impowerRecorderService.addImpowerRecorders(impowerRecorders);
        }

        ProductLineBO productLineBO = new ProductLineBO();
        productLineBO.setSynthesisCuttingToolBindVO(lineDTO.getSynthesisCuttingToolBindVO());
        productLineBO.setPartsVO(lineDTO.getPartsVO());
        productLineBO.setUnBindReason(lineDTO.getUnBindReason());
        productLineBO.setProcessingCount(lineDTO.getProcessingCount());
        productLineBO.setProductLineEquipmentVO(lineDTO.getEquipmentVO());
        AuthCustomerVO loginUserVO = new AuthCustomerVO();
        loginUserVO.setCode(authCustomerCode);
        productLineBO.setLoginUser(authCustomerService.getAuthCustomer(loginUserVO));
        productLineCompent.UnInstall(productLineBO);
    }
}
