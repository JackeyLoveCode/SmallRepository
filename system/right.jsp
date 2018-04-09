<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.util.*"
    import="com.some.egov.beans.*"
    import="com.some.egov.utils.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=basePath %>>
<meta http-equiv="Content-Type" content="text/html; charset='gb2312'">
<title>right</title>
<script type="text/javascript">
	function changePage(pageno){
		document.location="/egov-02/servlet/pageQuery?pageno="+pageno;
	}
	function goPage(){
		var pageFieldDomObg = document.getElementById("pageField");
		var pageField = pageFieldDomObg.value; 
		if(pageField==""){
		alert("页码不能为空！");
		pageFieldDomObg.focus();
		return ;
		}
		if(isNaN(pageField)){
			alert("输入的页码必须是数字！");
			pageField = "";
			pageFieldDomObg.focus();
			return ;
			
		}
		var pageno  = parseInt(pageField);
		if(pageno >4 ||pageno<1){
		alert("页码范围必须在[1,4]之间！");
		pageField = "";
		pageFieldDomObg.focus();
		return ;
		}
		changePage(pageno);
		
	}
	function changeImag(){
		
		var checkboxDomObjs = document.getElementsByName("checkbox");
		var checkboxCount = 0;
		var myCheckboxDomObg = document.getElementById("checkOrCancleAll");
		for(var i=0;i<checkboxDomObjs.length;i++){
			if(checkboxDomObjs[i].checked) checkboxCount++;
		}
		
		var userDeleteObg = document.getElementById("user_delete");
		var userUpdateObg = document.getElementById("user_edit");
		
		//一个也没选中
		if(checkboxCount==0){
			userDeleteObg.src="images/user_delete_disabled.png"; 
			userUpdateObg.src="images/user_edit_disabled.png";
			userDeleteObg.disabled=true;
			userUpdateObg.disabled=true;
			
		}
		
		//选中一个
		if(checkboxCount==1)
		{
			
			userDeleteObg.src="images/user_delete.png"; 
			userUpdateObg.src="images/user_edit.png";
			userDeleteObg.disabled=false;
			userUpdateObg.disabled=false;
		}
		//选中两个
		if(checkboxCount>=2){
			userDeleteObg.src="images/user_delete.png"; 
			userUpdateObg.src="images/user_edit_disabled.png";
			userDeleteObg.disabled=false;
			userUpdateObg.disabled=true;
		}
		
		if(checkboxCount==checkboxDomObjs.length){
			myCheckboxDomObg.checked = true;
		}else {
			myCheckboxDomObg.checked = false;
		}
		
		
	}
	function checkOrCancleAll2(){
		var myCheckboxDomObg = document.getElementById("checkOrCancleAll");
		var elets = document.getElementsByName("checkbox");
		if(myCheckboxDomObg.checked){
			for(var i=0;i<elets.length;i++){
				elets[i].checked = true;
			}
		changeImag();
		
		}else {
				for(var i=0;i<elets.length;i++){
				elets[i].checked = false;
			}
			changeImag();
		}
	}
	function goUpdate(){
		
		document.forms["userForm"].submit();
	}
	function goDelete(){
		if(window.confirm("您确定要删除吗？")){
			document.forms["userForm"].action = "servlet/deleteUser";
			document.forms["userForm"].submit();
		}
		
	}
</script>
</head>
<body onload="changeImag()">
	
	<%
		Page<User> pageObj =(Page) request.getAttribute("page");
		Integer totalSize = pageObj.getTotalSize();
		Integer pageno = pageObj.getPageno();
		int pageCount = pageObj.getPageCount();
		Integer perPageTotal = pageObj.getPerPageTotal();
		List<User> userList = pageObj.getList();
	 %>
	 <form action="servlet/goUpdate" method="POST" name="userForm">
	 <input type="hidden" name="pageno" value="<%=pageno%>"/>
	 <table align="left" bgcolor="gray"   width="1000px" height="200px">
	 	<tr>
	 	<td  align="right"><img  src="images/user_add.png" id ="user_add" style="cursor:pointer" 
	 	onclick="javascript:window.location.href='/egov-02/user/addUser.jsp'"/></td>
	 	<td  align="right"><img  src="images/user_delete_disabled.png" id="user_delete" style="cursor:pointer"
	 	onclick="goDelete()"/></td>
	 	<td  align="right"><img  src="images/user_edit_disabled.png" id="user_edit" style="cursor:pointer"
	 	onclick="goUpdate()"/></td>
	 	</tr>
	 	<tr>
	 		<th align="left"><input type="checkbox"  id="checkOrCancleAll" onclick="checkOrCancleAll2()"/></th>
	 		<th align="left">序号</th>&nbsp&nbsp
	 		<th align="left">用户代码</th>
	 		&nbsp&nbsp<th align="left">用户姓名</th>&nbsp&nbsp
	 		<th align="left">机构类型</th>&nbsp&nbsp<br>
	 	</tr>
	 	<%
	 		int i=0;
	 		for(User user :userList){
	 		
	 		%>
	 		<tr>
	 			<td><input type="checkbox" name="checkbox" value="<%=user.getUsercode() %>" onclick="changeImag()"/></td>
	 			<td><%=++i %></td>
	 			<td><%=user.getUsercode() %></td>
	 			<td><%=user.getUsername() %></td>
	 			<td><%=StringUtil.getStringByCode(user.getOrgtype()) %></td>
	 		</tr>
	 	<%
	 	   }
	 	   boolean isFirstPage = (pageno ==1);
	 	   boolean isLastPage = (pageno==pageCount);
	 	 %>
		<tr>
			<td align="left">一共<%=totalSize %>条记录,</td>&nbsp&nbsp&nbsp
			<td>当前<%=pageno %>/<%=pageCount %>页，</td>
			<td align="right">每页显示<%=perPageTotal %>条记录</td>
			<td><img src="images/2<%=isFirstPage==true? "":"D" %>.png" <%=isFirstPage==true? "" : "style='cursor:pointer' onclick='changePage("+1+")'"   %> /></td>
			<td><img src="images/3<%=isFirstPage==true? "":"D" %>.png" <%=isFirstPage==true? "" : "style='cursor:pointer' onclick='changePage("+(pageno-1)+")'"   %>/></td>
			<td><img src="images/5<%=isLastPage==true? "":"D" %>.png"  <%=isLastPage==true? ""  : "style='cursor:pointer' onclick='changePage("+(pageno+1)+")'"   %>/></td>
			<td><img src="images/4<%=isLastPage==true? "":"D" %>.png"  <%=isLastPage==true? ""  : "style='cursor:pointer' onclick='changePage("+pageCount+")'"   %>/></td>
			<td> 转到第<input type="text" id="pageField" height="6px" maxlength="4px"/></td>
			<td><image src="images/5D.png" onclick="goPage()"/></td>
			<td>页</td>
		</tr>	 	  
	 </table>
	 </form>
</body>
</html>