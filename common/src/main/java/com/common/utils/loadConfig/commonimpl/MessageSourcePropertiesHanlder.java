package com.common.utils.loadConfig.commonimpl;

import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.utils.loadConfig.PropertisConstants;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.Properties;

/**
 * @ClassName: PropertiesCommonImpl
 * @Description: 利用spring的MessageSource实现属性文件读取，设置缓存时间，关闭local
 * @author: Jivoin
 * @date: 2014年7月26日 下午3:05:06
 */
@Component("messageSourceImpl")
public class MessageSourcePropertiesHanlder  implements IMessageSourceHanlder {

	/**
	 * @fieldName: propertiesHandler
	 * @fieldType: ReloadableResourceBundleMessageSource
	 * @Description: application配置文件中的MessageSource实例
	 */
	@Resource(name="propertiesHandler")
	private ReloadableResourceBundleMessageSource propertiesHandler;
	
	/*
	 * (non Javadoc)
	 * @Title: getValue
	 * @Description: 获取字符内容
	 * @see com.mypro.utils.loadConfig.IPropertiesHanlder#getValue(java.lang.String)
	 */
	@Override
	public String getValue(String key) throws Exception {
		return propertiesHandler.getMessage(key, null, new Locale(PropertisConstants.DEFAULT_LOCAL_COUNTYR, PropertisConstants.DEFAULT_LOCAL_LANGUAGE));
	}

	@Override
	public String[] getValues(String key) throws Exception {
		return null;
	}
	
	/*
	 * (non Javadoc)
	 * @Title: getValueByParams
	 * @Description: spring的MessageSource读取方法
	 * @see com.mypro.utils.loadConfig.IMessageSourceHanlder#getValueByParams(java.lang.String, java.lang.String[], java.util.Locale)
	 */
	@Override
	public String getValueByParams(String key,String [] params,Locale locale) throws Exception{
		return propertiesHandler.getMessage(key, params, locale==null?new Locale(PropertisConstants.DEFAULT_LOCAL_COUNTYR, PropertisConstants.DEFAULT_LOCAL_LANGUAGE):locale);
	}

	@Override
	public void setValue(String key, String param) throws Exception {
		Properties properties = new Properties();
		properties.setProperty(key,param);
		propertiesHandler.setCommonMessages(new Properties());
	}
}
