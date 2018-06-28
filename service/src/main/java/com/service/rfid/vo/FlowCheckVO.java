package com.service.rfid.vo;

import com.common.vo.RfidContainerVO;

/**
 * Created by logan on 2018/5/27.
 */
public class FlowCheckVO {

//    private String rfidLaserCode;

    private Integer operationCode;

    private RfidContainerVO rfidContainerVO;

    public RfidContainerVO getRfidContainerVO() {
        return rfidContainerVO;
    }

    public void setRfidContainerVO(RfidContainerVO rfidContainerVO) {
        this.rfidContainerVO = rfidContainerVO;
    }

    public Integer getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(Integer operationCode) {
        this.operationCode = operationCode;
    }
}
