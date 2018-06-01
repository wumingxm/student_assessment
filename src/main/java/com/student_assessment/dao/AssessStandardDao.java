package com.student_assessment.dao;

import java.util.List;

import com.student_assessment.pojo.AssessStandard;

public interface AssessStandardDao {

	List<AssessStandard> selectAssessStandard(AssessStandard assessStandard);
	
	AssessStandard  selectAssessStandardById(String assessItemId);
	
	void deleteAssessStandard(String assessItemId);

	void addAssessStandard(AssessStandard assessStandard);

	void updateAssessStandard(AssessStandard assessStandard);
	
	Integer selectStandardLocation(String assessItemName);

	AssessStandard selectAssessStandardByName(String assessItemName);
	

}
