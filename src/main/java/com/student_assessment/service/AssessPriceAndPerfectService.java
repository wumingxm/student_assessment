package com.student_assessment.service;

import java.util.List;
import java.util.Map;

import com.student_assessment.pojo.Student;
import com.student_assessment.util.AssessResultBean;

public interface AssessPriceAndPerfectService {

	List<AssessResultBean>selectAssessNationalScholarship(Map map);

	List<AssessResultBean> selectSchoolScholarship(Map map);

	List<AssessResultBean> selectThreeGoodStudent(Map map);

}
