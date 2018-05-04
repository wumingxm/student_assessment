// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   StudentController.java

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
import com.student_assessment.pojo.Student;
import com.student_assessment.service.StudentService;
import com.student_assessment.util.PageBean;
import com.student_assessment.util.StudentBean;

@Controller
public class StudentController
{
	@Autowired
	private StudentService studentService;
	@RequestMapping("/selectStudent")
	public String selectStudent(HttpServletRequest request,Student student, @RequestParam(name="page",defaultValue="1")Integer page,@RequestParam(name="pageSize",defaultValue="8") Integer pageSize)
	{
		PageHelper.startPage(page.intValue(), pageSize.intValue(), true);
		List<StudentBean> list =studentService.selectStudent(student);
		PageInfo<StudentBean> pageInfo = new PageInfo<StudentBean>(list);
		PageBean<StudentBean> pb = new PageBean<StudentBean>();
		pb.setPage(page);
		pb.setRows(pageInfo.getList());
		pb.setTotal(Long.valueOf(pageInfo.getTotal()));
		pb.setPageSize(pageSize);
		pb.setTotalPage();
		request.setAttribute("pb",pb);
		request.setAttribute("pb",pb);
		return "stu_infor_set";
	}
	@RequestMapping("/selectStudentAll")
	@ResponseBody
	public List<StudentBean>selectStudentAll(){
		return studentService.selectStudent(new Student());
	}
}
