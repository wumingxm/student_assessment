package com.student_assessment.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.StudentAssessTabDao;
import com.student_assessment.pojo.AssessStandard;
import com.student_assessment.pojo.Student;
import com.student_assessment.pojo.StudentAssessTab;
import com.student_assessment.service.StudentAssessTabService;
import com.student_assessment.util.AssessResultBean;
@Service
public class StudentAssessTabServiceImpl implements StudentAssessTabService {
	@Autowired
	private StudentAssessTabDao studentAssessTabDao;
	@Override
	public List<AssessResultBean> selectStudentAssessTab(Map map) {
		return studentAssessTabDao.selectStudentAssessTab(map);
	}
	@Override
	public void addStudentAssessTab(StudentAssessTab studentAssessTab) {
		studentAssessTabDao.addStudentAssessTab(studentAssessTab);
	}
	@Override
	public List<AssessResultBean> selectStudentFinalAssessment(Map map) {
		return studentAssessTabDao.selectStudentFinalAssessment(map);
	}
	@Override
	public Long selectStudentFinalAssessmentCount(Student student) {
		return studentAssessTabDao.selectStudentFinalAssessmentCount(student);
	}
	@Override
	public void deleteTeacherAssessment(Map map) {
		studentAssessTabDao.deleteTeacherAssessment(map);
	}
	
	@Override
	public List<AssessStandard>selectAssessStandardEnabled(){
		return studentAssessTabDao.selectAssessStandardEnabled();
	}
	@Override
	public Long selectTeacherAssessmentCount() {
		return studentAssessTabDao.selectTeacherAssessmentCount();
	}
	@Override
	public List<Student> selectAssessedStudent() {
		return studentAssessTabDao.selectAssessedStudent();
	}
	@Override
	public void updateStudentAssessTabState(StudentAssessTab studentAssessTab) {
		// TODO Auto-generated method stub
		studentAssessTabDao.updateStudentAssessTabState(studentAssessTab);
	}
}
