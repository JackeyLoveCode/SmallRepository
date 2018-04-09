<%@ page language="java" import="java.util.*,com.some.egov.beans.*" pageEncoding="utf-8"%>
<%@ taglib prefix="egov" uri="http://www.some.egov.jstl.fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="egov" uri="http://www.some.egov.jstl.fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'EnDetail.jsp' starting page</title>

	<script type="text/javascript">
		function saveAppro(){
			document.forms["approForm"].submit();
		}
	</script>
  </head>
  
  <body>
  	<form action="aut_saveAuthor.action" method="POST" enctype="multipart/form-data" name="approForm">
	<table align="center" border="1px" bordercolor="blue" height="100" width="1000">
		<tr>
			<font color="blue"><center>资本金账户开户核准信息</center></font>
		</tr>
		<tr>
			<td>组织机构代码</td><td><span id="orgcode">${en.orgcode}</span>
			<input type="hidden" name="orgcode" value="${en.orgcode }"/>
			</td>
			<td>企业中文名称</td>
			<td><span id="company_name_cn">${en.company_name_cn }</span>
			</td>
		</tr>
		<tr>
			<td>限额币种</td>
			<td><span id="reg_curr">${egov:getStringByCode2("cur.",en.reg_curr)}</span></td>
			<input type="hidden" name="reg_curr" value="${en.reg_curr }">
			<td>账户限额</td>
			<td>
			<span id="reg_capital">${en.reg_capital }</span>
			<input type="hidden" name="reg_capital" value="${en.reg_capital}"/>
			</td>
		</tr>
	</table>
	<table align="center" border="1px" bordercolor="blue" height="100" width="1000">
		<tr><font color="blue"><center>核准件其他信息</center></font></tr>
		<tr>
			<td>联系人</td><td><input type="text" name="contact"/></td><td>联系电话</td><td><input type="text" name="contact_pho_num"/></td>
		</tr>
		<tr>
			<td>备注</td><td><input type="text" name="note" style="width:400;height:60"/></td>
		</tr>
	</table>
	<table align="center" border="1px" bordercolor="blue" height="100" width="1000">
		<tr>
			<font color="blue"><center>文件信息</center></font>
		</tr>
		<tr>
			<td>验资文件</td><td><input type="file" name="upload"/></td>
		</tr>
		<tr>
			<td>备注</td><td><input type="text" name="file_remark" height="200px" width="800px" style="width:400;height:60"/></td>
		</tr>
		<tr>
			<td><input type="button" value="确定" align="middle" onclick="saveAppro()" style="cursor:hand"/></td><td><input type="button" value="返回" align="middle" style="cursor:hand" onclick="window.location.href='/egov-02/author/inputOrg.jsp'"/></td>
		</tr>
	 </table>
	</form>	
		
  </body>
</html>
