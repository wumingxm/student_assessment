package com.student_assessment.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student_assessment.pojo.AssessScoreTab;
import com.student_assessment.pojo.AssessStandard;
import com.student_assessment.pojo.CourseSelect;
import com.student_assessment.pojo.Student;
import com.student_assessment.pojo.StudentAssessTab;
import com.student_assessment.service.AssessScoreTabService;
import com.student_assessment.service.AssessStandardService;
import com.student_assessment.service.CourseSelectService;
import com.student_assessment.service.StudentAssessTabService;
import com.student_assessment.service.StudentService;
import com.student_assessment.util.StudentBean;

@Controller
public class TestController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentAssessTabService studentAssessTabService;
	@Autowired
	private AssessStandardService assessStandardService;
	
	@Autowired
	private CourseSelectService courseSelectService;
	
	@Autowired
	private AssessScoreTabService assessScoreTabService;
	public Integer generateScore() {
		Integer score=(int)(Math.random()*10);
		return score;
	}
	//添加学生评价
	@RequestMapping("/insertTeacherAssess")
	public void insertTeacherAssess() {
		//查询学生信息
		List<StudentBean>studentList=studentService.selectStudent(new Student());
		//查询评价标准信息
		List<AssessStandard>assessStandardList=assessStandardService.selectAssessStandard(new AssessStandard());
		for(StudentBean studentBean:studentList) {
				StudentAssessTab studentAssessTab=new StudentAssessTab();
				studentAssessTab.setAcademicYear("2017-2018");
				studentAssessTab.setAssessManId("1030314014014");
				studentAssessTab.setAssessDate(new Date());
				studentAssessTab.setsNo(studentBean.getsNo());
				studentAssessTab.setAssessTabId(UUID.randomUUID().toString());
				studentAssessTab.setState("1");
				studentAssessTab.setTerm("2");
				for(AssessStandard assessStandard:assessStandardList) {
					AssessScoreTab assessScoreTab=new AssessScoreTab();
					assessScoreTab.setAssessTabId(studentAssessTab.getAssessTabId());
					assessScoreTab.setAssessItemGrade(generateScore());
					assessScoreTab.setAssessItemId(assessStandard.getAssessItemId());
					//插入学生评价结果
					assessScoreTabService.addAssessScoreTab(assessScoreTab);
				}
				//给学生评价表中插入数据
				studentAssessTabService.addStudentAssessTab(studentAssessTab);
				studentAssessTabService.updateStudentAssessTabState(studentAssessTab);
		}
	}
	@RequestMapping("/insertStudentAssess")
	public void insertStudentAssess() {
		//查询学生信息
		List<StudentBean>studentList=studentService.selectStudent(new Student());
		//查询评价标准信息
		List<AssessStandard>assessStandardList=assessStandardService.selectAssessStandard(new AssessStandard());
		for(StudentBean studentBean:studentList) {
				StudentAssessTab studentAssessTab=new StudentAssessTab();
				studentAssessTab.setAcademicYear("2017-2018");
				studentAssessTab.setAssessManId(studentBean.getsNo());
				studentAssessTab.setAssessDate(new Date());
				studentAssessTab.setsNo(studentBean.getsNo());
				studentAssessTab.setAssessTabId(UUID.randomUUID().toString());
				studentAssessTab.setState("2");
				studentAssessTab.setTerm("2");
				for(AssessStandard assessStandard:assessStandardList) {
					AssessScoreTab assessScoreTab=new AssessScoreTab();
					assessScoreTab.setAssessTabId(studentAssessTab.getAssessTabId());
					assessScoreTab.setAssessItemGrade(generateScore());
					assessScoreTab.setAssessItemId(assessStandard.getAssessItemId());
					//插入学生评价结果
					assessScoreTabService.addAssessScoreTab(assessScoreTab);
				}
				//给学生评价表中插入数据
				studentAssessTabService.addStudentAssessTab(studentAssessTab);
		}
	}
	@RequestMapping("/test")
	public String goTest() {
		return "test";
	}
	public Integer generateScore2() {
		return (int)(Math.round(Math.random()*100));
	}
	//测试学生选课
	@RequestMapping("/inserGrade")
	public String  insertGrade() {
		for(int i=1;i<=5;i++) {
			Student student=new Student();
			student.setClassId(i+"");
			List<StudentBean>list=studentService.selectStudent(student);
			for(StudentBean studentBean:list) {
				CourseSelect courseSelect=new CourseSelect();
				for(int j=i;j<i+8;j++) {
					courseSelect.setCourseId(j+"");
					courseSelect.setGrade(generateScore2());
					courseSelect.setsNo(studentBean.getsNo());
					courseSelectService.addCourseSelect(courseSelect);
				}
			}
		
		}
		return "index";
	}
}
