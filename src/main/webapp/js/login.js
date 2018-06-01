$(document).ready(function() {
		   $("#btn").click(function(){
			  alert($("#userName").val());
			  $("#userName").attr("value",$("#userName").val()); 
			  $("#passWord").attr("value",$("#passWord").val()); 
			  $("#verifyCode").attr("value",$("#verifyCode").val()); 
		   });
		   $('#ff').bootstrapValidator({
		        message: 'This value is not valid',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		        	userName: {
		                message: 'userName',
		                validators: {
		                    notEmpty: {
		                        message: '用户名不能为空'
		                    },
		                    stringLength: {
		                        min: 6,
		                        max: 30,
		                        message: '用户名至少6-10位'
		                    },
		                    regexp: {
		                        regexp: /\d+/,
		                        message: '用户名只能是数字'
		                    }
		                }
		            },
		            passWord: {
		                message: 'passWord',
		                validators: {
		                    notEmpty: {
		                        message: '密码不能为空'
		                    },
		                    stringLength: {
		                        min: 6,
		                        max: 10,
		                        message: '密码必须6-10位'
		                    }
		                }
		            },
		            verifyCode: {
		                message: 'verifyCode',
		                validators: {
		                    notEmpty: {
		                        message: '验证码不能为空'
		                    }
		                }
		            }
		        }
		    });
	});