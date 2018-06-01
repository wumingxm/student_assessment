// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseSelectDao.java

package com.student_assessment.dao;

import java.util.List;

import com.student_assessment.pojo.CourseSelect;
import com.student_assessment.pojo.Student;
import com.student_assessment.util.CourseSelectBean;
import com.student_assessment.util.CourseSelectResultBean;

public interface CourseSelectDao
{

	 List selectCourseSelectBySNo(String s);

	 void deleteCourseSelect(String s);

	 void updateCourseSelect(CourseSelect courseselect);

	 void addCourseSelect(CourseSelect courseselect);

	 List selectCollge(CourseSelect courseselect);

	 void addCourseSelectList(List list);

	 void updateCourseSelectList(List list);

	 List<CourseSelectBean> selectCourseInfoAll(Student student);
	 
	 List<CourseSelectResultBean>selectCourselectAll(Student student);
}
