package com.gwtjs.lookup.entity;

import com.gwtjs.common.entity.BaseResource;

public class LookupItemVO extends BaseResource {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2735567571111256970L;

	private Integer itemId;

	private Integer itemCode;// 一般使用序号或英文简写

	private String itemName;// 显示值

	private Integer itemLan;// 语言

	private String itemStatus;

	private String remarks;// 说明

	private Integer classId; // 分类,对应lookup classify id

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId == null ? null : itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName == null ? null : itemName.trim();
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId == null ? null : classId;
	}

	public Integer getItemCode() {
		return itemCode;
	}

	public void setItemCode(Integer itemCode) {
		this.itemCode = itemCode;
	}

	public Integer getItemLan() {
		return itemLan;
	}

	public void setItemLan(Integer itemLan) {
		this.itemLan = itemLan;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "LookupItemVO [itemId=" + itemId + ", itemCode=" + itemCode
				+ ", itemName=" + itemName + ", itemLan=" + itemLan
				+ ", itemStatus=" + itemStatus + ", remarks=" + remarks
				+ ", classId=" + classId + "]";
	}

}