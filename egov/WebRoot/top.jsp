<%@page pageEncoding="GB18030" 
   import="com.some.egov.beans.*"
   import="com.some.egov.utils.*"%>
<html>
	<head>
		<title></title>
		<meta content="text/html;charset='gb2312'"/>
	</head>
	<body>
		<font size="30" color="blue"><center>���ҵ�����ƽ̨</center></font>
		<%
			User user = (User)session.getAttribute("user");
		 %>
		<td align="right">��ǰ��¼�û���</td><span id="nameSpan"><%=user.getUsername() %></span>
		<td align="right">�������ͣ�<span><%=StringUtil.getStringByCode(user.getOrgtype()) %></span></td>
		<span align="right"><a href="/egov/servlet/logout" target="_top">�˳�</a></span>
	</body>
</html>