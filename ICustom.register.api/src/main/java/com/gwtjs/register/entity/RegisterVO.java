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

	private Integer regId; //

	private String regName;// 名称或label

	private String regCode;// 编码,路径形式

	private String regValue;// 字典值

	private String regDesc; // 说明

	private Integer parentId; // 上级标识 -->等于　regId

	private String parentPath; //icustom.app.xxx

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getRegValue() {
		return regValue;
	}

	public void setRegValue(String regValue) {
		this.regValue = regValue;
	}

	public String getParentPath() {
		return parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

}
