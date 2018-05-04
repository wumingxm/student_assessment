package com.student_assessment.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student_assessment.pojo.AssessScoreTab;
import com.student_assessment.pojo.Student;
import com.student_assessment.pojo.StudentAssessTab;
import com.student_assessment.pojo.User;
import com.student_assessment.service.AssessScoreTabService;
import com.student_assessment.service.StudentAssessTabService;
import com.student_assessment.util.AssessResultBean;
import com.student_assessment.util.PageBean;

@Controller
public class StudentAssessController {
	@Autowired
	private AssessScoreTabService assessScoreTabService;
	@Autowired
	private StudentAssessTabService studentAssessTabService;
	@RequestMapping("/generateAssessTab")
	//生成评价信息表
	public String  generateAssessTab(HttpServletRequest request,Student student,String AcademicYear,@RequestParam(name= "pageSize",defaultValue="10")Integer pageSize ,@RequestParam(name="page",defaultValue="1")Integer page) {
		//查询学生评价标准		
		Map map=new HashMap();
		map.put("start",(page-1)*pageSize);
		map.put("end",page*pageSize);
		List<AssessResultBean>stuAssessTabList=studentAssessTabService.selectStudentAssessTab(map);
		PageBean<AssessResultBean>pb=new PageBean<AssessResultBean>();
		pb.setPage(page);
		pb.setPageSize(pageSize);
		pb.setRows(stuAssessTabList);
		Integer total=studentAssessTabService.selectselectStudentAssessTabCount(map);
		pb.setTotal((long)total);
		pb.setTotalPage();
		request.setAttribute("pb",pb);
		return "tea_assess_tab";
	}
	@RequestMapping("/selectFinalAssessment")
	public String selectStudentFinalAssessment(HttpServletRequest request,Student student,String AcademicYear,@RequestParam(name= "pageSize",defaultValue="20")Integer pageSize ,@RequestParam(name="page",defaultValue="1")Integer page){
		Map map=new HashMap();
		map.put("start",(page-1)*pageSize);
		map.put("end",page*pageSize);
		List<AssessResultBean>stuAssessTabList=studentAssessTabService.selectStudentFinalAssessment(map);
		PageBean<AssessResultBean>pb=new PageBean<AssessResultBean>();
		pb.setPage(page);
		pb.setPageSize(pageSize);
		pb.setTotal((long)studentAssessTabService.selectStudentFinalAssessmentCount());
		pb.setRows(stuAssessTabList);
		pb.setTotalPage();
		request.setAttribute("pb",pb);
		return "stu_final_assess";
	}
	@RequestMapping("/addStudentAssess")
	@ResponseBody
	public String  addStudentAssess(AssessResultBean assessResultBean,HttpServletRequest request) {
			//查询评价标准信息
				User user=(User)request.getSession().getAttribute("user");
				StudentAssessTab studentAssessTab=new StudentAssessTab();
				studentAssessTab.setAssessManId(user.getUserName());
				studentAssessTab.setAssessDate(new Date());
				studentAssessTab.setsNo(user.getUserName());
				studentAssessTab.setAssessTabId(UUID.randomUUID().toString());
				studentAssessTab.setState("1");
				studentAssessTab.setTerm(assessResultBean.getTerm());
				studentAssessTab.setState("1");
				studentAssessTab.setAcademicYear(assessResultBean.getAcademicYear());
				List<AssessScoreTab>list=new ArrayList<AssessScoreTab>();
				AssessScoreTab assessScoreTab1=new AssessScoreTab();
				assessScoreTab1.setAssessItemGrade(assessResultBean.getMoralTrait());
				assessScoreTab1.setAssessItemId("1");
				assessScoreTab1.setAssessTabId(studentAssessTab.getAssessTabId());
				list.add(assessScoreTab1);
				AssessScoreTab assessScoreTab2=new AssessScoreTab();
				assessScoreTab2.setAssessItemGrade(assessResultBean.getCivicLiteracy());
				assessScoreTab2.setAssessItemId("2");
				assessScoreTab2.setAssessTabId(studentAssessTab.getAssessTabId());
				list.add(assessScoreTab2);
				AssessScoreTab assessScoreTab3=new AssessScoreTab();
				assessScoreTab3.setAssessItemGrade(assessResultBean.getLiaision());
				assessScoreTab3.setAssessItemId("3");
				assessScoreTab3.setAssessTabId(studentAssessTab.getAssessTabId());
				list.add(assessScoreTab3);
				AssessScoreTab assessScoreTab4=new AssessScoreTab();
				assessScoreTab4.setAssessItemGrade(assessResultBean.getExerciseHealth());
				assessScoreTab4.setAssessItemId("4");
				assessScoreTab4.setAssessTabId(studentAssessTab.getAssessTabId());
				list.add(assessScoreTab4);
				AssessScoreTab assessScoreTab5=new AssessScoreTab();
				assessScoreTab5.setAssessItemGrade(assessResultBean.getAppearance());
				assessScoreTab5.setAssessItemId("5");
				assessScoreTab5.setAssessTabId(studentAssessTab.getAssessTabId());
				list.add(assessScoreTab5);
				for(AssessScoreTab ast:list) {
					//插入学生评价结果
					assessScoreTabService.addAssessScoreTab(ast);
				}
				//给学生评价表中插入数据
		studentAssessTabService.addStudentAssessTab(studentAssessTab);
		return "学生评价成功!";
	}
	@RequestMapping("/addTeacherAssess")
	@ResponseBody
	public String  addTeacherAssess(AssessResultBean assessResultBean,HttpServletRequest request) {
			//查询评价标准信息
				User user=(User)request.getSession().getAttribute("user");
				StudentAssessTab studentAssessTab=new StudentAssessTab();
				studentAssessTab.setAssessManId(user.getUserName());
				studentAssessTab.setsNo(assessResultBean.getsNo());
				studentAssessTab.setAssessDate(new Date());
				studentAssessTab.setAssessTabId(UUID.randomUUID().toString());
				studentAssessTab.setState("1");
				studentAssessTab.setTerm(assessResultBean.getTerm());
				studentAssessTab.setState("1");
				studentAssessTab.setAcademicYear(assessResultBean.getAcademicYear());
				List<AssessScoreTab>list=new ArrayList<AssessScoreTab>();
				AssessScoreTab assessScoreTab1=new AssessScoreTab();
				assessScoreTab1.setAssessItemGrade(assessResultBean.getMoralTrait());
				assessScoreTab1.setAssessItemId("1");
				assessScoreTab1.setAssessTabId(studentAssessTab.getAssessTabId());
				list.add(assessScoreTab1);
				AssessScoreTab assessScoreTab2=new AssessScoreTab();
				assessScoreTab2.setAssessItemGrade(assessResultBean.getCivicLiteracy());
				assessScoreTab2.setAssessItemId("2");
				assessScoreTab2.setAssessTabId(studentAssessTab.getAssessTabId());
				list.add(assessScoreTab2);
				AssessScoreTab assessScoreTab3=new AssessScoreTab();
				assessScoreTab3.setAssessItemGrade(assessResultBean.getLiaision());
				assessScoreTab3.setAssessItemId("3");
				assessScoreTab3.setAssessTabId(studentAssessTab.getAssessTabId());
				list.add(assessScoreTab3);
				AssessScoreTab assessScoreTab4=new AssessScoreTab();
				assessScoreTab4.setAssessItemGrade(assessResultBean.getExerciseHealth());
				assessScoreTab4.setAssessItemId("4");
				assessScoreTab4.setAssessTabId(studentAssessTab.getAssessTabId());
				list.add(assessScoreTab4);
				AssessScoreTab assessScoreTab5=new AssessScoreTab();
				assessScoreTab5.setAssessItemGrade(assessResultBean.getAppearance());
				assessScoreTab5.setAssessItemId("5");
				assessScoreTab5.setAssessTabId(studentAssessTab.getAssessTabId());
				list.add(assessScoreTab5);
				for(AssessScoreTab ast:list) {
					//插入学生评价结果
					assessScoreTabService.addAssessScoreTab(ast);
				}
				//给学生评价表中插入数据
		studentAssessTabService.addStudentAssessTab(studentAssessTab);
		return "学生评价成功!";
	}
	@ResponseBody
	//删除学生评价
	@RequestMapping("/deleteTeacherAssessment")
	public boolean deleteTeacherAssessment(HttpServletRequest request,@RequestParam("sNo")String sNo,@RequestParam("assessManId")String assessManId) {
		Map map=new HashMap();
		User user=(User) request.getSession().getAttribute("user");
		map.put("assessManId",assessManId);
		map.put("sNo",sNo);
		studentAssessTabService.deleteTeacherAssessment(map);
		return true;
	}
}
