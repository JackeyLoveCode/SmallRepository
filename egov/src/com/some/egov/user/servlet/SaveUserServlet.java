package com.some.egov.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.some.egov.beans.User;
import com.some.egov.consts.Consts;
import com.some.egov.utils.DBUtil;
import com.some.egov.utils.DateUtil;
import com.some.egov.utils.WebUtil;

public class SaveUserServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public SaveUserServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  /* usercode             VARCHAR(12)          not null,
		   username             VARCHAR(12),
		   userpawd             VARCHAR(12),
		   orgtype              CHAR(1 BYTE),
		   userdate             CHAR(19 BYTE),*/
		/*解决中文乱码问题*/
		//request.setCharacterEncoding("gb2312");
		//获取表单参数
		/*String usercode = request.getParameter("usercode");
		String username = request.getParameter("username");
		String userpawd = request.getParameter("userpawd");
		String orgtype = request.getParameter("orgtype");*/
		
		String userdate = request.getParameter("userdate");
		User user = new User();
		WebUtil.makeRequestToObj(request, user);
		userdate =DateUtil.getDateFormat(new Date(),Consts.ALL_DATE_PATTERN);
		user.setUserdate(userdate);
		
		//连接oracle数据库
		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
		conn = DBUtil.getConnection();
		String ins_sql = "insert into t_user(usercode,username,userpawd,orgtype,userdate) values(?,?,?,?,?)";
		ps = conn.prepareStatement(ins_sql);
		ps.setString(1, user.getUsercode());
		ps.setString(2, user.getUsername());
		ps.setString(3, user.getUserpawd());
		ps.setString(4, user.getOrgtype());
		ps.setString(5, userdate);
		int count = ps.executeUpdate(); 
		if(count==1){
			response.sendRedirect("/egov/servlet/pageQuery");
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try {
				DBUtil.close(conn,ps,null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
