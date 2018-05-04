package com.student_assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.AssessScoreTabDao;
import com.student_assessment.pojo.AssessScoreTab;
import com.student_assessment.service.AssessScoreTabService;
@Service
public class AssessScoreTabServiceImpl implements AssessScoreTabService {
	@Autowired
	private AssessScoreTabDao assessScoreTabDao;
	@Override
	public void addAssessScoreTab(AssessScoreTab assessScoreTab) {
		assessScoreTabDao.addAssessScoreTab(assessScoreTab);
	}

}
