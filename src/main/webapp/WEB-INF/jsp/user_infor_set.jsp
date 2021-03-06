<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>用户管理</title>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<div style="margin-top: 10px;font-size:15px;">
		<form method="post"
			action="${pageContext.request.contextPath}/selectUserDetialInformation"
			id="ff">
				<label for="#userName1">用户名:</label> 
				<input type="text" id="userName1" name="userName" class="easyui-textbox" placeholder="请输入用户名" /> 
				<label for="#rName1">姓名:</label> <input type="text" id="rName1"
				name="rName" class="easyui-textbox" placeholder="请输入姓名" />
				<button class="btn btn-primary">查询</button>
		</form>
		<a class="glyphicon glyphicon-plus-sign" data-toggle="modal"
			data-target="#addDialogue" style="color:'#54FF9F'; margin-left: 5px;">添加用户</a>
		<table id="index" class="table table-bordered"
			style="text-align: center; 
			table-layout: fixed; 
			margin-top: 10px;
			margin-left:5px;
			margin-right:5px;
			font-size:15px;">
			<tr id="caption">
				<td>用户名</td>
				<td>姓名</td>
				<td>密码</td>
				<td>用户类型</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${pb.rows}" var="userBean">
				<tr>
					<td>${userBean.userName}</td>
					<td>${userBean.rName}</td>
					<td>${userBean.passWord}</td>
					<td>${userBean.userTypeName}</td>
					<td><a id="edit" +userBean.index
						class=" glyphicon glyphicon-pencil" data-toggle="modal"
						data-target="#editDialogue" onclick="setValues(this)"
						style="color: '#54FF9F'">&nbsp;</a> &nbsp;<a id="del"
						+userBean.index class="glyphicon glyphicon-trash"
						style="margin-left: 10px; color: #EE2C2C"
						onclick="deleteRow(this)">&nbsp</a></td>
				</tr>
			</c:forEach>
		</table>
		<ul class="pagination pager" style="margin-left:600px;margin-top:0px;">
			<c:if test="${pb.totalPage ge 1}">
			&nbsp;&nbsp;第${pb.page}页
					/共${pb.totalPage}页
			</c:if>
			<c:if test="${pb.page-1 ge 1}">
			&nbsp;&nbsp;<li class="previous active"><a
					href="${pageContext.request.contextPath}/selectUserDetialInformation?page=${pb.page-1}&pageSize=${pb.pageSize}"
					id="last">Previous</a></li>
			</c:if>
			<c:if test="${pb.page+1 le pb.totalPage}">
			&nbsp;&nbsp;<li class="next active"><a
					href="${pageContext.request.contextPath}/selectUserDetialInformation?page=${pb.page+1}&pageSize=${pb.pageSize}"
					id="next">Next</a></li>
			</c:if>
			<form id="form"
				action="${pageContext.request.contextPath}/selectUserDetialInformation"
				method="post" style="height: 14px; display: inline;">
				每页显示的记录数:<select class="easyui-combobox" name="pageSize" id="pageSize"
					style="margin-right: 10px;">
					<option>8</option>
					<option>12</option>
					<option>20</option>
				</select> <input type="hidden" value="1" name="page"
					style="width: 0px; height: 0px;" />
			</form>
			至&nbsp;
			<input type="text" class="easyui-textbox" name="page" id="page" style="width:40px;" />
			&nbsp;页
			<a id="redirect"
				href="${pageContext.request.contextPath}/selectUserDetialInformation?page=${pb.page}&pageSize=${pb.pageSize}">跳转</a>&nbsp;&nbsp;&nbsp;
			<a
				href="${pageContext.request.contextPath}/selectUserDetialInformation?page=${pb.totalPage}&pageSize=${pb.pageSize}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</ul>
		<span style="margin-left: 25px;"">共${pb.total}条记录</span>
		<!-- 添加用户信息 -->
		<div class="modal fade" id="addDialogue" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document"
				style="width: 700px; height: 800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">添加用户信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="ff3">
							<div class="form-group">
								<label for="userName3" class="col-sm-2 control-label">用户名</label>
								<div class="col-md-6">
									<input type="text" name="userName"
										class="form-control col-md-4" id="userName3"> <span
										id="" class="help-block"></span> <span id="userNameError1"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">密码</label>
								<div class="col-md-6">
									<input id="passWord3" type="password" name="passWord"
										class="form-control" /> <span id="passWordError1"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">确认密码</label>
								<div class="col-md-6">
									<input id="passWord31" type="password" name="confirmPassword"
										id="passWord2" class="form-control" /> <span
										id="passWordError2"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2" style="margin-left: 10px;">用户类型</label>
								<div class="col-sm-4">
									<select id="userTypeName3" class="form-control"
										name="userTypeId" id="userTypeName"
										style="margin-left: -10px;">
										<option value="1" selected>学生</option>
										<option value="2">教师</option>
										<option value="3">管理员</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" id="save2">保存</button>
						<button type="button" data-dismiss="modal" class="btn btn-primary" id="close2">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="editDialogue" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document"
				style="width: 700px; height: 800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">编辑 用户信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="ff2" method="post">
							<!-- <div class="form-group">
								<label for="sNo2" class="col-sm-2 control-label">学号</label>
								<div class="col-sm-10">
									<input type="text" name="rNo" class="form-control" id="rNo2"
										disabled="disabled"> <span class="help-block"></span>
								</div>
							</div> -->
							<div class="form-group">
								<label for="userName2" class="col-sm-2 control-label">用户名</label>
								<div class="col-sm-10">
									<input type="text" name="userName" class="form-control"
										id="userName2" disabled="disabled"> <span id=""
										class="help-block"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">密码</label>
								<div class="col-sm-10">
									<input id="passWord2" type="password" name="passWord"
										class="form-control" disabled="disabled" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2" style="margin-left: 10px;">用户类型</label>
								<div class="col-sm-4">
									<select id="userTypeName2" class="form-control"
										name="userTypeId" id="userTypeName"
										style="margin-left: -10px;">
										<option value="1" selected>学生</option>
										<option value="2">教师</option>
										<option value="3">管理员</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							onclick="updateUser();">保存</button>
						<button type="button" data-dismiss="modal" class="btn btn-primary" id="close"
							onclick="close();">关闭</button>
					</div>
				</div>
			</div>
		</div>
		
	<script type="text/javascript">
	function setValues(ele){
		var basePath="${pageContext.request.contextPath}";
		var tr=$(ele).parent("td").parent("tr");
		var rNo=$(tr).children("td:eq(0)").html();
		var userName=$(tr).children("td:eq(1)").html();
		var rName=$(tr).children("td:eq(2)").html();
		var passWord=$(tr).children("td:eq(3)").html();
		var userTypeName=$(tr).children("td:eq(4)").val();
		$("#editDialogue #rNo2").val(rNo);
		$("#editDialogue #userName2").val(userName);
		$("#editDialogue #passWord2").val(passWord);	
		$("#editDialogue #userTypeId2").val(userTypeName);
		var userTypeOptions=$("#addDialogue #userTypeName").find("option");
		for(var i=1;i<=userTypeOptions.length;i++){
			if(userTypeName==userTypeOptions[i].html()){
				$(userTypeOptions[i]).attr("selected","selected");
			}
		}
	}
	function updateUser(){
		$.ajax({
			url:"/updateUser",
			data:{
				"rNo":$("#addDialogue #rNo2").val(),
				"userName":$("#addDialogue #userName2").val(),
				"passWord":$("#addDialogue #passWord2").val(),
				"userTypeId":$("#addDialogue #userTypeName2").val()
			},
			method:"post",
		    success:function(msg){
		    	alert(msg);
		    	window.location.href = window.location.href;  
		    }
		});
	}
	function deleteUser(ele){
		var tr=$(ele).parent("td").parent("tr");
		var userName=$(tr).children("td:eq(1)").html();
		if(confirm("是否删除!")){
			$.ajax({
				url:"/deleteUser/"+userName,
				method:"get",
				success:function(flag){
					if(flag)
					$(tr).remove();
				}
			});
		}
	}
	</script>
	<script type="text/javascript" src="../js/user_infor_set.js"></script>
</body>
</html>
