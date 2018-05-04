package com.student_assessment.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.student_assessment.util.StudentBean;

public class StudentAssessTab implements Serializable{
	private String assessTabId;
	private String sNo;
	private String state; //0表示未评价，1表示学生已经自我评价，2表示教师已经评价，3表示评价完成
	private String academicYear;//学年  
	private String assessManId;//评价人Id
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date assessDate;
	private String term;
	public String getAssessTabId() {
		return assessTabId;
	}
	public void setAssessTabId(String assessTabId) {
		this.assessTabId = assessTabId;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	
	public String getAssessManId() {
		return assessManId;
	}
	public void setAssessManId(String assessManId) {
		this.assessManId = assessManId;
	}
	public Date getAssessDate() {
		return assessDate;
	}
	public void setAssessDate(Date date) {
		this.assessDate = date;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
	
}
