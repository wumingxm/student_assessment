<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: '楷体;'">
	<style type="text/css">
#ff {
	margin-left: 40px;
	margin-top: 15px;
}

#ff:first {
	margin-top: 30px;
}

#stu_imp, #tea_imp, #course_imp, #class_imp, #college_imp, #course_imp {
	width: 200px;
	height: 35px;
}

#btn {
	border-radius: 6px;
}
</style>
	<div id="import">
		<form id="ff" action="/uploadStudent" method="post"
			enctype="multipart/form-data">
			<label for="stu_imp">导入学生信息</label> <input id="stu_imp"
				class="easyui-filebox" name="file" /> <input type="submit"
				value="提交" />
		</form>
		<form id="ff" action="/uploadTeacher" method="post"
			enctype="multipart/form-data">
			<label for="tea_imp">导入教师信息</label> <input id="tea_imp"
				class="easyui-filebox" name="file" /> <input type="submit"
				value="提交" />
		</form>
		<form id="ff" action="/uploadCourse" method="post"
			enctype="multipart/form-data">
			<label for="course_imp">导入课程信息</label> <input id="course_imp"
				class="easyui-filebox" name="file" /> <input type="submit"
				value="提交" />
		</form>
		<form id="ff" class="form-inline" action="/uploadClasses"
			method="post" enctype="multipart/form-data">
			<label for="class_imp">导入班级信息</label> <input id="class_imp"
				class="easyui-filebox" name="file" /> <input type="submit"
				value="提交" />
		</form>
		<form id="ff" action="/uploadCollege" method="post"
			enctype="multipart/form-data">
			<label for="college_imp">导入学院信息</label> <input id="college_imp"
				class="easyui-filebox" name="file" /> <input type="submit"
				value="提交" />
		</form>
		<form id="ff" action="/uploadCourseSelect" method="post"
			enctype="multipart/form-data">
			<label for="course_imp">导入选课信息</label> <input id="course_imp"
				class="easyui-filebox" name="file" /> <input type="submit"
				value="提交" />
		</form>
	</div>
	<!-- <div id="bb">
		<a href="#" class="easyui-linkbutton" id="ok" data-options="iconCls:'icon-ok'">确定</a>
		<a href="#" class="easyui-linkbutton" id="cancel" data-options="iconCls:'icon-cancel'">取消</a>
	</div> -->
	<!-- <script type="text/javascript">
		$("#import").dialog({
			title: '导入基本信息',   
		    minimizable:true,
		    width:400,    
		    height:380,    
		    closed:false,  
		    inline:true,
		    modal:true,
		    cache: false,    
		    buttons:'#bb',
		    border:false,
		});
		$("#cancel").click(function(){
			$("#import").dialog('close');
		})
	</script> -->
</body>
</html>