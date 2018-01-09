<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$("select[name='dId']").change(function(){
		var dId = $(this).val();
		alert(dId);
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
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>招聘信息页面</title>
</head>
<body>
<c:forEach items="${requestScope.recruits }" var="recruit">
	<table border="2px" cellspacing="0px" cellpadding="10px">
		<tr>
			<td colspan="6"style="font-size:25px; text-align: center;">招聘信息</td>
			
		</tr>
		<tr>
			<td>工作地点</td>
			<td>${recruit.workPlace }</td>
			<td>发布时间</td>
			<td><f:formatDate value="${recruit.releaseTime }" pattern="yyyy-MM-dd"/></td>
			<td>工作性质</td>
			<td>${recruit.jobType }</td>
		</tr>
		<tr>
			<td>工作经验</td>
			<td>${recruit.workExperience }</td>
			<td>最低学历</td>
			<td>${recruit.minDegree }</td>
			<td>招聘人数</td>
			<td>${recruit.needNumber }</td>
		</tr>
		<tr>
			<td>职位类别</td>
			<td><select name="dId">
					<option selected="selected" value="0">部门</option>
					<c:forEach items="${requestScope.departs }" var="depart">
					<option value="${depart.dId }">${depart.dName }</option>
					</c:forEach>
				</select>
				<select name="pId">
					<option selected="selected">职位</option>
					<option ></option>
				</select></td>
			<td>职位描述</td>
			<td><textarea rows="3" cols="6" >${recruit.positionDecription }</textarea></td>
			<td>公司简介</td>
			<td><textarea rows="3" cols="6">${recruit.companyProfile }</textarea></td>
		</tr>
		<tr>
			<td colspan="3" style="text-align: center;"><a href="#">投递简历</a></td>
			<td colspan="3"  style="text-align: center;"><a href="#">取消</a></td>
		</tr>
	</table>
	</c:forEach>
</body>
</html>