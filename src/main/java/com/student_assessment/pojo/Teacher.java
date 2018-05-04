// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Teacher.java

package com.student_assessment.pojo;

import java.io.Serializable;
import java.util.Date;

public class Teacher implements Serializable
{
	private String collegeId;
	private String tName;
	private String tSex;
	private String tMinority;
	private String tStatus;
	private String id;
	private Date tInDate;
	private String tPosition;
	private Date tBirthday;
	private String tLivePlace;
	private String tTelephone;
	private String tNo;
	private Integer tAge;
	private String deptId;

	public Teacher()
	{
	}

	public String getCollegeId()
	{
		return collegeId;
	}

	public void setCollegeId(String collegeId)
	{
		this.collegeId = collegeId;
	}

	public String gettName()
	{
		return tName;
	}

	public void settName(String tName)
	{
		this.tName = tName;
	}

	public String gettSex()
	{
		return tSex;
	}

	public void settSex(String tSex)
	{
		this.tSex = tSex;
	}

	public String gettMinority()
	{
		return tMinority;
	}

	public void settMinority(String tMinority)
	{
		this.tMinority = tMinority;
	}

	public String gettStatus()
	{
		return tStatus;
	}

	public void settStatus(String tStatus)
	{
		this.tStatus = tStatus;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Date gettInDate()
	{
		return tInDate;
	}

	public void settInDate(Date tInDate)
	{
		this.tInDate = tInDate;
	}

	public void settBirthday(Date tBirthday)
	{
		this.tBirthday = tBirthday;
	}

	public String gettPosition()
	{
		return tPosition;
	}

	public void settPosition(String tPosition)
	{
		this.tPosition = tPosition;
	}

	public String gettLivePlace()
	{
		return tLivePlace;
	}

	public void settLivePlace(String tLivePlace)
	{
		this.tLivePlace = tLivePlace;
	}

	public String gettTelephone()
	{
		return tTelephone;
	}

	public void settTelephone(String tTelephone)
	{
		this.tTelephone = tTelephone;
	}

	public String gettNo()
	{
		return tNo;
	}

	public void settNo(String tNo)
	{
		this.tNo = tNo;
	}

	public Integer gettAge()
	{
		return tAge;
	}

	public void settAge(Integer tAge)
	{
		this.tAge = tAge;
	}

	public String getDeptId()
	{
		return deptId;
	}

	public Date gettBirthday()
	{
		return tBirthday;
	}

	public void setDeptId(String deptId)
	{
		this.deptId = deptId;
	}
}
