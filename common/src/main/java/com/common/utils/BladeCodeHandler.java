package com.common.utils;

import java.text.NumberFormat;

/**
 * Created by logan on 2018/6/16.
 */
public class BladeCodeHandler {

    public static String create(String code) throws Exception{
        return String.format("%04d", Integer.parseInt(code));
    }

    public static void main(String[] args) throws Exception {
        String newString = BladeCodeHandler.create("25");
        System.out.println(newString);
    }

}
