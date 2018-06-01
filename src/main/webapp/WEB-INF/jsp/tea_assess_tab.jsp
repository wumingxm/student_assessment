<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生自我评价</title>
</head>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/addTeacherAssess" method="post" id="ff">
	<table class="table table-bordered"
		style="text-align: center; table-layout: fixed; margin-left:5px; margin-top: 5px;">
		<tr>
			<td><label for="tea_assess">被评价学生姓名:</label>
			<select id="tea_assess" class="easyui-combobox"  name="sNo" data-options="url:'/selectStudent2',textField:'sName',valueField:'sNo'" style="width:100px;margin-top"15px;">
			</select></td>
			<td></td>
		</tr>
		<tr>
			<td>评价项</td>
			<td>分值</td>
		</tr>
		<c:forEach items="${assessStandardList}" var="assessStandard" varStatus="as">
			<tr>
				<c:if test="${assessStandard.assessItemName!='学习能力'&&assessStandard.assessItemName!='运动与健康'}">
				<td><label>${assessStandard.assessItemName}:</label></td>
				<td>
					<select class="easyui-combobox formText" style="width: 150px; margin-top: 5px;" name="assessItemGrade${as.index}">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</td>
				</c:if>
			</tr>
		</c:forEach>
		<tr>
			<td><label for="stu_assesss_academicYeid="stu_assess_academicYear_la">评价学年:</label>
			</td>
			<td>
			<select class="easyui-combobox" id="stu_assess_academicYear"
					name="academicYear" style="width:150px;">
					<option>2014-2015</option>
					<option>2015-2016</option>
					<option>2016-2017</option>
					<option>2017-2018</option>
			</select>
			</td>
		</tr>
		<tr>
			<td><label for="stu_assess_term" id="stu_assess_term_la">评价学期:</label></td>
			<td><select class="easyui-combobox" id="stu_assess_term"
					name="term" style="width: 150px;">
					<option>1</option>
					<option>2</option>
				</select>
			</td>
		</tr>
	</table>
	<a type="submit" class="easyui-linkbutton" style="margin-left:660px;" id="btn">提交</a>
	</form>
</body>
<script type="text/javascript">
	$("#btn").click(function(){
		$("#ff").submit();
		alert("提交成功!");
	});

</script>
</html>