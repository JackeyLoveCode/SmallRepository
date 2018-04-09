<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	import="com.some.egov.utils.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href=<%=basePath%>>
    
    <title>My JSP 'EntAdd.jsp' starting page</title>
    <script type="text/javascript">
    	function addNewLine(inv_reg_code,investor_name,countryName){
    		//获得整个表格
    		var table = document.getElementById("Inv_Cap_ProTable");
    		//获取表格现有的总行数
    		var index = table.rows.length;
    		//在表格末尾添加一行
    		var tableRow = table.insertRow(index);
    		//给添加行设置id
    		tableRow.id = inv_reg_code;
    		//在添加行上添加单元格
    		var tableCell1 = tableRow.insertCell(0);
    		var tableCell2 = tableRow.insertCell(1);
    		var tableCell3 = tableRow.insertCell(2);
    		var tableCell4 = tableRow.insertCell(3);
    		var tableCell5 = tableRow.insertCell(4);
    		//给每一个单元格设置InnerHtml
    		tableCell1.innerHTML = '<div align="center"><input type="hidden" name="investor_reg_code" value="'+inv_reg_code+'"/>'+investor_name+'</div>';
    		tableCell2.innerHTML = '<div align="center"><input type="hidden" name="country" value="'+countryName+'"/>'+countryName+'</div>';
    		tableCell3.innerHTML = '<input type="text" name="reg_cap_con" onblur="computeCap()"/>';
    		tableCell4.innerHTML = '<input type="text" name="pro_dis"/>';
    		tableCell5.innerHTML = '<input type="button" style="cursor:hand" onclick="delRow('+inv_reg_code+')" value="删除"/>';
    	}
    	function delRow(inv_reg_code){
    		var table = document.getElementById("Inv_Cap_ProTable");
    		var tableRow = document.getElementById(inv_reg_code);
    		table.deleteRow(tableRow.rowIndex);
    	}
    	function computeCap(){
    		
			var regCapItems =  document.getElementsByName("reg_cap_con");
			var countryNames = document.getElementsByName("country");
			var totalRegCap = 0;
			var outRegCap = 0;
			for(var i=0;i<regCapItems.length;i++){
				var regCapItem = regCapItems[i];
				var countryName = countryNames[i];
				if(regCapItem.value!=""){
					if(countryName.value!="中国"){
						outRegCap += parseInt(regCapItem.value)
					}
					totalRegCap += parseInt(regCapItem.value);
				}
			}
			var reg_capital = document.getElementById("reg_capital");
			reg_capital.value = totalRegCap;
			var fore_reg_capital = document.getElementById("fore_reg_capital");
			fore_reg_capital.value = outRegCap;
			var out_cap_dis = document.getElementById("out_cap_dis");
			out_cap_dis.innerHTML = (outRegCap/totalRegCap*100).toFixed(2)+"%";
    	}
    	function saveEnt(){
    		document.forms["EntForm"].submit();
    	}
    </script>
  </head>
  <body>
  	<form action="ent_saveEnt.action" method="POST" name="EntForm">
	<table>
		<tr><font  color="blue"><center>企业基本信息</center></font></tr>
		<tr>
			<td>组织机构代码<input type="text" name="orgcode" readonly="readonly" value="${ent.orgcode }"/></td>
			<td>外汇登记证号<input type="text" name="foreign_reg_number" /></td> 
		</tr>
		<tr>
			<td>企业中文名称<input type="text" name="company_name_cn"/></td>
			<td>企业英文名称<input type="text" name="bus_english_name"/></td>
		</tr>
		<tr>
			<td>联系&nbsp&nbsp人<input type="text" name="contact"/></td>
			<td>联系电话<input type="text" name="contact_pho_num"/></td>
		</tr>
	</table>
	<hr>
	<table>
		<tr>
			<font color="blue"><center>企业资金情况信息</center></font>
		</tr>
		<tr>
			<td>注册资金<input type="text" id="reg_capital" readonly="readonly" name="reg_capital"/></td>
			<td>
				币种<select name="reg_curr">
					<option value="">--请选择--</option>
					<option value="000"/>人民币</option>
					<option value="001">美元</option>
					<option value="002">英镑</option>
					<option value="003">日元</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>外汇注册资本<input type="text" id="fore_reg_capital" readonly="readonly" name="fore_reg_capital"/></td>
			<td>外方出资比例<span id="out_cap_dis" align="center"></span>
		</tr>
	</table>
	<hr>
	<table id="Inv_Cap_ProTable">
		<tr align="center"><font color="blue">投资者资金及利润分配</font></tr>
		<tr>
			<td>投资者名称</td>
			<td>国别</td>
			<td>注册资本出资额</td>
			<td>利润分配比例</td>
			<td><input type="button" value="查询" style="cursor:hand" onclick="window.open('foreignExchange/EntList.jsp')"/></td>
		</tr>
	</table>
	<table>
		<tr>
			<td><input type="button" value="确定" style="cursor:hand" onclick="saveEnt()"/></td>
			<td><input type="button" value="返回" style="cursor:hand" onclick="document.location='foreignExchange/EntView.jsp'"/></td>
		</tr>
	</table>
	</form>
  </body>
</html>
