<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生最终评价</title>
</head>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<div style="margin-top: 10px; font-size: 15px;">
		<form method="post"
			action="${pageContext.request.contextPath}/selectFinalAssessment?page=1&pageSize=8" id="ff">
			<label for="#sNo1">学号:</label> <input type="text" id="sNo1"
				name="sNo" class="easyui-textbox" placeholder="请输入学号" /> <label
				for="#sName1">姓名:</label> <input type="text" id="sName1"
				name="sName" class="easyui-textbox" placeholder="请输入姓名" /> 
				<label for="classId">班级名称</label>
				<select id="className" name="classId" class="easyui-combobox" style="width:120px;" data-options="url:'/selectClasses', textField:'className',valueField:'classId'"></select>
				<a class="easyui-linkbutton" type="submit" id="btn">查询</a>
		</form>
		<c:if test="${pb.rows!=null}">
		<table id="index" class="table table-bordered"
			style="text-align: center; table-layout: fixed; margin-top: 10px; font-size: 15px; margin-left: 5px;">
			<tr id="caption">
				<td>学号</td>
				<td>姓名</td> 
				<c:forEach items="${assessStandardList}" var="assessStandard">
					<td>${assessStandard.assessItemName}</td>
				</c:forEach>
				<td>总分</td>
				<td>操作</td> 
			</tr>
			<c:forEach items="${pb.rows}" var="assessResultBean">
				<tr>
					<td>${assessResultBean.sNo}</td>
					<td>${assessResultBean.sName}</td>
					<!-- 显示得分 -->
					<c:forEach items="${assessResultBean.assessScoreList}" var="ast">
						<td>${ast.assessItemGrade}</td>
					</c:forEach>
					<td>${assessResultBean.sum}</td>
					<td><a id="edit" +userBean.index
						class=" glyphicon glyphicon-pencil" data-toggle="modal"
						data-target="#editDialogue" onclick="setValues(this)"
						style="color: #EE2C2C">&nbsp;</a> &nbsp;<a id="del"
						+userBean.index class="glyphicon glyphicon-trash"
						style="margin-left: 10px; color: #EE2C2C"
						onclick="deleteRow(this)">&nbsp</a></td>
				</tr>
			</c:forEach>
		</table>
		<ul class="pagination pager" style="margin-left: 700px;">
			<c:if test="${pb.totalPage ge 1}">
			&nbsp;&nbsp;第${pb.page}页 /共${pb.totalPage}页 
		</c:if>
			<c:if test="${pb.page-1 ge 1}">
			&nbsp;&nbsp;<li class="previous active"><a
					href="${pageContext.request.contextPath}/selectFinalAssessment?page=${pb.page-1}&pageSize=${pb.pageSize}"
					id="last">Previous</a></li>
			</c:if>
			<c:if test="${pb.page+1 le pb.totalPage}">
			&nbsp;&nbsp;<li class="next active"><a
					href="${pageContext.request.contextPath}/selectFinalAssessment?page=${pb.page+1}&pageSize=${pb.pageSize}"
					id="next">Next</a></li>
			</c:if>
			至&nbsp;
			<input type="text" class="easyui-textbox" name="page" id="page"
				style="width: 40px;" />&nbsp;页
			<a id="redirect"
				href="${pageContext.request.contextPath}/selectFinalAssessment?page=${pb.page}&pageSize=${pb.pageSize}">跳转</a>&nbsp;&nbsp;&nbsp;
			<a
				href="${pageContext.request.contextPath}/selectFinalAssessment?page=${pb.totalPage}&pageSize=${pb.pageSize}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</ul>
		<span style="margin-left: 25px;"">共${pb.total}条记录</span>
		</c:if>
		<script type="text/javascript" src="../js/stu_final_assess.js"></script>
</body>
</html>