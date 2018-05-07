<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	span[class='textbox']{
		width:40px;
	}
</style>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<div style="margin-top:5px;font-size:15px;">
		<form method="post" action="selectStudent" id="ff">
			<label for="#collegeName">学院:</label> <select id="collegeName"
				name="collegeId" class="easyui-combobox" data-options="url:'/selectCollege',textField:'collegeName',valueField:'collegeId',editable:false">
				<option value="" selected="selected">请选择学院</option>
			</select> <label for="#className">班级:</label> <select id="className"
				name="classId" style="padding-left: 20px;" class="easyui-combobox" data-options="url:'/selectClasses',textField:'className',valueField:'classId',editable:false">
				<option value="" selected="selected">请选择班级</option>
			</select>
			<label for="#sNo">学号:</label> <input type="text"
				id="sNo" name="sNo" class="easyui-textbox" placeholder="请输入学号"/>
			<label for="#sName">姓名:</label> <input type="text"
				id="sName" name="sName" class="easyui-textbox" placeholder="请输入姓名"/>
			<a class="easyui-linkbutton" onclick="submit();">查询</a>
		</form>
		<table id="index" class="table table-bordered"
		style="
			text-align:center;
			table-layout:fixed;
			margin-top:10px;
			font-size:15px;
			margin-left:5px;">
		<tr id="caption">
			<td width="180px;">身份证号</td>
			<td>学号</td>
			<td width="120px">姓名</td>
			<td width="80px">性别</td>
			<td width="80px">年龄</td>
			<td width="120px">出生日期</td>
			<td width="120px">政治面貌</td>
			<td>班级名称</td>
			<td>院系</td>
		</tr>
		<c:forEach items="${pb.rows}" var="studentBean">
		<tr>
			<td>${studentBean.id}</td>
			<td>${studentBean.sNo}</td>         
	 		<td>${studentBean.sName}</td>                                    
	 		<td>${studentBean.sSex}</td>
	 		<td>${studentBean.sAge}</td>
	 		<td><fmt:formatDate value="${studentBean.sBirthday}" pattern="yyyy-MM-dd"/></td>
	 		<td>${studentBean.sStatus}</td>            
	 		<td>${studentBean.className}</td>
	 		<td>${studentBean.collegeName}</td>
	</tr>
		</c:forEach>
	</table>
	<ul class="pagination pager" style="margin-left:600px;">		
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
			每页显示的记录数:<select class="easyui-combobox" name="pageSize" id="pageSize" style="margin-right:10px;">
				<option>8</option>
				<option>12</option>
				<option>20</option>
			</select>
			<input type="hidden" value="1" name="page" style="width:0px;height:0px;"/>
		</form>
		至&nbsp;<input type="text" class="form-input" name="page"  style="width:40px;"/></span>&nbsp;页
		<a id="redirect" href="${pageContext.request.contextPath}/selectStudent?page=${pb.page}&pageSize=${pb.pageSize}">跳转</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/selectStudent?page=${pb.totalPage}&pageSize=${pb.pageSize}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
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