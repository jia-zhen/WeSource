package com.we.utils;

import java.io.Serializable;

public class QueryRequestUtils implements Serializable {

	private static final long serialVersionUID = -4869594085374385813L;

	private int pageSize;
	private int pageNum;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
