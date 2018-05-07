// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseSelectController.java

package com.student_assessment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student_assessment.service.CourseSelectService;
import com.student_assessment.util.CourseSelectBean;
import com.student_assessment.util.CourseSelectResultBean;
import com.student_assessment.util.PageBean;
@Controller
public class CourseSelectController
{
	@Autowired
	private CourseSelectService courseSelectService;
	//查询学生选修课程的成绩
	@RequestMapping("/selectCourseSelect")
	public String selectCourseSelect(HttpServletRequest request, @RequestParam(name="page",defaultValue="1")Integer page, @RequestParam(name="pageSize",defaultValue="8")Integer pageSize)
	{
		PageHelper.startPage(page.intValue(), pageSize.intValue(), true);
		List<CourseSelectBean> courseSelectBeanList =courseSelectService.selectCourseInfoAll();
		List<CourseSelectBean>courseSelectBeanList2=new ArrayList<CourseSelectBean>();	
		//拆分查询的学生的成绩，设置学生的各科成绩
		for(CourseSelectBean csb:courseSelectBeanList) {
			String[]gradeArray=csb.getGradeString().trim().replaceAll("\\s","").split(",");
			csb.setG1(Integer.parseInt(gradeArray[0]));
			csb.setG2(Integer.parseInt(gradeArray[1]));
			csb.setG3(Integer.parseInt(gradeArray[2]));
			csb.setG4(Integer.parseInt(gradeArray[3]));
			csb.setG5(Integer.parseInt(gradeArray[4]));
			csb.setG6(Integer.parseInt(gradeArray[5]));
			csb.setG7(Integer.parseInt(gradeArray[6]));
			csb.setG8(Integer.parseInt(gradeArray[7]));
			courseSelectBeanList2.add(csb);
		}
		PageInfo<CourseSelectBean> pageInfo = new PageInfo<CourseSelectBean>(courseSelectBeanList);
		PageBean<CourseSelectBean> pb = new PageBean<CourseSelectBean>();
		List<CourseSelectResultBean>couseSelectResultBeanList=courseSelectService.selectCourseSelectAll();
		pb.setRows(pageInfo.getList());
		pb.setTotal(Long.valueOf(pageInfo.getTotal()));
		pb.setPage(page);
		pb.setPageSize(pageSize);
		pb.setTotalPage();
		request.setAttribute("pb",pb);
		request.setAttribute("csrb",couseSelectResultBeanList);
		return "course_select_set";
	}
}
