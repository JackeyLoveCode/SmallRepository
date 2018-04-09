<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'inputAuthorCode.jsp' starting page</title>
    <script type="text/javascript">
    	var xRequest;
    	function checkA_no(){
    		var a_no = document.getElementById("a_no").value;
    		if(a_no==""){
    			alert("核准件编号不能为空");
    			
    		}else{
    			if(window.XMLHttpRequest){
    				xRequest = new XMLHttpRequest();
    			}else if(window.ActiveXObject){
    				xRequest = new ActiveXObject("Microsoft.XMLHTTP");
    			}
    			xRequest.onreadystatechange = callback;
    			//xRequest.open("GET", "servlet/queryAuthor?a_no="+a_no, "true");
    			xRequest.open("GET", "aut_queryAuthor.action?_="+new Date().getTime()+"&a_no="+a_no, "true");
    			xRequest.send();
    		}
    	}
    	function callback(){
    				if(xRequest.readyState==4){
    					if(xRequest.status==200){
    						var authorInfo = document.getElementById("authorInfo");
    						authorInfo.innerHTML = xRequest.responseText;
    						var tbody = document.getElementById("buttonBody");
    						tbody.style.display="block";
    					}
    					else{
    						alert(xRequest.status);
    					}
    				}
    	}
    	function deleteAuthorInfo(){
    		var authorInfo = document.getElementById("authorInfo");
    		authorInfo.innerHTML="";
    		return ;
    	}
    	function feedback(){
    	
    		if(window.confirm("您确定要反馈吗？")){
    			document.forms["form"].submit();
    		}
    	}
    	function showMsg(){
    		if(${not empty msg }){
    			alert("${msg}");
    		}
    	}
    </script>
 	</head>
  
  <body onload="showMsg()">
  	<form action="aut_updateAuthor.action" method="POST" name="form">
    <table align="top">
    	<tr>
    		<td>核准件编号</td><td><input type="text" name="a_no"/></td>
    	</tr>
    	<tr>
    		<td><input type="button" value="查询" onclick="checkA_no()"/></td>
    		<td><input type="button" value="清除" /></td>
    	</tr>
    </table>
    </form>
    <div id="authorInfo"></div>
    <table width="800" height="100">
    <tbody style="display:none" id="buttonBody">
    <tr>
  	  
  	   <td>
  	   
  	   <input type="button" value="反馈" onclick="feedback()" id="button"/>
  	   
  	   </td>
  	   <td><input type="button" value="返回" onclick="deleteAuthorInfo()"/></td>
    </tr>
    </tbody>
    <tfoot></tfoot>
  </table>
  </body>
</html>
