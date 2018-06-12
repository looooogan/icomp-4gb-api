package com.service.rfid.bo;

/**
 * Created by logan on 2018/5/29.
 */
public class RFIDBO {

    private String laserCode;

    private Integer prevOperationKey;

    private String operatorCode;

    private Integer labelType;

    public Integer getLabelType() {
        return labelType;
    }

    public void setLabelType(Integer labelType) {
        this.labelType = labelType;
    }

    public String getLaserCode() {
        return laserCode;
    }

    public void setLaserCode(String laserCode) {
        this.laserCode = laserCode;
    }

    public Integer getPrevOperationKey() {
        return prevOperationKey;
    }

    public void setPrevOperationKey(Integer prevOperationKey) {
        this.prevOperationKey = prevOperationKey;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }
}
