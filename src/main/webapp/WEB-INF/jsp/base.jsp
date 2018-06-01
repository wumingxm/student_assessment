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
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet"
	href="../bootstrap-validator/vendor/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="../bootstrap-validator/dist/css/bootstrapValidator.css" />
<link rel="stylesheet" type="text/css" href="../css/base.css" />
<link rel="stylesheet" type="text/css" href="../css/stu_assess_tab.css">
</head>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="../bootstrap-validator/vendor/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../bootstrap-validator/dist/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
<body>
	<div class="containerfluid">
		<div style="height:90px; widht:100%;" id="top">
			<img src="../img/ydzy.jpg" id="logo" /> <span id="sysName"
				style="font-family: 楷体; font-size: 30px;"">大学生综合素质测评系统</span> <span
				id="welcome" style="position: absolute; right: 100px; top: 10px;">
				欢迎<c:if test="${sessionScope.user.userTypeId==1}">
					${sessionScope.student.sName}同学
				</c:if>
				<c:if test="${sessionScope.user.userTypeId==2}">
					${sessionScope.teacher.tName}老师
				</c:if>
				<c:if test="${sessionScope.user.userTypeId==3}">
					管理员
				</c:if>登录！</span>
			<span id="exit"><a href="/login">退出系统</a></span> <span id="time"></span>
		</div>
		<nav class="navbar navbar-default" role="navigation"
			style="margin-bottom:0;border:none;">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1"
			style="font-size: 24px; background-color: rgb(193, 223, 179);">
			<ul class="nav navbar-nav">
				<li class="dropdown" id="index"><a class="dropdown-toggle"
					 data-toggle="dropdown">首页<strong
						class="caret"></strong></a></li>
				<li class="dropdown"><a class="dropdown-toggle" href="#"
					data-toggle="dropdown">用户管理 <strong class="caret"> </strong></a>
					<c:if test="${sessionScope.user.userTypeId==3}">
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/selectUserDetialInformation?page=1&pageSize=8"
								id="his">用户基本信息管理</a></li>
							<li><a
								href="${pageContext.request.contextPath}/password_update">修改密码</a></li>
						</ul>
					</c:if>
				</li>
				<c:if test="${sessionScope.user.userTypeId!=1}">
					<li class="dropdown"><a class="dropdown-toggle" href="#"
						data-toggle="dropdown">学生信息管理<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/goStuInforSet">学生基本信息管理</a></li>
						</ul>
					</li>
				</c:if>
				<c:if test="${sessionScope.user.userTypeId==3}">
					<li class="dropdown"><a class="dropdown-toggle" href="#"
						data-toggle="dropdown">教师信息管理<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/selectTeacher">教师基本信息管理</a></li>
						</ul></li>
					</li>
				</c:if>
				<li class="dropdown"><a class="dropdown-toggle" href="#"
					data-toggle="dropdown">课程信息管理<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<!-- 课程信息管理只有管理员有权限 -->
						<c:if test="${sessionScope.user.userTypeId==3}">
							<li>
								<a href="${pageContext.request.contextPath}/selectCourseAll?page=1&pageSize=8">课程信息管理</a>
							</li>
						</c:if>
						<c:if test="${sessionScope.user.userTypeId!=1}">
							<li>
								<a href="${pageContext.request.contextPath}/goCourseSelect">学生成绩查询</a>
							</li>
						</c:if>
						<c:if test="${sessionScope.user.userTypeId==1}">
								<li>
									<a href="${pageContext.request.contextPath}/stu_score_query">查询成绩</a>
								</li>
						</c:if>
					</ul>
				</li>
				<!--只有管理员可以访问评价标准管理-->
				<c:if test="${sessionScope.user.userTypeId==3}">
					<li class="dropdown"><a class="dropdown-toggle" href="#"
						data-toggle="dropdown">评价标准管理<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li>
								<a href="${pageContext.request.contextPath}/selectAssessStandard?page=1&pageSize=8">评价标准管理</a>
							</li>
						</ul>
					</li>
				</c:if>
				<li class="dropdown">
				<a class="dropdown-toggle" href="#"
					data-toggle="dropdown">学生评价<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<!-- 支允许学生和管理员访问学生自我评价 -->
						<c:if test="${sessionScope.user.userTypeId!=2}">
							<li><a  href="${pageContext.request.contextPath}/stu_assess_tab">学生自我评价</a></li>
						</c:if>
						<c:if test="${sessionScope.user.userTypeId!=1}">
							<li><a  href="${pageContext.request.contextPath}/tea_assess_tab">教师对学生评价</a></li>
						</c:if>
						<!-- 只允许教师和管理员访问教师评价模块 -->
						<%-- <c:if test="${sessionScope.user.userTypeId!=1}">
							<li>
								<a href="${pageContext.request.contextPath}/selectTeacherAssess?page=1&pageSize=8">查询学生评价</a>
							</li>
						</c:if> --%>
						<c:if test="${sessionScope.user.userTypeId==3}">
							<li>
								<a href="${pageContext.request.contextPath}/stu_final_assess">学生综合评价</a>								
							</li>
						</c:if>
						<c:if test="${sessionScope.user.userTypeId==3}">
							<li>
								<a href="${pageContext.request.contextPath}/assignWeight">设置指标权重</a>			
							</li>
						</c:if>
					</ul>
				</li>
				<c:if test="${sessionScope.user.userTypeId!=1}">
				<li class="dropdown"><a class="dropdown-toggle" href="#"
						data-toggle="dropdown">评奖评优<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/national_scholarship">国家奖学金</a></li>
							<li><a
								href="${pageContext.request.contextPath}/sch_scholarship">校级奖学金</a></li>
							<li><a
								href="${pageContext.request.contextPath}/three_good_student">三好学生</a></li>	
						</ul>
				</li>
				</c:if>
			</ul>
		</div>
		</nav>
	<style type="text/css">
</style>
</body>
</html>