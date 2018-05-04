// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CollegeServiceImpl.java

package com.student_assessment.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_assessment.dao.CollegeDao;
import com.student_assessment.pojo.College;
import com.student_assessment.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService {
	@Autowired
	private CollegeDao collegeDao;

	public College selectCollegeById(String collegeId) {
		return collegeDao.selectCollegeById(collegeId);
	}

	public void deleteCollege(String collegeId) {
		collegeDao.deleteCollege(collegeId);
	}

	public void updateCollege(College college) {
		collegeDao.updateCollege(college);
	}

	public void addCollege(College college) {
		collegeDao.addCollege(college);
	}

	public List selectCollge(College college) {
		return collegeDao.selectCollege(college);
	}

	public void addCollegeList(List collegeList) {
		College college;
		for (Iterator iterator = collegeList.iterator(); iterator.hasNext(); collegeDao.addCollege(college))
			college = (College) iterator.next();

	}

	public void updateCollgeList(List collegeList) {
		College college;
		for (Iterator iterator = collegeList.iterator(); iterator.hasNext(); collegeDao.updateCollege(college))
			college = (College) iterator.next();

	}
}
