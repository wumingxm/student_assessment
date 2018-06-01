package com.student_assessment.dao;

import java.util.List;
import java.util.Map;

import com.student_assessment.pojo.AssessStandard;
import com.student_assessment.pojo.Student;
import com.student_assessment.pojo.StudentAssessTab;
import com.student_assessment.util.AssessResultBean;

public interface StudentAssessTabDao {
	List<AssessResultBean> selectStudentAssessTab(Map map);
	
	void addStudentAssessTab(StudentAssessTab studentAssessTab);
	
	List<AssessResultBean> selectStudentFinalAssessment(Map map);
	
	Long selectStudentFinalAssessmentCount(Student student);
	
	void deleteTeacherAssessment(Map map); 
	
	List<AssessStandard>selectAssessStandardEnabled();//查询已经启用的评价标准

	Long selectTeacherAssessmentCount();
	
	//查询已经自我评价的学生
	List<Student> selectAssessedStudent();

	void updateStudentAssessTabState(StudentAssessTab studentAssessTab);
}
