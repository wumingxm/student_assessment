<%@ page language="java"  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>Insert title here</title>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	<div id="toolbar">
	 <form id="ff" action="${pageContext.request.contextPath}/selectCourseSelect" style="margin-top:10px;margin-left:10px;">
		<label for="#sNo" id="sNO_L1" style="font-size:15px;"">学号</label>
		<input type="text" id="sNo" class="easyui-textbox" name="sNo" />
		<label for="#sName" id="sName_L1" style="font-size:15px;"">姓名</label>
		<input type="text" id="sName" class="easyui-textbox" name="sName" />
		<a class="easyui-linkbutton" onclick="sub();">查询</a>
	</form>
	</div>
	<table id="index" class="table table-bordered" 
		style="text-align:center;table-layout:fixed;font-size:15px;margin-left:5px;margin-right:5px;">
		<tr id="caption">
			<td style="width:120px;">学号</td>
			<td style="width:100px;"">姓名</td>
			<c:forEach items="${csrb}" var="csrb">
				<td style="width:120px;">${csrb.courseName}</td>
			</c:forEach>
			<td style="width:80px;"">总分</td>
		</tr>
			
		<c:forEach items="${pb.rows}" var="grade">
			<tr>
				<td>${grade.sNo}</td>
				<td>${grade.sName}</td>
				<td>${grade.g1}</td>
				<td>${grade.g2}</td>
				<td>${grade.g3}</td>
				<td>${grade.g4}</td>
				<td>${grade.g5}</td>
				<td>${grade.g6}</td>
				<td>${grade.g7}</td>
				<td>${grade.g8}</td>
				<td>${grade.sum}</td>
			</tr>
		</c:forEach>
	</table>
	<ul class="pagination pager" style="margin-left:600px;">		
		<c:if test="${pb.totalPage ge 1}">
			&nbsp;&nbsp;第${pb.page}页 /共${pb.totalPage}页
		</c:if>
		<c:if test="${pb.page-1 ge 1}">
			&nbsp;&nbsp;<li class="previous active"><a href="${pageContext.request.contextPath}/selectCourseSelect?page=${pb.page-1}&pageSize=${pb.pageSize}" id="last">Previous</a></li>
		</c:if>
		<c:if test="${pb.page+1 le pb.totalPage}">
			&nbsp;&nbsp;<li class="next active"><a href="${pageContext.request.contextPath}/selectCourseSelect?page=${pb.page+1}&pageSize=${pb.pageSize}" id="next">Next</a></li>
		</c:if>
		<form  id="form" action="${pageContext.request.contextPath}/selectCourseSelect" method="post" style="height:14px;display:inline;">
			每页显示的记录数:<select class="easyui-combobox" name="pageSize" id="pageSize" style="margin-right:10px;">
				<option>8</option>
				<option>12</option>
				<option>20</option>
			</select>
			<input type="hidden" value="1" name="page" style="width:0px;height:0px;"/>
		</form>
		至&nbsp;<input type="text" name="page" id="page" style="width:40px;"/>&nbsp;页
		<a id="redirect" href="${pageContext.request.contextPath}/selectCourseSelect?page=${pb.page}&pageSize=${pb.pageSize}">跳转</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/selectCourseSelect?page=${pb.totalPage}&pageSize=${pb.pageSize}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
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
	function sub(){
		$("#ff").submit();
	}
	</script>
</body>
</html>