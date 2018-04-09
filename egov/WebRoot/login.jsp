<%@page pageEncoding='utf-8'%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
 %>
<html>
<head>

<base href=<%=basePath %>>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="/egov/js/form.js"></script>
<script type="text/javascript">
	function doLogin(){
		
		var ok = validateForm();
		if(ok){
			document.forms["userForm"].submit();
		}
	}
	function validateForm(){
		var orgtype_item = new FormItem("机构类型","orgtype");
		var usercode_item = new FormItem("用户代码","usercode");
		var userpawd_item = new FormItem("用户密码","userpawd");
		var ItemArr = [orgtype_item,usercode_item,userpawd_item];
		var $ = new EGOVUtil();
		return $.isNull(ItemArr);
		
	}
	function pageLoad(){
		
	<%
		String errorMSG =(String) request.getAttribute("errorMSG");
		if(errorMSG!=null){
    %> 
        alert("<%=errorMSG %>");
    <%
		}
		
	%>
	}
</script>
</head>
<body onload="pageLoad()">
	<!-- <img alt="img" src="images/background.jpg" > -->
	<table color="gray" >
	<form action="/egov/servlet/login" method="POST" name="userForm">
	<tr>
		<td>机构类型</td><td><select value="--请选择--" id="orgtype" name="orgtype">
		<option value="0" selected="selected">外汇管理局</option>
		<option value="1">银行</option>
		</select></td>
	</tr><br>
	<tr>
		<td>用户代码</td><td><input type="text" name="usercode" value="001" id="usercode"/></td>
	</tr><br>
	<tr>
		<td>用户密码</td><td><input  type="password" name="userpawd" value="123" id="userpawd"/></td>
	</tr><br>
	<tr>
		<td><input type="button" value="登录" onclick="doLogin()"> </td><td><input type="reset" value="重置"/></td>
	</tr><br>
	</form>
	</table>
</body>
</html>