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

	public Teacher selectTeacherByTNo(String tNo) {
		return teacherDao.selectTeacherByTNo(tNo);
	}

	public void deleteStudent(String tNo) {
		teacherDao.deleteStudent(tNo);
	}

	public void updateTeacher(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}

	public void addTeacher(Teacher teacher) {
		teacherDao.addTeacher(teacher);
	}

	public List selectTeacher(Teacher teacher) {
		return teacherDao.selectTeacher(teacher);
	}

	public void addTeacherList(List tList) {
		Teacher teacher;
		for (Iterator iterator = tList.iterator(); iterator.hasNext(); teacherDao.addTeacher(teacher))
			teacher = (Teacher) iterator.next();

	}

	public void updateTeacherList(List tList) {
		Teacher teacher;
		for (Iterator iterator = tList.iterator(); iterator.hasNext(); teacherDao.updateTeacher(teacher))
			teacher = (Teacher) iterator.next();

	}
}
