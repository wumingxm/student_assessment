<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生评价管理系统</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css"/>
</head>
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<body>
<link rel="stylesheet" type="text/css" href="../css/login.css">
<div id="top">
    <img src="../img/ydzy.jpg" id="img"/>
    <span id="systemName">学生评价管理系统</span>
</div>
<div id="main">
    <div id="login"
         style="height:440px;border:1px solid;width:440px;background-color:rgb(224,240,253);">
        <div id="user_login"><a>用户登录</a></div>
        <div id="user_regist"><a href="regist.html">注册</a></div>
        <hr/>
        <form id="ff" method="post" action="${pageContext.request.contextPath}/user_login" onsubmit="return checkForm();">
            <div id="userName_div">
                <input type="text"  name="userName" id="userName" value="${userName}" placeholder="用户名"
                 style="width:280px;height:40px;" placeholder="用户名" onkeyup="validateUserName();"/>
                <a id="dd"></a>
                <span id="userNameError" style="font-size:10px;color:red;">${userNameError}</span> 
               	  <span style="font-size:10px;color:red;">${repeatLoginError}</span>
                <br/>
            </div>
            <div id="password_div">
                <input type="password" 
                name="passWord" id="passWord" value="${passWord}" 
                placeholder="密码" style="width:280px;height:40px;"/>
           		<span id="passWordError" style="font-size:10px;color:red;" data-options="iconCls:icon-success">${passWordError}</span>
            </div>
            <div id="validate_div">
                <input type="text"  name="verifyCode" id="validate" placeholder="验证码" style="width:180px;height:40px;"  />
                <img id="verifyCode" src="/generateVerifyCode" style="width:100px;height:30px;margin-left:0;"/>
                <a  href="#" id="updateImage" style="font-size:12px;margin-left:0">看不清换一张</a>
                <div style="font-size:10px;color:red;"
                    id="validateError"></div>
            </div>
            <div id="submit_div">
                <input type="submit" class="form-control" sname="提交" id="submit"
                       style="background-color:rgb(58,165,235);"/>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="../js/login.js"></script>
<script type="text/javascript">
$(function(){
	 var input_verifyCode=$("#validate").val();
     $("#validate").textbox('textbox').bind('blur',function(){
    	 var verifyCode=$("#validate").val();
    	 if(verifyCode==null||verifyCode==''){
    		 $("#validateError").html("验证码不能为空");
    	 }else if(verifyCode!=input_verifyCode){
	 		$("#validateError").html("验证码错误");
    	 }else{
    		$("#validateError").html("");
    	 }
    });
    $("#updateImage").click(function(){
    	$("#verifyCode").attr("src","${pageContext.request.contextPath}/generateVerifyCode?"+new Date().toLocaleString());
    });
});
function checkForm() {
	 var username=$("#userName").val();
	 if(username==null||username==''){
		 $("#userNameError").html("用户名不能为空");
		 return false;
	 }else if(username.length<6||username.length>13){
			 $("#userNameError").html("");
			 $("#userNameError").html("用户名必须6-13位");
			 return false;
	 }else{
		 $("#userNameError").html("");
	 }
	 var password=$("#passWord").val();
	 if(password==null||password==''){
		 $("#passWordError").html("密码不能为空");
		 return false;
	 }else if(password.length<6||password.length>13){
			 $("#passWordError").html("");
			 $("#passWordError").html("密码必须6-13位");
			 return false;
	 }else{
		 $("#passWordError").html("");
	 }
    // var input_verifyCode='${sessionScope.verifyCode}';
   /*  $("#validate").textbox('textbox').bind('blur',function(){
        	 var verifyCode=${sesssionScope.verifyCode};
        	 if(verifyCode==null||verifyCode==''){
        		 $("#validateError").html("验证码不能为空");
        		 return false;
        	 }else if(verifyCode!=input_verifyCode){
    	 		 $("#validateError").html("验证码错误")
    	 		return false;
        	 }else{
        		 $("#validateError").html("");
        	 }
    }); */
    return true;
}
</script>
</body>
</html>
