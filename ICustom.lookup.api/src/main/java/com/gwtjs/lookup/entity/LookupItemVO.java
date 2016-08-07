package com.gwtjs.lookup.entity;

import com.gwtjs.common.entity.BaseResource;

public class LookupItemVO extends BaseResource {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2735567571111256970L;

	private String itemId;

	private String itemName;

	private String classId;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId == null ? null : itemId.trim();
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName == null ? null : itemName.trim();
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId == null ? null : classId.trim();
	}

}