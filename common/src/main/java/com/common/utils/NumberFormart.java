package com.common.utils;

/**
 * Created by logan on 2018/6/17.
 */
public class NumberFormart {

    public static String prefix0(Integer num) throws Exception{
        String newString = String.format("%03d", num);
        return  newString;
    }
}
