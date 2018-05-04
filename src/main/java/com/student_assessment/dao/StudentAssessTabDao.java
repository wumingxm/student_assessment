package com.student_assessment.dao;

import java.util.List;
import java.util.Map;

import com.student_assessment.pojo.StudentAssessTab;
import com.student_assessment.util.AssessResultBean;

public interface StudentAssessTabDao {
	List<AssessResultBean> selectStaudentAssessTab(Map map);
	Integer selectStaudentAssessTabCount(Map map);
	void addStudentAssessTab(StudentAssessTab studentAssessTab);
	List<AssessResultBean> selectStudentFinalAssessment(Map map);
	Integer selectStudentFinalAssessmentCount();
	void deleteTeacherAssessment(Map map); 
}
