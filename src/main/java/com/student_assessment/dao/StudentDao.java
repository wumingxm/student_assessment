// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   StudentDao.java

package com.student_assessment.dao;

import com.student_assessment.pojo.Student;
import com.student_assessment.util.StudentBean;

import java.util.List;
import java.util.Map;

public interface StudentDao
{

	public abstract void addStudent(Student student);

	public abstract List<StudentBean> selectStudent(Student student);

	public abstract void updateStudent(Student student);

	public abstract void deleteStudent(String s);

	public abstract Student selectStudentBySNo(String s);

	public abstract Long selectCount(Map map);
}
