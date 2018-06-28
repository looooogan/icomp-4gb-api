package com.common.constants;

/**
 * Created by logan on 2018/6/14.
 */
public enum GrindingStatusEnum {
    To_Grinding("1","待刃磨"),
    Grinded("2","已刃磨");
    GrindingStatusEnum(String key, String name) {
        this.key = key;
        this.name = name;
    }

    private String key;
    private String name;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
