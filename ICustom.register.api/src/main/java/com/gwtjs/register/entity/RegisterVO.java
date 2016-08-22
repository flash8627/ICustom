package com.gwtjs.register.entity;

import com.gwtjs.common.entity.BaseResource;

/**
 * 数据字典
 * 
 * @author aGuang
 *
 */
public class RegisterVO extends BaseResource {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long regId; //

	private String regName;// 名称或label

	private String regCode;// 编码,路径形式

	private String regValue;// 字典值

	private String regDesc; // 说明

	private Long parentId; // 上级标识 -->等于　regId

	public Long getRegId() {
		return regId;
	}

	public void setRegId(Long regId) {
		this.regId = regId;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName == null ? null : regName.trim();
	}

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode == null ? null : regCode.trim();
	}

	public String getRegDesc() {
		return regDesc;
	}

	public void setRegDesc(String regDesc) {
		this.regDesc = regDesc == null ? null : regDesc.trim();
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	public String getRegValue() {
		return regValue;
	}

	public void setRegValue(String regValue) {
		this.regValue = regValue;
	}

}
