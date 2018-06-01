<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style type="text/css">
span[class='textbox'] {
	width: 40px;
}
</style>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="../css/stu_infor_set.css" />
	<div style="margin-top: 5px; font-size: 15px;" id="main">
		<form method="post" action="selectStudent" id="ff">
			<label for="#collegeName">学院:</label> <select id="collegeName"
				name="collegeId" class="easyui-combobox"
				data-options="url:'/selectCollege',
				textField:'collegeName',
				valueField:'collegeId',
				editable:false"
				style="width: 160px;">
			</select> <label for="#className">班级:</label> <select id="className"
				name="classId" style="padding-left: 20px; width: 120px;"
				class="easyui-combobox"
				data-options="url:'/selectClasses',
				textField:'className',
				valueField:'classId',
				editable:false">
			</select> <label for="#sNo">学号:</label> <input type="text" id="sNo" name="sNo"
				class="easyui-textbox" placeholder="请输入学号" /> <label for="#sName">姓名:</label>
			<input type="text" id="sName" name="sName" class="easyui-textbox"
				placeholder="请输入姓名" /> <a  id="queryButton" class="easyui-linkbutton">查询</a>
		</form>
		<table id="tab" class="table table-bordered"
			style="text-align: center; table-layout: fixed; margin-top: 10px; font-size: 15px; margin-left: 5px;">
		</table>
		<script type="text/javascript" src="../js/stu_infor_set.js"></script>
</body>
</html>