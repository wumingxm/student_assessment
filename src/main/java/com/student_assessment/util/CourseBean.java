// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseBean.java

package com.student_assessment.util;

import java.io.Serializable;

import com.student_assessment.pojo.Course;

public class CourseBean  extends Course implements Serializable{
	private String tName;
	private Integer courseScore;
	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public Integer getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(Integer courseScore) {
		this.courseScore = courseScore;
	}
	
}
