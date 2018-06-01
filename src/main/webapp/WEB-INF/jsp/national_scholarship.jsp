<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="base.jsp" />
	<h2 style="margin-left:15px;">国家奖学金评选</h1>
	<form id="ff"
		style="margin-top: 10px; margin-left: 20px;" method="post" class="form-inline">
		 <div class="form-group">
		 	 <label for="className">班级：</label>
			 <select class="easyui-combobox" name="classId" id="className"
				data-options="
				url:'/selectClasses',
				textField:'className',
				valueField:'classId'"
				style="margin-left: 10px; width: 120px;">
		</select> 
		 </div>
		 <div class="form-group">
			<a  type="button" class="btn btn-primary" class="form-control" id="sub">开始评选</a> 
		 </div>
		 <h3 id="result"></h3>
	</form>
	<h3 style="margin-left:20px;" id="result"></h3>
		</div>
		<script type="text/javascript" src="../js/national_scholarship.js"></script>
</body>
</html>