<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
	$(function(){	
		$("#correct").hide();
		$("#error").hide();
		var zzUser=/^[a-zA-Z0-9_]{6,20}$/;
		var zzPw=/^[a-zA-Z][a-zA-Z0-9_]{5,20}$/;
		$("#name").blur(function() {
		var name =$(this).val();	
		if(zzUser.test(name)){
			var url ="${pageContext.request.contextPath}/user/checkSame";
			var args={"name":name};
			$.get(url,args,function(data){
				if(data==0){
					$("#correct").show();
					$("#error").hide();
					$(".regist").removeAttr("disabled");
				}else{
					$("#error").show();
					$("#correct").hide();
					$(".regist").attr("disabled","disabled");
				}
			})
		}else{
			alert("请输入6-20位用户名,由字母或数字组成");
			$(".regist").attr("disabled","disabled");
			$("#error").show();
			$("#correct").hide();
		}
		
	})
		$(".login").click(function(){
			$("form").attr("action","${pageContext.request.contextPath}/user/login");
			var password =$(":password").val();
			if(password==""){
				alert("密码不能为空");
			}else{
			$("form").submit();
			}
		})
		$(".regist").click(function(){
			$("form").attr("action","${pageContext.request.contextPath}/user/regist");
			var password =$(":password").val();
			if(zzPw.test(password)){
				$("form").submit();
			}else{
				alert("请输入6-20位密码,由数字和字母组成,首写必须为字母");
			}
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
		#formD{
		position: absolute;left:50%;top:30%; 
		margin-left:-140px;
		margin-top: -100px;
		color: blue; 
		}
		td{
			text-align: center;
		}
	</style>
</head>
<body >
	<div id="formD">
	<form action="" method="post">
		<table  cellpadding="8" cellspacing="0">
		<tr><td colspan=2 style="font-size:30px;">欢迎使用人力资源系统</td></tr>
			<tr>
				<td align="right">用户名:</td>
				<td><input type="text" name="userName" id="name" size="30px" style="border-radius: 10px;"></td>
			</tr>
			<tr>
				<td align="right">密&nbsp;码:</td>
				<td><input type="password" name="password" width="100%" size="30px" style="border-radius: 10px;"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="注册" class="regist"  style="border-radius: 10px;"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="登录" class="login"  style="border-radius: 10px;"></td>
			</tr>
			<tr><td colspan=2><a href="${pageContext.request.contextPath}/admin/index">管理员登录</a></td></tr>
			<tr>
			<td style="color: red" id="error" colspan="2" align="center">x用户名已存在或者不可用</td>
			<td style="color: green" id="correct" colspan="2" align="center">用户名可用</td>
			</tr>
			<c:if test="${!empty requestScope.error}">
			<tr><td colspan="2" align="center">
				用户名:${requestScope.error.userName}&nbsp;密码:${requestScope.error.password}有误,请重新输入!
			</td></tr>
			</c:if>
		</table>
			
	</form>
	
</div>
</body>
</html>