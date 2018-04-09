package com.some.egov.enterprise.servlet;

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

import com.some.egov.beans.Enterprise;
import com.some.egov.beans.User;
import com.some.egov.consts.Consts;
import com.some.egov.utils.DBUtil;
import com.some.egov.utils.DateUtil;
import com.some.egov.utils.WebUtil;

public class SaveEntInfoServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		   orgcode              VARCHAR(32)          not null,
		   foreign_reg_number   VARCHAR(32),
		   company_name_cn      VARCHAR(64),
		   bus_english_name     VARCHAR(64),
		   contact              VARCHAR(32),
		   contact_pho_num      VARCHAR(32),
		   reg_capital          NUMBER(9),
		   fore_reg_capital     NUMBER(9),
		   reg_curr             CHAR(3 BYTE),
		   agent                VARCHAR(32),
		   regdate              CHAR(10 BYTE),
		*/
		Enterprise enter = new Enterprise();
		WebUtil.makeRequestToObj(request,enter);
		String agent = ((User)request.getSession(false).getAttribute("user")).getUsercode();
		enter.setAgent(agent);
		String regdate = DateUtil.getDateFormat(new Date(), Consts.YMD_DATE_PATTERN);
		enter.setRegdate(regdate);
		Connection conn = null;
		PreparedStatement ps = null;
		String[] inv_reg_codes = request.getParameterValues("inv_reg_code");
		String[] reg_cap_cons   = request.getParameterValues("reg_cap_con");
		String[] pro_diss = request.getParameterValues("pro_dis");
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			String sql = "insert into enterprise(orgcode,foreign_reg_number,company_name_cn,bus_english_name,contact,contact_pho_num,reg_capital,fore_reg_capital,reg_curr,agent,regdate)"
					+ " values(?,?,?,?,?,?,?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, enter.getOrgcode());
			ps.setString(2, enter.getForeign_reg_number());
			ps.setString(3, enter.getCompany_name_cn());
			ps.setString(4, enter.getBus_english_name());
			ps.setString(5, enter.getContact());
			ps.setString(6, enter.getContact_pho_num());
			ps.setInt(7, Integer.parseInt(enter.getReg_capital()));
			ps.setInt(8, Integer.parseInt(enter.getFore_reg_capital()));
			ps.setString(9, enter.getReg_curr());
			ps.setString(10, enter.getAgent());
			ps.setString(11, enter.getRegdate());
			count = ps.executeUpdate();
			sql = "insert into ent_inv(orgcode,inv_reg_code,reg_cap_con,pro_dis) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			for(int i=0;i < inv_reg_codes.length;i++){
				ps.setString(1, enter.getOrgcode());
				ps.setString(2, inv_reg_codes[i]);
				ps.setInt(3, Integer.parseInt(reg_cap_cons[i]));
				ps.setInt(4, Integer.parseInt(pro_diss[i]));
				count += ps.executeUpdate();
			}
			if(count==1+inv_reg_codes.length){
				DBUtil.commitTransaction(conn);
				response.sendRedirect("/egov/foreignExchange/EntView.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			DBUtil.rollbackTransaction(conn);
			e.printStackTrace();
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
