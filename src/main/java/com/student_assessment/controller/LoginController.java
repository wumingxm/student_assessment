// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LoginController.java

package com.student_assessment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student_assessment.pojo.User;
import com.student_assessment.service.UserService;
@Controller
public class LoginController
{
	@Autowired
	private UserService userService;
	@RequestMapping(name="/user_login")
	public String login(User user, HttpServletRequest request)
	{	
		if(user==null) {
			return "login";
		}
		if(user.getUserName()==null) {
			return  "login";
		}
		User user2 = userService.selectUserByUserName(user.getUserName());
		if (user2 == null)
		{
			request.setAttribute("userNameError", "用户名错误");
			request.setAttribute("userName", user.getUserName());
			return "login";
		}
		if (!user2.getPassWord().equals(user.getPassWord()))
		{
			request.setAttribute("passWordError", "密码错误");
			request.setAttribute("userName", user.getUserName());
			request.setAttribute("passWord", user.getPassWord());
			return "login";
		} else
		{
			request.getSession().setAttribute("user",user);
			return "index";
		}
	}
}
