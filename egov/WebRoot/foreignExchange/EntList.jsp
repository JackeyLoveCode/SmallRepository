<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="com.some.egov.beans.*,com.some.egov.utils.*"
    import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function pageQueryInv(){
		document.forms["InvForm"].submit();
	}
	function changePage(pageno){
		document.forms["InvForm"].action = "/egov/servlet/pageQueryInv?pageno="+pageno;
		document.forms["InvForm"].submit();
	}
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/egov/css/tcal.css" />
<script type="text/javascript" src="/egov/js/tcal.js"></script> 
     <base href="<%=basePath%>">
</head>
<body>
	<table align="left" bgcolor="gray" height="30%" width="1000">
	<thead>
		<tr>
		<td color="blue" >企业投资人信息登记列表</td>
		</tr>
	</thead>
	<tbody>
		<form action="/egov/servlet/pageQueryInv" method="POST" name="InvForm">
		<tr>
			<td>投资人登记编号<input type="text" name="investor_reg_code" value="<%= request.getParameter("investor_reg_code")==null ? "":request.getParameter("investor_reg_code")%>"/></td>
			<td>投资人名称<input type="text" name="investor_name" value="<%= request.getParameter("investor_name")==null ? "":request.getParameter("investor_name")%>"/></td>
			<td>登记日期<input type="text" name="startDate" class="tcal" value="<%= request.getParameter("startDate")==null ? "":request.getParameter("startDate")%>" /></td><td>~<input type="text" name="endDate" class="tcal" value="<%= request.getParameter("endDate")==null ? "":request.getParameter("endDate")%>"/></td>
			
		</tr>
		<input type="hidden" name="url" value="/foreignExchange/EntList.jsp"/>
		<tr>
			<td></td><td><a href="">清除</a></td>
			<td><input type="button" value="查询" style="cursor:hand" onclick="pageQueryInv()"/></td>
		</tr>
		</form>
		</tbody>
		</table>
		<table align="left" bgcolor="gray" height="70%" width="1000">
		<thead>
			<td>序号</td><td>投资人登记编号</td><td>投资人名称</td><td>登记日期</td>><td>经办人</td>
		</thead>
		<tbody id="dataInvTable">
		
			
			<%
				Page page1 =(Page) request.getAttribute("page");
				Integer pageno = 0;
				Integer pageCount = 0;
				Integer totalSize = 0;
				Integer perPageTotal = 0;
				List<Investor> investorList = null;
				if(page1!=null){
				pageno = page1.getPageno();
				pageCount = page1.getPageCount();
				totalSize = page1.getTotalSize();
				perPageTotal = page1.getPerPageTotal();
				investorList = page1.getList();
			    }
			    int i =0;
			    if(investorList!=null){
			 	for(Investor inv:investorList){
				
			   %>
			   <tr>
			   <td><%=++i %></td>
			  	<td><span style="cursor:hand" onclick="window.opener.addNewLine('<%=inv.getInvestor_reg_code() %>','<%=inv.getInvestor_name() %>','<%=StringUtil.getStringByCode(inv.getCountry()) %>')"><%=inv.getInvestor_reg_code() %></span></td><td><%=inv.getInvestor_name() %></td>
			  	<td><%=inv.getRegdate() %></td><td><%=inv.getUsername() %></td>
			  <%
			  	}
			  	}
			   %>
		     </tr>
		</tbody>
		<tfoot>
		</tfoot>
		<%
			boolean isFirstPage ;
			isFirstPage =pageno == 1 ? true:false;
			boolean isLastPage ;
			isLastPage = pageno == pageCount ? true:false;
		 %>
		<tr>
			<td align="left">一共<%=totalSize %>条记录,</td>&nbsp&nbsp&nbsp
			<td>当前<%=pageno %>/<%=pageCount %>页，</td>
			<td align="right">每页显示<%=perPageTotal %>条记录</td>
			<td><img src="/egov/images/2<%=isFirstPage==true? "":"D" %>.png" <%=isFirstPage==true? "" : "style='cursor:pointer' onclick='changePage("+1+")'"   %> /></td>
			<td><img src="/egov/images/3<%=isFirstPage==true? "":"D" %>.png" <%=isFirstPage==true? "" : "style='cursor:pointer' onclick='changePage("+(pageno-1)+")'"   %>/></td>
			<td><img src="/egov/images/5<%=isLastPage==true? "":"D" %>.png"  <%=isLastPage==true? ""  : "style='cursor:pointer' onclick='changePage("+(pageno+1)+")'"   %>/></td>
			<td><img src="/egov/images/4<%=isLastPage==true? "":"D" %>.png"  <%=isLastPage==true? ""  : "style='cursor:pointer' onclick='changePage("+pageCount+")'"   %>/></td>
			<td> 转到第<input type="text" id="pageField" height="6px" maxlength="4px"/></td>
			<td><image src="/egov/images/5D.png" onclick="goPage()"/></td>
			<td>页</td>
		</tr>	 	
	</table>
</body>
</html>