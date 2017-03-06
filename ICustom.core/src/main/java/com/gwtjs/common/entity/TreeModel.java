package com.gwtjs.common.entity;

import java.util.ArrayList;
import java.util.List;

public class TreeModel<T> extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6494862592290138908L;

	private long id; //

	private long parentId; //

	private String text;// 名称或label

	private boolean checked = false; // 是否选中

	private String state; // 打开关闭状态

	private String iconCls;// 树的图标
	// 叶子节点否?
	private boolean leaf;

	private List<T> children = new ArrayList<T>();

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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public List<T> getChildren() {
		return children;
	}

	public void setChildren(List<T> children) {
		this.children = children;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

}
