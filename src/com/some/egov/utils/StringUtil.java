package com.some.egov.utils;

import java.util.ResourceBundle;

public class StringUtil {
	private StringUtil(){}
	public static String getStringByCode(String code){
		ResourceBundle bundle = ResourceBundle.getBundle("com.some.egov.resource.resource");
		if(code != null && code.trim().length() >0 ){
			
			return bundle.getString(code);
		}
		return "";
		
		
	}
	public static String getStringByCode(String prefix, String code){
		ResourceBundle bundle = ResourceBundle.getBundle("com.some.egov.resource.resource");
		if(code != null && code.trim().length() >0){
			return bundle.getString(prefix+code);
		}
		return "";
		
		
	}
	public static boolean isNotEmpty(String str){
		return ((str!=null)&&(str.trim().length()!=0));
	}
	public static boolean equalIgnoreCase(String code, String validateCode) {
		if(validateCode.toLowerCase().equals(code.toLowerCase())){
			return true;
		}
		return false;
	}
	
	
	
}
