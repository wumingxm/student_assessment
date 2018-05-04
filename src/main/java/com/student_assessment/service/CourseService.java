// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseService.java

package com.student_assessment.service;

import com.student_assessment.pojo.Course;
import java.util.List;

public interface CourseService
{

	public abstract Course selectCourseBySNo(String s);

	public abstract void deleteCourse(String s);

	public abstract void updateCourse(Course course);

	public abstract void addCourse(Course course);

	public abstract List selectCourse(Course course);

	public abstract void addCourseList(List list);

	public abstract void updateCourseList(List list);
}
