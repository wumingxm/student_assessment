<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'base.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="../easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" href="../bootstrap-validator/vendor/bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" href="../bootstrap-validator/dist/css/bootstrapValidator.css"/>
<link rel="stylesheet" type="text/css" href="../css/base.css" />
<link rel="stylesheet" type="text/css" href="../css/stu_assess_tab.css">
</head>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="../bootstrap-validator/vendor/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../bootstrap-validator/dist/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
<body style="font-family: 华文楷体; font-size: 18px;">
	<div class="containerfluid">
		<div style="height:90px;widht:100%;" id="top" >
			<img src="../img/ydzy.jpg" id="logo" /> <span id="sysName"
				style="font-family:楷体;font-size:30px;"">延安大学学生评价管理系统</span> <span id="welcome" style="position:absolute;right:100px;top:10px;">欢迎${user.userName}登录！</span>
				<span id="exit" ><a href="/login">退出系统</a></span>
			<span id="time"></span>
		</div>
		<nav class="navbar navbar-default" role="navigation"
			style="margin-bottom:0;border:none;">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1" style="font-size:25px;background-color:rgb(193, 223, 179);">
			<ul class="nav navbar-nav">
				<li class="dropdown" id="index"><a class="dropdown-toggle"
					href="index.jsp" data-toggle="dropdown" >首页<strong class="caret"></strong></a>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" href="#" data-toggle="dropdown">用户管理
						<strong class="caret">
					</strong></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/selectUserDetialInformation?page=1&pageSize=10"
							id="his">用户基本信息管理</a></li>
						<li><a
							href="${pageContext.request.contextPath}/password_update">修改密码</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle" href="#"
					data-toggle="dropdown">学生管理<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/selectStudent?page=1&pageSize=8">学生基本信息管理</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle" href="#"
					data-toggle="dropdown">教师管理<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/selectTeacher">教师基本信息管理</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle" href="#"
					data-toggle="dropdown">课程基本信息管理<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/selectCourseSelect?page=1&pageSize=8">课程信息管理</a></li>
						<li><a
							href="${pageContext.request.contextPath}/selectCourseSelect?page=1&pageSize=8">学生成绩查询</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle" href="#"
					data-toggle="dropdown">评价标准管理<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/selectAssessStandard?page=1&pageSize=8">评价标准管理</a></li>
					</ul></li>
				<li class="dropdown">
					<a class="dropdown-toggle" href="#" data-toggle="dropdown">学生评价管理<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							<a  href="#" data-toggle="modal" data-target="#stuAssessDialogue">学生自我评价</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/generateAssessTab?page=1&pageSize=10">教师评价</a></li>
						<li><a
							href="${pageContext.request.contextPath}/selectFinalAssessment?page=1&pageSize=10">学生综合评价</a></li>
						<li>
							<a href="${pageContext.request.contextPath}/selectStudentAssessment">学生评价分析</a></li>
					</ul>
				</li>
				<li class="dropdown"><a class="dropdown-toggle" href="#"
					data-toggle="dropdown">评奖评优<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/selectNationalScholarship">国家奖学金</a></li>
						<li><a
							href="${pageContext.request.contextPath}/selectSchoolScholarship">校级奖学金</a></li>
						<li><a
							href="${pageContext.request.contextPath}/ThreeeGoodStudent">三好学生</a></li>
					</ul></li>
			</ul>
		</div>
		</nav>
	</div>
	</div>
	<!-- 学生自我评价模态框 -->
	<div class="modal fade" id="stuAssessDialogue" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document"
				style="width: 700px; height: 800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">学生自我评价</h4>
					</div>
					<div class="modal-body">
						 <form action="assStudentAssessment" method="post">
		 	<br/>
		 	<span id="moralTrait_div" style="display:'inline';">
		 		<label for="stu_assess_moralTrait" id="stu_assess_moralTrait_la">道德素质:</label>
		 		<select id="stu_assess_moralTrait" name="moralTrait" class="easyui-combobox" style="width:140px;">
		 			<option>1</option>
		 			<option>2</option>
		 			<option>3</option>
		 			<option>4</option>
		 			<option>5</option>
		 		</select>
		 	</span>
		 	<span id="civicLiteracy_div" style="">
		 		<label for="stu_assess_civicLiteracy" id="stu_assess_civicLiteracy_la">公民素养:</label>
		 		<select id="stu_assess_civicLiteracy" name="civicLiteracy" class="easyui-combobox" style="width:140px">
		 			<option>1</option>
		 			<option>2</option>
		 			<option>3</option>
		 			<option>4</option>
		 			<option>5</option>
		 		</select>
		 	</span>
		 	<span id="liaision_div">
		 		<label for="stu_assess_liaision" id="stu_assess_liaision_la">交流合作:</label>
		 		<select id="stu_assess_liaision" name="liaision" class="easyui-combobox" style="width:140px;">
		 			<option>1</option>
		 			<option>2</option>
		 			<option>3</option>
		 			<option>4</option>
		 			<option>5</option>
		 		</select>	
		 	</span>
		 	<span id="exerciseHealth_div">
		 		<label for="stu_assess_exerciseHealth" id="stu_assess_exerciseHealth_la" >运动健康:</label>
		 		<select id="stu_assess_exerciseHealth" name="exerciseHealth" class="easyui-combobox" style="width:140px;"">
		 			<option>1</option>
		 			<option>2</option>
		 			<option>3</option>
		 			<option>4</option>
		 			<option>5</option>
		 		</select>
		 	</span>
		 	<br/>
		 	<span id="appearance_div" style="margin-left:100px;margin-top:20px;">
		 		<label for="stu_assess_appearance" id="stu_assess_appearance_la">审美表现:</label>
		 		<select class="easyui-combobox" id="stu_assess_appearance" name="appearance" style="width:140px;">
		 			<option>1</option>
		 			<option>2</option>
		 			<option>3</option>
		 			<option>4</option>
		 			<option>5</option>
		 		</select>
		 	</span>
		 	<span id="academicYear_div">
		 		<label for="stu_assesss_academicYear" id="stu_assess_academicYear_la">评价学年:</label>
		 		<select class="easyui-combobox" id="stu_assess_academicYear" name="academiceYear" style="width:140px;">
		 			<option>2014-2015</option>
		 			<option>2015-2016</option>
		 			<option>2016-2017</option>
		 			<option>2017-2018</option>
		 		</select>
		 	</span>
		 	<span id="term_div">
		 		<label for="stu_assess_term" id="stu_assess_term_la">评价学期:</label>
		 		<select class="easyui-combobox" id="stu_assess_term" name="term" style="width:140px;">
		 			<option>1</option>
		 			<option>2</option>
		 		</select>
		 	</span>
		 </form>	    	
		</div>
		<div class="modal-footer">
			<button type="button" id="stu_assess_save" class="btn btn-default">保存</button>
			<button id="stu_assess_close" type="button" class="btn btn-primary" >关闭</button>
			</div>
		</div>
	</div>
