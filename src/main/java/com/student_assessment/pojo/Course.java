// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Course.java

package com.student_assessment.pojo;

import java.io.Serializable;

public class Course implements Serializable
{

	private String courseId;
	private String courseName;
	private String tNo;

	public Course()
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

	public String gettNo()
	{
		return tNo;
	}

	public void settNo(String tNo)
	{
		this.tNo = tNo;
	}
}
