// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ModelController.java

package com.student_assessment.controller;

import com.student_assessment.service.ModelService;
import java.util.List;

public class ModelController
{
	private ModelService modelService;
	public List selectModel(Integer id)
	{
		List list = modelService.selectModelById(id);
		return list;
	}
}
