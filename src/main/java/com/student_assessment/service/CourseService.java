// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseService.java

package com.student_assessment.service;

import com.student_assessment.pojo.Course;
import java.util.List;

public interface CourseService
{
	 void deleteCourse(String s);

	 void updateCourse(Course course);

	 void addCourse(Course course);

	 List selectCourseAll(Course course);

}
