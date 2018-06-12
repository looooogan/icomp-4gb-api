package com.service.synthesiscuttingtool;

import com.common.pojo.*;
import com.common.vo.ProductLineVO;
import com.common.vo.RfidContainerVO;
import com.service.orders.vo.WriteBackVO;
import com.service.synthesiscuttingtool.vo.*;

import java.util.List;

/**
 * Created by logan on 2018/4/29.
 */
public interface ISynthesisCuttingToolBusinessService {

    /**
     * 获取合成刀初始化参数
     * @param synthesisCuttingToolInitVO 查询条件 查询合成刀配置
     * @return 合成刀信息
     * @throws Exception
     */
    public SynthesisCuttingToolConfig getSynthesisCuttingToolForInit(SynthesisCuttingToolInitVO synthesisCuttingToolInitVO) throws Exception;


    /**
     * 获取合成刀绑定信息
     * @param synthesisCuttingToolInitVO 查询条件 查询合成刀配置
     * @return 合成刀信息
     * @throws Exception
     */
    public SynthesisCuttingToolBind getSynthesisCuttingBind(SynthesisCuttingToolInitVO synthesisCuttingToolInitVO) throws Exception;



    /**
     * 初始化合成刀
     * @param synthesisCuttingToolBinds 合成刀信息
     * @throws Exception
     */
    public WriteBackVO addInitSynthesisCuttingTool(List<SynthesisCuttingToolBind> synthesisCuttingToolBinds) throws Exception;


    /**
     * 刀具换装
     * @param exChangeVO 换装结果
     * @throws Exception
     */
    public void writeSynthesisCuttingToolExChange(ExChangeVO exChangeVO,AuthCustomer authCustomer) throws Exception;

    /**
     * 刀具拆分
     * @param breakUpVO 拆分内容
     * @throws Exception
     */
    public void writeSynthesisCuttingToolBreakUp(BreakUpVO breakUpVO,AuthCustomer authCustomer) throws Exception;

    /**
     * 刀具组装
     * @param packageUpVO 组装内容
     * @throws Exception
     */
    public void writeSynthesisCuttingToolPackageUp(PackageUpVO packageUpVO,AuthCustomer authCustomer) throws Exception;


    /**
     * 获取所有生产线上的设备
     * @param productLineVO
     * @return
     * @throws Exception
     */
    public List<ProductLineEquipment> getAllInUseEquipment(ProductLineVO productLineVO) throws Exception;

    /**
     * 合成刀绑定设备
     * @param bindEquipmentVO 绑定值
     * @throws Exception
     */
    public void bindData(BindEquipmentVO bindEquipmentVO,AuthCustomer authCustomer) throws Exception;

    /**
     * 合成刀卸下设备
     * @param unBindEquipmentVO
     * @return
     * @throws Exception
     */
    public SynthesisCuttingToolBindleRecords unBindData(UnBindEquipmentVO unBindEquipmentVO,AuthCustomer authCustomer) throws Exception;


    /**
     * 刀具拆分获取标签盒
     * @param rfidContainerVO
     * @return
     * @throws Exception
     */
    public RfidContainer queryRFIDForUnConfig(RfidContainerVO rfidContainerVO) throws Exception;

    public void insideFactory() throws Exception;

}
