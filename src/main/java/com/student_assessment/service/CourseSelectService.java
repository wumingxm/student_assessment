// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseSelectService.java

package com.student_assessment.service;

import com.student_assessment.pojo.CourseSelect;
import java.util.List;

public interface CourseSelectService
{

	public abstract List selectCollegeSelectBySNo(String s);

	public abstract void deleteCourseSelect(String s);

	public abstract void updateCourseSelect(CourseSelect courseselect);

	public abstract void addCourseSelect(CourseSelect courseselect);

	public abstract List selectCollge(CourseSelect courseselect);

	public abstract void addCourseSelectList(List list);

	public abstract void updateCourseSelectList(List list);

	public abstract List selectCourseInfoAll();
}
