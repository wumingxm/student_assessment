// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ModelServiceImpl.java

package com.student_assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.ModelDao;
import com.student_assessment.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService {
	@Autowired
	private ModelDao modelDao;

	public List selectModelById(Integer id) {
		return modelDao.selectModelById(id);
	}

	public List selectModel2() {
		return modelDao.selectModel2();
	}
}
