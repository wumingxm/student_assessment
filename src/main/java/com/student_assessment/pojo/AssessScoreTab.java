package com.student_assessment.pojo;

import java.io.Serializable;

public class AssessScoreTab implements Serializable {
	/**
	 * @author Administrator 
	 * @since 
	 */
	private static final long serialVersionUID = 1L;
	private String assessTabId;
	private String assessItemId;// 评价项Id
	private Integer assessItemGrade;// 评价项得分

	public String getAssessTabId() {
		return assessTabId;
	}

	public void setAssessTabId(String assessTabId) {
		this.assessTabId = assessTabId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAssessItemId() {
		return assessItemId;
	}

	public void setAssessItemId(String assessItemId) {
		this.assessItemId = assessItemId;
	}

	public Integer getAssessItemGrade() {
		return assessItemGrade;
	}

	public void setAssessItemGrade(Integer assessItemGrade) {
		this.assessItemGrade = assessItemGrade;
	}

}
