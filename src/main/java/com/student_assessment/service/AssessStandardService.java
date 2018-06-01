package com.student_assessment.service;

import java.util.List;

import com.student_assessment.pojo.AssessStandard;

public interface AssessStandardService {
	List<AssessStandard> selectAssessStandard(AssessStandard assessStandard);
	
	AssessStandard  selectAssessStandardById(String  assessItemId);
	
	AssessStandard selectAssessStandardByName(String assessItemName);

	void deleteAssessStandard(String assssItemId);

	void addAssessStandard(AssessStandard assessStandard);

	void updateAssessStandard(AssessStandard assessStandard);
	
	Integer selectStandardLocation(String assessItemName);
}
