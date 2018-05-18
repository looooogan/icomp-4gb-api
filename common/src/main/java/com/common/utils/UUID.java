package com.common.utils;

/**
 * Created by logan on 2018/4/29.
 */
public class UUID {

    public static String getInstance(){
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

}
