// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CollegeDao.java

package com.student_assessment.dao;

import com.student_assessment.pojo.College;
import java.util.List;

public interface CollegeDao
{

	public abstract College selectCollegeById(String s);

	public abstract void deleteCollege(String s);

	public abstract void updateCollege(College college);

	public abstract void addCollege(College college);

	public abstract List selectCollege(College college);

	public abstract void addCollegeList(List list);

	public abstract void updateCollgeList(List list);
}
