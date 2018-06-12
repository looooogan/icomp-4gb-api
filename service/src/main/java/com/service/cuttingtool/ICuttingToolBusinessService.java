package com.service.cuttingtool;

import com.common.pojo.AuthCustomer;
import com.common.pojo.CuttingToolBind;
import com.common.vo.CuttingToolBindVO;
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
     * 绑定材料刀  版本更新  注释掉 保证编译
     * @param cuttingToolBind
     * @throws Exception
     */
    public void addBindOld(CuttingToolBind cuttingToolBind) throws Exception;


    /**
     * 绑定材料刀
     * @param cuttingToolBind
     * @param authCustomer
     * @throws Exception
     */
    public void addBind0609(CuttingToolBind cuttingToolBind, AuthCustomer authCustomer) throws Exception;

}
