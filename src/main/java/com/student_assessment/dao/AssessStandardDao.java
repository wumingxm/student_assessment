package com.student_assessment.dao;

import java.util.List;

import com.student_assessment.pojo.AssessStandard;

public interface AssessStandardDao {

	List<AssessStandard> selectAssessStandard(AssessStandard assessStandard);

	void deleteAssessStandard(String assessItemId);

	void addAssessStandard(AssessStandard assessStandard);

	void updateAssessStandard(AssessStandard assessStandard);

}
