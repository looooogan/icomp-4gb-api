package com.common.utils.loadConfig;



/**
 * @ClassName: IPropertiesHanlder
 * @Description: 属性文件读取接口 .properties
 * @author: Jivoin
 * @date: 2014年7月26日 下午3:06:29
 */
public interface IPropertiesHanlder {
	
	/**
	 * @Title: getValue
	 * @Description: 获取字符串内容
	 * @param key key
	 * @return 内容
	 * @throws Exception
	 * @return: String
	 */
	public String getValue(String key) throws Exception;
	
	/**
	 * @Title: getValues
	 * @Description: 获取输入内容
	 * @param key key
	 * @return 内容数组
	 * @throws Exception
	 * @return: String[]
	 */
	public String [] getValues(String key) throws Exception;
	

}
