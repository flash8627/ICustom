package com.gwtjs.common.entity;

import java.util.List;

/**
 * 系统导航
 * 
 * @author aGuang
 *
 */
public class NavigationVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8995521445443370814L;
	// 主键ID
	private Integer itemId;
	// 条目栏目名称
	private String itemName;
	// 上级
	private Integer parentId;
	private String parentName;
	// 子节点
	private List<NavigationVO> children;
	// 子节点统计
	private int childrenCount;
	// 图标
	private String icon;
	// 叶子节点否?
	private boolean leaf;
	// 资源类型
	private int resourceType;
	// 栏目地址
	private String url;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<NavigationVO> getChildren() {
		return children;
	}

	public void setChildren(List<NavigationVO> children) {
		this.children = children;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}

	public int getResourceType() {
		return resourceType;
	}

	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}

}
