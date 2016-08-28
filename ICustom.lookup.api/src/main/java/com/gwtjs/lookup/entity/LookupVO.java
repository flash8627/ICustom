package com.gwtjs.lookup.entity;

import com.gwtjs.common.entity.BaseResource;

public class LookupVO extends BaseResource {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4553951836037253023L;

	private Integer classId;

	private String className;

	private String classCode; // icustom.xxx.xxx

	private String classDesc;

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId == null ? null : classId;
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

	public String getClassDesc() {
		return classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}

}