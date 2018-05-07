// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CourseServiceImpl.java

package com.student_assessment.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.CourseDao;
import com.student_assessment.pojo.Course;
import com.student_assessment.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;

	public void deleteCourse(String courseId) {
		courseDao.deleteCourse(courseId);
	}

	public void updateCourse(Course course) {
		courseDao.updateCourse(course);
	}

	public void addCourse(Course course) {
		System.out.println(course);
		courseDao.addCourse(course);
	}

	public List selectCourseAll(Course course) {
		return courseDao.selectCourseAll(course);
	}
}
