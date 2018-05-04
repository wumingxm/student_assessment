// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Model.java

package com.student_assessment.pojo;

import java.io.Serializable;
import java.util.List;

public class Model implements Serializable
{

	private Integer id;
	private String text;
	private String state;
	private List children;
	private Integer pid;
	private Integer isParent;
	private String url;

	public Model()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getState()
	{
		return isParent.intValue() != 0 ? "closed" : "open";
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public List getChildren()
	{
		return children;
	}

	public void setChildren(List children)
	{
		this.children = children;
	}

	public Integer getPid()
	{
		return pid;
	}

	public void setPid(Integer pid)
	{
		this.pid = pid;
	}

	public Integer getIsParent()
	{
		return isParent;
	}

	public void setIsParent(Integer isParent)
	{
		this.isParent = isParent;
	}
}
