<%@page pageEncoding="GB18030" 
   import="com.some.egov.beans.*"
   import="com.some.egov.utils.*"%>
<%@ taglib prefix="egov" uri="http://www.some.egov.jstl.fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
 %>
<html>
	<head>
	<base href=<%=basePath %>>
		<title></title>
		<meta content="text/html;charset='gb2312'"/>
	</head>
	<body>
		<font size="30" color="blue"><center>���ҵ�����ƽ̨</center></font>
		
		<td align="right">��ǰ��¼�û���</td><span id="nameSpan">${user.username }</span>
		<td align="right">�������ͣ�<span>${egov:getStringByCode(user.orgtype) }</span></td>
		<span align="right"><a href="user_logout.action" target="_top">�˳�</a></span>
	</body>
</html>