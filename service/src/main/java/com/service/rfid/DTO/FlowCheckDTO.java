package com.service.rfid.DTO;

/**
 * Created by logan on 2018/5/27.
 */
public class FlowCheckDTO {

    private String message;
    /**
     * 1 正常流程  2 非正常流程，可继续执行 3 非正常流程，终止
     */
    private String type;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
