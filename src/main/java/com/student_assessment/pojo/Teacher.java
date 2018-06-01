// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Teacher.java

package com.student_assessment.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author Administrator
 *
 */
public class Teacher implements Serializable
{
	private String id;//身份证号
	
	private String tNo;//教工号
	
	private String tName;//姓名
	
	private String tSex;//性别
	
	private Integer tAge;//年龄
	
	private Date tBirthday;//出生年月
	
	private String tMinority;//民族
	
	private String tStatus;//政治面貌
	
	private Date tInDate;//入职日期
	
	private String tPosition;//职称
	
	private String tLivePlace;//居住地
	
	private String tTelephone;//联系电话
	
	private String collegeId;//学院
	
	private String deptId;//部门
	

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
