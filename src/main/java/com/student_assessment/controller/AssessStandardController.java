package com.student_assessment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student_assessment.pojo.AssessStandard;
import com.student_assessment.service.AssessStandardService;
import com.student_assessment.util.PageBean;
@Controller
public class AssessStandardController {
	@Autowired
	private AssessStandardService assessStandardService;
	@RequestMapping("/selectAssessStandard")
	//查询评价标准
	public String selectAssessStandard(HttpServletRequest request,AssessStandard assessStandard ,@RequestParam(name="page",defaultValue="1")Integer page,@RequestParam(name="pageSize",defaultValue="12")Integer pageSize){
		PageHelper pageHelper=new PageHelper();
		pageHelper.startPage(page,pageSize,true);
		List<AssessStandard>list=assessStandardService.selectAssessStandard(assessStandard);
		PageInfo<AssessStandard>pageInfo=new PageInfo(list);
		PageBean<AssessStandard>pb=new PageBean<AssessStandard>();
		pb.setPage(page);
		pb.setRows(list);
		pb.setTotal(pageInfo.getTotal());
		pb.setPageSize(pageSize);
		pb.setTotalPage();
		request.setAttribute("pb",pb);
		return "assess_standard_set";
	}
	@RequestMapping("/assess_standard_set")
	public String goAssessStandard() {
		return "assess_standard";
	}
	@RequestMapping("/selectAssessStandard2")
	@ResponseBody
	public PageBean<AssessStandard> selectAssessStandard2(@RequestParam(name="page",defaultValue="1")Integer page,@RequestParam(name="pageSize",defaultValue="2")Integer pageSize,AssessStandard assessStandard){
		 PageHelper pagHelper=new PageHelper();
		 PageHelper.startPage(1,2,true);
		 List<AssessStandard>list=assessStandardService.selectAssessStandard(assessStandard); 
		 PageInfo pageInfo=new PageInfo(list);
		 PageBean<AssessStandard>pb=new PageBean<AssessStandard>();
		 pb.setRows(pageInfo.getList());
		 pb.setTotal(pageInfo.getTotal());
		 return pb;
	}
	
	@RequestMapping("/deleteAssessStandard")
	@ResponseBody
	public boolean   deleteAssessStandard(String assessItemId) {
		assessStandardService.deleteAssessStandard(assessItemId);
		return true;
	}
	
	@RequestMapping("/addAssessStandard")
	@ResponseBody
	public String  addAssessStandard(AssessStandard assessStandard) {
		//查询指标权重
		AssessStandard assessStandard2=assessStandardService.selectAssessStandardById(assessStandard.getAssessItemId());
		AssessStandard assessStandard3=assessStandardService.selectAssessStandardByName(assessStandard.getAssessItemName());
		if(null!=assessStandard2) {
			return "测评指标ID已经 存在";
		}else if(null!=assessStandard3) {
			return "测评指标名称已经存在!";
		}else {
			assessStandardService.addAssessStandard(assessStandard);
		}
		return "添加学生标准成功!";
	}
	
	@RequestMapping("/updateAssessStandard")
	@ResponseBody
	public String updateAssessStandard(AssessStandard assessStandard) {
		assessStandardService.updateAssessStandard(assessStandard);
		return "变更评价标准信息成功！";
	}
}
