package com.api.cuttingtool.controller;

import com.api.base.controller.BaseController;
import com.api.cuttingtool.dto.BindBladeDTO;
import com.api.cuttingtool.dto.RunningDTO;
import com.common.pojo.*;
import com.common.vo.AuthCustomerVO;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.QimingRecordsVO;
import com.common.vo.SynthesisCuttingToolVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.common.IAuthCustomerService;
import com.service.common.IDjOutapplyAkpService;
import com.service.common.IQimingRecordsService;
import com.service.cuttingtool.CuttingToolComent;
import com.service.cuttingtool.ICuttingToolBusinessService;
import com.service.cuttingtool.bo.BindBladeBO;
import com.service.cuttingtool.bo.CuttingToolBindBO;
import com.service.orders.QiMingComent;
import com.service.orders.vo.WBCuttingToolBindVO;
import com.service.productline.bo.ProductLineBO;
import com.service.rfid.IFlowCheckService;
import com.service.rfid.vo.FlowCheckVO;
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
@RequestMapping("cuttingToolBusiness")
public class CuttingToolBusinessController extends BaseController{

    @Autowired
    private ICuttingToolBusinessService cuttingToolBusinessService;
    @Autowired
    private IQimingRecordsService qimingRecordsService;
    @Autowired
    private QiMingComent qiMingComent;
    @Autowired
    private CuttingToolComent cuttingToolComent;
    @Autowired
    private IAuthCustomerService authCustomerService;
    @Autowired
    private IFlowCheckService flowCheckService;

    @RequestMapping("getUnbind")
    @ResponseBody
    public List<CuttingToolBind> getUnbind(@RequestBody CuttingToolBindVO cuttingToolBindVO) throws Exception{
        return cuttingToolBusinessService.getBindByCode(cuttingToolBindVO);
    }

    @RequestMapping("bind")
    @ResponseBody
    public void bind(@RequestBody List<CuttingToolBind> cuttingToolBinds, @RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        WBCuttingToolBindVO wbCuttingToolBindVO = new WBCuttingToolBindVO();
        AuthCustomer authCustomer = new AuthCustomer();
        authCustomer.setCode(authCustomerCode);
        wbCuttingToolBindVO.setCuttingToolBinds(cuttingToolBinds);
        wbCuttingToolBindVO.setAuthCustomer(authCustomer);
        cuttingToolComent.bindCuttingTool(wbCuttingToolBindVO);
    }

    /**
     * 查询材料刀绑定信息接口
     * @param cuttingToolBindVO
     * @return
     * @throws Exception
     */
    @RequestMapping("queryBindInfo")
    @ResponseBody
    public CuttingToolBind queryBindInfo(@RequestBody CuttingToolBindVO cuttingToolBindVO, HttpServletResponse response, HttpServletRequest request) throws Exception{
        if (null !=request.getHeader("impower")){
            Integer impowerkey = Integer.parseInt(request.getHeader("impower"));
            ObjectMapper mapper = new ObjectMapper();
            FlowCheckVO flowCheckVO = new FlowCheckVO();
            flowCheckVO.setOperationCode(impowerkey);
            flowCheckVO.setRfidContainerVO(cuttingToolBindVO.getRfidContainerVO());
            response.addHeader("impower",mapper.writeValueAsString(flowCheckService.checkFlow(flowCheckVO)));
        }
        CuttingToolBindBO cuttingToolBindBO = new CuttingToolBindBO();
        cuttingToolBindBO.setBladeCode(cuttingToolBindVO.getBladeCode());
        cuttingToolBindBO.setRfidContainerVO(cuttingToolBindVO.getRfidContainerVO());
        return cuttingToolBusinessService.queryBindInfo(cuttingToolBindBO);
    }

    //以下接口确认无用后可抛弃

    @RequestMapping("bindold")
    @ResponseBody
    public void bindold(@RequestBody CuttingToolBind cuttingToolBind, @RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        WBCuttingToolBindVO wbCuttingToolBindVO = new WBCuttingToolBindVO();
        AuthCustomer authCustomer = new AuthCustomer();
        authCustomer.setCode(authCustomerCode);
        wbCuttingToolBindVO.setCuttingToolBind(cuttingToolBind);
        wbCuttingToolBindVO.setAuthCustomer(authCustomer);
        qiMingComent.bindCuttingTool(wbCuttingToolBindVO);
    }

    @RequestMapping("queryOutOrder")
    @ResponseBody
    public List<DjOutapplyAkp> queryOutOrder() throws Exception{
        return cuttingToolComent.getOutedOrders();
    }

    @RequestMapping("queryBladeCodes")
    @ResponseBody
    public List<QimingRecords> queryBladeCodes(@RequestBody  QimingRecordsVO qimingRecordsVO) throws Exception{
        return qimingRecordsService.getAllQimingRecord(qimingRecordsVO);
    }

    /**
     * 根据合成刀T号，查询材料刀
     * @param synthesisCuttingToolVO
     * @return
     * @throws Exception
     */
    @RequestMapping("queryByTCode")
    @ResponseBody
    public List<CuttingTool> queryByTCode(@RequestBody SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception{
        return cuttingToolBusinessService.queryByTCode(synthesisCuttingToolVO);
    }

    /**
     * 流转刀具绑定
     * @param runningDTO
     * @return
     * @throws Exception
     */
    @RequestMapping("bindForRunning")
    @ResponseBody
    public void bindForRunning(@RequestBody RunningDTO runningDTO,@RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        AuthCustomerVO loginUserVO = new AuthCustomerVO();
        loginUserVO.setCode(authCustomerCode);
        CuttingToolBindBO cuttingToolBindBO = new CuttingToolBindBO();
        cuttingToolBindBO.setLoginUser(authCustomerService.getAuthCustomer(loginUserVO));
        cuttingToolBindBO.setCuttingToolBind(runningDTO.getCuttingToolBind());
        cuttingToolBindBO.setStatus(runningDTO.getStatus());
        cuttingToolBindBO.setRfidContainerVO(runningDTO.getRfidContainerVO());
        cuttingToolBusinessService.bindRunningData(cuttingToolBindBO);
    }


    /**
     * 补充刀身码
     * @param bindBladeDTO
     * @return
     * @throws Exception
     */
    @RequestMapping("bindBlade")
    @ResponseBody
    public void bindBlade(@RequestBody BindBladeDTO bindBladeDTO) throws Exception{
        BindBladeBO bindBladeBO = new BindBladeBO();
        bindBladeBO.setCuttingToolBind(bindBladeDTO.getCuttingToolBind());
        bindBladeBO.setLocation(bindBladeDTO.getLocation());
        cuttingToolBusinessService.bindBladeData(bindBladeBO);
    }

}
