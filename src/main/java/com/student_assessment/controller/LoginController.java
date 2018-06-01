// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LoginController.java

package com.student_assessment.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.student_assessment.pojo.Student;
import com.student_assessment.pojo.Teacher;
import com.student_assessment.pojo.User;
import com.student_assessment.service.StudentService;
import com.student_assessment.service.TeacherService;
import com.student_assessment.service.UserService;
@Controller
public class LoginController
{
	static{  
	    ParserConfig.getGlobalInstance().setAsmEnable(false);  
	    SerializeConfig.getGlobalInstance().setAsmEnable(false);  
	}  
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@RequestMapping("/checkForm")
	public String checkForm(String verifyCode,User user, HttpServletRequest request){	
		request.setAttribute("userName",user.getUserName());
		request.setAttribute("passWord",user.getPassWord());
		request.setAttribute("verifyCode",verifyCode);
		Map map=new HashMap();
		//已经登录不能重复登录
		if(request.getSession().getAttribute("user")!=null){
			return "index";
		}
		//根据用户名查询验证用户名是否存在
		User user2=userService.selectUserByUserName(user.getUserName());
		if(user2!=null) {
			String passWord=user2.getPassWord();
			if(null!=passWord&&passWord.equals(user.getPassWord())) {
				String verifyCode2=(String)request.getSession().getAttribute("verifyCode");
				if(verifyCode2!=null&&verifyCode2.equals(verifyCode)) {
					System.out.println(user2.getUserTypeId());
					if(user2.getUserTypeId()==1) {
						Student s=studentService.selectStudentBySNo(user2.getUserName());
						request.getSession().setAttribute("student",s);
					}else{
						Teacher t=new Teacher();
						t=teacherService.selectTeacherByTNo(user.getUserName());
						request.getSession().setAttribute("teacher",t);
					}
					request.getSession().setAttribute("user",user2);
					return "index";
				}
				request.setAttribute("verifyCodeError","验证码错误");
				return "forward:/login.jsp";
			}
			request.setAttribute("passWordError","密码错误");
			return "forward:/login.jsp";
		}
		request.setAttribute("userNameError","用户名不存在");
		return "forward:/login.jsp";
	}
}
