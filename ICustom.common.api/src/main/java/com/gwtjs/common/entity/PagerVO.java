package com.gwtjs.common.entity;

import java.util.Collections;

/**
 * 分页组件
 * 
 * @author aGuang
 *
 */
public class PagerVO {

	private Object entityList;
	private int totalRows;
	private int curPage;
	private int pageSize;
	private int startRecord;
	private int endRecord;
	private int totalPage;
	private String order;

	public Object getEntityList() {
		return entityList == null ? Collections.<Object> emptyList() : entityList;
	}

	public void setEntityList(Object entityList) {
		this.entityList = entityList;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getStartRecord() {
		return curPage*pageSize-1;
	}

	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}

	public int getEndRecord() {
		return curPage*pageSize+pageSize;
	}

	public void setEndRecord(int endRecord) {
		this.endRecord = endRecord;
	}
	
}
