package com.api.inoutfactory.controller;

import com.api.base.controller.BaseController;
import com.api.inoutfactory.dto.InFactoryDTO;
import com.common.constants.OperationEnum;
import com.common.pojo.*;
import com.common.vo.*;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.common.IAuthCustomerService;
import com.service.impower.IImpowerRecorderService;
import com.service.inoutFactory.IInOutFactoryService;
import com.service.inoutFactory.InOutFactoryComent;
import com.service.inoutFactory.bo.InOutGrindingBO;
import com.service.inoutFactory.vo.HistoryVO;
import com.service.inoutFactory.vo.InsideVO;
import com.service.inoutFactory.vo.SharpenVO;
import com.service.productline.bo.ProductLineBO;
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

    /**
     * 扫码获取材料刀信息
     * @param cuttingToolBindVO 材料刀具信息
     * @param response 添加授权
     * @param request 获取操作
     * @return
     * @throws Exception
     */
    @RequestMapping("queryCuttingToolBind")
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
        return inOutFactoryService.getCuttingToolBind(cuttingToolBindVO, OperationEnum.Cutting_tool_Inside.getKey());
    }

    /**
     * 获取刃磨设备列表
     * @return
     * @throws Exception
     */
    @RequestMapping("queryGrindingEquipments")
    @ResponseBody
    public List<ProductLineEquipment> getCuttingToolBind() throws Exception{
        return inOutFactoryService.getGrindingEquipment();
    }

    /**
     * 扫描获取刃磨设备信息
     * @return
     * @throws Exception
     */
    @RequestMapping("queryGrindingEquipmentsByRFID")
    @ResponseBody
    public ProductLineEquipment getCuttingToolBind(@RequestBody ProductLineEquipmentVO equipmentVO) throws Exception{
        return inOutFactoryService.getGrindingEquipmentByRFID(equipmentVO);
    }

    /**
     * 场内刃磨
     * @param inFactoryDTO 刃磨信息
     * @param authCustomerCode 登陆用户
     * @throws Exception
     */
    @RequestMapping("insideGrinding")
    @ResponseBody
    public void insideGrinding(@RequestBody InFactoryDTO inFactoryDTO, @RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        AuthCustomerVO loginUserVO = new AuthCustomerVO();
        loginUserVO.setCode(authCustomerCode);
        InOutGrindingBO inOutGrindingBO = new InOutGrindingBO();
        inOutGrindingBO.setGrindingEquipment(inFactoryDTO.getGrindingEquipment());
        inOutGrindingBO.setGrindingVOS(inFactoryDTO.getGrindingVOS());
        inOutGrindingBO.setLoginUser(authCustomerService.getAuthCustomer(loginUserVO));
        inOutFactoryComent.inSideGrinding(inOutGrindingBO);
    }
}
