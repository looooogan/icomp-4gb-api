package com.service.orders;

import com.service.orders.vo.OutApplyVO;
import com.service.orders.vo.WBCuttingToolBindVO;
import com.service.orders.vo.WBUnInstallVO;

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


}
