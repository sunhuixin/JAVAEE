<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function(){
			$()
		})
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
	<style>
		body{
			background-image: url(${pageContext.request.contextPath}/image/01.jpg);
			background-repeat:no-repeat;
			background-position: center;
			background-attachment:fixed;
			background-size: cover;
		}
	</style>
</head>
<body>
	<div align="center" style=" margin-top: 100px">
		<form action="${pageContext.request.contextPath}/user/addUser">
			<table>
				<tr>
					<td style="font-size: 30px">注册</td>
				</tr>
				<tr></tr>
				<tr>
					<td><input type="text" value="请输入用户名" name="userName" size="30px"/></td>
				</tr>
				<tr></tr>
				<tr>
					<td><input type="password" value="请输入密码" name="password1" size="30px"/></td>
				</tr>
				<tr></tr>
				<tr>
					<td><input type="password" value="请确认密码" name="password2" size="30px"/></td>
				</tr>
				<tr></tr>
				<tr>
					<td><input type="submit" value="提交" size="30px"></td>
				</tr>
			</table>
			
		</form>
	</div>

</body>
</html>