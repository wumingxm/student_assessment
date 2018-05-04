// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Classes.java

package com.student_assessment.pojo;

import java.io.Serializable;

/**
 * 班级pojo 类
 * @author Administrator
 *
 */
public class Classes implements Serializable
{

	private String classId;
	private String className;
	private String tNo;
	private String collegeId;
	public String getClassId()
	{
		return classId;
	}

	public void setClassId(String classId)
	{
		this.classId = classId;
	}

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	public String gettNo()
	{
		return tNo;
	}

	public void settNo(String tNo)
	{
		this.tNo = tNo;
	}

	public String getCollegeId()
	{
		return collegeId;
	}

	public void setCollegeId(String collegeId)
	{
		this.collegeId = collegeId;
	}
}
