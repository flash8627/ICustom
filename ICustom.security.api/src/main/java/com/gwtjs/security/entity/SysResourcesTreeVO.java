package com.gwtjs.security.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gwtjs.common.entity.TreeModel;

/**
 * 系统导航
 * 
 * @author aGuang
 *
 */
public class SysResourcesTreeVO extends TreeModel<SysResourcesTreeVO> {

	private static final long serialVersionUID = 8995521445443370814L;
	// 主键ID
	private long resourceId;
	// 条目栏目名称
	private String resourceName;
	// 资源类型
	private int resourceType;
	// 栏目地址
	private String resUrl;
	// 说明
	private String resourceDesc;
	
	// 上级名称
	private String parentName;
	// 子节点统计
	private int childrenCount;
	// 图标
	private String icon;

	private boolean priority;

	private Set<SysAuthoritiesResourcesVO> sysAuthoritiesResourceses = new HashSet<SysAuthoritiesResourcesVO>(
			0);

	public SysResourcesTreeVO() {
	}

	public SysResourcesTreeVO(Integer resourceId, String resourceName,
			int resourceType, String resUrl, String resourceDesc,
			long parentId, String parentName, List<SysResourcesTreeVO> children,
			int childrenCount, String icon, boolean leaf, Boolean priority,
			Integer enabled, Integer issys,
			Set<SysAuthoritiesResourcesVO> sysAuthoritiesResourceses) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.resUrl = resUrl;
		this.resourceDesc = resourceDesc;
		this.parentName = parentName;
		this.childrenCount = childrenCount;
		this.icon = icon;
		this.priority = priority;
		this.sysAuthoritiesResourceses = sysAuthoritiesResourceses;
	}

	public long getResourceId() {
		return resourceId;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	public String getResourceDesc() {
		return resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}


	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public int getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getResourceType() {
		return resourceType;
	}

	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}

	public Boolean getPriority() {
		return priority;
	}

	public void setPriority(Boolean priority) {
		this.priority = priority;
	}

	public Set<SysAuthoritiesResourcesVO> getSysAuthoritiesResourceses() {
		return sysAuthoritiesResourceses;
	}

	public void setSysAuthoritiesResourceses(
			Set<SysAuthoritiesResourcesVO> sysAuthoritiesResourceses) {
		this.sysAuthoritiesResourceses = sysAuthoritiesResourceses;
	}

}
