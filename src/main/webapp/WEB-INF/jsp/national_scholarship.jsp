<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="base.jsp"/>
	<form  id="ff" action="selectNationScholarship" style="margin-top:10px;margin-left:20px;" method="post">
		<select class="easyui-combobox" name="collegeId" id="collegeName" data-options="url:'/selectCollege',
		textField:'collegeName',
		valueField:'collegeId'"
		style="width:120px;">
			<option>请选择学院</option>
		</select>
		<select class="easyui-combobox" name="classId" id="className" data-options="
			url:'/selectClasses',
			textField:'className',
			valueField:'classId'" style="margin-left:10px;width:120px;">
			<option>请选择班级</option>
		</select>
		<a class="easyui-linkbutton" onclick="submit();">开始评选</a>
		<br/>
		<c:if test="${student!=null}">
			<h3>评选结果:${student.sName}</h3>
		</c:if>
	</div>
</body>
</html>