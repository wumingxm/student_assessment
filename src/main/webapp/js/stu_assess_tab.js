				/*$("#stu_assess_tab").dialog({
					title: '学生评价',   
				    minimizable:true,
				    left:0,
				    top:0,
				    width:400,    
				    height:380,    
				    closed:false,  
				    inline:true,
				    modal:true,
				    cache: false,    
				    buttons:'#bb'
			});
			$("#stu_assess_tab").window('center');	
		});*/
		/*function sub(){
			var moralTrait=$("#moralTrait").combobox('getValue');
			var exerciseHealth=$("#exerciseHealth").combobox('getValue');
			var civicLiteracy=$("#civicLiteracy").combobox('getValue');
			var appearance=$("#appearance").combobox('getValue');
			var liaision=$("#liaision").combobox('getValue');
			var academicYear=$("#academicYear").combobox('getValue');
			var term=$("#term").combobox('getValue');
			if(confirm("是否确认提交")){
				$.ajax({
					url:'updateStudentAssessment',
					data:{
						'moralTrait':moralTrait, 
						'exerciseHealth':exerciseHealth,
						'civicLiteracy':civicLiteracy,
						'appearance':appearance,
						'liaision':liaision,
						'academicYear':academicYear,
						'term':term
					},
					type:'post',
					dataType:'json',
					success:function(){
						alert("学生评价成功！")
						$("#stu_assess_tab").dialog('close');
					}
				});
			}
		}*/
	/*	function cancel(){
			alert("cancel");
			$("#stu_assess_tab").window('close');
		}*/