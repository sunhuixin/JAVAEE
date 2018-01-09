<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function(){
			$("input[name='password1']").change(function(){
				var password = $(this).val();
				
			})
		})
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
	<style type="text/css">
		body {
			background-image: url(${pageContext.request.contextPath}/image/01.jpg);
			background-repeat: no-repeat;
			background-position: center;
			background-attachment: fixed;
			background-size: cover;
 		}
	</style>
</head>
<body>
	<form action="toUpdatePassword" method="post">
	<table>
		<tr>
			<td colspan="2" style="font-size:25px;">修改密码</td>
		</tr>
		<tr>
			<td>原始秘密</td>
			<td><input type="password" name="password1"></td>
		</tr>
		<tr>
			<td>新密码</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td><input type="password" name="password"></td>
		</tr>
	</table>
</form>
</body>
</html>