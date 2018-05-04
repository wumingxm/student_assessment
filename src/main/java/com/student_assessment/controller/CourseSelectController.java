// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseSelectController.java

package com.student_assessment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student_assessment.pojo.Course;
import com.student_assessment.service.CourseSelectService;
import com.student_assessment.util.PageBean;
@Controller
public class CourseSelectController
{
	@Autowired
	private CourseSelectService courseSelectService;
	@RequestMapping("/selectCourseSelect")
	public String selectCourseSelect(HttpServletRequest request, @RequestParam(name="page",defaultValue="1")Integer page, @RequestParam(name="pageSize",defaultValue="8")Integer pageSize)
	{
		PageHelper.startPage(page.intValue(), pageSize.intValue(), true);
		List<Course> list =courseSelectService.selectCourseInfoAll();
		PageInfo<Course> pageInfo = new PageInfo<Course>(list);
		PageBean<Course> pb = new PageBean<Course>();
		pb.setRows(pageInfo.getList());
		pb.setTotal(Long.valueOf(pageInfo.getTotal()));
		pb.setPage(page);
		pb.setPageSize(pageSize);
		pb.setTotalPage();
		request.setAttribute("pb",pb);
		return "course_select_set";
	}
}
