package com.api.utils;

import ch.qos.logback.classic.Logger;
import com.common.utils.exception.SelfDefinedException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: AopLog
 * @Description: aop日志
 * @author: Jivoin
 * @date: 2014年3月27日 上午8:49:38
 */
public class AopLog {
	
	public AopLog(){
		objectMapper = new ObjectMapper();
	}
	
	private ObjectMapper objectMapper;
    
    /**
     * @fieldName: logger
     * @fieldType: Logger
     * @Description: 业务处理 logger
     */
    private Logger serviceLogger = (Logger) LoggerFactory.getLogger("service_file_log");
    
    /**
     * @fieldName: errorLogger
     * @fieldType: Logger
     * @Description: 异常logger
     */
    private Logger errorLogger = (Logger) LoggerFactory.getLogger("error_file_log");
    
    
    /**
     * @Title: before
     * @Description: 前置方法
     * @param joinPoint
     * @return: void
     */
    public void before(JoinPoint joinPoint){
		serviceLogger.info("--------------"+joinPoint.getTarget().getClass()+" : "+ joinPoint.getSignature().getName() +"  begin  -------------------");
			try {
				serviceLogger.info("param  json  :  "+objectMapper.writeValueAsString(joinPoint.getArgs()));
			} catch (JsonProcessingException e) {
				errorLogger.error("param json parse error",e);
			}
    }
    
    /**
     * @Title: after
     * @Description: 后续方法
     * @param joinPoint
     * @return: void
     */
    public void after(JoinPoint joinPoint){
    	serviceLogger.info("--------------"+joinPoint.getTarget().getClass()+" : "+ joinPoint.getSignature().getName() +"  end  -------------------");
    }
    
    
    /**
     * @Title: doThrowing
     * @Description: 异常处理
     * @param joinPoint
     * @param ex
     * @return: void
     */
    public void doThrowing (JoinPoint joinPoint, Throwable ex) {
    	if(ex instanceof SelfDefinedException){
    		return;
    	}
		errorLogger.error("--------------"+joinPoint.getTarget().getClass()+" : "+ joinPoint.getSignature().getName() +"   -------------------");
			try {
				errorLogger.error("param  json  :  "+objectMapper.writeValueAsString(joinPoint.getArgs()));
			} catch (JsonProcessingException e) {
				errorLogger.error("param json parse error",e);
			}
		errorLogger.error("error    info  :  ",ex);
    }

}
