package com.service.writeback;

import com.service.inoutFactory.bo.InOutGrindingBO;
import com.service.orders.vo.OutApplyVO;
import com.service.orders.vo.WBCuttingToolBindVO;
import com.service.orders.vo.WBUnInstallVO;
import com.service.scrap.bo.ScrapBO;
import com.service.writeback.bo.InstallWBBO;
import com.service.writeback.bo.UnInstallWBBO;

/**
 * Created by logan on 2018/5/11.
 */
public interface IDjWriteBackService {

    /**
     * 回写出库单数据
     * @param outApplyVO 出库单数据封装
     * @throws Exception
     */
    public void writeBackOutLibrary(OutApplyVO outApplyVO) throws Exception;

    /**
     * 刀具绑定
     * @param wbCuttingToolBindVO 刀具绑定数据封装
     * @throws Exception
     */
    public void writeBackCuttingToolBind(WBCuttingToolBindVO wbCuttingToolBindVO) throws Exception;


    /**
     * 出库0609
     * @param outApplyVO
     * @throws Exception
     */
    public void writeBackOutLibrary0609(OutApplyVO outApplyVO) throws Exception;


    /**
     * 安上设备回写
     * @param installWBBO
     * @throws Exception
     */
    public void writeBackInstall(InstallWBBO installWBBO) throws Exception;


    /**
     * 卸下设备回写
     * @param unInstallWBBO
     * @throws Exception
     */
    public void writeBackUnInstall(UnInstallWBBO unInstallWBBO) throws Exception;


    /**
     * 场内刃磨
     * @param inOutGrindingBO 业务数据封装
     * @throws Exception
     */
    public void writeBackGrindingIn(InOutGrindingBO inOutGrindingBO) throws Exception;

    /**
     * 场外刃磨
     * @param inOutGrindingBO 业务数据封装
     * @throws Exception
     */
    public void writeBackGrindingOut(InOutGrindingBO inOutGrindingBO) throws Exception;

    /**
     * 刀具报废
     * @param  scrapBO 业务数据封装
     * @throws Exception
     */
    public void writeBackScrap(ScrapBO scrapBO) throws Exception;


}
