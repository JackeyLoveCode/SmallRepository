<%@page pageEncoding='utf-8'%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
 %>
<html>
<head>

<base href=<%=basePath %>>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="js/form.js"></script>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	function doLogin(){
		
		var ok = validateForm();
		if(ok && pageLoad()){
			document.forms["userForm"].submit();
		}
	}
	function validateForm(){
		var orgtype_item = new FormItem("机构类型","orgtype");
		var usercode_item = new FormItem("用户代码","usercode");
		var userpawd_item = new FormItem("用户密码","userpawd");
		var ItemArr = [orgtype_item,usercode_item,userpawd_item];
		var $ = new EGOVUtil();
		return $.isNull(ItemArr);
		
	}
	function pageLoad(){
		if(${empty msg}){
			return true;
		}else {
			alert("${msg}");
			var usercode = document.getElementById("usercode");
			var userpawd = document.getElementById("userpawd");
			usercode.focus();
			usercode.value="";
			userpawd.focus();
			userpawd.value="";
			return false;
		}
	}
	// 刷新图片  
    function changeImg() {  
        var imgSrc = $("#imgObj");  
        var src = imgSrc.attr("src");  
        imgSrc.attr("src", changeUrl(src));  
    }  
    //为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳  
    function changeUrl(url) {  
        var timestamp = (new Date()).valueOf();  
        var index = url.indexOf("?",url);  
        if (index > 0) {  
            url = url.substring(0, url.indexOf(url, "?"));  
        }  
        if ((url.indexOf("&") >= 0)) {  
            url = url + "×tamp=" + timestamp;  
        } else {  
            url = url + "?timestamp=" + timestamp;  
        }  
        return url;  
    }  
</script>
</head>
<body onload="pageLoad()">
	<!-- <img alt="img" src="images/background.jpg" > -->
	<table color="gray" >
	<form action="user_login.action" method="POST" name="userForm">
	<tr>
		<td>机构类型</td><td><select id="orgtype" name="orgtype">
		<option value="0" selected="selected">外汇管理局</option>
		<option value="1">银行</option>
		</select></td>
	</tr><br>
	<tr>
		<td>用户代码</td><td><input type="text" name="usercode"  id="usercode"/></td>
	</tr><br>
	<tr>
		<td>用户密码</td><td><input  type="password" name="userpawd"  id="userpawd"/></td>
	</tr><br>
	<!-- <tr>
		<div class="form-group  col-lg-6">  
	    <label for="id" class="col-sm-4 control-label">  
	        验证码:  
	    </label>  
	    <div class="col-sm-8">  
	        <input type="text" id="code" name="code" class="form-control" style="width:250px;"/>  
	        <img id="imgObj" alt="验证码" src="user_validateCode.action" onclick="changeImg()"/>  
	        <a href="#" onclick="changeImg()">换一张</a>  
	    </div>  
      </div>  
	</tr> -->
	<tr>
		<td><input type="button" value="登录" onclick="doLogin()"> </td><td><input type="reset" value="重置"/></td>
	</tr><br>
	</form>
	</table>
</body>
</html>