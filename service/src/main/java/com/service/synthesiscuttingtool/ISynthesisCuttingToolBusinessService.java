package com.service.synthesiscuttingtool;

import com.common.pojo.*;
import com.common.vo.ProductLineVO;
import com.common.vo.RfidContainerVO;
import com.service.orders.vo.WriteBackVO;
import com.service.synthesiscuttingtool.bo.SynthesisExchangeBO;
import com.service.synthesiscuttingtool.bo.SynthesisInitBO;
import com.service.synthesiscuttingtool.vo.*;

import java.util.List;

/**
 * Created by logan on 2018/4/29.
 */
public interface ISynthesisCuttingToolBusinessService {

    /**
     * 获取合成刀初始化参数
     * @param synthesisInitBO 查询条件 查询合成刀配置
     * @return 合成刀信息
     * @throws Exception
     */
    public SynthesisCuttingToolConfig getSynthesisCuttingToolForInit(SynthesisInitBO synthesisInitBO) throws Exception;

    /**
     * 合成刀初始化业务接口
     * @param synthesisInitBO 初始化参数
     * @throws Exception
     */
    public void addInitSynthesisCuttingTool(SynthesisInitBO synthesisInitBO) throws Exception;


    /**
     * 获取合成刀绑定信息
     * @param synthesisExchangeBO 查询条件
     * @return 合成刀信息
     * @throws Exception
     */
    public SynthesisCuttingToolBind getSynthesisCuttingBind(SynthesisExchangeBO synthesisExchangeBO) throws Exception;


    /**
     * 合成刀换装
     * @param synthesisExchangeBO 换装信息
     * @throws Exception
     */
    public void exChangeData(SynthesisExchangeBO synthesisExchangeBO) throws Exception;

    /**
     * 刀具拆分
     * @param breakUpVO 拆分内容
     * @throws Exception
     */
//    public void writeSynthesisCuttingToolBreakUp(BreakUpVO breakUpVO,AuthCustomer authCustomer) throws Exception;

    /**
     * 刀具组装
     * @param packageUpVO 组装内容
     * @throws Exception
     */
//    public void writeSynthesisCuttingToolPackageUp(PackageUpVO packageUpVO,AuthCustomer authCustomer) throws Exception;

}
