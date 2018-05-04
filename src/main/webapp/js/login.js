$("#updateImpage").click(function() {  
    	$("#verifyCode")[0].src =$("#verifyCode")[0].src+ "?nocache=" + new Date().getTime();  
});
  /*  $.extend($.fn.validatebox.defaults.rules, {
         //在这里写重写的验证其及方法和错误信息
         length: {
             validator: function (value, param) {
                 return value.length >= param[0] && value.length <= param[1];
             },
             message: '长度应为{0}~{1}之间'
         }
    });    */
   	$("#userName").textbox({
        iconCls:'icon-man'
    });
    $("#passWord").textbox({
        iconCls: 'icon-lock'
    });
     $("#validate").textbox({
        
     });
     $("#userName").textbox('textbox').bind('blur',function(){
    	 var username=$("#userName").val();
    	 if(username==null||username==''){
    		 $("#userNameError").html("用户名不能为空");
    		 $("#userName").focus();
    	 }else if(username.length<6||username.length>13){
    			 $("#userNameError").html("");
    			 $("#userNameError").html("用户名必须6-13位");
    	 }else{
    		 $("#userNameError").html("");
    	 }
     });
     $("#passWord").textbox('textbox').bind('blur',function(){
    	 var password=$("#passWord").val();
    	 if(password==null||password==''){
    		 $("#passWordError").html("密码不能为空");
    	 }else if(password.length<6||password.length>13){
    			 $("#passWordError").html("");
    			 $("#passWordError").html("密码必须6-13位");
    	 }else{
    		 $("#passWordError").html("");
    	 }
     });