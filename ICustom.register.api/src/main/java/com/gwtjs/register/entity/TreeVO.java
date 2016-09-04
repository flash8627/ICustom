package com.gwtjs.register.entity;

import com.gwtjs.common.entity.BaseResource;

/**
 * 数据字典
 * 
 * @author aGuang
 *
 */
public class TreeVO extends BaseResource {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id; //

	private String text;// 名称或label

	private boolean checked = false; // 是否选中

	private String regCode;// 编码,路径形式

	private String regValue;// 字典值

	private String regDesc; // 说明

	private long parentId; // 上级标识 -->等于　regId

	private String parentPath; // icustom.app.xxx

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
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

	public TreeVO regToTree(RegisterVO reg) {

		TreeVO tree = new TreeVO();
		tree.setId(reg.getRegId());
		tree.setText(reg.getRegName());
		tree.setRegCode(reg.getRegCode());
		tree.setRegValue(reg.getRegValue());
		tree.setRegDesc(reg.getRegDesc());

		return tree;
	}

}
