<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/tea_infor_set.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<script type="text/javascript" src="../js/tea_infor_set.js"></script>
	<div style="margin-top: 5px; font-size: 15px;">
		<form method="post" id="ff"
			action="${pageContext.request.contextPath}/selectTeacher">
			<!-- <label for="#collegeName">学院:</label> <select id="collegeName"
				name="collegeId" class="easyui-combobox"
				data-options="url:'/selectCollege',textField:'collegeName',valueField:'collegeId',editable:false">
				<option selected="selected" value="">请选择学院</option>
			</select> --> <label for="#tNo">教工号:</label> <input id="tNo" type="text"
				class="easyui-textbox" name="tNo" /> <label for="#tName">教工姓名:</label>
			<input type="text" id="tName" name="tName" class="easyui-textbox" />
			<a class="easyui-linkbutton" onclick="submit();">查询</a>
		</form>
		<a class="glyphicon glyphicon-plus-sign" data-toggle="modal"
			data-target="#addTeacherInfoDialogue"
			style="color: '#54FF9F'; margin-left: 5px;">添加教师信息</a>
		<table id="index" class="table table-bordered"
			style="text-align: center; table-layout: fixed; margin-top: 10px; font-size: 15px; margin-left: 5px;">
			<tr id="caption">
				<td>教工号</td>
				<td>教工姓名</td>
				<td style="width: 80px;">年龄</td>
				<td style="width: 80px;">性别</td>
				<td>政治面貌</td>
				<td>职称</td>
				<td>联系电话</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${pb.rows}" var="teacher">
				<tr>
					<td>${teacher.tNo}</td>
					<td>${teacher.tName}</td>
					<td>${teacher.tSex}</td>
					<td>${teacher.tAge}</td>
					<td>${teacher.tStatus}</td>
					<td>${teacher.tPosition}</td>
					<td>${teacher.tTelephone}</td>
					<td><a id="edit" +userBean.index
						class=" glyphicon glyphicon-pencil" data-toggle="modal"
						data-target="#editTeacherInfoDialogue" onclick="setValues(this)"
						style="color: '#54FF9F'">&nbsp;</a> &nbsp; <a id="del2"
						+userBean.index class="glyphicon glyphicon-trash"
						style="margin-left: 10px; color: #EE2C2C"
						onclick="deleteTeacher(this);">&nbsp</a></td>
				</tr>
			</c:forEach>
		</table>
		<ul class="pagination pager" style="margin-left: 700px;">
			<c:if test="${pb.totalPage ge 1}">
			&nbsp;&nbsp;第${pb.page}页 /共${pb.totalPage}页  
		</c:if>
			<c:if test="${pb.page-1 ge 1}">
			&nbsp;&nbsp;<li class="previous active"><a
					href="${pageContext.request.contextPath}/selectTeacher?page=${pb.page-1}&pageSize=${pb.pageSize}"
					id="last">Previous</a></li>
			</c:if>
			<c:if test="${pb.page+1 le pb.totalPage}">
			&nbsp;&nbsp;<li class="next active"><a
					href="${pageContext.request.contextPath}/selectTeacher?page=${pb.page+1}&pageSize=${pb.pageSize}"
					id="next">Next</a></li>
			</c:if>
			<form id="form"
				action="${pageContext.request.contextPath}/selectTeacher"
				method="post" style="height: 14px; display: inline;">
				每页显示的记录数:<select name="pageSize" id="pageSize" class="easyui-combobox"
					style="margin-right: 10px;">
					<option>8</option>
					<option>12</option>
					<option>20</option>
				</select> <input type="hidden" value="1" name="page"
					style="width: 0px; height: 0px;" />
			</form>
			至&nbsp;
			<input type="text" name="page" id="page" style="width: 40px;" class="easyui-textbox"/>&nbsp;页
			<a id="redirect"
				href="${pageContext.request.contextPath}/selectTeacher?page=${pb.page}&pageSize=${pb.pageSize}">跳转</a>&nbsp;&nbsp;&nbsp;
			<a
				href="${pageContext.request.contextPath}/selectTeacher?page=${pb.totalPage}&pageSize=${pb.pageSize}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</ul>
		<span style="margin-left: 25px;"">共${pb.total}条记录</span>
		<!-- 添加用户信息 -->
		<div class="modal fade" id="addTeacherInfoDialogue" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document"
				style="width: 700px; height: 800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">添加教师信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="ff3">
							<div class="form-group">
								<label for="tNo2" class="col-sm-2 control-label">教工号</label>
								<div class="col-md-6">
									<input type="text" name="tNo" class="form-control col-md-4"
										id="tNo2"> <span class="help-block"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="id2" class="col-sm-2 control-label">身份证号</label>
								<div class="col-md-6">
									<input type="text" name="id" class="form-control col-md-4"
										id="id2">
								</div>
							</div>
							<div class="form-group">
								<label for="tName2" class="col-sm-2 control-label">姓名</label>
								<div class="col-md-6">
									<input type="text" name="tName" class="form-control col-md-4"
										id="tName2"> <span id="tName2" class="help-block"></span>
									<span id="userNameError1"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="tTelephone2" class="col-sm-2 control-label">联系电话</label>
								<div class="col-md-6">
									<input type="text" name="tTelephone"
										class="form-control col-md-4" id="tTelephone2">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" id="save2">保存</button>
						<button type="button" data-dismiss="modal" class="btn btn-primary"
							id="close2">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="editTeacherInfoDialogue" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document"
				style="width: 800px; height: 800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">编辑 教师信息</h4>
					</div>
					<div class="modal-body">
						<form role="form" class="form-inline" id="editTeacherForm">
							<div class="form-group" id="id_div">
								<label for="id3" id="id3_la" class="control-label">身份证号:</label>
								<input type="text" name="id" class="form-control" id="id3"
									disabled="disabled">
							</div>
							<div class="form-group" id="tNo3_div">
								<label for="tNo3" id="tNo3_la" class="control-label">教工号:</label>
								<input type="text" name="tNo" class="form-control" id="tNo3"
									disabled="disabled">
							</div>
							<br />
							<div class="form-group" id="tName3_div">
								<label for="tName3" id="tName3_la" class="control-label">教师姓名:</label>
								<input type="text" name="tName" class="form-control" id="tName3"
									disabled="disabled">
							</div>
							<div class="form-group" id="tStatus3_div">
								<label for="tStatus3" id="tStatus3_la" class="control-label">政治面貌:</label>
								<select class="easyui-combobox" name="tStatus" id="tStatus3">
									<option>群众</option>
									<option>中共党员</option>
									<option>其他党派人士</option>
								</select>
							</div>
							<br />
							<div class="form-group" id="tPosition3_div">
								<label for="tPosition3" id="tPosition3_la" class="control-label">职称:</label>
								<select class="easyui-combobox" name="tPosition" id="tPosition3">
									<option value="讲师">讲师</option>
									<option value="教授">教授</option>
									<option value="副教授">副教授</option>
								</select>
							</div>
							<div class="form-group" id="tTelephone3_div">
								<label for="tTelephone3" id="tTelephone3_la"
									class="control-label">联系电话:</label> <input type="text"
									name="tTelephone3" class="form-control" id="tTelephone3">
							</div>
						</form>
						<form class="form-horizontal" id="ff2" method="post"></form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							onclick="updateTeacher();">保存</button>
						<button type="button" data-dismiss="modal" class="btn btn-primary"
							id="close" onclick="close();">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			var basePath = "${pageContext.request.contextPath}";
			function deleteTeacher(ele) {
				var tr = $(ele).parent("td").parent("tr");
				var tNo = $(tr).children("td:eq(1)").html();
				alert(tNo);
				if (confirm("是否删除!")) {
					$.ajax({
						url : basePath + "/deleteTeacher/" + tNo,
						method : "get",
						success : function(flag) {
							if (flag)
								$(tr).remove();
						}
					});
				}
			};
			function setValues(ele) {
				var tr = $(ele).parent("td").parent("tr");
				var id = $(tr).children("td:eq(0)").html();
				var tNo = $(tr).children("td:eq(1)").html();
				var tName = $(tr).children("td:eq(2)").html();
				var tTelephone = $(tr).children("td:eq(7)").html();
				alert(id);
				alert(tTelephone)
				$("#editTeacherInfoDialogue #id3").val(id);
				$("#editTeacherInfoDialogue #tNo3").val(tNo);
				$("#editTeacherInfoDialogue #tName3").val(tName);
				$("#editTeacherInfoDialogue #tTelephone3").val(tTelephone);
			}
			function updateTeacher() {
				$.ajax({
					url : basePath + "/updateTeacher",
					data : {
						"id" : $("#editTeacherInfoDialogue #id3").val(),
						"tNo" : $("#editTeacherInfoDialogue #tNo3").val(),
						"tName" : $("#editTeacherInfoDialogue #tName3").val(),
						"tTelephone" : $("#editTeacherInfoDialogue #tTelephone3").val(),
						"tStatus" : $("#editTeacherInfoDialogue #tStatus3").combobox('getValue'),
						"tPosition" : $("#editTeacherInfoDialogue #tPosition3").combobox('getValue')
					},
					method : "post",
					success : function(msg) {
						alert(msg);
						window.location.href = window.location.href;  
					}
				});
			}
		</script>
		<script type="text/javascript" src="../js/tea_infor_set.js"></script>
</body>
</html>