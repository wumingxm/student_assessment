
package com.student_assessment.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student_assessment.pojo.Teacher;
import com.student_assessment.service.TeacherService;
import com.student_assessment.util.PageBean;
@Controller
public class TeacherController
{
	@Autowired
	private TeacherService teacherService;
	@RequestMapping("/selectTeacher")
	public String selectTeacher(HttpServletRequest request,Teacher tea, @RequestParam(name="page",defaultValue="1")Integer page, @RequestParam(name="pageSize",defaultValue="10")Integer pageSize)
	{
		Map map = new HashMap();
		List list = teacherService.selectTeacher(tea);
		PageHelper.startPage(page.intValue(),pageSize.intValue());
		PageInfo pageInfo = new PageInfo(list);
		PageBean pb = new PageBean();
		pb.setTotal(Long.valueOf(pageInfo.getTotal()));
		pb.setRows(pageInfo.getList());
		pb.setPage(page);
		pb.setPageSize(pageSize);
		pb.setTotalPage();
		request.setAttribute("pb",pb);
		return "tea_infor_set";
	}
	@RequestMapping("/selectTeacherInfo")
	@ResponseBody
	public List<Teacher> selectTeacherInfo(HttpServletRequest request,Teacher tea, @RequestParam(name="page",defaultValue="1")Integer page, @RequestParam(name="pageSize",defaultValue="10")Integer pageSize)
	{
		List list = teacherService.selectTeacher(tea);
		return list;
	}
	
	@RequestMapping("/addTeacher")
	@ResponseBody
	public String addTeacher(Teacher teacher) {
		List<Teacher>tList=teacherService.selectTeacher(teacher);
		if(tList!=null&&tList.size()>0) {
			return "教师信息已经存在不能重复添加!";
		}else {
			teacherService.addTeacher(teacher);
			return "添加教师细信息成功!";
		}
	}

	@RequestMapping("/deleteTeacher/{tNo}")
	@ResponseBody
	public boolean deleteTeacher(@PathVariable("tNo")String tNo) {
		teacherService.deleteTeacher(tNo);
		return true;
	}
	@RequestMapping("/updateTeacher")
	@ResponseBody
	public String updateTeacher(Teacher teacher) {
		teacherService.updateTeacher(teacher);
		return "更新教师信息成功";
	}
}
