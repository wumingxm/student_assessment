package com.student_assessment.util;

import java.io.Serializable;

/**
 * 学生选课的工具bean
 * @author Administrator
 * 
 */
public class CourseSelectResultBean implements Serializable{
	private String sNo;
	private String sName;
	private String courseId;
	private String courseName;
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
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
