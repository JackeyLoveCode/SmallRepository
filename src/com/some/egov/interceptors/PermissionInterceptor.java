package com.some.egov.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.some.egov.beans.User;

public class PermissionInterceptor extends AbstractInterceptor {


	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取信息  
        User user = (User) ActionContext.getContext().getSession().get("user"); // 当前登录用户  
        String namespace = invocation.getProxy().getNamespace();  
        String actionName = invocation.getProxy().getActionName();  
        String privUrl = namespace + actionName; // 对应的权限URL  
  
        // 如果未登录  
        if (user == null) {  
            if (privUrl.startsWith("/user_login") || privUrl.startsWith("/user_validate") || privUrl.contains("/login.jsp")) { // "/user_loginUI", "/user_login"  
                // 如果是去登录，就放行  
                return invocation.invoke();  
            } else {  
                // 如果不是去登录，就转到登录页面  
                return "error";  
            }  
        }  
		return invocation.invoke();
	}

}
