package com.student_assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.UserTypeDao;
import com.student_assessment.pojo.UserType;
import com.student_assessment.service.UserTypeService;
@Service
public class UserTypeServiceImpl implements UserTypeService {
	@Autowired
	private UserTypeDao userTypeDao;
	@Override
	public List<UserType> selectUserType() {
		return userTypeDao.selectUserType();
	}

}
