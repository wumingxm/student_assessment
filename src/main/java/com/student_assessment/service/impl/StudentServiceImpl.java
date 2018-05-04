// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   StudentServiceImpl.java

package com.student_assessment.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.StudentDao;
import com.student_assessment.pojo.Student;
import com.student_assessment.service.StudentService;
import com.student_assessment.util.StudentBean;
@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentDao studentDao;

	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	public List<StudentBean> selectStudent(Student student) {
		return studentDao.selectStudent(student);
	}

	public void addStudentList(List uList) {
		Student student;
		for (Iterator iterator = uList.iterator(); iterator.hasNext(); studentDao.addStudent(student))
			student = (Student) iterator.next();

	}

	public void updateStudentList(List uList) {
		Student student;
		for (Iterator iterator = uList.iterator(); iterator.hasNext(); studentDao.updateStudent(student))
			student = (Student) iterator.next();

	}

	public Student selectStudentBySNo(String sNo) {
		return studentDao.selectStudentBySNo(sNo);
	}

	public void deleteStudent(String sNo) {
		studentDao.deleteStudent(sNo);
	}

	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

	public Long selectCount(Map map) {
		return studentDao.selectCount(map);
	}
}
