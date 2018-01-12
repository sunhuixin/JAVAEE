<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	})
	
	$(function(){
		$("select[name='dId']").change(function(){
			var dId = $(this).val();
			$.ajax({
				url:"${pageContext.request.contextPath}/user/findDepart",
				type:"post",
				dataType:"json",
				data:{dId:dId},
				success:function(data){
					$("select[name='pId']").empty();
					$("select[name='pId']").append("<option value="+0+">职位</option>")
					$.each(data,function(idex,item){
						$("select[name='pId']").append("<option value="+item.pid+">"+item.pname+"</option>")
					})
					
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
		})
		
	})
	$(function(){
		var table = $("table");
		var resume = ${empty requestScope.resume };
		if(resume == true){
			table.hide();
		}
	})
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游客页面</title>
<style>
body {
	background-image: url(${pageContext.request.contextPath}/image/01.jpg);
	background-repeat: no-repeat;
	background-position: center;
	background-attachment: fixed;
	background-size: cover;
}

#div1{
	background-color: #cc6666;
	height:100%;	
	position: absolute;
	width: 200px;
	float: left;
	
	
}

#div2{
	margin-left: 500px;
	
}

</style>
</head>
<body>
	<div id="div1">
		<ul>
			<li id="li1"><a href="#">反馈</a></li>
			<li id="li2"><a href="${pageContext.request.contextPath}/resume/findResume?userId=${sessionScope.user.userId}">查看简历</a></li>
			<li id="li3"><a href="${pageContext.request.contextPath}/user/updatePassword?password=${sessionScope.user.password}&userId=${sessionScope.user.userId}">修改密码</a></li>
			<li id="li4"><a href="${pageContext.request.contextPath}/recruit/findAll">查看招聘信息</a></li>
			<li id="li5"><a href="#">退出</a></li>
		</ul>
	</div>
	
	<div id="div2">
	<form action="addResume" method="post">
	<input type="hidden" name="id" value="${requestScope.resume.id }">
	<input type="hidden" name="userId" value="${requestScope.resume.userId }">
	<table border="2px" cellspacing="0px" cellpadding="10px" >
		<tr>
			<td colspan="4" align="center" style="font-size: 20px">简历</td>
		</tr>
		<tr>
			<td>真实姓名</td>
			<td><input type="text" name="realName"value="${requestScope.resume.realName }"></td>
			<td>性别</td>
			
			<td>
				<c:if test="${requestScope.resume.gender == '男' }">
				<input type="radio"name="gender"value="${requestScope.resume.gender }" checked="checked">男
				<input type="radio" name="gender"value="女">女
				</c:if>
				<c:if test="${requestScope.resume.gender  == '女' }">
				<input type="radio"name="gender"value="男">男
				<input type="radio" name="gender"value="${requestScope.resume.gender }"  checked="checked">女
				</c:if>
			</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="age"value="${requestScope.resume.age }"></td>
			<td>学历</td>
			<td>
				<select name="degree">
					<c:if test="${requestScope.resume.degree=='专科' }">
					<option selected="selected"value="${requestScope.resume.degree}">专科</option>
					<option value="本科">本科</option>
					<option value="硕士">硕士</option>
					<option value="博士">博士</option>
					</c:if>
					<c:if test="${requestScope.resume.degree=='本科' }">
					<option value="专科">专科</option>
					<option value="${requestScope.resume.degree}" selected="selected">本科</option>
					<option value="硕士">硕士</option>
					<option value="博士">博士</option>
					</c:if>
					<c:if test="${requestScope.resume.degree=='硕士' }">
					<option value="专科">专科</option>
					<option value="本科" >本科</option>
					<option value="${requestScope.resume.degree}" selected="selected">硕士</option>
					<option value="博士">博士</option>
					</c:if>
					<c:if test="${requestScope.resume.degree=='博士' }">
					<option value="专科">专科</option>
					<option value="本科" >本科</option>
					<option value="硕士" >硕士</option>
					<option value="${requestScope.resume.degree}" selected="selected">博士</option>
					</c:if>
				</select>
			</td>
		</tr>
		<tr>
			<td>联系方式</td>
			<td><input type="text" name="phoneNumber"value="${requestScope.resume.phoneNumber}"></td>
			<td>e-mail</td>
			<td><input type="text" name="email"value="${requestScope.resume.email}"></td>
		</tr>
		<tr>
			<td>应聘职位</td>
			<td>
				<select name="dId">
					<option selected="selected" value="0">部门</option>
					<c:forEach items="${requestScope.departs }" var="depart">
					<c:if test="${requestScope.resume.depart.dId==depart.dId}">
					<option value="${depart.dId }" selected="selected">${depart.dName }</option>
					</c:if>
					<c:if test="${requestScope.resume.depart.dId!=depart.dId}">
					<option value="${depart.dId }">${depart.dName }</option>
					</c:if>
					</c:forEach>
				</select>
				<select name="pId">
					<option>职位</option>
					<option value="${requestScope.resume.position.pid }"selected="selected">${requestScope.resume.position.pname }</option>
				</select>
			</td>
			<td>政治面貌</td>
			<td>
				<select name="politicalStatus">
					<c:if test="${requestScope.resume.politicalStatus=='群众'}">
					<option value="${requestScope.resume.politicalStatus}"selected="selected">群众</option>
					<option value="团员">团员</option>
					<option value="党员">党员</option>
					</c:if>
					<c:if test="${requestScope.resume.politicalStatus=='团员'}">
					<option value="群众">群众</option>
					<option value="${requestScope.resume.politicalStatus}"selected="selected">团员</option>
					<option value="党员">党员</option>
					</c:if>
					<c:if test="${requestScope.resume.politicalStatus=='党员'}">
					<option value="群众">群众</option>
					<option value="团员">团员</option>
					<option value="${requestScope.resume.politicalStatus}"selected="selected">党员</option>
					</c:if>
				</select>
			</td>
		</tr>
		<tr>
			<td>上份工作</td>
			<td><input type="text" name="lastJob" value="${requestScope.resume.lastJob}"></td>
			<td>工作经验</td>
			<td><input type="text" name="workExpirence" value="${requestScope.resume.workExpirence}"></td>
		</tr>
		<tr>
			<td>期望薪资</td>
			<td>
				<select name="expectedSalary">
					<c:if test="${requestScope.resume.expectedSalary=='2000-3000'}">
					<option value="${requestScope.resume.expectedSalary}"selected="selected">2000-3000元/月</option>
					<option value="3000-4000元/月">3000-4000元/月</option>
					<option value="4000-5000元/月">4000-5000元/月</option>
					<option value="5000-6000元/月">5000-6000元/月</option>
					</c:if>
					<c:if test="${requestScope.resume.expectedSalary=='3000-4000'}">
					<option value="2000-3000元/月">2000-3000元/月</option>
					<option value="${requestScope.resume.expectedSalary}"selected="selected">3000-4000元/月</option>
					<option value="4000-5000元/月">4000-5000元/月</option>
					<option value="5000-6000元/月">5000-6000元/月</option>
					</c:if>
					<c:if test="${requestScope.resume.expectedSalary=='4000-5000'}">
					<option value="2000-3000元/月">2000-3000元/月</option>
					<option value="3000-4000元/月">3000-4000元/月</option>
					<option value="${requestScope.resume.expectedSalary}"selected="selected">4000-5000元/月</option>
					<option value="5000-6000元/月">5000-6000元/月</option>
					</c:if>
					<c:if test="${requestScope.resume.expectedSalary=='5000-6000'}">
					<option value="2000-3000元/月">2000-3000元/月</option>
					<option value="3000-4000元/月">3000-4000元/月</option>
					<option value="4000-5000元/月">4000-5000元/月</option>
					<option value="${requestScope.resume.expectedSalary}"selected="selected">5000-6000元/月</option>
					</c:if>
				</select>
			</td>
			<td>兴趣爱好</td>
			<td><input type="text" name="hobby" value="${requestScope.resume.hobby}"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="保存"></td>
		
			<td colspan="2" align="center"><a href="${pageContext.request.contextPath }/resume/return">退出</a></td>
		</tr>
	</table>
		</form>
	</div>
	

</body>
</html>