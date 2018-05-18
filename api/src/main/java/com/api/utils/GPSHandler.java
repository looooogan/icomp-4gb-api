package com.api.utils;

import com.api.utils.constants.Constants;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: GPSHandler
 * @Description: GPS位置计算
 * @author: Jivoin
 * @date: 2014年7月5日 上午11:45:45
 */
public class GPSHandler {
	
	/**
	 * 
	 * @Title: computedRange
	 * @Description: 同一纬度上一段距离(单位千米)的经度差
	 * @param lat 纬度
	 * @param distance 距离
	 * @return
	 * @return: String
	 */
	public static Double  computedLonDistance(Double lat, int distance){
		Double cosLat = Math.cos(lat);
		BigDecimal Londistance =new BigDecimal(110).multiply(new BigDecimal(Math.abs(cosLat)));
		BigDecimal result = new BigDecimal(distance).divide(Londistance, Constants.BIGDECIMAL_DIVIDE_LEN, BigDecimal.ROUND_HALF_UP);
		return result.doubleValue();
	}
	
	public static void main(String [] args){
//		BigDecimal bd1 = new BigDecimal(1);
//		BigDecimal bd2 = new BigDecimal(111);
//		System.out.println(bd1.divide(bd2,Constants.BIGDECIMAL_DIVIDE_LEN,BigDecimal.ROUND_HALF_UP));
//		GPSHandler.computedRange(new BigDecimal(121.640038), new BigDecimal(38.922359));
//		System.out.println(GPSHandler.computedRange(new BigDecimal(38.922359)));
	}
}
