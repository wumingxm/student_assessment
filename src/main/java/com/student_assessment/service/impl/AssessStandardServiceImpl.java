package com.student_assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.AssessStandardDao;
import com.student_assessment.pojo.AssessStandard;
import com.student_assessment.service.AssessStandardService;
@Service
public class AssessStandardServiceImpl implements AssessStandardService {
	@Autowired
	private AssessStandardDao assessStandardDao;
	@Override
	public List<AssessStandard> selectAssessStandard(AssessStandard assessStandard) {
		// TODO Auto-generated method stub
		return assessStandardDao.selectAssessStandard(assessStandard);
	}
	@Override
	public AssessStandard selectAssessStandardById(String assessItemId) {
		return assessStandardDao.selectAssessStandardById(assessItemId);
	}
	@Override
	public AssessStandard selectAssessStandardByName(String assessItemName) {
		return assessStandardDao.selectAssessStandardByName(assessItemName);
	}
	@Override
	public void deleteAssessStandard(String assessItemId) {
		assessStandardDao.deleteAssessStandard(assessItemId);
	}

	@Override
	public void addAssessStandard(AssessStandard assessStandard) {
		assessStandardDao.addAssessStandard(assessStandard);
	}

	@Override
	public void updateAssessStandard(AssessStandard assessStandard) {
		// TODO Auto-generated method stub
		assessStandardDao.updateAssessStandard(assessStandard);
	}
	public Integer selectStandardLocation(String assessItemName) {
		return assessStandardDao.selectStandardLocation(assessItemName);
	}

}
