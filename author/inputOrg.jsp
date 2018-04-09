<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript">
    	function goSaveAuth(){
    		var orgcode = document.getElementById("orgcode");
    		if(orgcode.value == ""){
    			alert("组织机构代码不能为空！");
    		}
    		else{
    			document.forms["orgcodeForm"].submit();
    		}
    	}
    	function showMsg(){
    		if(${not empty msg}){
    			alert("${msg}");
    		}
    	}
    </script>
    <title>My JSP 'inputOrg.jsp' starting page</title>
  </head>
  
  <body onload="showMsg()">
  		<form action="aut_toEnDetail.action" method="POST" name="orgcodeForm">
		组织机构代码<input type="text" name="orgcode" id="orgcode"/>
		<input type="button" value="查询" style="cursor:hand" onclick="window.open('author/EnList.jsp','','width=1300,height=1000')"/>&nbsp&nbsp
		<input type="button" value="确定" style="cursor:hand" onclick="goSaveAuth();"/>
		</form>
  </body>
</html>
