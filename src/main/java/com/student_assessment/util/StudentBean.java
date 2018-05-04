
package com.student_assessment.util;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StudentBean
{

	private String id;
	private String sNo;
	private String sName;
	private String sSex;
	private Integer sAge;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sBirthday;
	private String sState;
	private String sStatus;
	private String collegeId;
	private String classId;
	private String className;
	private String collegeName;
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
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

	public String getsSex()
	{
		return sSex;
	}

	public void setsSex(String sSex)
	{
		this.sSex = sSex;
	}

	public Integer getsAge()
	{
		return sAge;
	}

	public void setsAge(Integer sAge)
	{
		this.sAge = sAge;
	}
	public Date getsBirthday() {
		return sBirthday;
	}

	public void setsBirthday(Date sBirthday) {
		this.sBirthday = sBirthday;
	}

	public String getsState()
	{
		return sState;
	}

	public void setsState(String sState)
	{
		this.sState = sState;
	}

	public String getsStatus()
	{
		return sStatus;
	}

	public void setsStatus(String sStatus)
	{
		this.sStatus = sStatus;
	}

	public String getCollegeId()
	{
		return collegeId;
	}

	public void setCollegeId(String collegeId)
	{
		this.collegeId = collegeId;
	}

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

	public String getCollegeName()
	{
		return collegeName;
	}

	public void setCollegeName(String collegeName)
	{
		this.collegeName = collegeName;
	}
}
