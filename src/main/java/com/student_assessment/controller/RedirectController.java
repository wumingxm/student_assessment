package com.student_assessment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student_assessment.pojo.AssessStandard;
import com.student_assessment.pojo.Student;
import com.student_assessment.pojo.User;
import com.student_assessment.service.AssessStandardService;
import com.student_assessment.service.CourseSelectService;
import com.student_assessment.service.StudentAssessTabService;
import com.student_assessment.util.CourseSelectResultBean;

@Controller
public class RedirectController {
	@Autowired
	private AssessStandardService assessStandardService;
	
	@Autowired
	private CourseSelectService courseSelectService;
	
	@Autowired
	private StudentAssessTabService studentAssessTabService;
	@RequestMapping("/login")
	public String exitSystem(HttpServletRequest request) {
		request.getSession().setAttribute("user",null);
		return "forward:/login.jsp";
	}
	
	@RequestMapping("/assignWeight")
	public String AsssingWeight(HttpServletRequest request) {
		List<AssessStandard>list=studentAssessTabService.selectAssessStandardEnabled();
		request.setAttribute("standardList",list);
		request.setAttribute("size",list.size());
		return "/weight_assign";
	}
	
	@RequestMapping("/goCourseSelect")
	public String goCourseSelect() {
		return "course_select_set";
	}
	
	@RequestMapping("/sch_scholarship")
	public String goSchoolScholarship() {
		return "sch_scholarship";
	}
	
	@RequestMapping("/national_scholarship")
	public String goNationalScholarship() {
		return "national_scholarship";
	}
	
	@RequestMapping("/three_good_student")
	public String goThreeGoodStudent() {
		return "three_good_student";
	}
	//根据学生的学号查询学生成绩
	@RequestMapping("/stu_score_query")
	public String goStuScoreQuery(Student student,HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		student.setsNo(user.getUserName());
		List<CourseSelectResultBean>courseSelectBeanList=courseSelectService.selectCourseSelectAll(student);
		request.setAttribute("courseSelectBeanList",courseSelectBeanList);
		return "stu_score_query";
	}
	@RequestMapping("/goStuInforSet")
	public String goStudentInforSet(){
		return "stu_infor_set";
	}
}
