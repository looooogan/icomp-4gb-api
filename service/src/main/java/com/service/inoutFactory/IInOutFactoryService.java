package com.service.inoutFactory;

import com.common.constants.OperationEnum;
import com.common.pojo.*;
import com.common.vo.*;
import com.service.inoutFactory.bo.InOutGrindingBO;
import com.service.inoutFactory.vo.HistoryVO;
import com.service.inoutFactory.vo.InsideVO;
import com.service.inoutFactory.vo.OutSideVO;

import java.util.List;
import java.util.Map;

/**
 * Created by logan on 2018/5/6.
 */
public interface IInOutFactoryService {

    /**
     * 根据RFID获取合成刀信息
     * @param cuttingToolBindVO
     * @return
     * @throws Exception
     */
    public CuttingToolBind getCuttingToolBind(CuttingToolBindVO cuttingToolBindVO,Integer operationKey) throws Exception;

    /**
     * 获取刃磨设备
     * @return
     * @throws Exception
     */
    public List<ProductLineEquipment> getGrindingEquipment() throws Exception;

    /**
     * 根据rfid标签获取刃磨设备信息
     * @param equipmentVO 查询信息
     * @return
     * @throws Exception
     */
    public ProductLineEquipment getGrindingEquipmentByRFID(ProductLineEquipmentVO equipmentVO) throws Exception;

    /**
     * 获取场内刃磨记录数
     * @return
     * @throws Exception
     */
    public Integer countInsideFactory(InsideFactoryVO insideFactoryVO) throws Exception;


    /**
     * 场内刃磨
     * @param inOutGrindingBO 业务数据
     * @throws Exception
     */
    public void insideGrindingData(InOutGrindingBO inOutGrindingBO) throws Exception;

    /**
     * 厂外刃磨
     * @param inOutGrindingBO 业务数据
     * @throws Exception
     */
    public void outsideGrindingData(InOutGrindingBO inOutGrindingBO) throws Exception;



    /**
     * 补充既往刃磨记录
     * @param historyVO
     * @throws Exception
     */
    public void addInsideFactoryHistory(HistoryVO historyVO) throws Exception;

    /**
     * 添加场外刃磨服务商
     * @throws Exception
     */
    public void addSharpenProvider(SharpenProvider sharpenProvider) throws Exception;

    /**
     * 添加场外刃磨服务商
     * @throws Exception
     */
    public List<SharpenProvider> getSharpenProvider() throws Exception;



    /**
     * 获取场外刃磨记录数
     * @return
     * @throws Exception
     */
    public Integer countOutSideFactory(OutsideFactoryVO outsideFactoryVO) throws Exception;

    /**
     * 添加场外刃磨记录
     * @param outSideVO
     * @throws Exception
     */
    public void addOutsideFactory(OutSideVO outSideVO) throws Exception;


    /**
     * 补充既往刃磨记录
     * @param outsideFactory
     * @throws Exception
     */
    public void addOutsideFactoryHistory(OutsideFactory outsideFactory) throws Exception;

    /**
     * 根据材料号获取材料刀
     * @param cuttingToolVO
     * @return
     * @throws Exception
     */
    public CuttingTool getCuttingTool(CuttingToolVO cuttingToolVO, OperationEnum operationEnum) throws Exception;


    /**
     * 根据合成刀T号查询材料刀信息
     * @param synthesisCuttingToolVO 合成刀查询条件
     * @return
     * @throws Exception
     */
    public List<CuttingTool> getCuttingToolByTCode(SynthesisCuttingToolVO synthesisCuttingToolVO, OperationEnum operationEnum) throws Exception;




}
