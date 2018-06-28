package com.common.constants;

/**
 * Created by logan on 2018/6/15.
 */
public enum  EquipmentBindStatus {
    Bind(1,"绑定"),UnBind(2,"未绑定"),;

    EquipmentBindStatus(Integer key, String name) {
        this.key = key;
        this.name = name;
    }

    private Integer key;
    private String name;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
