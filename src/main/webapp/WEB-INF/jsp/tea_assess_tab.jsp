<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/tea_assess_tab.css">
<title>学生评价管理页面</title>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<div style="margin-top:10px;font-size:15px">
		<form method="post" action="${pageContext.request.contextPath}/selectUser/1/10" id="ff">
			<label for="#sNo1">学号:</label> <input type="text"
				id="sNo1" name="sNo" class="easyui-textbox" placeholder="请输入学号"/>
			<label for="#sName1">姓名:</label> <input type="text"
				id="sName1" name="sName" class="easyui-textbox" placeholder="请输入姓名"/>
			<label for="#userName1">用户名:</label> <input type="text"
				id="userName1" name="userName" class="easyui-textbox" placeholder="请输入用户名"/>		
			<a class="easyui-linkbutton" onclick="submit();">查询</a>
		</form>
		<br/>
		<a class="glyphicon glyphicon-plus-sign"  href="#" data-toggle="modal" data-target="#tea_assess_tab" style="color:green;margin-left:5px;" style="margin-top:10px;">添加教师评价信息</a>
		<table id="index" class="table table-bordered"
		style="text-align:center;
		table-layout:fixed;
		margin-top:10px;
		font-size:15px;">
		<tr id="caption">
			<td>学号</td>
			<td>姓名</td>
			<td>道德品质</td>
			<td>公民素养</td>
			<td>交流与合作</td>
			<td>运动健康</td>
			<td>评价人</td>
			<td>评价日期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pb.rows}" var="assessResultBean">
		<tr>
			<td>${assessResultBean.sNo}</td>         
	 		<td>${assessResultBean.sName}</td>                                    
	 		<td>${assessResultBean.moralTrait}</td>
	 		<td>${assessResultBean.civicLiteracy}</td>
	 		<td>${assessResultBean.liaision}</td>
	 		<td>${assessResultBean.exerciseHealth}</td>
	 		<td>${assessResultBean.assessManId}</td>
	 		<td><fmt:formatDate value="${assessResultBean.assessDate}" pattern="yyyy-MM-dd"/></td>
	 		<td><a  id="edit"+userBean.index class=" glyphicon glyphicon-pencil" data-toggle="modal" data-target="#editDialogue" onclick="setValues(this)" style="color:#EE2C2C">&nbsp;</a>
	 		&nbsp;<a  id="del"+userBean.index class="glyphicon glyphicon-trash" style="margin-left:10px;color:#EE2C2C" onclick="deleteRow(this)">&nbsp</a></td>
		</tr>
		</c:forEach>
	</table>
	<ul class="pagination pager" style="margin-left:300px;">		
		<c:if test="${pb.totalPage ge 1}">
			&nbsp;&nbsp;第${pb.page}页 /共${pb.totalPage}页 
		</c:if>
		<c:if test="${pb.page-1 ge 1}">
			&nbsp;&nbsp;<li class="previous active"><a href="${pageContext.request.contextPath}/generateAssessTab?page=${pb.page-1}&pageSize=${pb.pageSize}" id="last">Previous</a></li>
		</c:if>
		<c:if test="${pb.page+1 le pb.totalPage}">
			&nbsp;&nbsp;<li class="next active"><a href="${pageContext.request.contextPath}/generateAssessTab?page=${pb.page+1}&pageSize=${pb.pageSize}" id="next">Next</a></li>
		</c:if>
		<form  id="form" action="${pageContext.request.contextPath}/generateAssessTab" method="post" style="height:14px;display:inline;">
			每页显示的记录数:<select class="easyui-combobox" name="pageSize" id="pageSize" style="margin-right:10px;">
				<option>8</option>
				<option>12</option>
				<option>20</option>
			</select>
			<input type="hidden" value="1" name="page" style="width:0px;height:0px;"/>
		</form>
		至&nbsp;<input type="text" class="easyui-textbox" name="page" id="page"  style="width:40px;" />&nbsp;页
		<a id="redirect" href="${pageContext.request.contextPath}/generateAssessTab?page=${pb.page}&pageSize=${pb.pageSize}">跳转</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/generateAssessTab?page=${pb.totalPage}&pageSize=${pb.pageSize}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</ul>
	<span style="margin-left:25px;"">共${pb.total}条记录</span>
	<!-- Modal -->
		<div class="modal fade" id="editDialogue" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document" style="width:700px;height:800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">编辑 用户信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="sNo" class="col-sm-2 control-label">学号</label>
								<div class="col-sm-10">
									<input type="text" name="sNo" class="form-control"
										id="sNo" disabled="disabled"> <span class="help-block"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="sName" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-10">
									<input type="text" name="sName" class="form-control"
										id="sName"  disabled="disabled"> <span id="" class="help-block"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">密码</label>
								<div class="col-sm-10">
									<input id="passWord" type="password" name="passWord" class="form-control" disabled="disabled"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2" style="margin-left:10px;">用户类型</label>
								<div class="col-sm-4">
									<select id="userTypeName" class="form-control" name="userTypeId" id="userTypeName" style="margin-left:-10px;">
										<option value="1" selected>学生</option>
										<option value="2">教师</option>
										<option value="3">管理员</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" onclick="updateUser();">保存</button>
						<button type="button" class="btn btn-primary" id="close" onclick="close();">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 添加教师评价 -->
		<div class="modal fade" id="tea_assess_tab" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document" style="width:700px;height:800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">添加教师评价</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<label for="sNo2" id="sNo2_la">学号</label>
							<select name="sNo" class="easyui-combobox" id="sNo2" style="width:200px;" data-options="url:'${pageContext.request.contextPath}/selectStudentAll',valueField:'sNo',textField:'sName',editable:false"></select>
							<label for="moralTrait2" style="margin-left:2em;">道德品质</label>
							<select name="moralTrait" id="moralTrait2" class="easyui-combobox" style="width:200px;">s
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
							<br/>
							<label for="civicLiteracy2" id="civicLiteracy2_la">公民素养</label>
							<select name="civicLiteracy" class="easyui-combobox" id="civicLiteracy2" style="width:200px;">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
							<label for="liaision2" id="liaision2_la" style="margin-left:2em;margin-top:1em;">交流合作</label>
							<select class="easyui-combobox" name="liaision"  id="liaision2" style="width:200px;">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
							<br/>
							<label for="exerciseHealth2" id="exercieHealth2_la" style="margin-top:1em;">运动健康</label>
							<select class="easyui-combobox"  name="exerciseHealth" id="exerciseHealth2" style="width:200px;">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
							<label for="appearance2" id="appearance2_la" style="margin-left:2em;margin-top:1em;">审美表现</label>
							<select class="easyui-combobox" name="appearance" id="appearance2" style="width:200px;">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
							<br/>
							<label for="academicYear2"  id="academicYear2_la" style="margin-top:1em;">评价学年</label>
							<select id="academicYear2" name="academicYear" class="easyui-combobox" style="width:200px;">
								<option>2014-2015</option>
								<option>2016-2017</option>
								<option>2017-2018</option>
							</select>
							<label for="term2" id="term_la" style="margin-left:2em;margin-top:1em;">评价学期</label>
							<select id="term2" name="term" class="easyui-combobox" style="width:200px;">
								<option>1</option>
								<option>2</option>
							</select>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"  id="save2" data-dismiss="modal">保存</button>
						<button type="button" class="btn btn-primary" id="close2">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
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
			function submit(){
				$("#ff").submit();
			}
			function deleteRow(ele){
				var tr=$(ele).parent("td").parent("tr");
				var sNo=$(tr).children("td:eq(0)").html();
				var assessManId=$(tr).children("td:eq(6)").html();
				alert(sNo);
				if(confirm("是否删除!")){
					$.ajax({
						url:"${pageContext.request.contextPath}/deleteTeacherAssessment?sNo="+sNo+"&assessManId="+assessManId,
						method:"post",
						success:function(flag){
							if(flag){
								$(tr).remove();
								alert("删除教师评价信息成功!");
							}
						}
					});
				}
			}
			$("#save2").click(function(){
				 $.ajax({
					 url:'${pageContext.request.contextPath}/addTeacherAssess',
					 data:{
						 'sNo':$('#sNo2').combobox('getValue'),
						 'academicYear':$("#academicYear2").val(),
	 					 'term':$("#term2").val(),
	 					 'moralTrait':$("#moralTrait2").val(),
	 					 'civicLiteracy':$('#civicLiteracy2').val(),
	 					 'exerciseHealth':$("#exerciseHealth2").val(),
	 					 'liaision':$("#liaision2").val(),
	 					 'exerciseHealth':$('#exerciseHealth2').val(),
	 					 'appearance':$("#appearance2").val()
					 },
					 method:'post'
				 })
			});
			$("#close2").click(function(){
				$("#tea_assess_tab").modal('hide');
			});
	</script>
</body>
</html>