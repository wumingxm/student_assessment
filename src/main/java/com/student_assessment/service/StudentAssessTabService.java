package com.student_assessment.service;

import java.util.List;
import java.util.Map;

import com.student_assessment.pojo.StudentAssessTab;
import com.student_assessment.util.AssessResultBean;
import com.student_assessment.util.PageBean;

public interface StudentAssessTabService {
	List<AssessResultBean> selectStudentAssessTab(Map map);
	
	void addStudentAssessTab(StudentAssessTab studentAssessTab);
	
	Integer selectselectStudentAssessTabCount(Map map); 
	
	List<AssessResultBean>selectStudentFinalAssessment(Map m);
	
	Integer selectStudentFinalAssessmentCount();
	
	void deleteTeacherAssessment(Map map);
}
