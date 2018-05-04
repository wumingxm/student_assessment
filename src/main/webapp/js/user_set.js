//easyui远程校验
	/* $.extend($.fn.validatebox.defaults.rules,{
	 	check:{//检查验证码  
	       validator: function (value) {  
	            var result=$.ajax({  
	                async : false,    
	                cache : false,  
	                type : 'post',    
	                url : './selectUserByUserName',    
	                data : {    
	                    'userName' : value  
	                }   
	            }).responseText;
	            return result!=null&&result!="";
	        },  
	        message:'用户名已存在'
	    } 
	}); */
$.extend($.fn.datagrid.methods, {  
    editCell: function(jq,param){  
        return jq.each(function(){  
            var opts = $(this).datagrid('options');  
            var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));  
            for(var i=0; i<fields.length; i++){  
                var col = $(this).datagrid('getColumnOption', fields[i]);  
                col.editor1 = col.editor;  
                if (fields[i] != param.field){  
                    col.editor = null;  
                }  
            }  
            $(this).datagrid('beginEdit', param.index);  
            for(var i=0; i<fields.length; i++){  
                var col = $(this).datagrid('getColumnOption', fields[i]);  
                col.editor = col.editor1;  
            }  
        });  
    }  
});  
	$(function(){
		var typeList=[{"text":'学生',"value":1},{"text":"教师","value":2},{"text":"管理员","value":3}];
		var editRow=undefined;
		function unitformatter(value, rowData,rowIndex) {
		    if (value == 0) {
		        return;
		    }
		    for (var i = 0; i <typeList.length; i++) {
		        if (typeList[i].value == value) {
		            return typeList[i].text;
		        }
		    }
		}
		$("#userInfo").datagrid({
			fit:true,
			url : '/selectUser',
			pagePosition:'bottom',
			pageList:[12,14,16],
			pageSize:18,
			pagiantion:true,
			columns : [ [ {
			field : "id",
			halign : "center",
			width : 100,
			align : 'center',
			hidden:true,
			title : '编号'
		}, {
			field : "userName",
			halign : "center",
			width : 280,
			align : 'center',
			title : '用户名',
			editor:{
				type:'validatebox',
				options:{
					missingMessage:"用户名不能为空",
					required:true,
					validType:'length[6,10]'
					//validType:"check['userName']"
				},
			},
			formatter: 
                function(value,row,index){
                            return '<span style="font-size:20px">'+value+'</span>';//改变表格中内容字体的大小
                }   
			}, {
			field : "passWord",
			halign : "center",
			width : 280,
			align : 'center',
			title : '密码',
			editor:{
				type:'validatebox',
				options:{
					missingMessage:"密码不能为空",
					required:true,
					validType:'length[6,13]'
				},
			},
		}, {
			field : "userTypeId",
			halign : "center",
			width : 280,
			align : 'center',
			title : '用户类型',
			formatter: unitformatter,
			editor:{
				type:'combobox',
				options:{	
					required:true,
					data : typeList,
					editable:false,
					valueField : "value",
					textField : "text"
				}
			}
		   },{
			field : "userAddDate",
			halign : "center",
			width : 300,
			align : 'center',
			fixed : true,
			title : "添加日期",
			editor:{
					type:'datetimebox',
					options:{
						editable:false,
						required:true
					}
			}
		} ] ],
		border:false,
		pageSize:12,
		pagination:true,
		rownumbers:true,
		pageList:[12,16,20],
		singleSelect : true,
		pagePostion:'bottom',
		toolbar:'#toolbar',
		onDblClickRow : function(rowIndex, rowData) {
			if (editRow != undefined) {
				$("#userInfo").datagrid('endEdit', editRow);
			}
			if (editRow == undefined) {
				$("#userInfo").datagrid('beginEdit',rowIndex);
				editRow = rowIndex;
			}
			$("#save,#redo").show();
			
		},
		//点击表格进行编辑
		onClickRow : function(rowIndex, rowData) {
			if (editRow != undefined) {
				$("#userInfo").datagrid('endEdit', editRow);
			}
		},
		//编辑完后结束编辑
		onAfterEdit:function(rowIndex, rowData, changes){
			//$("#save,#redo").hide();
			editRow=undefined;
		}
	});
		obj={
			search:function(){
				$("#userInfo").datagrid('load',{
					userName:$.trim($("#userName").val()),
					userAddDate:$("#userAddDate").val(),
					userTypeId:$("#userTypeId").val()
				});
			},
			add:function(){
				if(editRow==undefined){
					$("#userInfo").datagrid('insertRow',{
						index:0,
						row:{
					
						}					
					});
					$("#save,#redo").show();
					$("#userInfo").datagrid('beginEdit',0);
					editRow=0;
				}
			},
			edit: function() {
				var row = $("#userInfo").datagrid('getSelected');
				if (row != null) {
					if (editRow != undefined) {
						$("#userInfo").datagrid('endEdit', editRow);
					}
					if (editRow == undefined) {
					var index = $("#userInfo").datagrid('getRowIndex',row);
					$("#userInfo").datagrid('beginEdit', index);
					$("#save,#redo").show();
					editRow = index;
					$("#userInfo").datagrid('unselectAll');
					} else {

					}
				}
			},
			up: function() {
				MoveUp();
			}, 
			down : function() {
				MoveDown();
			},
			save:function(){
				//如果调用acceptChanges(),使用getChanges()则获取不到编辑和新增的数据。
				//使用JSON序列化datarow对象，发送到后台。
				var rows= $("#userInfo").datagrid('getChanges','updated');
				var rows2=$("#userInfo").datagrid('getChanges','inserted');
				var rowstr =JSON.stringify(rows);
				var rowstr2=JSON.stringify(rows2);
				if(rows.length>0){
					$.ajax({
						type:"post",
						url:"/updateUserList",
						data:'data='+rowstr,
						success:function(msg){
							alert(msg);
						}
					});
				}
				if(rows2.length>0){
					$.ajax({
						type:"post",
						url:"/addUserList",
						data:'data='+rowstr2,
						success:function(msg){
							alert(msg)
						}
					});
				}
			},
			redo:function(){
				$("#userInfo").datagrid('rejectChanges');
				$("#userInfo").datagrid('unselectAll');
				editRow=undefined;
				$("#save,#redo").hide();
			},
			remove:function(){
				var row = $("#userInfo").datagrid('getSelections');
				var userName=row[0].userName;
				alert("userName")
				var indexs=$("#userInfo").datagrid('getRowIndex',row)+1;
				if(confirm("是否删除！")){	
				$.ajax({
						   type: "POST",
						   url: "/deleteUserByUserName",
						   data: "userName="+userName,
						   success: function(msg){
						    	$("#userInfo").datagrid('deleteRow',indexs)
						   }
					});	
				}
			}
		}	
	});