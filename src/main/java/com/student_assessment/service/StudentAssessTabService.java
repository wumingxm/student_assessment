package com.student_assessment.service;

import java.util.List;
import java.util.Map;

import com.student_assessment.pojo.AssessStandard;
import com.student_assessment.pojo.Student;
import com.student_assessment.pojo.StudentAssessTab;
import com.student_assessment.util.AssessResultBean;

public interface StudentAssessTabService {
	List<AssessResultBean> selectStudentAssessTab(Map map);
	
	void addStudentAssessTab(StudentAssessTab studentAssessTab);//添加学生评价 
	
	List<AssessResultBean>selectStudentFinalAssessment(Map m);//查询学生最终评价
	
	Long selectStudentFinalAssessmentCount(Student student);//查询学生最终评价的条数
	
	void deleteTeacherAssessment(Map map);//删除教师评价
	
	List<AssessStandard>selectAssessStandardEnabled();//查询启用的标准

	Long selectTeacherAssessmentCount();//查询教师评价的条数
	
	List<Student> selectAssessedStudent(); //查询已经自我评价的学生
	//更新学生自我评价表的转态
	void updateStudentAssessTabState(StudentAssessTab studentAssessTab);
}
