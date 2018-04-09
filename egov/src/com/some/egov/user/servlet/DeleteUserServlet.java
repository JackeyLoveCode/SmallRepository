package com.some.egov.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.some.egov.utils.DBUtil;

public class DeleteUserServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单参数
		String[] usercodes = request.getParameterValues("checkbox");
		
		//连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			String del_sql = "delete from t_user where usercode = ?";
			ps = conn.prepareStatement(del_sql);
			for(int i=0;i<usercodes.length;i++){
				ps.setString(1, usercodes[i]);
				count+=ps.executeUpdate();
			}
			DBUtil.commitTransaction(conn);
			if(count==usercodes.length){
				response.sendRedirect("/egov/servlet/pageQuery");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.rollbackTransaction(conn);
		}finally{
			try {
				DBUtil.endTransaction(conn);
				DBUtil.close(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
