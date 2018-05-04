// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ClassesDao.java

package com.student_assessment.dao;

import com.student_assessment.pojo.Classes;
import java.util.List;

public interface ClassesDao
{

	public abstract Classes selectClassesByClassesId(String s);

	public abstract void deleteClasses(String s);

	public abstract void updateClasses(Classes classes);

	public abstract void addClasses(Classes classes);

	public abstract List selectClasses(Classes classes);

	public abstract void addClassesList(List list);

	public abstract void updateClassesList(List list);
}
