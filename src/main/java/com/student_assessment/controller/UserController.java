// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserController.java

package com.student_assessment.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student_assessment.pojo.Student;
import com.student_assessment.pojo.Teacher;
import com.student_assessment.pojo.User;
import com.student_assessment.service.StudentService;
import com.student_assessment.service.TeacherService;
import com.student_assessment.service.UserService;
import com.student_assessment.util.PageBean;
import com.student_assessment.util.StudentBean;
import com.student_assessment.util.UserResultBean;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired 
	private TeacherService teacherService;
	
	@RequestMapping("/selectUserByUserName")
	public String selectUserByUserName(String userName) {
		User user = userService.selectUserByUserName(userName);
		if (user == null) {
			return "false";
		}else {
			return "true";
		}
	}
	@RequestMapping("/selectUserDetialInformation")
	public String selectUserDetialInformation(HttpServletRequest request,UserResultBean  userResultBean, @RequestParam(name="page",defaultValue="1") Integer page,@RequestParam(name="pageSize",defaultValue="8") Integer pageSize) {
		Map map = new HashMap();
		PageHelper.startPage(page.intValue(), pageSize.intValue(), true);
		List list =userService.selectUserDetialInformation(userResultBean);
		PageInfo pageInfo = new PageInfo(list);
		PageBean pb = new PageBean();
		pb.setRows(pageInfo.getList());
		pb.setTotal(Long.valueOf(pageInfo.getTotal()));
		pb.setPage(page);
		pb.setPageSize(pageSize);
		pb.setTotal(pageInfo.getTotal());
		pb.setTotalPage();
		request.setAttribute("pb",pb);
		return "user_infor_set";
	}
	
	@RequestMapping("/selectUser/{page}/{pageSize}")
	public String  selectUser(UserResultBean userResultBean,HttpServletRequest request, @PathVariable("page") Integer page,@PathVariable("pageSize") Integer pageSize) {
		System.out.println(page);
		Map map = new HashMap();
		PageHelper.startPage(page.intValue(), pageSize.intValue(), true);
		List<UserResultBean> list = userService.selectUserDetialInformation(userResultBean);
		PageInfo pageInfo = new PageInfo(list);
		PageBean pb = new PageBean();
		pb.setRows(pageInfo.getList());
		pb.setTotal(Long.valueOf(pageInfo.getTotal()));
		pb.setPage(page);
		pb.setPageSize(pageSize);
		pb.setTotal(pageInfo.getTotal());
		pb.setTotalPage();
		request.setAttribute("pb",pb);
		return "user_infor_set";
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(User user) {
		List list=null;
		if(user.getUserTypeId()==1) {
			Student s=new Student();
			s.setsNo(user.getUserName());
			list=studentService.selectStudent(s);
		}
		if(user.getUserTypeId()==1) {
			Teacher t=new Teacher();
			t.settNo(user.getUserName());
			list=teacherService.selectTeacher(t);
		}
		if(list!=null&&list.size()>0) {
			user.setUserAddDate(new Date());
			userService.addUser(user);	
			return "添加用户信息成功!";
		}
		return "你不是该学校的人员不能添加";
	}

	@RequestMapping("/deleteUser/{userName}")
	@ResponseBody	
	public boolean deleteUser(@PathVariable("userName")String userName) {
		User u = userService.selectUserByUserName(userName);
		if (userName == null) {
			return false;
		} else {
			userService.deleteUserByUserName(userName);
			return true;
		}
	}

	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(User user) {
		System.out.println(user);
		userService.updateUser(user);
		return "更新用户信息成功";
	}
}
