package com.gwtjs.register.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典
 * 
 * @author aGuang
 *
 */
public class TreeVO extends RegisterVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id; //

	private String text;// 名称或label

	private boolean checked = false; // 是否选中

	private String state; // 打开关闭状态

	private String iconCls;// 树的图标
	// 叶子节点否?
	private boolean leaf;

	private List<TreeVO> children = new ArrayList<TreeVO>();

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

	public List<TreeVO> getChildren() {
		return children;
	}

	public void setChildren(List<TreeVO> children) {
		this.children = children;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
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

	@Override
	public String toString() {
		return "TreeVO [id=" + id + ", text=" + text + ", checked=" + checked
				+ ", state=" + state + ", iconCls=" + iconCls + ", leaf="
				+ leaf + ", children=" + children + "]";
	}

}
