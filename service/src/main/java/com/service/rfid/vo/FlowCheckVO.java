package com.service.rfid.vo;

/**
 * Created by logan on 2018/5/27.
 */
public class FlowCheckVO {

    private String rfidLaserCode;

    private Integer operationCode;

    public String getRfidLaserCode() {
        return rfidLaserCode;
    }

    public void setRfidLaserCode(String rfidLaserCode) {
        this.rfidLaserCode = rfidLaserCode;
    }

    public Integer getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(Integer operationCode) {
        this.operationCode = operationCode;
    }
}
