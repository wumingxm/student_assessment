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
import com.student_assessment.pojo.CourseSelect;
import com.student_assessment.pojo.Student;
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
	public String selectCourseSelect(Student student,HttpServletRequest request, @RequestParam(name="page",defaultValue="1")Integer page, @RequestParam(name="pageSize",defaultValue="8")Integer pageSize)
	{
		PageHelper.startPage(page.intValue(), pageSize.intValue(), true);
		List<CourseSelectBean> courseSelectBeanList =courseSelectService.selectCourseInfoAll(student);
		List<CourseSelectBean>courseSelectBeanList2=new ArrayList<CourseSelectBean>();	
		List<CourseSelectResultBean>couseSelectResultBeanList=courseSelectService.selectCourseSelectAll(student);
		//拆分查询的学生的成绩，设置学生的各科成绩
		for(CourseSelectBean csb:courseSelectBeanList) {
			List<CourseSelect>cList=new ArrayList<CourseSelect>();
			String[]gradeArray=csb.getGradeString().trim().replaceAll("\\s","").split(",");
			Integer sum=0;
			for(int i=0;i<gradeArray.length;i++) {
				Integer grade=Integer .parseInt(gradeArray[i]);
				CourseSelect courseSelect=new CourseSelect();
				courseSelect.setGrade(grade);
				courseSelect.setCourseId(couseSelectResultBeanList.get(i).getCourseId());
				sum+=grade;
				cList.add(courseSelect);
			}
			csb.setcList(cList);
			csb.setSum(sum);			
			courseSelectBeanList2.add(csb);
		}
		PageInfo<CourseSelectBean> pageInfo = new PageInfo<CourseSelectBean>(courseSelectBeanList);
		PageBean<CourseSelectBean> pb = new PageBean<CourseSelectBean>();
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