</div>
	<style type="text/css">
		.navbar-default .navbar-nav>li>a {
 			   color: #00008B;
		}
		.navbar{
			backgroud-color:'red';
		}
		$("#stuAssess").click(function(){
			alert("stuAssess");
		});
   </style>
   <script type="text/javascript">
 		$("#stu_assess_save").click(function(){
 			 var data=[];
 			 $.ajax({
 				 url:'${pageContext.request.contextPath}/addStudentAssess',
 				 data:{
 					 'academicYear':$("#stu_assess_academicYear").val(),
 					 'term':$("#stu_assess_term").val(),
 					 'moralTrait':$("#stu_assess_moralTrait").val(),
 					 'civicLiteracy':$('#stu_assess_civicLiteracy').val(),
 					 'exerciseHealth':$("#stu_assess_exerciseHealth").val(),
 					 'liaision':$("#stu_assess_liaision").val(),
 					 'exerciseHealth':$('#stu_assess_exerciseHealth').val(),
 					 'appearance':$("#stu_assess_appearance").val()
 				 },
 				 method:'post',
 				 success:function(msg){
 					 alert(msg);
 				 }
 			 });
 		 });
   	     $("#stu_assess_close").click(function(){
   	    	 $("#stuAssessDialogue").modal('hide');
   	     });
   </script>
</body>
</html>