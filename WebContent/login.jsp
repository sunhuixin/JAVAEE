<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function(){
			$("input[name='userName']").blur(function(){
				var name=$(this).val();
				$.ajax({
					url:"${pageContext.request.contextPath}/user/findUserByName",
					type:"post",
					dataType:"text",
					data:{name:name},
					success:function(data){
						if(data==0){
							$("span").text("该用户不存在！");
						}else{
							$("span").text("");
						}
					}
				})
			})
		})
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
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
<body >
	<div align="center" style=" margin-top: 100px">
	<form action="${pageContext.request.contextPath}/user/findUserByNameAndPassword" method="post">
		<table>
			<tr><td style="font-size:30px;color:red;text-align: center;">欢迎使用人力资源管理系统！</td></tr>
			<tr>
				<td><input type="text" name="userName" size="30"><span style="color:red"></span></td>
			</tr>
			<tr>
				<td><input type="password" name="password" size="30" ></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录" size="20px" style=" text-align: center;"></td>
				
			</tr>
			<tr>
				<td><input type="reset" value="取消" size="20px" style=" text-align: center;"></td>
			</tr>
			<tr>
				<td style="color: red">快来加入我们吧！<a
					href="${pageContext.request.contextPath }/user/toRegister"
					style="color: yellow; font-size: 25px ; font-style: italic;">注册</a></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>