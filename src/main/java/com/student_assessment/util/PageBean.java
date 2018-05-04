// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PageBean.java

package com.student_assessment.util;

import java.util.List;

public class PageBean<T> {

	private List<T> rows;
	private Long total;
	private Integer page;
	private Integer pageSize;
	private Integer totalPage;
	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return (int) ((total%pageSize==0)?(total/pageSize):(total/pageSize)+1);
	}

	public void setTotalPage() {
		this.totalPage = totalPage;
	}
	
}
