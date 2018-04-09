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

public class DoUpdateUserServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//request.setCharacterEncoding("utf-8");
			//获取表单参数
			String usercode = request.getParameter("usercode");
			String username = request.getParameter("username");
			String userpawd = request.getParameter("userpawd");
			String orgtype = request.getParameter("orgtype");
			
			/*连接数据库*/
			Connection conn = null;
			PreparedStatement ps =null;
			try {
				conn = DBUtil.getConnection();
				String sql_upd = "update t_user set username = ?,userpawd = ?,orgtype = ? where usercode = ?";
				ps = conn.prepareStatement(sql_upd);
				ps.setString(1, username);
				ps.setString(2, userpawd);
				ps.setString(3, orgtype);
				ps.setString(4, usercode);
				int count = ps.executeUpdate();
				if(count==1){
					response.sendRedirect("/egov/servlet/pageQuery?pageno="+request.getParameter("pageno"));
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					DBUtil.close(conn, ps, null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

}
