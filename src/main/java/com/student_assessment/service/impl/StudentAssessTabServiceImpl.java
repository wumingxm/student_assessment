package com.student_assessment.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.StudentAssessTabDao;
import com.student_assessment.pojo.StudentAssessTab;
import com.student_assessment.service.StudentAssessTabService;
import com.student_assessment.util.AssessResultBean;
@Service
public class StudentAssessTabServiceImpl implements StudentAssessTabService {
	@Autowired
	private StudentAssessTabDao studentAssessTabDao;
	@Override
	public List<AssessResultBean> selectStudentAssessTab(Map map) {
		return studentAssessTabDao.selectStaudentAssessTab(map);
	}
	@Override
	public void addStudentAssessTab(StudentAssessTab studentAssessTab) {
		studentAssessTabDao.addStudentAssessTab(studentAssessTab);
	}
	@Override
	public Integer selectselectStudentAssessTabCount(Map map) {
		return studentAssessTabDao.selectStaudentAssessTabCount(map);
	}
	@Override
	public List<AssessResultBean> selectStudentFinalAssessment(Map map) {
		return studentAssessTabDao.selectStudentFinalAssessment(map);
	}
	@Override
	public Integer selectStudentFinalAssessmentCount() {
		return studentAssessTabDao.selectStudentFinalAssessmentCount();
	}
	@Override
	public void deleteTeacherAssessment(Map map) {
		studentAssessTabDao.deleteTeacherAssessment(map);
	}
}
