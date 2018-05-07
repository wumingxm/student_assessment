<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<div style="margin-top:5px;font-size:15px;">
		<form method="post" id="ff" action="${pageContext.request.contextPath}/selectTeacher">
			<label for="#collegeName">学院:</label> <select id="collegeName"
				name="collegeId" class="easyui-combobox" data-options="url:'/selectCollege',textField:'collegeName',valueField:'collegeId',editable:false">
				<option selected="selected" value="">请选择学院</option>
			</select>
			<label for="#tNo">教工号:</label>
			<input id="tNo" type="text" class="easyui-textbox" name="tNo"/>
			<label for="#tName">教工姓名:</label>
			<input type="text" id="tName" name="tName" class="easyui-textbox"/>
			<a class="easyui-linkbutton" onclick="submit();">查询</a>
		</form>
		<table id="index" class="table table-bordered"
		style="text-align:center;table-layout:fixed;margin-top:10px;font-size:15px;margin-left:5px;">
		<tr id="caption">
			<td style="width:180px;">身份证号</td>
			<td>教工号</td>
			<td>教工姓名</td>
			<td style="width:80px;">年龄</td>
			<td style="width:80px;">性别</td>
			<td>政治面貌</td>
			<td>民族</td>
			<td>出生日期</td>
			<td>职称</td>
			<td>联系电话</td>
		</tr>
		<c:forEach items="${pb.rows}" var="teacher">
		<tr>
			<td>${teacher.id}</td>
			<td>${teacher.tNo}</td>         
	 		<td>${teacher.tName}</td>                                    
	 		<td>${teacher.tSex}</td>
	 		<td>${teacher.tAge}</td>
	 		<td>${teacher.tStatus}</td>
	 		<td>${teacher.tMinority}</td>
	 		<td><fmt:formatDate value="${teacher.tBirthday}" pattern="yyyy-MM-dd" /></td>
	 		<td>${teacher.tPosition}</td>            
	 		<td>${teacher.tTelephone}</td>
	</tr>
		</c:forEach>
	</table>
	<ul class="pagination pager" style="margin-left:600px;">		
		<c:if test="${pb.totalPage ge 1}">
			&nbsp;&nbsp;第${pb.page}页 /共${pb.totalPage}页  
		</c:if>
		<c:if test="${pb.page-1 ge 1}">
			&nbsp;&nbsp;<li class="previous active"><a href="${pageContext.request.contextPath}/selectTeacher?page=${pb.page-1}&pageSize=${pb.pageSize}" id="last">Previous</a></li>
		</c:if>
		<c:if test="${pb.page+1 le pb.totalPage}">
			&nbsp;&nbsp;<li class="next active"><a href="${pageContext.request.contextPath}/selectTeacher?page=${pb.page+1}&pageSize=${pb.pageSize}" id="next">Next</a></li>
		</c:if>
		<form  id="form" action="${pageContext.request.contextPath}/selectTeacher" method="post" style="height:14px;display:inline;">
			每页显示的记录数:<select name="pageSize" id="pageSize" style="margin-right:10px;">
				<option>8</option>
				<option>12</option>
				<option>20</option>
			</select>
			<input type="hidden" value="1" name="page" style="width:0px;height:0px;"/>
		</form>
		至&nbsp;<input type="text" name="page" id="page" style="width:40px;"/>&nbsp;页
		<a id="redirect" href="${pageContext.request.contextPath}/selectTeacher?page=${pb.page}&pageSize=${pb.pageSize}">跳转</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/selectTeacher?page=${pb.totalPage}&pageSize=${pb.pageSize}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</ul>
	<span style="margin-left:25px;"">共${pb.total}条记录</span>
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
	</script>
</body>
</html>