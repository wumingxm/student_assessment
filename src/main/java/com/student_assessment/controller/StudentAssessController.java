package com.student_assessment.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import com.student_assessment.pojo.AssessStandard;
import com.student_assessment.pojo.CourseSelect;
import com.student_assessment.pojo.Student;
import com.student_assessment.pojo.StudentAssessTab;
import com.student_assessment.pojo.User;
import com.student_assessment.service.AssessScoreTabService;
import com.student_assessment.service.AssessStandardService;
import com.student_assessment.service.CourseSelectService;
import com.student_assessment.service.StudentAssessTabService;
import com.student_assessment.util.AssessResultBean;
import com.student_assessment.util.CourseSelectBean;
import com.student_assessment.util.CourseSelectResultBean;
import com.student_assessment.util.PageBean;

@Controller
public class StudentAssessController {
	@Autowired
	private AssessScoreTabService assessScoreTabService;
	
	@Autowired
	private StudentAssessTabService studentAssessTabService;
	
	@Autowired 
	private AssessStandardService assessStandardService;
	 
	@Autowired
	private CourseSelectService courseSelectService;
	
	
	@RequestMapping("/stu_assess_tab")
	//生成评价信息表
	public String  generateStudentAssessTab(HttpServletRequest request) {
		AssessStandard assessStandard=new AssessStandard();
		assessStandard.setStandardState("1");
		//查询非必用而启用的评价指标
		List<AssessStandard>assessStandardList= assessStandardService.selectAssessStandard(assessStandard);
		//跳转前设置值
		request.setAttribute("assessStandardList",assessStandardList);
		return "stu_assess_tab";
	}
	@RequestMapping("/tea_assess_tab")
	//生成评价信息表
	public String  generateTeaAssessTab(HttpServletRequest request) {
		AssessStandard assessStandard=new AssessStandard();
		assessStandard.setStandardState("1");
		//查询非必用而启用的评价指标
		List<AssessStandard>assessStandardList= assessStandardService.selectAssessStandard(assessStandard);
		//跳转前设置值
		request.setAttribute("assessStandardList",assessStandardList);
		return "tea_assess_tab";
	}
	@RequestMapping("/stu_final_assess")
	//生成评价信息表
	public String generateFinalAssessTab(HttpServletRequest request) {
		List<AssessStandard>assessStandardList= studentAssessTabService.selectAssessStandardEnabled();
		//跳转前设置值
		request.setAttribute("assessStandardList",assessStandardList);
		return "stu_final_assess";
	}
	@RequestMapping("/selectFinalAssessment")
	public String selectStudentFinalAssessment(Student stu,Map map,HttpServletRequest request,String AcademicYear,@RequestParam(name= "pageSize",defaultValue="8")Integer pageSize ,@RequestParam(name="page",defaultValue="1")Integer page){
		//查询评价标准信息
				map.put("start",(page-1)*pageSize);
				map.put("end",page*pageSize);
				map.put("student",stu);
				User user=(User)request.getSession().getAttribute("user");
				List<AssessResultBean>assessResultBeanList=studentAssessTabService.selectStudentFinalAssessment(map);
				List<StudentAssessTab>studentAssessTabList=new ArrayList<StudentAssessTab>();
				//查询指标
				List<AssessStandard>assessStandardList=studentAssessTabService.selectAssessStandardEnabled();
				for(int i=0;i<assessResultBeanList.size();i++) {
					AssessResultBean arb=assessResultBeanList.get(i);
					StudentAssessTab studentAssessTab=new StudentAssessTab();
					List<AssessScoreTab>list=new ArrayList<AssessScoreTab>();
					//处理查询出来的评分字符串
					String[]assessScoreStr=arb.getAssessScoreString().trim().replaceAll("\\s","").split(",");
					studentAssessTab.setAcademicYear(arb.getAcademicYear());
					studentAssessTab.setAssessDate(arb.getAssessDate());
					studentAssessTab.setTerm(arb.getTerm());
					studentAssessTab.setsNo(arb.getsNo());
					studentAssessTab.setsName(arb.getsName());
					int sum=0;
					//查询课程成绩
					Student student2=new Student();
					student2.setsNo(arb.getsNo());
					List<CourseSelectBean>courseSelectBeanList=courseSelectService.selectCourseInfoAll(student2);
					List<CourseSelectResultBean>courseSelectBeanList2=courseSelectService.selectCourseSelectAll(student2);
					List<CourseSelectBean>courseSelectBeanList3=new ArrayList<CourseSelectBean>();	
					List<CourseSelect>cList=new ArrayList<CourseSelect>();
					int exerciseHealth=0;
					int studyCapacity=0;
					//拆分查询的学生的成绩，设置学生的各科成绩
					for(int j=0;j<courseSelectBeanList.size();j++) {
						CourseSelectBean csb=courseSelectBeanList.get(j);
						CourseSelect courseSelect=new CourseSelect();
						String[]gradeArray=csb.getGradeString().trim().replaceAll("\\s","").split(",");
						Integer sum2=0;
						for(int m=0;m<gradeArray.length;m++) {
							CourseSelectResultBean csrb=courseSelectBeanList2.get(m);
							sum2+=Integer.parseInt(gradeArray[i]);
							if(csrb.getCourseName().equals("大学体育")){
								//设置运动与健康成绩
								exerciseHealth=Integer.parseInt(gradeArray[m]);
							}
							courseSelect.setCourseId(csrb.getCourseId());
							cList.add(courseSelect);
						}
						csb.setSum(sum2);			
						csb.setcList(cList);
						courseSelectBeanList3.add(csb);
					}
					Integer rn1=assessStandardService.selectStandardLocation("学习能力");
					Integer rn2=assessStandardService.selectStandardLocation("运动与健康");
					//查询权重
					for(int j=0;j<assessScoreStr.length;j++) {
						double weight=assessStandardList.get(0).getWeight();
						AssessScoreTab assessScoreTab=new AssessScoreTab();
						assessScoreTab.setAssessItemGrade(Integer.parseInt(assessScoreStr[j]));
						sum+=Integer.parseInt(assessScoreStr[j])*weight;
						list.add(assessScoreTab);
					}
					AssessScoreTab assessScoreTab1=new AssessScoreTab();
					AssessScoreTab assessScoreTab2=new AssessScoreTab();
					assessScoreTab1.setAssessItemGrade(exerciseHealth);
					studyCapacity=courseSelectBeanList3.get(0).getSum()-exerciseHealth;
					assessScoreTab2.setAssessItemGrade(studyCapacity);
					list.add(assessScoreTab1);
					list.add(assessScoreTab2);
					sum=(int) (exerciseHealth*assessStandardList.get(rn1-1).getWeight()+(int)studyCapacity*assessStandardList.get(rn2-1).getWeight());
					//设置评表的数据
					studentAssessTab.setAssessScoreList(list);
					studentAssessTab.setAssessManId(user.getUserName());
					studentAssessTab.setAssessDate(new Date());
					studentAssessTab.setSum(sum);
					studentAssessTabList.add(studentAssessTab);
				}
				//查询显示的列名
				PageBean<StudentAssessTab>pb=new PageBean<StudentAssessTab>();
				pb.setRows(studentAssessTabList);
				pb.setPageSize(pageSize);
				System.out.println(studentAssessTabService);
				Long total=(long)studentAssessTabService.selectStudentFinalAssessmentCount(stu);
				pb.setTotal(total);
				pb.setPage(page);
				pb.setTotalPage();
				request.setAttribute("pb", pb);
				request.setAttribute("assessStandardList",assessStandardList);
				return "stu_final_assess";
	}
	@RequestMapping("/selectTeacherAssess")
	public String selectTeacherAssess(Student student,Map map,HttpServletRequest request,@RequestParam(name="page",defaultValue="9")Integer page,@RequestParam(name="pageSize",defaultValue="8")Integer pageSize) {
		//查询评价标准信息
		map.put("start",(page-1)*pageSize);
		map.put("end",page*pageSize);
		map.put("student",student);
		User user=(User)request.getSession().getAttribute("user");
		List<AssessResultBean>assessResultBeanList=studentAssessTabService.selectStudentAssessTab(map);
		List<StudentAssessTab>studentAssessTabList=new ArrayList<StudentAssessTab>();
		for(AssessResultBean arb:assessResultBeanList) {
			StudentAssessTab studentAssessTab=new StudentAssessTab();
			List<AssessScoreTab>list=new ArrayList<AssessScoreTab>();
			//处理查询出来的评分字符串
			String[]assessScoreStr=arb.getAssessScoreString().trim().replaceAll("\\s","").split(",");
			studentAssessTab.setAcademicYear(arb.getAcademicYear());
			studentAssessTab.setAssessDate(arb.getAssessDate());
			studentAssessTab.setAssessManId(arb.getAssessManId());
			studentAssessTab.setState(arb.getState());
			studentAssessTab.setTerm(arb.getTerm());
			studentAssessTab.setsNo(arb.getsNo());
			studentAssessTab.setsName(arb.getsName());
			for(String score:assessScoreStr) {
				AssessScoreTab assessScoreTab=new AssessScoreTab();
				assessScoreTab.setAssessItemGrade(Integer.parseInt(score));
				list.add(assessScoreTab);
			}
			studentAssessTab.setAssessScoreList(list);
			studentAssessTabList.add(studentAssessTab);
		}
		//查询显示的列名
		AssessStandard assessStandard=new AssessStandard();
		assessStandard.setStandardState("1");
		List<AssessStandard>assessStandardList= assessStandardService.selectAssessStandard(assessStandard);
		Collections.sort(studentAssessTabList);
		PageBean<StudentAssessTab>pb=new PageBean<StudentAssessTab>();
		Long total=studentAssessTabService.selectTeacherAssessmentCount();
		pb.setTotal(total);
		pb.setPage(page);
		pb.setPageSize(pageSize);
		pb.setRows(studentAssessTabList);
		request.setAttribute("pb", pb);
		request.setAttribute("assessStandardList",assessStandardList);
		return "tea_assess_select";
	}
	//添加学生自我评价
	@RequestMapping("/addStudentAssess")
	public String  addStudentAssess(StudentAssessTab studentAssessTab,HttpServletRequest request) {
			//查询评价标准信息
				User user=(User)request.getSession().getAttribute("user");
				//设置评价表的其他信息
				studentAssessTab.setAssessManId(user.getUserName());
				
				studentAssessTab.setsNo(user.getUserName());
				
				studentAssessTab.setAssessDate(new Date());
				
				studentAssessTab.setAssessTabId(UUID.randomUUID().toString());
				
				studentAssessTab.setState("1");
				
				studentAssessTab.setsNo(user.getUserName());
				List<AssessScoreTab>list=new ArrayList<AssessScoreTab>();
				//查询启用的评价指标，学习能力运动与健康通过体育课程成绩和文化课成绩
				AssessStandard ass=new AssessStandard();
				ass.setStandardState("1");
				List<AssessStandard>assessStandardList=assessStandardService.selectAssessStandard(ass);

				String str=request.getParameter("assesItemName");

				//设置评价表Id
				String assessTabId=UUID.randomUUID().toString();
				
				studentAssessTab.setAssessTabId(assessTabId);
				//查询到引用标准
				for(int i=0;i<assessStandardList.size();i++) {
					//封装学生评价得分
					AssessStandard assessStandard=assessStandardList.get(i);
						AssessScoreTab assessScoreTab=new AssessScoreTab();
						assessScoreTab.setAssessItemId(assessStandard.getAssessItemId());
						assessScoreTab.setAssessTabId(assessTabId);
						String param="assessItemGrade"+i;
						String assessItemGrade=request.getParameter(param);
						assessScoreTab.setAssessItemGrade(Integer.parseInt(assessItemGrade));
						System.out.println(assessItemGrade);
						assessScoreTabService.addAssessScoreTab(assessScoreTab);
				}
				//给学生评价表中插入数据
				studentAssessTabService.addStudentAssessTab(studentAssessTab);
				return "index";
	}
	@RequestMapping("/addTeacherAssess")
	public String  addTeacherAssess(StudentAssessTab studentAssessTab,HttpServletRequest request,Student student) {
		System.out.println(studentAssessTab.getsNo());
		System.out.println(student.getsNo());
		//查询评价标准信息
		User user=(User)request.getSession().getAttribute("user");
		//设置评价表的其他信息
		studentAssessTab.setAssessManId(user.getUserName());
		
		studentAssessTab.setsNo(user.getUserName());
		
		studentAssessTab.setAssessDate(new Date());
		
		studentAssessTab.setAssessTabId(UUID.randomUUID().toString());
		
		studentAssessTab.setState("2");
		
		studentAssessTab.setsNo(student.getsNo());
		List<AssessScoreTab>list=new ArrayList<AssessScoreTab>();
		//查询启用的评价指标，学习能力运动与健康通过体育课程成绩和文化课成绩
		AssessStandard ass=new AssessStandard();
		ass.setStandardState("1");
		List<AssessStandard>assessStandardList=assessStandardService.selectAssessStandard(ass);
		String str=request.getParameter("assesItemName");

		//设置评价表Id
		String assessTabId=UUID.randomUUID().toString();
		
		studentAssessTab.setAssessTabId(assessTabId);
		//查询到引用标准
		for(int i=0;i<assessStandardList.size();i++) {
			//封装学生评价得分
			AssessStandard assessStandard=assessStandardList.get(i);
				AssessScoreTab assessScoreTab=new AssessScoreTab();
				assessScoreTab.setAssessItemId(assessStandard.getAssessItemId());
				assessScoreTab.setAssessTabId(assessTabId);
				String param="assessItemGrade"+i;
				String assessItemGrade=request.getParameter(param);
				assessScoreTab.setAssessItemGrade(Integer.parseInt(assessItemGrade));
				assessScoreTabService.addAssessScoreTab(assessScoreTab);
		}
		//给学生评价表中插入数据
		studentAssessTabService.addStudentAssessTab(studentAssessTab);
		//更新表中学生自我评价的状态
		studentAssessTabService.updateStudentAssessTabState(studentAssessTab);
		return "index";
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
