<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'EntView.jsp' starting page</title>
    <script type="text/javascript">
    	function checkOrgcode(){
    		var ok  = validateForm();
    		if(ok){
    			document.forms["EntForm"].submit();
    		}
    	}
    	function validateForm(){
    	    var orgcode = document.getElementById("orgcode");
    	    if(orgcode.value==""){
    	    	alert("组织机构代码不能为空！");
    	    	orgcode.focus();
    	    	orgcode.value="";
    	    	return false;
    	    }
    	    	return true;
    	}
    	function pageLoad(){
    		if(${not empty errorMsg}){
    			alert("${errorMsg}");
    		}
    		else if(${not empty msg}){
    			alert("${msg}");
    		}
    		
    	}
    </script>
  </head>
  
  <body onload="pageLoad()">
	<form action="ent_checkOrgcode.action" method="POST" name="EntForm">
		<font>组织机构代码</font><input type="text" name="orgcode" id="orgcode"/><input type="button" value="确定" onclick="checkOrgcode()"/>
	</form>
  </body>
</html>
