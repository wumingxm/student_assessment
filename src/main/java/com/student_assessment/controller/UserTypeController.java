package com.student_assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student_assessment.pojo.UserType;
import com.student_assessment.service.UserTypeService;

@Controller
public class UserTypeController {
	@Autowired
	private UserTypeService userTypeService;
	@RequestMapping("/selectUserType")
	@ResponseBody
	public List<UserType>selectUserType(){
		return userTypeService.selectUserType();
	}
}
