package com.gwtjs.international.entity;

import com.gwtjs.common.entity.BaseResource;

public class LanguageVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 36316418868787090L;

	private long lanId;

	private String lanCode;

	private int lanType;

	public long getLanId() {
		return lanId;
	}

	public void setLanId(long lanId) {
		this.lanId = lanId;
	}

	public String getLanCode() {
		return lanCode;
	}

	public void setLanCode(String lanCode) {
		this.lanCode = lanCode;
	}

	public int getLanType() {
		return lanType;
	}

	public void setLanType(int lanType) {
		this.lanType = lanType;
	}

}