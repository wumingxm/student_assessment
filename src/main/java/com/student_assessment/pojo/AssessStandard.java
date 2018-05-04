package com.student_assessment.pojo;

import java.util.Date;
/**
 * 评价项管理得分统计po类
 * @author Administrator
 *
 */
public class AssessStandard {
	private String assessItemId;//评价项Id
	private String assessItemName;
	private Date   assessItemDate;
	public String getAssessItemId() {
		return assessItemId;
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
}
