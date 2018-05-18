package com.api.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageProperties {
	
	private static ResourceBundle rb;
	
	public static void init(){
		rb = ResourceBundle.getBundle("message", Locale.getDefault());
	}
	
	public static String getValue(String key){
		if(rb==null){
			MessageProperties.init();
		}
		return rb.getString(key);
	}
	
	
	public static void main(String [] args){
		System.out.println(MessageProperties.getValue("name"));
		System.out.println(MessageProperties.getValue("age"));
	}
	

}
