<%@ page language="java" 
         import="java.util.*,com.some.egov.beans.*" 
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function pageQueryEn(){
  			document.forms["EnForm"].submit();
  		}
  		function changePage(pageno){
  			document.forms["EnForm"].action="servlet/pageQueryEn?pageno="+pageno;
  			document.forms["EnForm"].submit();
  		}
  	</script>
    <base href="<%=basePath%>">
    
    <title>My JSP 'EnList.jsp' starting page</title>
  </head>
  
  <body>
	<table align="left" bgcolor="gray" height="30%" width="1000">
	<thead>
		<tr>
		<td color="blue" >外商投资企业列表</td>
		</tr>
	</thead>
	<tbody>
		<form action="ent_pageQuery.action" method="POST" name="EnForm">
		<tr>
			<td>组织机构代码<input type="text" name="orgcode" value="${param.orgcode }"/></td>
			<td>企业中文名称<input type="text" name="company_name_cn" value="${param.company_name_cn }"/></td>
			<td>登记日期<input type="text" name=startDate class="tcal" value="${param.startDate }" /></td><td>~<input type="text" name="endDate" class="tcal" value="${param.endDate }"/></td>
		</tr>
		<input type="hidden" name="url" value="/author/EntList.jsp"/>
		<tr>
		<td><input type="button" value="查询" onclick="pageQueryEn()"/></td>
		<td><input type="button" value="清除" /></td>
		</tr>
		</form>
	</tbody>
	<!-- <table align="center" bgcolor="gray" height="70%" width="1000"> -->
		<tr>
			<td>序号</td><td>组织机构代码</td><td>企业中文名称</td><td>登记日期</td>><td>经办人</td><td>投资比例</td>
		</tr>
		<tbody id="dataInvTable">
		
		   <c:if test="${not empty page }">
		   <c:forEach items="${page.list }" var="en" varStatus="enStatus">
		   <tr>
		   <td>${enStatus.count }</td>
		  	<td><span style="cursor:hand" onclick="window.opener.document.all.orgcode.value='${en.orgcode }';window.close()">${en.orgcode }</span></td><td>${en.company_name_cn }</td>
		  	<td>${en.regdate }</td><td>${en.user.username }</td>
		  </tr>
		  </c:forEach>
		  </c:if>
		</tbody>
		<tfoot></tfoot>
		<tr>
			<td align="left">一共${page.totalSize }条记录,</td>&nbsp&nbsp&nbsp
			<td>当前${page.pageno }/${page.pageCount }页，</td>
			<td align="right">每页显示${page.perPageTotal }条记录</td>
			<c:choose>
				<c:when test="${page.pageCount <= 1}">
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
