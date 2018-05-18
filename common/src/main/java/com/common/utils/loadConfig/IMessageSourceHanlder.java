package com.common.utils.loadConfig;

import java.util.Locale;

/**
 * 
 * @ClassName: IMessageSourceHanlder
 * @Description: 读取配置文件，spring的MessageSource接口
 * @author: Jivoin
 * @date: 2014年7月26日 下午3:35:34
 */
public interface IMessageSourceHanlder extends IPropertiesHanlder {

	/**
	 * @Title: getValueByParams
	 * @Description: 
	 * @param key 内容标示
	 * @param params 参数 获取资源文件中的{0}等参数
	 * @param locale 本地化
	 * @return: String
	 */
	public String getValueByParams(String key, String[] params, Locale locale) throws Exception;



	/**
	 * @Title: setValue
	 * @Description:
	 * @param key 内容标示
	 * @param param 参数 获取资源文件中的{0}等参数
	 * @param locale 本地化
	 * @return: String
	 */
	public void setValue(String key, String param) throws Exception;
	
}
