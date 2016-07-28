<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户登录</title> 
<script type="text/javascript">
	function getCookie(cname){ 
			var name = cname + "=";
		var ca = document.cookie.split(';');
		for(var i=0; i<ca.length; i++) {
		var c = ca[i].trim();
	 	 	if (c.indexOf(name)==0) return c.substring(name.length,c.length);
	  	}
		return "";
	}
	function setPass(){
		var pass=document.getElementById(
		"userPass");
		pass.value=getCookie("cookieInfo");
	}
	function toSubmit(){
		document.getElementById("_s").value=document.getElementById("userName").value;
		document.getElementById("myForm").submit();
	}
	function logout(){
		document.getElementById("_s").value=document.getElementById("userName").value;
		document.getElementById("myForm").action="user/logout.action";
		document.getElementById("myForm").submit();
	}
</script>
	


</head>
<body onload="setPass()">
	<form id="myForm" method="post" action="login/login.action">
		<table>
			<tr>
				<td>用户名：</td>

				<td><input type="text" name="userName" id="userName"><input type="hidden" id="_s" name="_s"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name="userPass" id="userPass"></td>
			</tr>
			<tr>
				<td>记住密码</td>
				<td><input type="checkbox" name="remember"></td>
			</tr>
			<tr>
				<td><input type="button" onclick="toSubmit()" value="登录"></td>
				<td><input type="button" name="register" onclick="logout()" value="注册"></td>
			</tr>
		</table>
	</form>
	<div>
	</div>
</body>
</html>