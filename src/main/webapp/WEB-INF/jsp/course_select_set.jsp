<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Insert title here</title>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<div id="toolbar">
		<form id="ff"
			action="${pageContext.request.contextPath}/selectCourseSelect"
			style="margin-top: 10px; margin-left: 10px;" method="post">
			<label for="#sNo" id="sNO_L1" style="font-size: 15px;"">学号</label> <input
				type="text" id="sNo" class="easyui-textbox" name="sNo" /> <label
				for="#sName" id="sName_L1" style="font-size: 15px;"">姓名</label> <input
				type="text" id="sName" class="easyui-textbox" name="sName" /> <label
				for="#classId" id="className_L1" style="font-size: 15px;"">班级名称:</label>
				<select id="className" name="classId" class="easyui-combobox" style="width:120px;" data-options="url:'/selectClasses',textField:'className',valueField:'classId'"></select>
				<a class="easyui-linkbutton" onclick="sub();">查询</a>
		</form>
	</div>
	<c:if test="${csrb!=null}">
	<table id="index" class="table table-bordered"
		style="text-align: center; table-layout: fixed; font-size: 15px; margin-left: 5px; margin-right: 5px;margin-top:5px;">
		<tr id="caption">
			<td style="width: 120px;">学号</td>
			<td style="width: 100px;"">姓名</td>
			<c:forEach items="${csrb}" var="csb">
				<td style="width: 120px;">${csb.courseName}</td>
			</c:forEach>
			<td style="width: 80px;"">总分</td>
		</tr>

		<c:forEach items="${pb.rows}" var="csb">
			<tr>
				<td>${csb.sNo}</td>
				<td>${csb.sName}</td>
				<c:forEach items="${csb.cList}" var="courseGrade">
					<td>${courseGrade.grade} </td>
				</c:forEach>
				<td>${csb.sum}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<ul class="pagination pager" style="margin-left:700px;">
		<c:if test="${pb.totalPage ge 1}">
			&nbsp;&nbsp;第${pb.page}页 /共${pb.totalPage}页
		</c:if>
		<c:if test="${pb.page-1 ge 1}">
			&nbsp;&nbsp;<li class="previous active"><a
				href="${pageContext.request.contextPath}/selectCourseSelect?page=${pb.page-1}&pageSize=${pb.pageSize}"
				id="last">Previous</a></li>
		</c:if>
		<c:if test="${pb.page+1 le pb.totalPage}">
			&nbsp;&nbsp;<li class="next active"><a
				href="${pageContext.request.contextPath}/selectCourseSelect?page=${pb.page+1}&pageSize=${pb.pageSize}"
				id="next">Next</a></li>
		至&nbsp;
		<input type="text" name="page" id="page" style="width: 40px;" />&nbsp;页
		<a id="redirect"
			href="${pageContext.request.contextPath}/selectCourseSelect?page=${pb.page}&pageSize=${pb.pageSize}">跳转</a>&nbsp;&nbsp;&nbsp;
		<a
			href="${pageContext.request.contextPath}/selectCourseSelect?page=${pb.totalPage}&pageSize=${pb.pageSize}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</ul>
	<span style="margin-left: 25px;"">共${pb.total}条记录</span>
	</c:if>
	<script type="text/javascript" src="../js/course_select_set.js"></script>
</body>
</html>