package com.some.egov.enterprise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.some.egov.utils.DBUtil;

public class CheckOrgcodeServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orgcode = request.getParameter("orgcode");
		//连接数据库
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from enterprise where orgcode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, orgcode);
			rs = ps.executeQuery();
			if(rs.next()){
				String errorMsg  = "组织机构已经存在，请重新填写";
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("/foreignExchange/EntView.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/foreignExchange/EntAdd.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
