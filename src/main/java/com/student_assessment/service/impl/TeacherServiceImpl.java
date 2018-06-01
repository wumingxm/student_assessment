// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TeacherServiceImpl.java

package com.student_assessment.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.TeacherDao;
import com.student_assessment.pojo.Teacher;
import com.student_assessment.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;

	//根据教工号查询教师信息
	public Teacher selectTeacherByTNo(String tNo) {
		return teacherDao.selectTeacherByTNo(tNo);
	}
	
	//删除教师信息
	public void deleteTeacher(String tNo) {
		teacherDao.deleteTeacher(tNo);
	}

	public void updateTeacher(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}
	
	//添加教师信息
	public void addTeacher(Teacher teacher) {
		teacherDao.addTeacher(teacher);
	}
	
	//查询教师信息
	public List selectTeacher(Teacher teacher) {
		return teacherDao.selectTeacher(teacher);
	}
}
