<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function() {
		$("#li1").mouseover(function() {
			$("#li1").css("background-color", "yellow");
		})
		$("#li1").mouseout(function() {
			$("#li1").css("background-color", "#cc6666");
		})
		$("#li2").mouseover(function() {
			$("#li2").css("background-color", "yellow");
		})
		$("#li2").mouseout(function() {
			$("#li2").css("background-color", "#cc6666");
		})
		$("#li3").mouseover(function() {
			$("#li3").css("background-color", "yellow");
		})
		$("#li3").mouseout(function() {
			$("#li3").css("background-color", "#cc6666");
		})
		$("#li4").mouseover(function() {
			$("#li4").css("background-color", "yellow");
		})
		$("#li4").mouseout(function() {
			$("#li4").css("background-color", "#cc6666");
		})
		$("#li5").mouseover(function() {
			$("#li5").css("background-color", "yellow");
		})
		$("#li5").mouseout(function() {
			$("#li5").css("background-color", "#cc6666");
		})
		$("#li6").mouseout(function() {
			$("#li6").css("background-color", "#cc6666");
		})
		$("#li7").mouseout(function() {
			$("#li7").css("background-color", "#cc6666");
		})
	})
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
	<style type="text/css">
		body {
			background-image: url(${pageContext.request.contextPath}/image/01.jpg);
			background-repeat: no-repeat;
			background-position: center;
			background-attachment: fixed;
			background-size: cover;
	}
	#div1{
		background-color: #cc6666;
		position: absolute;
		height: 100%;
		
	}
	</style>
</head>
<body>
<div id="div1">
	<ul>
		<li id="li1"><a href="#">应聘管理</a></li>
		<li id="li2"><a href="#">部门职位</a></li>
		<li id="li3"><a href="#">培训管理</a></li>
		<li id="li4"><a href="#">员工管理</a></li>
		<li id="li5"><a href="#">奖惩管理</a></li>
		<li id="li6"><a href="#">薪资管理</a></li>
		<li id="li7"><a href="#">退出</a></li>
	</ul>
</div>

</body>
</html>