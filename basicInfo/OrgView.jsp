<%@ page language="java" import="java.util.*" pageEncoding="GB18030"
         import="com.some.egov.beans.*,com.some.egov.utils.*"%>
<%@ taglib prefix="egov" uri="http://www.some.egov.jstl.fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    			<td>Ͷ��������</td><td>${inv.investor_name }</td>
    		</tr>
    		<tr>
    			<td>��������/����</td><td>${egov:getStringByCode(inv.country) }</td>
    		</tr>
    		<tr>
    			<td>��֯��������</td><td>${inv.org_code }</td>
    		</tr>
    		<tr>
    			<td>��ϵ��</td><td>${inv.contact }</td>
    		</tr>
    		<tr>
    			<td>��ϵ�绰</td><td>${inv.contact_pho_num }</td><td>��������</td><td>${inv.email }</td>
    		</tr>
    		<tr>
    			<td>��ע</td><td>${inv.note }</td>
    		</tr>
    		<tr>
    			<td><a href="basicInfo/OrgList.jsp">����</a></td>
    		</tr>
    	
    	
    	</table>
  </body>
</html>
