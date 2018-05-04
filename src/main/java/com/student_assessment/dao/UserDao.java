// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserDao.java

package com.student_assessment.dao;

import java.util.List;

import com.student_assessment.pojo.User;
import com.student_assessment.util.UserResultBean;

public interface UserDao
{

	User selectUserByUserName(String s);

	void deleteUserByUserName(String s);

	void updateUser(User user);

	void addUser(User user);
	
	List<UserResultBean>selectUserDetialInformation(UserResultBean userResultBean);
}
