package com.gwtjs.lookup.entity;

import com.gwtjs.common.entity.BaseResource;

public class LookupVO extends BaseResource {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4553951836037253023L;

	private String classId;

	private String classCode; // icustom.xxx.xxx

	private String className;
	private String regDesc;

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId == null ? null : classId.trim();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getRegDesc() {
		return regDesc;
	}

	public void setRegDesc(String regDesc) {
		this.regDesc = regDesc;
	}

}