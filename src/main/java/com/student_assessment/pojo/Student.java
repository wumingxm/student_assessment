// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Student.java

package com.student_assessment.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @author Administrator
 *
 */
public class Student implements Serializable
{

	private String id;//身份证号
	
	private String sNo;//学号
	
	private String sName;//姓名
	
	private String sSex;//性别
	
	private Integer sAge;//年龄
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	private Date sBirthday;//出生日期
	
	private String sState;//学生状态
	
	private String sStatus;//政治面貌
	
	private String collegeId;//学院Id
	
	private String classId;//班级Id

	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsSex() {
		return sSex;
	}

	public void setsSex(String sSex) {
		this.sSex = sSex;
	}

	public Integer getsAge() {
		return sAge;
	}

	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}

	public Date getsBirthday() {
		return sBirthday;
	}

	public void setsBirthday(Date sBirthday) {
		this.sBirthday = sBirthday;
	}

	public String getsState() {
		return sState;
	}

	public void setsState(String sState) {
		this.sState = sState;
	}

	public String getsStatus() {
		return sStatus;
	}

	public void setsStatus(String sStatus) {
		this.sStatus = sStatus;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		return (new StringBuilder("Student [id=")).append(id).append(", sNo=").append(sNo).append(", sName=")
				.append(sName).append(", sSex=").append(sSex).append(", sAge=").append(sAge).append(", sBirthday=")
				.append(sBirthday).append(", sState=").append(sState).append(", sStatus=").append(sStatus)
				.append(", collegeId=").append(collegeId).append(", classId=").append(classId).append("]").toString();
	}
}
