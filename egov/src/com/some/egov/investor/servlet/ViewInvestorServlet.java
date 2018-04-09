package com.some.egov.investor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.some.egov.beans.Investor;
import com.some.egov.utils.DBUtil;

public class ViewInvestorServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		String investor_reg_code=request.getParameter("investor_reg_code");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select investor_name,country,org_code,contact,contact_pho_num,email,note,agent,regdate from investor where investor_reg_code=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,investor_reg_code);
			rs = ps.executeQuery();
			Investor inv = null;
			while(rs.next()){
				inv = new Investor();
				inv.setInvestor_name(rs.getString("investor_name"));
				inv.setAgent(rs.getString("agent"));
				inv.setCountry(rs.getString("country"));
				inv.setOrg_code(rs.getString("org_code"));
				inv.setContact(rs.getString("contact"));
				inv.setContact_pho_num(rs.getString("contact_pho_num"));
				inv.setEmail(rs.getString("email"));
				inv.setNote(rs.getString("note"));
				inv.setRegdate(rs.getString("regdate"));
				
			}
			request.setAttribute("inv", inv);
			request.getRequestDispatcher("/basicInfo/OrgView.jsp").forward(request, response);;
	/*		investor_reg_code    VARCHAR(32)          not null,
			   investor_name        VARCHAR(32),
			   country              VARCHAR(3),
			   org_code             VARCHAR(32),
			   contact              VARCHAR(32),
			   contact_pho_num      VARCHAR(32),
			   email                VARCHAR(32),
			   note                 VARCHAR(128),
			   agent                VARCHAR(32),
			   regdate              CHAR(10 BYTE),*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
