// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseDao.java

package com.student_assessment.dao;

import com.student_assessment.pojo.Course;
import java.util.List;

public interface CourseDao
{

	 Course selectCourseBySNo(String s);

	 void deleteCourse(String s);

	 void updateCourse(Course course);

	 void addCourse(Course course);

	 List selectCourseAll(Course course);

	 void addCourseList(List list);

	 void updateCourseList(List list);
}
