// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ClassesController.java

package com.student_assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student_assessment.pojo.Classes;
import com.student_assessment.service.ClassesService;
@Controller
public class ClassesController
{	@Autowired
	private ClassesService classesService;
	@RequestMapping("/selectClasses")
	@ResponseBody
	public List selectClass(Classes classes)
	{
		return classesService.selectClasses(classes);
	}
}
