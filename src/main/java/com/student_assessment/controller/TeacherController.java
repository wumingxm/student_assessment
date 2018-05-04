// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TeacherController.java

package com.student_assessment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
