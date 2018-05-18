package com.service.system;

import com.service.system.vo.ChangeRFIDVO;
import com.service.system.vo.RFIDQueryVO;

/**
 * Created by logan on 2018/5/6.
 */
public interface ISystemBusinessService {

    /**
     * 标签置换
     * @param changeRFIDVO
     * @throws Exception
     */
    public void chagneRFIDForTool(ChangeRFIDVO changeRFIDVO) throws Exception;


    /**
     * 清空标签
     * @param rfidQueryVO
     * @throws Exception
     */
    public void clearRFID(RFIDQueryVO rfidQueryVO) throws Exception;


    /**
     * 查询标签绑定信息
     * @param rfidQueryVO
     * @throws Exception
     */
    public RFIDQueryVO queryByRFID(RFIDQueryVO rfidQueryVO) throws Exception;

}
