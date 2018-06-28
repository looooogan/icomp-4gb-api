package com.service.synthesiscuttingtool.vo;

/**
 * Created by logan on 2018/4/30.
 */
public class UpCuttingToolVO {

    private String upCode;

    private Integer upCount;

    private String upRfidLaserCode;

    private String bladeCode;

    private String businessCode;

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getBladeCode() {
        return bladeCode;
    }

    public void setBladeCode(String bladeCode) {
        this.bladeCode = bladeCode;
    }

    public String getUpRfidLaserCode() {
        return upRfidLaserCode;
    }

    public void setUpRfidLaserCode(String upRfidLaserCode) {
        this.upRfidLaserCode = upRfidLaserCode;
    }

    public String getUpCode() {
        return upCode;
    }

    public void setUpCode(String upCode) {
        this.upCode = upCode;
    }

    public Integer getUpCount() {
        return upCount;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }
}
