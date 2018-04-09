package com.some.egov.investor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.some.egov.beans.Investor;
import com.some.egov.beans.User;
import com.some.egov.consts.Consts;
import com.some.egov.utils.DBUtil;
import com.some.egov.utils.DateUtil;
import com.some.egov.utils.WebUtil;

public class SaveInvInfoServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("GB2312");
		 /*String  investor_name =   request.getParameter("investor_name");
		 String  country       =   request.getParameter("country");
		 String  org_code      =   request.getParameter("org_code");
		 String  contact       =   request.getParameter("contact");
		 String  contact_pho_num =   request.getParameter("contact_pho_num");
		 String  email         =   request.getParameter("email");
		 String  note          =   request.getParameter("note");*/
		 Investor inv = new Investor();
		 WebUtil.makeRequestToObj(request, inv);
		 User    agentObg       =  (User) request.getSession().getAttribute("user");
		 String  agent               = agentObg.getUsername();
		 String  regdate       =   DateUtil.getDateFormat(new Date(),Consts.YMD_DATE_PATTERN );
		 //连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
				/*
				 * investor_reg_code    VARCHAR(32)          not null,
				   investor_name        VARCHAR(32),
				   country              VARCHAR(3),
				   org_code             VARCHAR(32),
				   contact              VARCHAR(32),
				   contact_pho_num      VARCHAR(32),
				   email                VARCHAR(32),
				   note                 VARCHAR(128),
				   agent                VARCHAR(32),
				   regdate              CHAR(10 BYTE),
							 */
			String sql = "insert into investor(investor_reg_code,investor_name,country,org_code,contact,contact_pho_num,email,note,agent,regdate)"
					+ " values(inv_seq.nextval,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,  inv.getInvestor_name());
			ps.setString(2,  inv.getCountry());
			ps.setString(3,  inv.getOrg_code());
			ps.setString(4,  inv.getContact());
			ps.setString(5,  inv.getContact_pho_num()  );
			ps.setString(6,  inv.getEmail());
			ps.setString(7,  inv.getNote());
			ps.setString(8,  agent);
			ps.setString(9,  regdate);
			int count = ps.executeUpdate();
			if(count==1){
				response.sendRedirect("/egov/servlet/pageQueryInv");
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

}
