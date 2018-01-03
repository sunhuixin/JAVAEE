<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="${pageConext.request.contextPath }/"></script>
	<script type="text/javascript">
		$(function(){
			$("input[name='userName']").blur(function(){
				var name=$(this).val();
				$.ajax({
					url:"${pageContext.request.contextPath}/findUserByName",
					type:"post",
					dataType:"text",
					
				})
			})
		})
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<form action="findUserByNameAndPassword" method="post">
		<table>
			<tr>
				<td><input type="text" name="userName" size="30"value="用户名"></td>
				<td><input type="text" name="password" size="30" value="密码"></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="submit" value="登录"></td>
				<td><input type="reset" value="取消"></td>
			</tr>
			<tr></tr>
			<tr>
				<td style="color: red">快来加入我们吧！<a
					href="${pageContext.request.contextPath }/toRegister"
					style="color: yellow; font-size: 20px;">注册</a></td>
			</tr>
		</table>
	</form>
</body>
</html>