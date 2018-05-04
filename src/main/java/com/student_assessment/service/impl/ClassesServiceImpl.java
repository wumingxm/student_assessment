// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ClassesServiceImpl.java

package com.student_assessment.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.ClassesDao;
import com.student_assessment.pojo.Classes;
import com.student_assessment.service.ClassesService;

@Service
public class ClassesServiceImpl implements ClassesService {
	@Autowired
	private ClassesDao classesDao;
	public Classes selectClassesByClassesId(String classesId) {
		return classesDao.selectClassesByClassesId(classesId);
	}

	public void deleteClasses(String classesId) {
		classesDao.deleteClasses(classesId);
	}

	public void updateClasses(Classes classes) {
		classesDao.updateClasses(classes);
	}

	public void addClasses(Classes classes) {
		classesDao.updateClasses(classes);
	}

	public List selectClasses(Classes classes) {
		return classesDao.selectClasses(classes);
	}

	public void addClassesList(List cList) {
		Classes classes;
		for (Iterator iterator = cList.iterator(); iterator.hasNext(); classesDao.addClasses(classes))
			classes = (Classes) iterator.next();

	}

	public void updateClassesList(List cList) {
		Classes classes;
		for (Iterator iterator = cList.iterator(); iterator.hasNext(); classesDao.updateClasses(classes))
			classes = (Classes) iterator.next();

	}
}
