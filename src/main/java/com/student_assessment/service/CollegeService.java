// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CollegeService.java

package com.student_assessment.service;

import com.student_assessment.pojo.College;
import java.util.List;

public interface CollegeService
{

	public abstract College selectCollegeById(String s);

	public abstract void deleteCollege(String s);

	public abstract void updateCollege(College college);

	public abstract void addCollege(College college);

	public abstract List selectCollge(College college);

	public abstract void addCollegeList(List list);

	public abstract void updateCollgeList(List list);
}
