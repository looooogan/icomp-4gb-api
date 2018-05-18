package com.service.orders;

import com.service.orders.vo.OutApplyVO;

/**
 * Created by logan on 2018/5/11.
 */
public interface IDjQiMingDBService {

    /**
     * 查询出库单中的信息
     * @param outApplyVO
     * @return
     * @throws Exception
     */
    public OutApplyVO getInfo(OutApplyVO outApplyVO) throws Exception;

    /**
     * 修改出库单相关数据
     * @throws Exception
     */
    public void updateDjOutapplyAkpForOut(OutApplyVO outApplyVO) throws Exception;

}
