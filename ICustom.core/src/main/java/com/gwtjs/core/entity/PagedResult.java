package com.gwtjs.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PagedResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PagerVO pageVO;
	private List<T> result;

	public PagedResult() {
	}

	public PagedResult(PagerVO page, List<T> result) {
		this.pageVO = page;
		this.result = result;
	}

	public PagerVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PagerVO pageVO) {
		this.pageVO = pageVO;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

}
