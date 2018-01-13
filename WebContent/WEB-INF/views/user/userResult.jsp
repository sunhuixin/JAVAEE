<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#detail").hide();
		var count = 0;
		$("#check").click(function() {
			if (count == 0) {
				$("#detail").show();
				count = count + 1;
			} else {
				$("#detail").hide();
				count = 0;
			}
			var url = "${pageContext.request.contextPath}/user/checkInterview";
			var iid = "${sessionScope.interview.iid}";
			var args = {
				"iid" : iid
			};
			$.get(url, args, function(data) {
				if (data == 0) {
					alert("ok")
				} else {
					alert("no")
				}
			})
		})
		$("#checkBefore").click(function() {
			if (count == 0) {
				$("#detail").show();
				count = count + 1;
			} else {
				$("#detail").hide();
				count = 0;
			}
		})
		$(".confirm").click(function() {
			var url = "${pageContext.request.contextPath}/user/confirmInterview";
			var iid = "${sessionScope.interview.iid}";
			var args = {"iid" : iid};
			$.get(url, args, function(data) {
				if (data == 0) {
					alert("确认成功")
						$("h2").hide();
				} else {
					alert("已经确认过了")
				}
			})
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
	<span>用户名：${sessionScope.user.userName}</span>
	<c:if test="${requestScope.flag}">操作成功！</c:if>
	<p />
	<c:if test="${!empty requestScope.error}">操作失败！</c:if>
	<p />
	<c:if test="${sessionScope.interview.checked==1}">
		<h2>
			你好${sessionScope.interview.resume.realName},你有一份新的面试通知
			<button id="check">查看详情</button>
		</h2>
	</c:if>
	<div>
		<a href="${pageContext.request.contextPath}/user/checkRecruit"><button>招聘信息</button></a>
		<p />
		<a href="${pageContext.request.contextPath}/user/resume"><button>我的简历</button></a>
		<p />
		<a href="${pageContext.request.contextPath}/index.jsp"><button>返回主页</button></a>
		<p />

		<c:if test="${!empty sessionScope.interview.resume}">
			<button id="checkBefore">往期面试</button>
		</c:if>
		<p id="detail">
			尊敬的用户:${sessionScope.interview.resume.realName},你有一份
			<c:if test="${empty sessionScope.interview.interviewer}">来自管理员${sessionScope.interview.admin.adminName}</c:if>
			<c:if test="${!empty sessionScope.interview.interviewer}">来自面试官:${sessionScope.interview.interviewer}</c:if>
			的面试通知, 请于
			<f:formatDate value="${sessionScope.interview.interviewTime}"
				pattern="yyyy年MM月dd日  HH时mm分ss"></f:formatDate>
			去[${sessionScope.interview.interviewPlace}]参加面试!
			<button class="confirm">确认参加</button>
		</p>
	</div>
</body>
</html>