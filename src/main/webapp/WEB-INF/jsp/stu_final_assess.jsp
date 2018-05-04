<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生最终评价</title>
</head>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<div style="margin-top:10px;">
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
		style="text-align:center;table-layout:fixed;margin-top:10px;">
		<tr id="caption">
			<td>学号</td>
			<td>姓名</td>
			<td>道德品质</td>
			<td>公民素养</td>
			<td>交流与合作</td>
			<td>运动健康</td>
			<td>总分</td>
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
	 		<td>${assessResultBean.totalScore}</td>
	 		<td><a  id="edit"+userBean.index class=" glyphicon glyphicon-pencil" data-toggle="modal" data-target="#editDialogue" onclick="setValues(this)" style="color:#EE2C2C">&nbsp;</a>
	 		&nbsp;<a  id="del"+userBean.index class="glyphicon glyphicon-trash" style="margin-left:10px;color:#EE2C2C" onclick="deleteRow(this)">&nbsp</a></td>
		</tr>
		</c:forEach>
	</table>
	<ul class="pagination pager" style="margin-left:700px;">		
		<c:if test="${pb.totalPage ge 1}">
			&nbsp;&nbsp;第${pb.page}页 /共${pb.totalPage}页 
		</c:if>
		<c:if test="${pb.page-1 ge 1}">
			&nbsp;&nbsp;<li class="previous active"><a href="${pageContext.request.contextPath}/selectStudent?page=${pb.page-1}&pageSize=${pb.pageSize}" id="last">Previous</a></li>
		</c:if>
		<c:if test="${pb.page+1 le pb.totalPage}">
			&nbsp;&nbsp;<li class="next active"><a href="${pageContext.request.contextPath}/selectStudent?page=${pb.page+1}&pageSize=${pb.pageSize}" id="next">Next</a></li>
		</c:if>
		<form  id="form" action="${pageContext.request.contextPath}/selectStudent" method="post" style="height:14px;display:inline;">
			每页显示的记录数:<select name="pageSize"  class="easyui-combobox" id="pageSize" style="margin-right:10px;">
				<option>8</option>
				<option>12</option>
				<option>20</option>
			</select>
			<input type="hidden"  value="1" name="page" style="width:0px;height:0px;"/>
		</form>
		至&nbsp;<input type="text"  class="easyui-textbox" name="page" id="page" style="width:40px;"/>&nbsp;页
		<a id="redirect" href="${pageContext.request.contextPath}/selectStudent?page=${pb.page}&pageSize=${pb.pageSize}">跳转</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/selectStudent?page=${pb.totalPage}&pageSize=${pb.pageSize}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</ul>
	<span style="margin-left:25px;"">共${pb.total}条记录</span>
</body>
</html>