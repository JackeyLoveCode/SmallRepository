<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
			return $.isNull([new FormItem("Ͷ��������","investor_name"),new FormItem("��������/����","country")])
		}
	</script>
  </head>
  
  <body>
  	<form action="servlet/saveInvInfo" name="InvForm" method="POST">
    	<table align="left" height="450">
    		<tr bgcolor=""></tr>
    		<tr>
    			<td>Ͷ��������</td><td><input type="text" name="investor_name" id="investor_name"/></td>
    		</tr>
    		<tr>
    			<td>��������/����</td><td>
    			
    			<select name="country" id="country">
    				<option value="">--��ѡ��--</option>
    				<option value="000">�й�</option>
    				<option value="001">Ӣ��</option>
    				<option value="002">����</option>
    				<option value="003">�ձ�</option>
    			</select>
    			
    			</td>
    		</tr>
    		<tr>
    			<td>��֯��������</td><td><input type="text" name="org_code"/></td>
    		</tr>
    		<tr>
    			<td>��ϵ��</td><td><input type="text" name="contact"/></td>
    		</tr>
    		<tr>
    			<td>��ϵ�绰</td><td><input type="text" name="contact_pho_num"/></td><td>��������</td><td><input type="text"/></td>
    		</tr>
    		<tr>
    			<td>��ע</td><td><input type="text" name="note"/></td>
    		</tr>
    		<tr>
    			<td><input type="button" onclick="doSave()"/>����</a></td><td><input type="button">���</a></td>
    		</tr>
    	
    	
    	</table>
    </form>
  </body>
</html>
