package com.gwtjs.international.entity;

import java.math.BigDecimal;

import com.gwtjs.common.entity.BaseResource;

public class LanguageVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 36316418868787090L;

	private long lanId;

	private String lanCode;

	private BigDecimal lanType;

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

	public BigDecimal getLanType() {
		return lanType;
	}

	public void setLanType(BigDecimal lanType) {
		this.lanType = lanType;
	}

}