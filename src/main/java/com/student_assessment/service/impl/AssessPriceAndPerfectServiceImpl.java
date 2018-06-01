package com.student_assessment.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.AssessPriceAndPerfectDao;
import com.student_assessment.pojo.Student;
import com.student_assessment.service.AssessPriceAndPerfectService;
import com.student_assessment.util.AssessResultBean;
@Service
public class AssessPriceAndPerfectServiceImpl  implements AssessPriceAndPerfectService{
	@Autowired
	private AssessPriceAndPerfectDao assessPriceAndPerfectDao;
	@Override
	public List<AssessResultBean> selectAssessNationalScholarship(Map map) {
		return assessPriceAndPerfectDao.selectAssessNationalScholarship(map);
	}
	@Override
	public List<AssessResultBean> selectSchoolScholarship(Map map) {
		return assessPriceAndPerfectDao.selectSchoolScholarship(map);
	}
	@Override
	public List<AssessResultBean> selectThreeGoodStudent(Map map) {
		return assessPriceAndPerfectDao.selectThreeGoodStudent(map);
	}
}
