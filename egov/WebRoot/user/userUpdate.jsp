<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="com.some.egov.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="/egov/js/form.js"></script>
<script type="text/javascript">
	function doUpdate(){
		var ok = validateForm();
		if(ok){
		document.forms["UserForm"].submit();
		}
		
	}
	function validateForm(){
		var item1 = new FormItem("用户姓名","username");
		var item2 = new FormItem("用户密码","userpawd");
		var item3 = new FormItem("确认密码","checkpawd");
		var item4 = new FormItem("机构类型","orgtype");
		var $ = new EGOVUtil();
		var FormItems = [item1,item2,item3,item4];
		return $.isNull(FormItems)&& $.isSame(item2,item3);
		
	}
	
	
	
</script>
</head>
<body>
	<%
		User user =(User) request.getAttribute("user");
	 %>
	 <table border="1" >
        <form action="/egov/servlet/updateUser" method="POST"  name="UserForm">
      <input type="hidden" name="pageno" value="<%=request.getParameter("pageno") %>"/>
    <tr> 
    	<td>用户代码  &nbsp&nbsp<span > <input type="hidden" name="usercode" value = "<%=user.getUsercode()%>" /></span></td>
        
        
    <tr><br />
     <tr> 
    	<td>用户姓名 <input type="text" name="username" id="username" value="<%=user.getUsername() %>" /></td> 
    <tr><br />
     <tr> 
    	<td>用户密码  <input type="password" name="userpawd" id="userpawd" value="<%=user.getUserpawd() %>"/></td>
     
    <tr><br />
     <tr> 
    	<td>确认密码<input type="password" name="checkpawd" id="checkpawd" value="<%=user.getUserpawd() %>"/></td>
        
        
    <tr><br />
     <tr> 
    	<td>机构类型 <select name="orgtype" id="orgtype">
    		<option name=""></option>
    		<option value="0" <%="0".equals(user.getOrgtype()) ? "selected":""%>>外汇管理局</option>
    		<option value="1" <%="1".equals(user.getOrgtype()) ? "selected":""%>>银行</option>
    	</select></td>
       
    <tr><br />
    <tr>
    	<td><input type="button" value="保存" onclick="doUpdate()">&nbsp</td><td><input type="reset" value="清除"></td>
    </tr>
    <form>
    </table>
	 
	 
	 
	 
	 
</body>
</html>