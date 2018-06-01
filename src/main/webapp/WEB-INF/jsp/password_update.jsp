<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css"
		href="../css/password_update.css">
	<script type="text/javascript" src="../js/password_update.js"></script>
	<h1>修改密码</h1>
	<form action="/updatePassword">
		<div id="userName_div">
			<label for="#userName" id="userName_l1">用户名</label> <input
				type="text" name="userName" class="easyui-textbox" id="userName" />
		</div>
		<div id="passWord_div">
			<label for="#passWord" id="passWord_l1">原密码</label> <input
				type="password" class="easyui-textbox" name="passWord" id="passWord" />
		</div>
		<div id="userName_div">
			<label for="#passWord2" id="passWord2_l1">确认密码</label> <input
				type="password" class="easyui-textbox" name="passWord2"
				id="passWord2" /> <a id="sub" class="easyui-linkbutton">提交</a>
		</div>
	</form>
</body>
</html>