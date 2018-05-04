// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserResultBean.java

package com.student_assessment.util;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserResultBean
{
	private String rNo;
	private String rName;//角色姓名
	private String userTypeId;//用户类型Id
	private String userName;//用户名
	private String passWord;//密码
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date   userAddDate;//添加日期
	private String userTypeName;
	
	public String getUserTypeId() {
		return userTypeId;
	}


	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
	}


	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	public Date getUserAddDate()
	{
		return userAddDate;
	}

	public void setUserAddDate(Date userAddDate)
	{
		this.userAddDate = userAddDate;
	}

	public String getUserTypeName()
	{
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName)
	{
		this.userTypeName = userTypeName;
	}
	
	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}


	public String getrNo() {
		return rNo;
	}


	public void setrNo(String rNo) {
		this.rNo = rNo;
	}
}
