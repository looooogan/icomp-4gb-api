package com.service.rfid;

import com.common.vo.RfidContainerVO;
import com.service.rfid.DTO.FlowCheckDTO;
import com.service.rfid.vo.FlowCheckVO;

/**
 * Created by logan on 2018/5/27.
 */
public interface IFlowCheckService {

    /**
     * 流程检查
     * @param flowCheckVO
     * @throws Exception
     */
    public FlowCheckDTO checkFlow(FlowCheckVO flowCheckVO) throws Exception;
}
