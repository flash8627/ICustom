package com.gwtjs.international.entity;

import com.gwtjs.common.entity.BaseResource;

public class LanguageVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 36316418868787090L;

	private Long lanId;

	private String lanCode; //
	private String lanValue; //
	private String remarks; //

	private Integer lanType; //
	private String lanTypeLab; //

	public Long getLanId() {
		return lanId;
	}

	public void setLanId(Long lanId) {
		this.lanId = lanId;
	}

	public String getLanCode() {
		return lanCode;
	}

	public void setLanCode(String lanCode) {
		this.lanCode = lanCode;
	}

	public Integer getLanType() {
		return lanType;
	}

	public void setLanType(Integer lanType) {
		this.lanType = lanType;
	}

	public String getLanValue() {
		return lanValue;
	}

	public void setLanValue(String lanValue) {
		this.lanValue = lanValue;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getLanTypeLab() {
		return lanTypeLab;
	}

	public void setLanTypeLab(String lanTypeLab) {
		this.lanTypeLab = lanTypeLab;
	}

	@Override
	public String toString() {
		return "LanguageVO [lanId=" + lanId + ", lanCode=" + lanCode
				+ ", lanValue=" + lanValue + ", remarks=" + remarks
				+ ", lanType=" + lanType + ", lanTypeLab=" + lanTypeLab + "]";
	}

}