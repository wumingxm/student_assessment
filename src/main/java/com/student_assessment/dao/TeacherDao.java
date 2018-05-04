// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TeacherDao.java

package com.student_assessment.dao;

import com.student_assessment.pojo.Teacher;
import java.util.List;

public interface TeacherDao
{

	public abstract Teacher selectTeacherByTNo(String s);

	public abstract void deleteStudent(String s);

	public abstract void updateTeacher(Teacher teacher);

	public abstract void addTeacher(Teacher teacher);

	public abstract List selectTeacher(Teacher teacher);

	public abstract void addTeacherList(List list);
}
