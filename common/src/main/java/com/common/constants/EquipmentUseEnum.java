package com.common.constants;

/**
 * Created by logan on 2018/6/16.
 */
public enum  EquipmentUseEnum {
    InUse(1,"使用中"),
    UnUse(2,"未使用"),;

    EquipmentUseEnum(Integer key, String name) {
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
