$(document).ready(function() {
	   $('#ff3').bootstrapValidator({
	        message: 'This value is not valid',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	rNo: {
	                message: '用户工号不能为空',
	                validators: {
	                    notEmpty: {
	                        message: '用户工号不能为空'
	                    },
	                    stringLength: {
	                        min:13,
	                        max:13,
	                        message: '用户名为必须为13位'
	                    },
	                    regexp: {
	                        regexp: /\d+/,
	                        message: '用户工号只能是数字'
	                    }
	                }
	            },
	            userName: {
	                message: '用户名不能为空',
	                validators: {
	                    notEmpty: {
	                        message: '用户名不能为空'
	                    },
	                    stringLength: {
	                        min:13,
	                        max:13,
	                        message: '用户名必须为13位'
	                    },
	                    regexp: {
	                        regexp: /^[a-zA-Z0-9_\.]+$/,
	                        message: '用户名只能有字母数字组成不能由下划线组成'
	                    }
	                }
	            },
	            passWord: {
	                validators: {
	                    notEmpty: {
	                        message: '密码不能为空'
	                    }
	                }
	            },
	            confirmPassword: {
	                validators: {
	                    notEmpty: {
	                        message: '确认密码不能为空'
	                    },
	                    identical: {
	                        field: 'passWord',
	                        message: '两次输入密码必须不一致'
	                    }
	                }
	            }
	        }
	    });
	   $("#save2").click(function(){
		    $("#ff3").data('bootstrapValidator').validate();
		  	if($("#ff3").data('bootstrapValidator').isValid()){
		  		$.ajax({
					url:"/addUser",
					data:{
						"rNo":$("#addDialogue #rNo3").val(),
						"userName":$("#addDialogue #userName3").val(),
						"passWord":$("#addDialogue #passWord3").val(),
						"userTypeId":$("#addDialogue #userTypeName3").val()
					},
					method:"post",
				    success:function(msg){
				    	alert(msg);
				    	$("#addDialogue").modal('hide');
				    	window.location.href = window.location.href;  
				    }
				});
		  	}
		   
	   });
	});
	$("#pageSize").change(function(){
		var pageSize=$("#pageSize").val();
		if(pageSize!=null||pageSize!=undefined||pageSize!=""){
			$("#form").submit();
		}
	});
	$("#redirect").click(function(){
			var page=$("#page").val();
			if(page==""||page==undefined||page==null){
				page=1;
			}
			var url=$(this)[0].href;
			var start=url.substring(0,url.indexOf("page")+9);
			var h=start+page+"&pageSize=18";
			$(this)[0].href=h;
	});
	function sub(){
		$("#ff").submit();
	}
	$("#close2").click(function(){
		$("#ff3").data('bootstrapValidator').resetForm();  
		$("#addDialogue").modal('hide');
	});