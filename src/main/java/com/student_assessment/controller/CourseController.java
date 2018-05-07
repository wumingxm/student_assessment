package com.student_assessment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student_assessment.pojo.Course;
import com.student_assessment.service.CourseService;
import com.student_assessment.util.CourseBean;
import com.student_assessment.util.PageBean;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	@RequestMapping("/selectCourseAll")
	public String selectCourseAll(HttpServletRequest request,Course course,@RequestParam(name="page",defaultValue="1")Integer page,@RequestParam(name="pageSize",defaultValue="8")Integer pageSize){
		PageHelper.startPage(page,pageSize,true);
		List<CourseBean>courseBeanList=courseService.selectCourseAll(course);
		PageInfo<CourseBean>pageInfo=new PageInfo<CourseBean>(courseBeanList);
		PageBean<CourseBean>pb=new PageBean<CourseBean>();
		pb.setPage(page);
		pb.setPageSize(pageSize);
		pb.setRows(pageInfo.getList());
		pb.setTotal(pageInfo.getTotal());
		pb.setTotalPage();
		request.setAttribute("pb",pb);
		return "course_set";
	}

	@RequestMapping("/addCourse")
	@ResponseBody
	public String  addCourse(Course course) {
		List<Course>list=courseService.selectCourseAll(course);
		courseService.addCourse(course);
		return "添加课程信息成功!";
	}
	
	@RequestMapping("/updateCourse")
	@ResponseBody
	public String  updateCourse(Course course) {
		List<Course>list=courseService.selectCourseAll(course);
		courseService.updateCourse(course);
		return "更新课程信息成功！";
	}
	
	@RequestMapping("/deleteCourse")
	@ResponseBody
	public boolean deleteCourse(String courseId) {
		courseService.deleteCourse(courseId);
		return true;
	}
}
