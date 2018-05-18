package com.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by logan on 2018/5/12.
 */
public class OrderNumHandler {

    public static String beginStr = "ww";
    public static String initStr = "00001";
    public static String maxStr = "99999";


    public static String orderNumInit() throws Exception{
        Date nowTime=new Date();
        SimpleDateFormat time=new SimpleDateFormat("yyyyMMdd");
        return beginStr+time.format(nowTime)+initStr;
    }

    public static String getNextOrderNum(String currentOrderNum) throws Exception{
        String currentCount = currentOrderNum.substring(currentOrderNum.length()-5);
        if (maxStr.equals(currentCount)){
            currentCount = initStr;
        }
        Date nowTime=new Date();
        SimpleDateFormat time=new SimpleDateFormat("yyyyMMdd");
        return beginStr+time.format(nowTime)+String.format("%05d",Integer.parseInt(currentCount)+1);
    }

    public static void main(String[] args) {
        System.out.println(String.format("%05d",11231111));
    }

}
