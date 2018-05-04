// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ClassesService.java

package com.student_assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.student_assessment.dao.ClassesDao;
import com.student_assessment.pojo.Classes;
public interface ClassesService
{
	Classes selectClassesByClassesId(String s);

	 void deleteClasses(String s);

	 void updateClasses(Classes classes);

	 void addClasses(Classes classes);

	 List selectClasses(Classes classes);

	 void addClassesList(List list);

	 void updateClassesList(List list);
}