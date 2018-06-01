package com.student_assessment.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 评价项管理得分统计po类
 * @author Administrator
 *
 */
public class AssessStandard {
	private String assessItemId;//评价项Id
	
	private String assessItemName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date   assessItemDate;
	
	private double weight;//评价指标权重
	
	private String standardState;//评价项状态 0表示已经启用，1表示未启用
	
	public String getAssessItemId() {
		return assessItemId;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setAssessItemId(String assessItemId) {
		this.assessItemId = assessItemId;
	}
	public String getAssessItemName() {
		return assessItemName;
	}
	public void setAssessItemName(String assessItemName) {
		this.assessItemName = assessItemName;
	}
	public Date getAssessItemDate() {
		return assessItemDate;
	}
	public void setAssessItemDate(Date assessItemDate) {
		this.assessItemDate = assessItemDate;
	}

	public String getStandardState() {
		return standardState;
	}

	public void setStandardState(String standardState) {
		this.standardState = standardState;
	}
	
}
