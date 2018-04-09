<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<script src="js/form.js"></script>
	<script type="text/javascript">
		function doSave(){
			var ok = validateForm();
			if(ok){
				document.forms["InvForm"].submit();
			}
		}
		function validateForm(){
			var $ = new EGOVUtil();
			return $.isNull([new FormItem("投资人名称","investor_name"),new FormItem("所属国家/地区","country")])
		}
	</script>
  </head>
  
  <body>
  	<form action="inv_save.action" name="InvForm" method="POST">
    	<table align="left" height="450">
    		<tr bgcolor=""></tr>
    		<tr>
    			<td>投资人名称</td><td><input type="text" name="investor_name" id="investor_name"/></td>
    		</tr>
    		<tr>
    			<td>所属国家/地区</td><td>
    			
    			<select name="country" id="country">
    				<option value="">--请选择--</option>
    				<option value="000">中国</option>
    				<option value="001">英国</option>
    				<option value="002">美国</option>
    				<option value="003">日本</option>
    			</select>
    			
    			</td>
    		</tr>
    		<tr>
    			<td>组织机构代码</td><td><input type="text" name="org_code"/></td>
    		</tr>
    		<tr>
    			<td>联系人</td><td><input type="text" name="contact"/></td>
    		</tr>
    		<tr>
    			<td>联系电话</td><td><input type="text" name="contact_pho_num"/></td><td>电子信箱</td><td><input type="text"/></td>
    		</tr>
    		<tr>
    			<td>备注</td><td><input type="text" name="note"/></td>
    		</tr>
    		<tr>
    			<td><input type="button" onclick="doSave()"/>保存</a></td><td><input type="button">清除</a></td>
    		</tr>
    	
    	
    	</table>
    </form>
  </body>
</html>
