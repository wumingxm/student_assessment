package com.student_assessment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	@RequestMapping("/")
	public String goLogin() {
		return "login";
	}
	@RequestMapping("/password_update")
	public String goPassword_update() {
		return "password_update";
	}
	@RequestMapping("user_infor_set")
	public String goUserInfoSet() {
		return "user_infor_set";
	}
	@RequestMapping("tea_assess")
	public String goTeacherAssessment() {
		return "tea_assess_tab";
	}
	@RequestMapping("/stu_assess_tab")
	public String goStuAssess() {
		return "stu_assess_tab";
	}
	@RequestMapping("/stu_final_assess")
	public String goStuFinalAssess() {
		return "stu_final_assess";
	}
}
