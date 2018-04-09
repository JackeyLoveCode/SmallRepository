package com.some.egov.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.some.egov.utils.DBUtil;

public class checkUsercodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		String usercode = request.getParameter("usercode");
		response.setContentType("text/html;charset=GB18030");
		/*连接数据库*/
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_user where usercode =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,usercode);
			rs= ps.executeQuery();
			PrintWriter out = response.getWriter();
			if(rs.next()){
				out.print("<font color='red'>用户代码已经存在</font>");
			}else{
				out.print("<font color='green'>用户代码可用</font>");
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
