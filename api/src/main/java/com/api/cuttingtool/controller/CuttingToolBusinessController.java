package com.api.cuttingtool.controller;

import com.api.base.controller.BaseController;
import com.common.pojo.AuthCustomer;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.DjOutapplyAkp;
import com.common.pojo.QimingRecords;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.DjOutapplyAkpVO;
import com.common.vo.QimingRecordsVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.common.IDjOutapplyAkpService;
import com.service.common.IQimingRecordsService;
import com.service.cuttingtool.CuttingToolComent;
import com.service.cuttingtool.ICuttingToolBusinessService;
import com.service.orders.QiMingComent;
import com.service.orders.vo.WBCuttingToolBindVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private IDjOutapplyAkpService djOutapplyAkpService;

    @Autowired
    private IQimingRecordsService qimingRecordsService;

    @Autowired
    private QiMingComent qiMingComent;
    @Autowired
    private CuttingToolComent cuttingToolComent;

    @RequestMapping("getUnbind")
    @ResponseBody
    public List<CuttingToolBind> getUnbind(@RequestBody CuttingToolBindVO cuttingToolBindVO) throws Exception{
        return cuttingToolBusinessService.getBindByCode(cuttingToolBindVO);
    }

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




}
