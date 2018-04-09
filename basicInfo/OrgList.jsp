<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="com.some.egov.beans.*,com.some.egov.utils.*"
    import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="egov" uri="http://www.some.egov.jstl.fn"%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<script type="text/javascript">
	function pageQueryInv(){
		document.forms["InvForm"].submit();
	}
	function changePage(pageno){
		document.forms["InvForm"].action = "inv_pageQuery.action?pageno="+pageno;
		document.forms["InvForm"].submit();
	}
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/tcal.css" />
<script type="text/javascript" src="js/tcal.js"></script> 

</head>
<body>
	<table align="left" bgcolor="gray" height="30%" width="1000">
	<thead>
		<tr>
		<td color="blue" >企业投资人信息登记列表</td>
		</tr>
	</thead>
	<tbody>
		<form action="inv_pageQuery.action" method="POST" name="InvForm">
		<tr>
			<td>投资人登记编号<input type="text" name="investor_reg_code" value="${param.investor_reg_code }"/></td>
			<td>投资人名称<input type="text" name="investor_name" value="${param.investor_name }"/></td>
			<td>登记日期<input type="text" name="startDate" class="tcal" value="${param.startDate }" /></td><td>~<input type="text" name="endDate" class="tcal" value="${param.endDate }"/></td>
			
		</tr>
		<input type="hidden" name="url" value="/basicInfo/OrgList.jsp"/>
		<tr>
			<td><a href="basicInfo/OrgAdd.jsp" target="f3">新增</a></td><td><a href="">清除</a></td>
			<td><input type="button" value="查询" style="cursor:hand" onclick="pageQueryInv()"/></td>
		</tr>
		</form>
		</tbody>
		</table>
		<table align="left" bgcolor="gray" height="70%" width="1000">
		<thead>
			<td>序号</td><td>投资人登记编号</td><td>投资人名称</td><td>登记日期</td><td>国别</td><td>经办人</td>
		</thead>
		<tbody id="dataInvTable">
			   <c:if test="${not empty page }">
			   <c:forEach items="${page.list }" var="inv" varStatus="vs">
			   <tr>
			   <td>${vs.count }</td>
			  	<td><span style="cursor:hand" onclick="document.location='inv_viewInv.action?investor_reg_code=${inv.investor_reg_code }'">${inv.investor_reg_code }</span></td><td>${inv.investor_name }</td>
			  	<td>${inv.regdate }</td><td>${egov:getStringByCode(inv.country) }</td><td>${inv.user.username }</td>
		     </tr>
		      </c:forEach>
		      </c:if>
		</tbody>
		<tfoot>
		</tfoot>
			<tr>
			<td align="left">一共${page.totalSize }条记录,</td>&nbsp&nbsp&nbsp
			<td>当前${page.pageno }/${page.pageCount }页，</td>
			<td align="right">每页显示${page.perPageTotal }条记录</td>
			<c:choose>
				<c:when test="${page.pageCount == 1}">
					<td><img src="images/2.png" /></td>
					<td><img src="images/3.png"/></td>
					<td><img src="images/5.png"/></td>
					<td><img src="images/4.png"/></td>
				</c:when>
				<c:when test="${page.pageCount > 1 && page.pageno ==1 }">
					<td><img src="images/2.png" /></td>
					<td><img src="images/3.png"/></td>
					<td><img src="images/5D.png" style="cursor:pointer" onclick="changePage(${page.pageno+1})"/></td>
					<td><img src="images/4D.png" style="cursor:pointer" onclick="changePage(${page.pageCount})"/></td>
				</c:when>
				<c:when test="${page.pageCount > 1 && page.pageno ==page.pageCount }"> 
					<td><img src="images/2D.png" style="cursor:pointer" onclick="changePage(1)"/></td>
					<td><img src="images/3D.png" style="cursor:pointer" onclick="changePage(${page.pageno-1})"/></td>
					<td><img src="images/5.png"/></td>
					<td><img src="images/4.png"/></td>
				</c:when>
				<c:otherwise>
					<td><img src="images/2D.png" style="cursor:pointer" onclick="changePage(1)"/></td>
					<td><img src="images/3D.png" style="cursor:pointer" onclick="changePage(${page.pageno-1})"/></td>
					<td><img src="images/5D.png" style="cursor:pointer" onclick="changePage(${page.pageno+1})"/></td>
					<td><img src="images/4D.png" style="cursor:pointer" onclick="changePage(${page.pageCount})"/></td>
				</c:otherwise>
			</c:choose>
			
			<td> 转到第<input type="text" id="pageField" height="6px" maxlength="4px"/></td>
			<td><image src="images/5D.png" onclick="goPage()"/></td>
			<td>页</td>
		</tr>
	</table>
</body>
</html>