package com.some.egov.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	public static  void makeRequestToObj(HttpServletRequest request,Object obj){
		Class c= obj.getClass();
		Enumeration<String> fieldNames = request.getParameterNames();
		while(fieldNames.hasMoreElements()){
		String fieldName = fieldNames.nextElement();
		
		String methodName = "set"+fieldName.toUpperCase().substring(0, 1)+fieldName.substring(1);
		try {
			Method setMethod = c.getDeclaredMethod(methodName, String.class);//要求obj对象里的属性类型都是String类型的
			setMethod.invoke(obj, request.getParameter(fieldName));
		} catch (Exception e) {
			
		}
		
		}
		
		
	}
	
}
