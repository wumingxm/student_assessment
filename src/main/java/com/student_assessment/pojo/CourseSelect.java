// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseSelect.java

package com.student_assessment.pojo;

import java.io.Serializable;

public class CourseSelect implements Serializable
{

	private String sNo;
	private String courseId;
	private Integer grade;
	public String getsNo()
	{
		return sNo;
	}

	public void setsNo(String sNo)
	{
		this.sNo = sNo;
	}

	public String getCourseId()
	{
		return courseId;
	}

	public void setCourseId(String courseId)
	{
		this.courseId = courseId;
	}

	public Integer getGrade()
	{
		return grade;
	}

	public void setGrade(Integer grade)
	{
		this.grade = grade;
	}
}
