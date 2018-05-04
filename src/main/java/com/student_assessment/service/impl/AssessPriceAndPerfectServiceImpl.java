package com.student_assessment.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.AssessPriceAndPerfectDao;
import com.student_assessment.pojo.Student;
import com.student_assessment.service.AssessPriceAndPerfectService;
@Service
public class AssessPriceAndPerfectServiceImpl  implements AssessPriceAndPerfectService{
	@Autowired
	private AssessPriceAndPerfectDao assessPriceAndPerfectDao;
	@Override
	public Student selectAssessNationalScholarship(Map map) {
		return assessPriceAndPerfectDao.selectAssessNationalScholarship(map);
	}
	@Override
	public Student selectSchoolScholarship(Map map) {
		return assessPriceAndPerfectDao.selectSchoolScholarship(map);
	}
	@Override
	public Student selectThreeGoodStudent(Map map) {
		return assessPriceAndPerfectDao.selectThreeGoodStudent(map);
	}
}
