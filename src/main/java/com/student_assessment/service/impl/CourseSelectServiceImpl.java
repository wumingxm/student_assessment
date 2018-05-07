// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseSelectServiceImpl.java

package com.student_assessment.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.CourseSelectDao;
import com.student_assessment.pojo.CourseSelect;
import com.student_assessment.service.CourseSelectService;
import com.student_assessment.util.CourseSelectBean;
import com.student_assessment.util.CourseSelectResultBean;

@Service
class CourseSelectServiceImpl implements CourseSelectService {
	@Autowired
	private CourseSelectDao courseSelectDao;

	public void deleteCourseSelect(String sNo) {
		courseSelectDao.deleteCourseSelect(sNo);
	}

	public void updateCourseSelect(CourseSelect courseSelect) {
		courseSelectDao.updateCourseSelect(courseSelect);
	}

	public void addCourseSelect(CourseSelect courseSelect) {
		courseSelectDao.addCourseSelect(courseSelect);
	}

	public List selectCollge(CourseSelect courseSelect) {
		return courseSelectDao.selectCollge(courseSelect);
	}

	public void addCourseSelectList(List courseSelectList) {
		CourseSelect courseSelect;
		for (Iterator iterator = courseSelectList.iterator(); iterator.hasNext(); courseSelectDao
				.addCourseSelect(courseSelect))
			courseSelect = (CourseSelect) iterator.next();

	}

	public void updateCourseSelectList(List courseSelectList) {
		CourseSelect courseSelect;
		for (Iterator iterator = courseSelectList.iterator(); iterator.hasNext(); courseSelectDao
				.addCourseSelect(courseSelect))
			courseSelect = (CourseSelect) iterator.next();

	}

	public List selectCollegeSelectBySNo(String sNo) {
		return courseSelectDao.selectCourseSelectBySNo(sNo);
	}
	//查询学生成绩
	public List<CourseSelectBean> selectCourseInfoAll() {
		return courseSelectDao.selectCourseInfoAll();
	}
	//查询学生所选的课程名称
	@Override
	public List<CourseSelectResultBean> selectCourseSelectAll() {
		return courseSelectDao.selectCourselectAll();
	}
}
