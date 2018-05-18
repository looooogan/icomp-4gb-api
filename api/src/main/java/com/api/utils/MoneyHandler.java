package com.api.utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Jivoin
 * Date: 14-4-26
 * Time: 上午10:36
 * 金额计算
 */
@Component
public class MoneyHandler {

    /**
     *  金额的乘法计算
     * @param firstMoney
     * @param secondMoney
     * @return
     */
    public static String multiply(String firstMoney,String secondMoney){
    	if (firstMoney==null||secondMoney==null||"".equals(firstMoney.trim())||"".equals(secondMoney.trim())) {
			return "0";
		}
        BigDecimal first = new BigDecimal (firstMoney);
        BigDecimal second = new BigDecimal (secondMoney);
        return first.multiply (second).toPlainString ();
    }

    /**
     *  普通加法计算
     * @param firstMoney
     * @param secondMoney
     * @return
     */
    public static String add(String firstMoney,String secondMoney){
        BigDecimal first = new BigDecimal (firstMoney);
        BigDecimal second = new BigDecimal (secondMoney);
        return first.multiply (second).toPlainString ();
    }

    /**
     *  普通除法计算
     * @param firstMoney 金额1
     * @param secondMoney 金额2
     * @return
     */
    public static String divide(String firstMoney,String secondMoney){
        BigDecimal first = new BigDecimal (firstMoney);
        BigDecimal second = new BigDecimal (secondMoney);
        return first.multiply (second).toPlainString ();
    }

    /**
     *  普通减法计算
     * @param firstMoney
     * @param secondMoney
     * @return
     */
    public static String subtract(String firstMoney,String secondMoney){
        BigDecimal first = new BigDecimal (firstMoney);
        BigDecimal second = new BigDecimal (secondMoney);
        return first.multiply (second).toPlainString ();
    }

    public static void main(String[] args) {
        System.out.println (MoneyHandler.multiply ("","0"));
    }
}
