package com.service.system.vo;

import com.common.pojo.AuthCustomer;

/**
 * Created by logan on 2018/5/6.
 */
public class ChangeRFIDVO {


    private String laserCode;

    private String newLaserCode;

    private String toolCode;

    private Integer type;

    private AuthCustomer loginUser;

    public AuthCustomer getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(AuthCustomer loginUser) {
        this.loginUser = loginUser;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getLaserCode() {
        return laserCode;
    }

    public void setLaserCode(String laserCode) {
        this.laserCode = laserCode;
    }

    public String getNewLaserCode() {
        return newLaserCode;
    }

    public void setNewLaserCode(String newLaserCode) {
        this.newLaserCode = newLaserCode;
    }
}
