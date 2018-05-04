// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseBean.java

package com.student_assessment.util;


public class CourseBean
{

	private String courseId;
	private String courseName;
	private String sNo;
	private String sName;
	private String grade;

	public CourseBean()
	{
	}

	public String getCourseId()
	{
		return courseId;
	}

	public void setCourseId(String courseId)
	{
		this.courseId = courseId;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	public String getsNo()
	{
		return sNo;
	}

	public void setsNo(String sNo)
	{
		this.sNo = sNo;
	}

	public String getsName()
	{
		return sName;
	}

	public void setsName(String sName)
	{
		this.sName = sName;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}
}
