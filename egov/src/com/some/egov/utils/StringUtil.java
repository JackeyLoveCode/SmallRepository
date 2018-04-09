package com.some.egov.utils;

import java.util.ResourceBundle;

public class StringUtil {
	private StringUtil(){}
	public static String getStringByCode(String code){
		ResourceBundle bundle = ResourceBundle.getBundle("com.some.egov.resource.resource");
		return bundle.getString(code);
		
		
	}
	public static boolean isNotEmpty(String str){
		return ((str!=null)&&(str.trim().length()!=0));
	}
	
	
	
}
