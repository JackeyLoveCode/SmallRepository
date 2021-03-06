package com.some.egov.user.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


public class CheckLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = (HttpSession) request.getSession(false);
		String servletPath = request.getServletPath();
		if("/login.jsp".equals(servletPath)||"/servlet/login".equals(servletPath)||(session!=null&&session.getAttribute("user")!=null)){
			chain.doFilter(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
