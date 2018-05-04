package com.student_assessment.util;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.student_assessment.pojo.AssessScoreTab;
import com.student_assessment.pojo.StudentAssessTab;

public class AssessResultBean {
	private String sName;
	private String assessTabId;
	private String sNo;
	private String state; //0表示未评价，1表示学生已经自我评价，2表示教师已经评价，3表示评价完成
	private String academicYear;//学年  
	private String assessManId;//评价人Id
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date assessDate;
	private String term;
	private Integer moralTrait;
   	private Integer civicLiteracy;
   	private Integer liaision;
   	private Integer exerciseHealth;
   	private Integer appearance;
   	private Integer totalScore;
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
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
	public void setAssessDate(Date assessDate) {
		this.assessDate = assessDate;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public Integer getMoralTrait() {
		return moralTrait;
	}
	public void setMoralTrait(Integer moralTrait) {
		this.moralTrait = moralTrait;
	}
	public Integer getCivicLiteracy() {
		return civicLiteracy;
	}
	public void setCivicLiteracy(Integer civicLiteracy) {
		this.civicLiteracy = civicLiteracy;
	}
	public Integer getLiaision() {
		return liaision;
	}
	public void setLiaision(Integer liaision) {
		this.liaision = liaision;
	}
	public Integer getExerciseHealth() {
		return exerciseHealth;
	}
	public void setExerciseHealth(Integer exerciseHealth) {
		this.exerciseHealth = exerciseHealth;
	}
	public Integer getAppearance() {
		return appearance;
	}
	public void setAppearance(Integer appearance) {
		this.appearance = appearance;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
}
