package com.service.orders.vo;

import com.common.pojo.*;
import com.common.vo.AuthCustomerVO;


/**
 * Created by logan on 2018/5/7.
 */
public class OutApplyVO extends  WriteBaseVO{

    private String applyno;

    private String mtlCode;

    private DjOutapplyAkp djOutapplyAkp;

    private DjCircleKanbanAkp djCircleKanbanAkp;

    private DjMtlAkp djMtlAkp;

    private Integer batchNo;

    private Integer susr20;

    private Integer maxDJH;

    private Integer unitqty;
    //当前登陆
    private String kuguanOperatorCode;

    private AuthCustomerVO kzAuthCustomerVO;

    private AuthCustomerVO llAuthCustomerVO;

    private AuthCustomer loginUser;

    private AuthCustomer llAuthCustomer;

    private AuthCustomer kzAuthCustomer;

    private CuttingTool cuttingTool;

    public Integer getMaxDJH() {
        return maxDJH;
    }

    public void setMaxDJH(Integer maxDJH) {
        this.maxDJH = maxDJH;
    }

    public CuttingTool getCuttingTool() {
        return cuttingTool;
    }

    public void setCuttingTool(CuttingTool cuttingTool) {
        this.cuttingTool = cuttingTool;
    }

    public Integer getSusr20() {
        return susr20;
    }

    public void setSusr20(Integer susr20) {
        this.susr20 = susr20;
    }

    public Integer getUnitqty() {
        return unitqty;
    }

    public void setUnitqty(Integer unitqty) {
        this.unitqty = unitqty;
    }

    public String getMtlCode() {
        return mtlCode;
    }

    public void setMtlCode(String mtlCode) {
        this.mtlCode = mtlCode;
    }

    public String getApplyno() {
        return applyno;
    }

    public void setApplyno(String applyno) {
        this.applyno = applyno;
    }

    public AuthCustomer getLlAuthCustomer() {
        return llAuthCustomer;
    }

    public void setLlAuthCustomer(AuthCustomer llAuthCustomer) {
        this.llAuthCustomer = llAuthCustomer;
    }

    public AuthCustomer getKzAuthCustomer() {
        return kzAuthCustomer;
    }

    public void setKzAuthCustomer(AuthCustomer kzAuthCustomer) {
        this.kzAuthCustomer = kzAuthCustomer;
    }

    @Override
    public Integer getBatchNo() {
        return batchNo;
    }

    @Override
    public void setBatchNo(Integer batchNo) {
        this.batchNo = batchNo;
    }

    public AuthCustomerVO getKzAuthCustomerVO() {
        return kzAuthCustomerVO;
    }

    public void setKzAuthCustomerVO(AuthCustomerVO kzAuthCustomerVO) {
        this.kzAuthCustomerVO = kzAuthCustomerVO;
    }

    public AuthCustomerVO getLlAuthCustomerVO() {
        return llAuthCustomerVO;
    }

    public void setLlAuthCustomerVO(AuthCustomerVO llAuthCustomerVO) {
        this.llAuthCustomerVO = llAuthCustomerVO;
    }


    public AuthCustomer getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(AuthCustomer loginUser) {
        this.loginUser = loginUser;
    }

    public String getKuguanOperatorCode() {
        return kuguanOperatorCode;
    }

    public void setKuguanOperatorCode(String kuguanOperatorCode) {
        this.kuguanOperatorCode = kuguanOperatorCode;
    }

    public DjOutapplyAkp getDjOutapplyAkp() {
        return djOutapplyAkp;
    }

    public void setDjOutapplyAkp(DjOutapplyAkp djOutapplyAkp) {
        this.djOutapplyAkp = djOutapplyAkp;
    }

    public DjCircleKanbanAkp getDjCircleKanbanAkp() {
        return djCircleKanbanAkp;
    }

    public void setDjCircleKanbanAkp(DjCircleKanbanAkp djCircleKanbanAkp) {
        this.djCircleKanbanAkp = djCircleKanbanAkp;
    }

    public DjMtlAkp getDjMtlAkp() {
        return djMtlAkp;
    }

    public void setDjMtlAkp(DjMtlAkp djMtlAkp) {
        this.djMtlAkp = djMtlAkp;
    }
}
