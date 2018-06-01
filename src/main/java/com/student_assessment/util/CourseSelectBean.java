package com.student_assessment.util;

import java.util.List;

import com.student_assessment.pojo.CourseSelect;

public class CourseSelectBean {
	private String sNo;
	private String sName;
	private String gradeString;
	List<CourseSelect>cList;
	private Integer sum;
	
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
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
	public String getGradeString() {
		return gradeString;
	}
	public void setGradeString(String gradeString) {
		this.gradeString = gradeString;
	}
	public List<CourseSelect> getcList() {
		return cList;
	}
	public void setcList(List<CourseSelect> cList) {
		this.cList = cList;
	}
	
}
