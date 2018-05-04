// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserServiceImpl.java

package com.student_assessment.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.UserDao;
import com.student_assessment.pojo.User;
import com.student_assessment.service.UserService;
import com.student_assessment.util.UserResultBean;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User selectUserByUserName(String userName) {
		return userDao.selectUserByUserName(userName);
	}

	public void deleteUserByUserName(String userName) {
		userDao.deleteUserByUserName(userName);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}
	public void addUserList(List uList) {
		User user;
		for (Iterator iterator = uList.iterator(); iterator.hasNext(); userDao.addUser(user))
			user = (User) iterator.next();
	}

	public void updateUserList(List uList) {
		User user;
		for (Iterator iterator = uList.iterator(); iterator.hasNext(); userDao.updateUser(user))
			user = (User) iterator.next();

	}

	@Override
	public List<UserResultBean>selectUserDetialInformation(UserResultBean userResultBean){
		return userDao.selectUserDetialInformation(userResultBean);
	}
}
