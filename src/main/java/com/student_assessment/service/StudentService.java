// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   StudentService.java

package com.student_assessment.service;

import com.student_assessment.pojo.Student;
import com.student_assessment.util.StudentBean;

import java.util.List;
import java.util.Map;

public interface StudentService
{

	Student selectStudentBySNo(String s);
	
	void deleteStudent(String s);

	void updateStudent(Student student);

	void addStudent(Student student);

	List<StudentBean> selectStudent(Student s);

	void addStudentList(List list);

	void updateStudentList(List list);

	Long selectCount(Map map);
}
