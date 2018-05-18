package com.service.orders;

import com.service.orders.vo.OutApplyVO;
import com.service.orders.vo.WBOutApplyVO;

import java.util.List;

/**
 * Created by logan on 2018/5/7.
 */
public interface IOutApplyBusinessService {


    /**
     * 出库
     * @param outApplyVO
     * @throws Exception
     */
    public void outApplyData(OutApplyVO outApplyVO) throws Exception;


}
