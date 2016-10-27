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
public class SysResourcesVO extends TreeModel<SysResourcesVO> {

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
	// 上级
	private long parentId;
	// 上级名称
	private String parentName;
	// 子节点
	private List<SysResourcesVO> children;
	// 子节点统计
	private int childrenCount;
	// 图标
	private String icon;
	// 叶子节点否?
	private boolean leaf;

	private boolean priority;

	// 是否可用，0为不可用，1为可用。
	private Integer useStatus;

	// 是否是超级。0为不超级，1为超级。
	private Integer issys;

	private Set<SysAuthoritiesResourcesVO> sysAuthoritiesResourceses = new HashSet<SysAuthoritiesResourcesVO>(
			0);

	public SysResourcesVO() {
	}

	public SysResourcesVO(Integer resourceId, String resourceName,
			int resourceType, String resUrl, String resourceDesc,
			long parentId, String parentName, List<SysResourcesVO> children,
			int childrenCount, String icon, boolean leaf, Boolean priority,
			Integer enabled, Integer issys,
			Set<SysAuthoritiesResourcesVO> sysAuthoritiesResourceses) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.resUrl = resUrl;
		this.resourceDesc = resourceDesc;
		this.parentId = parentId;
		this.parentName = parentName;
		this.children = children;
		this.childrenCount = childrenCount;
		this.icon = icon;
		this.leaf = leaf;
		this.priority = priority;
		this.useStatus = enabled;
		this.issys = issys;
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

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<SysResourcesVO> getChildren() {
		return children;
	}

	public void setChildren(List<SysResourcesVO> children) {
		this.children = children;
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

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
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

	public Integer getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}

	public Integer getIssys() {
		return issys;
	}

	public void setIssys(Integer issys) {
		this.issys = issys;
	}

	public Set<SysAuthoritiesResourcesVO> getSysAuthoritiesResourceses() {
		return sysAuthoritiesResourceses;
	}

	public void setSysAuthoritiesResourceses(
			Set<SysAuthoritiesResourcesVO> sysAuthoritiesResourceses) {
		this.sysAuthoritiesResourceses = sysAuthoritiesResourceses;
	}

}
