package com.student_assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.student_assessment.pojo.AssessScoreTab;
import com.student_assessment.service.AssessScoreTabService;

@Controller
public class StydentTestController {
	@Autowired
	private AssessScoreTabService  assessScoreTabService;
	public void insertAssessScore(AssessScoreTab assessScoreTab) {
		
	}
}
