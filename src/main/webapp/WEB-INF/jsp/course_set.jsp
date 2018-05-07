<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程信息管理</title>
</head>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<div id="toolbar">
		<form id="ff"
			action="${pageContext.request.contextPath}/selectCourseAll"
			style="margin-top: 10px; margin-left: 10px;">
			<label for="#courseId" id="courseId_L1" style="font-size: 15px;"">课程号</label>
			<input type="text" id="courseId" class="easyui-textbox"
				name="courseId" /> <label for="#courseName" id="courseName_L1"
				style="font-size: 15px;"">课程名称</label> <input type="text"
				id="courseName" class="easyui-textbox" name="courseName" /> 
				<label	for="#tName" id="tName_L1" style="font-size: 15px;">任课教师</label> 
				<select class="easyui-combobox" name="tNo"
						data-options="url:'${pageContext.request.contextPath}/selectTeacherInfo',
						textField:'tName',
						valueField:'tNo'"
						style="width: 80px;">
				</select> 
				<label	for="#courseTypeName" id="tName_L1" style="font-size: 15px;">课程类型</label> 
				<select class="easyui-combobox" name="courseTypeId" id="courseTypeName" data-options="
						textField:'courseTypeName',
						valueField:'courseTypeId'"
						style="width: 80px;">
						<option value="1">必修课</option>
						<option value="2">选修课</option>
				</select> 
				<a class="easyui-linkbutton" onclick="sub();">查询</a>
		</form>
	</div>
	<div style="margin-top: 5px;">
		<a class="glyphicon glyphicon-plus-sign" href="#" data-toggle="modal"
			data-target="#addCourseDialogue" style="color: green; margin-left: 5px;"
			style="margin-top:10px;">添加课程信息</a>
	</div>
	<table id="index" class="table table-bordered"
		style="text-align: center; table-layout: fixed; font-size: 15px; margin-left: 5px; margin-right: 5px; margin-top: 5px; margin-right: 5px;">
		<tr id="caption">
			<td>课程号</td>
			<td>课程名称</td>
			<td>课程类型</td>
			<td style="width: 80px;">学分</td>
			<td>任课教师</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pb.rows}" var="course">
			<tr>
				<td>${course.courseId}</td>
				<td>${course.courseName}</td>
				<td>
					<c:if test="${course.courseTypeId==1}">必修课</c:if>
					<c:if test="${course.courseTypeId==2}">选修课</c:if>
				</td>
				<td>${course.courseScore}</td>
				
				<td>${course.tName}</td>
				<td><a id="edit" +userBean.index
					class=" glyphicon glyphicon-pencil" data-toggle="modal"
					data-target="#updateCourseDialogue" onclick="setValues(this)"
					style="color:#54FF9F">&nbsp;</a> &nbsp;<a id="del" +userBean.index
					class="glyphicon glyphicon-trash"
					style="margin-left: 10px; color: #e74649;" onclick="deleteCourse(this)">&nbsp</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<ul class="pagination pager" style="margin-left: 600px;">
		<c:if test="${pb.totalPage ge 1}">
			&nbsp;&nbsp;第${pb.page}页 /共${pb.totalPage}页
		</c:if>
		<c:if test="${pb.page-1 ge 1}">
			&nbsp;&nbsp;<li class="previous active"><a
				href="${pageContext.request.contextPath}/selectCourseAll?page=${pb.page-1}&pageSize=${pb.pageSize}"
				id="last">Previous</a></li>
		</c:if>
		<c:if test="${pb.page+1 le pb.totalPage}">
			&nbsp;&nbsp;<li class="next active"><a
				href="${pageContext.request.contextPath}/selectCourseAll?page=${pb.page+1}&pageSize=${pb.pageSize}"
				id="next">Next</a></li>
		</c:if>
		<form id="form"
			action="${pageContext.request.contextPath}/selectCourseAll"
			method="post" style="height: 14px; display: inline;">
			每页显示的记录数:<select class="easyui-combobox" name="pageSize"
				id="pageSize" style="margin-right: 10px;">
				<option>8</option>
				<option>12</option>
				<option>20</option>
			</select> <input type="hidden" value="1" name="page"
				style="width: 0px; height: 0px;" />
		</form>
		至&nbsp;
		<input type="text" class="easyui-textbox" name="page" id="page"
			style="width: 40px;" />&nbsp;页
		<a id="redirect"
			href="${pageContext.request.contextPath}/selectCourseAll?page=${pb.page}&pageSize=${pb.pageSize}">跳转</a>&nbsp;&nbsp;&nbsp;
		<a
			href="${pageContext.request.contextPath}/selectCourseAll?page=${pb.totalPage}&pageSize=${pb.pageSize}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</ul>
	<span style="margin-left: 25px;"">共${pb.total}条记录</span>
	<div class="modal fade" id="addCourseDialogue" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document"
				style="width: 700px; height: 800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">添加课程信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="ff3">
							<div class="form-group">
								<label for="courseId2" class="col-sm-2 control-label" for="#courseId2">课程Id</label>
								<div class="col-md-6">
									<input type="text" name="courseId"
										class="form-control col-md-4" id="courseId2"> <span
										class="help-block"></span> <span id="courseIdError1"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="#courseName2">课程名称</label>
								<div class="col-md-6">
									<input id="courseName2" type="text" name="courseName"
										class="form-control" /> <span id="passWordError1"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2" style="margin-left: 10px;" for="#courseTypeId2">任课老师</label>
								&nbsp;<select class="easyui-combobox" name="courseTypeId" 
								id="courseTypeId2"
								style="padding-left:5px;"
								data-options="textField:'courseTypeName',valueField:'courseTypeId'">
									<option value='1'>必修课</option>
									<option value='1'>选修课</option>
								</select>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="#courseScore2">学分</label>
								<div class="col-md-6">
									<input id="courseScore2" type="text" name="courseScore"
										class="form-control" /> <span
										id="passWordError2"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2" style="margin-left: 10px;" for="#tName2">任课老师</label>
								&nbsp;<select class="easyui-combobox" name="tNo" 
								id="tName2"
								style="padding-left:5px;"
								data-options="url:'${pageContext.request.contextPath}/selectTeacherInfo',textField:'tName',valueField:'tNo'">
								</select>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" id="save2">保存</button>
						<button type="button" class="btn btn-primary" id="close2">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="updateCourseDialogue" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document"
				style="width: 700px; height: 800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">更新课程信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="ff3">
							<div class="form-group">
								<label for="courseId3" class="col-sm-2 control-label" for="#courseId2">课程Id</label>
								<div class="col-md-6">
									<input type="text" name="courseId"
										class="form-control col-md-4" id="courseId3"> <span
										class="help-block"></span> <span id="courseIdError1"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="#courseName3">课程名称</label>
								<div class="col-md-6">
									<input id="courseName3" type="text" name="courseName"
										class="form-control" /> <span id="passWordError1"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="#courseScore3">学分</label>
								<div class="col-md-6">
									<input id="courseScore3" type="text" name="courseScore"
										class="form-control" /> <span
										id="passWordError2"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2" style="margin-left: 10px;" for="#tName3">任课老师</label>
								&nbsp;<select class="easyui-combobox" name="tNo" 
								id="tName3"
								style="padding-left:5px;"
								data-options="url:'${pageContext.request.contextPath}/selectTeacherInfo',textField:'tName',valueField:'tNo'">
								</select>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"  id="save3">保存</button>
						<button type="button" class="btn btn-primary"  data-dismiss="modal" id="close3">关闭</button>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript">
		$("#pageSize").change(function() {
			var pageSize = $("#pageSize").val();
			if (pageSize != null || pageSize != undefined || pageSize != "") {
				$("#form").submit();
			}
		});
		$("#redirect").click(function() {
			var page = $("#page").val();
			if (page == "" || page == undefined || page == null) {
				page = 1;
			}
			var url = $(this)[0].href;
			var start = url.substring(0, url.indexOf("page") + 9);
			var h = start + page + "&pageSize=18";
			$(this)[0].href = h;
		});
		function sub() {
			$("#ff").submit();
		}
		$(document).ready(function() {
			   $('#ff3').bootstrapValidator({
			        message: 'This value is not valid',
			        feedbackIcons: {
			            valid: 'glyphicon glyphicon-ok',
			            invalid: 'glyphicon glyphicon-remove',
			            validating: 'glyphicon glyphicon-refresh'
			        },
			        fields: {
			        	courseId: {
			                message: '课程Id不能为空',
			                validators: {
			                    notEmpty: {
			                        message: '课程Id不能为空'
			                    }
			                }
			            },
			            courseName: {
			                message: '课程名不能为空',
			                validators: {
			                    notEmpty: {
			                        message: '课程名不能为空'
			                    }
			                }
			            },
			            courseScore: {
			                validators: {
			                    notEmpty: {
			                        message: '学分不能为空'
			                    }
			                }
			            }
			        }
			    });
			   $("#save2").click(function(){
				   alert($("#courseId2").val());
				   alert($("#courseName2").val());
				   alert($("#courseScore2").val());
				   alert($("#addCourseDialogue #tName2").combobox('getValue'));
				    $("#ff3").data('bootstrapValidator').validate();
				 		if($("#ff3").data('bootstrapValidator').isValid()){
				  		$.ajax({
							url:"${pageContext.request.contextPath}/addCourse",
							data:{
								"courseId":$("#addCourseDialogue #courseId2").val(),
								"courseName":$("#addCourseDialogue #courseName2").val(),
								"courseScore":$("#addCourseDialogue #courseScore2").val(),
								"courseTypeId":$("#addCourseDialogue #courseTypeId2").combobox('getValue'),
								"tNo":$("#addCourseDialogue #tName2").combobox('getValue')
							},
							method:"post",
						    success:function(msg){
						    	alert(msg);
						    	$("#addCourseDialogue").modal('hide');
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
				//更新时候设置值
				function setValues(ele){
					var tr=$(ele).parent("td").parent("tr");
					var courseId=$(tr).children("td:eq(0)").html();
					var courseName=$(tr).children("td:eq(1)").html();
					var courseScore=$(tr).children("td:eq(2)").html();
					var tName=$(tr).children("td:eq(3)").html();
					$("#updateCourseDialogue #courseId3").val(courseId);
					$("#updateCourseDialogue #courseName3").val(courseName);
					$("#updateCourseDialogue #courseScore3").val(courseScore);	
					$("#updateCourseDialogue #tName3").val(tName);
					var tNameOptions=$("#updateCourseDialogue #tName").find("option");
					for(var i=1;i<=tNameOptions.length;i++){
						if(tName==tNameOptions[i].html()){
							$(tNameOptions[i]).attr("selected","selected");
						}
					}
				}
				
				$("#save3").click(function(){
					alert($("#updateCourseDialogue #tName3").combobox('getValue'));
					$.ajax({
						url:"${pageContext.request.contextPath}/updateCourse",
						data:{
							"courseId":$("#updateCourseDialogue #courseId3").val(),
							"courseName":$("#updateCourseDialogue #courseName3").val(),
							"courseScore":$("#updateCourseDialogue #courseScore3").val(),
							"tNo":$("#updateCourseDialogue #tName3").combobox('getValue')
						},
						method:"post",
					    success:function(msg){
					    	alert(msg);
					    	$("#updateCourseDialogue").modal('hide');
					    }
					});
				});
				function deleteCourse(ele){
					var tr=$(ele).parent("td").parent("tr");
					var courseId=$(tr).children("td:eq(1)").html();
					if(confirm("是否删除!")){
						$.ajax({
							url:"${pageContext.request.contextPath}/deleteCourse?courseId="+courseId,
							method:"get",
							success:function(flag){
								if(flag)
								$(tr).remove();
							}
						});
					}
				}
				
				$("#close2").click(function(){
					$("#ff3").data('bootstrapValidator').resetForm();  
					$("#addCourseDialogue").modal('hide');
				});
	</script>
</body>
</html>