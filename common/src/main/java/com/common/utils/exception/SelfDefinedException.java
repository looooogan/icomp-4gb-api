/**  
 * Copyright © 2014电子商务. All rights reserved.
 *
 * @Title: SelfDefinedException.java
 * @Prject: mypro
 * @Package: com.mypro.utils.exception
 * @Description: 自定义异常类
 * @author: Jingh 
 * @date: 2014年8月6日 下午2:15:11
 * @version: V1.0  
 */
package com.common.utils.exception;

/**
 * @ClassName: SelfDefinedException
 * @Description: 自定义异常类
 * @author: Jingh
 * @date: 2014年8月6日 下午2:15:11
 */
public class SelfDefinedException extends Exception {

	private static final long serialVersionUID = 6655164451288057079L;

	public SelfDefinedException() {
		super();
	}
	
	public SelfDefinedException(String msg) {
		super(msg);
	}
	
	public SelfDefinedException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public SelfDefinedException(Throwable cause) {
		super(cause);
	}
}
