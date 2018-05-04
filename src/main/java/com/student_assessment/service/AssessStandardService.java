package com.student_assessment.service;

import java.util.List;

import com.student_assessment.pojo.AssessStandard;

public interface AssessStandardService {
	List<AssessStandard> selectAssessStandard(AssessStandard assessStandard);

	void deleteAssessStandard(String assssItemId);

	void addAssessStandard(AssessStandard assessStandard);

	void updateAssessStandard(AssessStandard assessStandard);
}
