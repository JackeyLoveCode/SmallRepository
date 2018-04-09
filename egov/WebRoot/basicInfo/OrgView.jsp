<%@ page language="java" import="java.util.*" pageEncoding="GB18030"
         import="com.some.egov.beans.*,com.some.egov.utils.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	Investor inv = (Investor)request.getAttribute("inv");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'OrgAdd.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
    	<table align="left" height="450" bgcolor="gray">
    		
    		<tr>
    			<td>投资人名称</td><td><%=inv.getInvestor_name() %></td>
    		</tr>
    		<tr>
    			<td>所属国家/地区</td><td><%=StringUtil.getStringByCode(inv.getCountry()) %></td>
    		</tr>
    		<tr>
    			<td>组织机构代码</td><td><%=inv.getOrg_code() %></td>
    		</tr>
    		<tr>
    			<td>联系人</td><td><%=inv.getContact() %></td>
    		</tr>
    		<tr>
    			<td>联系电话</td><td><%=inv.getContact_pho_num() %></td><td>电子信箱</td><td><%=inv.getEmail() %></td>
    		</tr>
    		<tr>
    			<td>备注</td><td><%=inv.getNote() %></td>
    		</tr>
    		<tr>
    			<td><a href="basicInfo/OrgList.jsp">返回</a></td>
    		</tr>
    	
    	
    	</table>
  </body>
</html>
