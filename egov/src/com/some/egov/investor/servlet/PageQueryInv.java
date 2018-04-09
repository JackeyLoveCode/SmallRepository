package com.some.egov.investor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.some.egov.beans.Investor;
import com.some.egov.beans.Page;
import com.some.egov.utils.DBUtil;
import com.some.egov.utils.DateUtil;
import com.some.egov.utils.StringUtil;

public class PageQueryInv extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		String investor_reg_code = request.getParameter("investor_reg_code");
		String investor_name = request.getParameter("investor_name");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		//连接数据库
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			List<String> list = new ArrayList<String>();
			StringBuilder sql_sb =new StringBuilder();
			Page page = new Page((String)request.getParameter("pageno"));
			//业务sql
			sql_sb.append( "select i.investor_reg_code,i.investor_name,i.regdate,i.country,u.username from investor i join t_user u on i.agent = u.usercode where 1=1");
			//totalsizeSql语句
			StringBuilder totalSizeSql_sb = new StringBuilder(); 
			totalSizeSql_sb.append("select count(*) as totalSize from investor i join t_user u on i.agent = u.usercode where 1=1");
			if(StringUtil.isNotEmpty(investor_reg_code)){
				list.add(investor_reg_code);
				sql_sb.append(" and i.investor_reg_code =?");
				totalSizeSql_sb.append(" and i.investor_reg_code =?");
			}
			if(StringUtil.isNotEmpty(investor_name)){
				sql_sb.append(" and i.investor_name like '%"+investor_name+"%'");
				totalSizeSql_sb.append(" and i.investor_name like '%"+investor_name+"%'");
			}
			if(StringUtil.isNotEmpty(startDate)){
				list.add(startDate);
				sql_sb.append(" and i.regdate >=?");
				totalSizeSql_sb.append(" and i.regdate >=?");
			}
			if(StringUtil.isNotEmpty(endDate)){
				list.add(endDate);
				sql_sb.append(" and regdate <=?");
				totalSizeSql_sb.append(" and regdate <=?");
			}
			
			sql_sb.append(" order by i.regdate desc,i.investor_reg_code asc");
			String sql = sql_sb.toString();
			String totalSizeSql = totalSizeSql_sb.toString();
			sql = page.getSql(sql);
			ps = conn.prepareStatement(sql);
			for(int i=0;i<list.size();i++){
				ps.setString(i+1,list.get(i));
			}
			rs = ps.executeQuery();
			while(rs.next()){
				Investor inv = new Investor();
				inv.setInvestor_reg_code(rs.getString("investor_reg_code"));
				inv.setInvestor_name(rs.getString("investor_name"));
				inv.setRegdate(rs.getString("regdate"));
				inv.setCountry(rs.getString("country"));
				inv.setUsername(rs.getString("username"));
				page.getList().add(inv);
			}
			ps = conn.prepareStatement(totalSizeSql);
			for(int i = 0;i<list.size();i++){
				ps.setString(i+1, list.get(i));
			}
			rs = ps.executeQuery();
			Integer totalSize = null;
			while(rs.next()){
				totalSize = rs.getInt("totalSize");
			}
			page.setTotalSize(totalSize);
			request.setAttribute("page", page);
			request.getRequestDispatcher(request.getParameter("url")).forward(request, response);
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
