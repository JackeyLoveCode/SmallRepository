package com.some.egov.user.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.some.egov.beans.Page;
import com.some.egov.beans.User;
import com.some.egov.utils.DBUtil;

public class PageQuery extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Page<User> page = new Page<User>(request.getParameter("pageno"));
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			 conn = DBUtil.getConnection();
			 //业务SQL
			 String sql = "select usercode,username,orgtype from t_user order by userdate desc" ; 
			 /*分页SQL*/
			 String pageSql = page.getSql(sql);
			 ps = conn.prepareStatement(pageSql);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 User user = new User();
				 user.setUsercode(rs.getString("usercode"));
				 user.setUsername(rs.getString("username"));
				 user.setOrgtype(rs.getString("orgtype"));
				 page.getList().add(user);
			 }
			 String countSql = "select count(*) as totalSize from t_user ";
			 ps = conn.prepareStatement(countSql);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 page.setTotalSize(rs.getInt("totalSize"));
				 
			 }
			 request.setAttribute("page", page);
			 request.getRequestDispatcher("/system/right.jsp").forward(request, response);
			 
			 
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
