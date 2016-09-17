package com.gwtjs.register.entity;

import com.gwtjs.common.entity.TreeModel;

/**
 * 数据字典
 * 
 * @author aGuang
 *
 */
public class RegisterVO extends TreeModel<RegisterVO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long regId; //

	private String regName;// 名称或label

	private String regCode;// 编码,路径形式

	private int regStatus;// 编码,路径形式

	private String regValue;// 字典值

	private String regDesc; // 说明

	private long parentId; // 上级标识 -->等于　regId

	private String parentName; // icustom.app.xxx

	private String parentPath; // icustom.app.xxx

	public long getRegId() {
		return regId;
	}

	public void setRegId(long regId) {
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

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
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

	public int getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(int regStatus) {
		this.regStatus = regStatus;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}
