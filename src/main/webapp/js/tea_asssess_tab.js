$(function() {
	//获取当前编辑框的行号
	$.extend($.fn.datagrid.methods, {
		getEditingRowIndexs : function(jq) {
			var rows = $.data(jq[0], "datagrid").panel
					.find('.datagrid-row-editing');
			var indexs = [];
			rows.each(function(i, row) {
				var index = row.sectionRowIndex;
				if (indexs.indexOf(index) == -1) {
					indexs.push(index);
				}
			});
			return indexs;
		}
	});
	//定义编辑的格式
	$.extend($.fn.datagrid.defaults.editors,
	{
		text : {
			init : function(container, options) {
				var input = $(
						'<input type="text" class="datagrid-editable-input">')
						.appendTo(container);
				return input;
			},
			getValue : function(target) {
				return $(target).val();
			},
			setValue : function(target, value) {
				$(target).val(value);
			},
			resize : function(target, width) {
				var input = $(target);
				if ($.boxModel == true) {
					input.width(width
							- (input.outerWidth() - input.width()));
				} else {
					input.width(width);
				}
			}
		}
	});
	var editRow = undefined;
	var typeList = [ {
		"text" : 1,
		"value" : 1
	}, {
		"text" : 2,
		"value" : 2
	}, {
		"text" : 3,
		"value" : 3
	}, {
		"text" : 4,
		"value" : 4
	}, {
		"text" : 5,
		"value" : 5
	} ];
	function unitformatter(value, rowData, rowIndex) {
		if (value == 0) {
			return;
		}
		for (var i = 0; i < typeList.length; i++) {
			if (typeList[i].value == value) {
				return typeList[i].text;
			}
		}
	}
	$("#collegeName").combobox({
		url : '/selectCollege',
		width : 180,
		textField : 'collegeName',
		valueField : 'collegeId',
		editable : false
	/* onLoadSuccess:function(){
		 var data = $('#collegeName').combobox('getData');
		 $("#collegeName").combobox('select',data[0].collegeId);	 
	} */
	});
	$("#className").combobox({
		width : 120,
		url : '/selectClasses',
		textField : 'className',
		valueField : 'classId',
		editable : false
	/* onLoadSuccess:function(){
		 var data = $('#className').combobox('getData');
		 $("#className").combobox('select',data[0].classId);	 
	} */
	});
	$("#academicYear").combobox({
		textField : 'academicYear',
		valueField : 'academicYear'
	});
	$("#term").combobox({
		width : 50,
		textField : 'term',
		valueField : 'term'
	});
	$("#tea_assess_tab").datagrid({
		url : '/selectStudentAssessmentList',
		border : false,
		toolbar : '#toolbar',
		singleSelect : true,
		onClickRow : function(rowIndex, rowData) {
			if (editRow == undefined) {
				alert("helloworld");
				$("#tea_assess_tab").datagrid('beginEdit', rowIndex);
				editRow = rowIndex;
				$("#redo,#save").show();
			}
		},
		//编辑完后结束编辑
		onAfterEdit : function(rowIndex, rowData, changes) {
			//$("#save,#redo").hide();
			editRow = undefined;

		},
		columns : [ [ {
			field : "sNo",
			halign : "center",
			align : 'center',
			width : 120,
			title : '学号'
		}, {
			field : "sName",
			halign : "center",
			align : 'center',
			width : 120,
			title : '姓名'
		}, {
			field : "moralTrait",
			halign : "center",
			align : 'center',
			width : 120,
			title : '道德品质',
			formatter : unitformatter,
			editor : {
				type : 'combobox',
				options : {
					required : true,
					data : typeList,
					editable : false,
					valueField : "value",
					textField : "text"
				}
			}
		}, {
			field : "civicLiteracy",
			halign : "center",
			align : 'center',
			width : 120,
			title : '公民素养',
			formatter : unitformatter,
			editor : {
				type : 'combobox',
				options : {
					required : true,
					data : typeList,
					editable : false,
					valueField : "value",
					textField : "text"
				}
			}
		}, {
			field : "liaision",
			halign : "center",
			align : 'center',
			width : 120,
			title : '交流与合作',
			formatter : unitformatter,
			editor : {
				type : 'combobox',
				options : {
					required : true,
					data : typeList,
					editable : false,
					valueField : "value",
					textField : "text"
				}
			}
		}, {
			field : "exerciseHealth",
			halign : "center",
			align : 'center',
			width : 120,
			title : '运动与健康',
			formatter : unitformatter,
			editor : {
				type : 'combobox',
				options : {
					required : true,
					data : typeList,
					editable : false,
					valueField : "value",
					textField : "text"
				}
			}
		}, {
			field : "appearance",
			halign : "center",
			width : 120,
			align : 'center',
			title : '审美表现',
			formatter : unitformatter,
			editor : {
				type : 'combobox',
				options : {
					required : true,
					data : typeList,
					editable : false,
					valueField : "value",
					textField : "text"
				}
			}
		} ] ]
	});
	obj = {
		search : function() {
			$("#tea_assess_tab").datagrid('load', {
				url : '/selectStudent',
				collegeId : $("#collegeName").combobox('getValue'),
				classId : $("#className").combobox('getValue')
			});
		},
		add : function() {
			var rows = $("#tea_assess_tab").datagrid('getChanges', 'updated');
			var session = $("#session").combobox('getValue');
			var term = $("#term").combobox('getValue');
			var rowstr = JSON.stringify(rows);
			if (rows.length > 0) {
				$.ajax({
					type : "post",
					url : "/addTeacherAssessment",
					data : {
						'rowstr' : rowstr,
						'term' : term,
						'academicYear' : academicYear
					},
					success : function(msg) {
						alert(msg);
					}
				});
			}
		},
		save : function() {
			//获取正在编辑的行号
			var indexs = $("#tea_assess_tab").datagrid('getEditingRowIndexs');
			alert(indexs);
			alert(editRow);
			$(indexs).each(function(i, n) {
				$("#tea_assess_tab").datagrid('endEdit', indexs[i]);
			});
		},
		redo : function() {
			//撤销正在编辑的行
			$("#tea_assess_tab").datagrid('rejectChanges');
			$("#tea_assess_tab").datagrid('unselectAll');
			editRow = undefined;
			$("#save,#redo").hide();
		}
	}
});