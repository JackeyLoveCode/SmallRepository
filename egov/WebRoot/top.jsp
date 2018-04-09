<%@page pageEncoding="GB18030" 
   import="com.some.egov.beans.*"
   import="com.some.egov.utils.*"%>
<html>
	<head>
		<title></title>
		<meta content="text/html;charset='gb2312'"/>
	</head>
	<body>
		<font size="30" color="blue"><center>外汇业务管理平台</center></font>
		<%
			User user = (User)session.getAttribute("user");
		 %>
		<td align="right">当前登录用户：</td><span id="nameSpan"><%=user.getUsername() %></span>
		<td align="right">机构类型：<span><%=StringUtil.getStringByCode(user.getOrgtype()) %></span></td>
		<span align="right"><a href="/egov/servlet/logout" target="_top">退出</a></span>
	</body>
</html>