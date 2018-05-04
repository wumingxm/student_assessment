// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserService.java

package com.student_assessment.service;

import java.util.List;

import com.student_assessment.pojo.User;
import com.student_assessment.util.UserResultBean;

public interface UserService
{

	User selectUserByUserName(String s);

	void addUser(User user);

	void updateUser(User user);

	void deleteUserByUserName(String s);

	void addUserList(List list);

	void updateUserList(List list);

	List<UserResultBean> selectUserDetialInformation(UserResultBean userResultBean);//查询用户详细信息
}
