package com.service.inoutFactory;

import com.common.pojo.*;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.common.vo.InsideFactoryVO;
import com.common.vo.OutsideFactoryVO;
import com.service.inoutFactory.vo.HistoryVO;
import com.service.inoutFactory.vo.InsideVO;
import com.service.inoutFactory.vo.OutSideVO;

import java.util.List;

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
    public CuttingToolBind getCuttingToolBind(CuttingToolBindVO cuttingToolBindVO) throws Exception;

    /**
     * 获取场内刃磨记录数
     * @return
     * @throws Exception
     */
    public Integer countInsideFactory(InsideFactoryVO insideFactoryVO) throws Exception;

    /**
     * 添加场内刃磨记录
     * @param insideVO
     * @throws Exception
     */
    public void addInsideFactory(InsideVO insideVO) throws Exception;


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
    public CuttingTool getCuttingTool(CuttingToolVO cuttingToolVO) throws Exception;

}
