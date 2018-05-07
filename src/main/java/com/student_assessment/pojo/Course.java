// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Course.java

package com.student_assessment.pojo;

import java.io.Serializable;

public class Course implements Serializable
{
	private String courseId;//课程ID
	
	private String courseName;//课程名称
	
	private Integer courseScore;//学分
	
	private String tNo;//教工号
	
	private String courseTypeId;//课程类型
	
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

	public Integer getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(Integer courseScore) {
		this.courseScore = courseScore;
	}

	public String getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	
}
