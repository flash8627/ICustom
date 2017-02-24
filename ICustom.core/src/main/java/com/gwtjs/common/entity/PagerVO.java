package com.gwtjs.common.entity;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 分页组件
 * 
 * @author aGuang
 *
 */
@JsonIgnoreProperties
public class PagerVO {

	private int totalRows;
	private int curPage = 1;
	private int pageSize = 15;
	/** 配合结果模式为0取结果集与记录总，为1取记录数，为2只取结果集 */
	private int resultMode;
	private int startIndex;
	private int endIndex;

	private int mysqlStartIndex;

	private int mysqlEndIndex;

	/* 分页表达式 */
	private String orderBy;

	public int getStartIndex() {
		return startIndex == 0 ? (curPage - 1) * pageSize + 1 : startIndex;
	}

	@XmlTransient
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		if (endIndex - startIndex > pageSize) {
			return startIndex + pageSize;
		}
		return endIndex == 0 ? curPage * pageSize
				: (endIndex - 1 > totalRows ? totalRows : endIndex);
	}

	public int getTotalPage() {
		return totalRows % pageSize == 0 ? totalRows / pageSize : totalRows
				/ pageSize + 1;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
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
		return pageSize == 0 ? 15 : pageSize;
	}

	public void setPageSize(int pageSize) {
		/*
		 * if(pageSize<=0 || pageSize>20){ return ; }
		 */
		this.pageSize = pageSize;
	}

	public int getResultMode() {
		return resultMode;
	}

	public void setResultMode(int resultMode) {
		this.resultMode = resultMode;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getMysqlStartIndex() {
		return mysqlStartIndex == 0 ? (curPage - 1) * pageSize
				: mysqlStartIndex;
	}

	public void setMysqlStartIndex(int mysqlStartIndex) {
		this.mysqlStartIndex = mysqlStartIndex;
	}

	public int getMysqlEndIndex() {
		return mysqlEndIndex == 0 ? curPage * pageSize
				: (mysqlEndIndex - 1 > totalRows ? totalRows : mysqlEndIndex);
	}

	public void setMysqlEndIndex(int mysqlEndIndex) {
		this.mysqlEndIndex = mysqlEndIndex;
	}

	@Override
	public String toString() {
		return "PagerVO [totalRows=" + totalRows + ", curPage=" + curPage
				+ ", pageSize=" + pageSize + ", resultMode=" + resultMode
				+ ", startIndex=" + startIndex + ", endIndex=" + endIndex
				+ ", mysqlStartIndex=" + mysqlStartIndex + ", mysqlEndIndex="
				+ mysqlEndIndex + ", orderBy=" + orderBy + "]";
	}

}
