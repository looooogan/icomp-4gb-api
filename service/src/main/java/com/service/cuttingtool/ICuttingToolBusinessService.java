package com.service.cuttingtool;

import com.common.pojo.AuthCustomer;
import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.SynthesisCuttingTool;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.SynthesisCuttingToolVO;
import com.service.cuttingtool.bo.BindBladeBO;
import com.service.cuttingtool.bo.CuttingToolBindBO;
import com.service.orders.vo.WBCuttingToolBindVO;

import java.util.List;

/**
 * Created by logan on 2018/4/30.
 */
public interface ICuttingToolBusinessService {

    /**
     * 获取刀具订单列表
     * @return  订单列表
     * @throws Exception
     */
    public List getOrderNumList() throws Exception;


    /**
     * 根据材料号获取未绑定RFID的刀具
     * @param cuttingToolBindVO
     * @return
     * @throws Exception
     */
    public List<CuttingToolBind> getBindByCode(CuttingToolBindVO cuttingToolBindVO) throws Exception;


    /**
     * 刀具绑定
     * @param cuttingToolBind 刀具绑定信息
     * @param authCustomer 操作人
     * @throws Exception
     */
    public void addBind0609(CuttingToolBind cuttingToolBind, AuthCustomer authCustomer) throws Exception;

    /**
     * 查询刀具绑定信息
     * @param cuttingToolBindBO 查询条件封装
     * @return
     * @throws Exception
     */
    public CuttingToolBind queryBindInfo(CuttingToolBindBO cuttingToolBindBO) throws Exception;


    /**
     * 绑定材料刀  版本更新  注释掉 保证编译
     * @param cuttingToolBind
     * @throws Exception
     */
    public void addBindOld(CuttingToolBind cuttingToolBind) throws Exception;


    /**
     * 根据合成刀T号查询材刀信息
     * @param synthesisCuttingToolVO
     * @throws Exception
     */
    public List<CuttingTool> queryByTCode(SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception;

    /**
     * 流转刀具绑定
     * @param cuttingToolBindBO
     * @throws Exception
     */
    public void bindRunningData(CuttingToolBindBO cuttingToolBindBO) throws Exception;

    /**
     * 补充刀身码
     * @param bindBladeBO
     * @throws Exception
     */
    public void bindBladeData(BindBladeBO bindBladeBO) throws Exception;

}
