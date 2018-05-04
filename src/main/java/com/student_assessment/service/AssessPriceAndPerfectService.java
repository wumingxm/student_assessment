package com.student_assessment.service;

import java.util.Map;

import com.student_assessment.pojo.Student;

public interface AssessPriceAndPerfectService {

	Student selectAssessNationalScholarship(Map map);

	Student selectSchoolScholarship(Map map);

	Student selectThreeGoodStudent(Map map);

}
