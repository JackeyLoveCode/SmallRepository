package com.some.egov.user.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.some.egov.beans.User;
import com.some.egov.utils.DBUtil;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orgtype = request.getParameter("orgtype");
		String usercode = request.getParameter("usercode");
 		String userpawd = request.getParameter("userpawd");
 		//连接数据库
 		Connection conn = null;
 		PreparedStatement ps =null;
 		ResultSet rs = null;
 		try {
			conn = DBUtil.getConnection();
			String sql = "select username from t_user where orgtype=? and userpawd=?  and usercode=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, orgtype);
			ps.setString(2, userpawd);
			ps.setString(3, usercode);
			rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setOrgtype(orgtype);
				user.setUsercode(usercode);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("/egov/main.html");
			}else{
				String errorMSG = "用户不存在，请重新登录";
				request.setAttribute("errorMSG", errorMSG);
				request.getRequestDispatcher("/").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 		
	}

}
