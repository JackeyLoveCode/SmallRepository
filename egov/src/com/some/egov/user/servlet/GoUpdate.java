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

import com.some.egov.beans.User;
import com.some.egov.utils.DBUtil;

public class GoUpdate extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usercode = request.getParameter("checkbox");
		/*连接数据库*/
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			
			conn = DBUtil.getConnection();
			String sql = "select username,userpawd,orgtype from t_user where usercode = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, usercode);
			rs = ps.executeQuery();
			User user = null;
			while(rs.next()){
				user = new User();
				user.setUsercode(usercode);
				user.setUsername(rs.getString("username"));
				user.setUserpawd(rs.getString("userpawd"));
				user.setOrgtype(rs.getString("orgtype"));
				
			}
			request.setAttribute("user", user);
			request.getRequestDispatcher("/user/userUpdate.jsp").forward(request, response);;
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	

}
