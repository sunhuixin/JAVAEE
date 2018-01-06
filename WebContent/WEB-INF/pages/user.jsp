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
		$("li").mouseover(function() {
			$("li").css("background-color", "yellow")
		})

		$("li").mouseout(function() {
			$("li").css("background-color", "#cc6666")
		})
	})
	
	$(function(){
		$("select[name='departId']").change(function(){
			var dId = $(this).val();
			alert(dId)
			$.ajax({
				url:"${pageContext.request.contextPath}/user/findDepart",
				type:"post",
				dataType:"json",
				data:{dId:dId},
				success:function(data){
					alert(data);
					$("select[name='pId']").empty();
					$.each(data,function(idex,item){
						$("select[name='pId']").append("<option value="+item.pId+">"+item.pName+"</option>")
					})
					
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
		})
		
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
	margin-left: 200px;
	background-color: #cc6666;
	width: 200px;
	float: left;
}

#div2{
	margin-left: 500px;
	float: right;
}

</style>
</head>
<body>
	<div id="div1">
		<ul>
			<li><a>反馈</a></li>
			<li><a>查看简历</a></li>
			<li><a>修改密码</a></li>
			<li><a>其他</a></li>
			<li><a>退出</a></li>
		</ul>
	</div>
	<div id="div2">
	<table border="2px" cellspacing="0px" cellpadding="10px" >
		<tr>
			<td colspan="4" align="center">简历</td>
		</tr>
		<tr>
			<td>真实姓名</td>
			<td><input type="text"></td>
			<td>性别</td>
			<td><input type="radio">男<input type="radio">女</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text"></td>
			<td>学历</td>
			<td>
				<select>
					<option selected="selected">专科</option>
					<option>本科</option>
					<option>硕士</option>
					<option>博士</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>联系方式</td>
			<td><input type="text"></td>
			<td>e-mail</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td>应聘职位</td>
			<td>
				<select name="departId">
					<option selected="selected" value="0">部门</option>
					<c:forEach items="${requestScope.departs }" var="depart">
					<option value="${depart.dId }">${depart.dName }</option>
					</c:forEach>
				</select>
				<select name="pId">
					<option selected="selected">职位</option>
					<option value=""></option>
				</select>
			</td>
			<td>政治面貌</td>
			<td>
				<select>
					<option>群众</option>
					<option>团员</option>
					<option>党员</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>上份工作</td>
			<td><input type="text"></td>
			<td>工作经验</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td>期望薪资</td>
			<td>
				<select>
					<option>2000-3000元/月</option>
					<option>3000-4000元/月</option>
					<option>4000-5000元/月</option>
					<option>5000-6000元/月</option>
				</select>
			</td>
			<td>兴趣爱好</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="#">保存</a></td>
			<td colspan="2" align="center"><a href="#">返回</a></td>
		</tr>
	</table>
	</div>
</body>
</html>