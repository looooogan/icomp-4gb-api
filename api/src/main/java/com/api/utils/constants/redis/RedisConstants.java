/**  
 * Copyright © 2014电子商务. All rights reserved.
 *
 * @Title: RedisConstants.java
 * @Prject: mypro
 * @Package: com.mypro.utils.constants.redis
 * @Description:
 * @author: Jingh 
 * @date: 2014年7月24日 下午4:39:29
 * @version: V1.0  
 */
package com.api.utils.constants.redis;

/**
 * @ClassName: RedisConstants
 * @Description: redis缓存常量类
 * @author: Jingh
 * @date: 2014年7月24日 下午4:39:29
 */
public class RedisConstants {
	
	/**
	 * @fieldName: RANDOM_PWD_CACHE_TIME
	 * @fieldType: Integer
	 * @Description: 随机码缓存时间
	 */
	public static Integer RANDOM_PWD_CACHE_TIME = 300;	
	
	/**
	 * @fieldName: CACHE_DEFAULT_TIME
	 * @fieldType: Integer
	 * @Description: 缓存默认时间3600秒
	 */
	public static final Integer CACHE_DEFAULT_TIME = 3600;
	
	/**
	 * @fieldName: LOGIN_MEMBER_CACHE_TIME
	 * @fieldType: Integer
	 * @Description: 登录用户缓存时间
	 */
	public static final Integer LOGIN_MEMBER_CACHE_TIME = 2592000;
	
	/**
	 * @fieldName: RANDOM_PASSWORD_KEY
	 * @fieldType: String
	 * @Description: 随机密码前缀
	 */
	public static final String RANDOM_PASSWORD_KEY = "random_password_";



	public static final String SEND_PASSWORD_TIME_KEY = "send_password_time_";
	
	public static final int MAX_SEND_PASSWORD_TIME = 4;
	
	public static final int SEND_PASSWORD_RETRY_CYCLE = 30;
}
