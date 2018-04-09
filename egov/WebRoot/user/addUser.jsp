<%@page pageEncoding="utf-8"%>
<html>
  <head>
    <title>increament_user.jsp</title>
	
    <meta content="text/html;charset='utf-8'">
    <script>
    	function doSave(){
    		//校验用户提交表单参数
    		var ok = validateForm();
    		//如果OK，提交表单
    		if(ok){
    		document.forms[0].submit();
    		}
    		
    	}
    	function validateForm(){
    		var usercode = document.getElementById("usercode");
    		if(usercode.value==""){
    		alert("用户代码不能为空！");
    		usercode.focus();
    		return false;
    		}
    		var username = document.getElementById("username");
    		if(username.value==""){
    		alert("用户名不能为空！");
    		username.focus();
    		return false;
    		}
    		var userpawd = document.getElementById("userpawd");
    		if(userpawd.value==""){
    		alert("用户密码不能为空！");
    		userpawd.focus();
    		return false;
    		}
    		var checkpawd = document.getElementById("checkpawd");
    		if(checkpawd.value==""){
    		alert("确认密码不能为空！");
    		checkpawd.focus();
    		return false;
    		}
    		if(userpawd.value != checkpawd.value){
    		alert("两次密码输入不一致！，请重新输入");
    		userpawd.value = "";
    		checkpawd.value = "";
    		userpawd.focus();
    		return false;
    		}
    		var orgtype = document.getElementById("orgtype");
    		if(orgtype.value==""){
    		alert("机构类型不能为空！");
    		orgtype.focus();
    		return false;
    		}
    		return true;
    	}	
    	function checkUsercode(usercode){
    		
    		var xRequest;
    		if(window.XMLHttpRequest){
    			xRequest = new XMLHttpRequest();
    		}else if(window.ActiveXObject){
    			xRequest = new ActiveXObject();
    		}
    		xRequest.onreadystatechange= function(){
    			if(xRequest.readyState==4){
    				if(xRequest.status==200){
    					document.getElementById("usercodeSpan").innerHTML = xRequest.responseText;
    				}
    			}
    		}
    		xRequest.open("GET", "/egov/servlet/checkUsercode?_="+new Date().getTime()+"&usercode="+usercode, true);
    		xRequest.send();
    	}
    </script>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
  </head>
  <body >
  		<table border="1" >
        <form action="/egov/servlet/saveUser" method="POST" onsubmit="doSave()">
      
    <tr> 
    	<td>用户代码  <input type="text" name="usercode" id="usercode" onblur="checkUsercode(this.value)"/><span id="usercodeSpan"></span></td>
        
        
    <tr><br />
     <tr> 
    	<td>用户姓名 <input type="text" name="username" id="username"/></td> 
    <tr><br />
     <tr> 
    	<td>用户密码  <input type="password" name="userpawd" id="userpawd"/></td>
     
    <tr><br />
     <tr> 
    	<td>确认密码<input type="password" name="checkpawd" id="checkpawd"/></td>
        
        
    <tr><br />
     <tr> 
    	<td>机构类型 <select name="orgtype" id="orgtype">
    		<option name=""></option>
    		<option value="0" >外汇管理局</option>
    		<option value="1" >银行</option>
    	</select></td>
       
    <tr><br />
    <tr>
    	<td><input type="button" value="保存" onclick="doSave()"><&nbsp></td><td><input type="reset" value="清除"></td>
    </tr>
    <form>
    </table>
  </body>
</html>
