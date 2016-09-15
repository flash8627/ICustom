package com.gwtjs.security.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gwtjs.common.entity.BaseResource;

public class SysAuthoritiesVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7323278301594838580L;
	private long authId;
	private String authName;
	private String authDesc;
	private boolean enabled;
	private boolean issys;
	private long parentId;
	private List<SysAuthoritiesVO> children = new ArrayList<SysAuthoritiesVO>();

	private Set<SysRolesAuthoritiesVO> sysRolesAuthoritieses = new HashSet<SysRolesAuthoritiesVO>(
			0);
	private Set<SysAuthoritiesResourcesVO> sysAuthoritiesResources = new HashSet<SysAuthoritiesResourcesVO>(
			0);

	public SysAuthoritiesVO() {
	}

	public SysAuthoritiesVO(long authId, String authName, String authDesc,
			Boolean enabled, Boolean issys,
			Set<SysRolesAuthoritiesVO> sysRolesAuthoritieses,
			Set<SysAuthoritiesResourcesVO> sysAuthoritiesResources) {
		super();
		this.authId = authId;
		this.authName = authName;
		this.authDesc = authDesc;
		this.enabled = enabled;
		this.issys = issys;
		this.sysRolesAuthoritieses = sysRolesAuthoritieses;
		this.sysAuthoritiesResources = sysAuthoritiesResources;
	}

	public SysAuthoritiesVO(long authId, String authName, String authDesc,
			boolean enabled, boolean issys, long parentId,
			List<SysAuthoritiesVO> children,
			Set<SysRolesAuthoritiesVO> sysRolesAuthoritieses,
			Set<SysAuthoritiesResourcesVO> sysAuthoritiesResources) {
		super();
		this.authId = authId;
		this.authName = authName;
		this.authDesc = authDesc;
		this.enabled = enabled;
		this.issys = issys;
		this.parentId = parentId;
		this.children = children;
		this.sysRolesAuthoritieses = sysRolesAuthoritieses;
		this.sysAuthoritiesResources = sysAuthoritiesResources;
	}

	public long getAuthId() {
		return authId;
	}

	public void setAuthId(long authId) {
		this.authId = authId;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getAuthDesc() {
		return authDesc;
	}

	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean getIssys() {
		return issys;
	}

	public void setIssys(boolean issys) {
		this.issys = issys;
	}

	public Set<SysRolesAuthoritiesVO> getSysRolesAuthoritieses() {
		return sysRolesAuthoritieses;
	}

	public void setSysRolesAuthoritieses(
			Set<SysRolesAuthoritiesVO> sysRolesAuthoritieses) {
		this.sysRolesAuthoritieses = sysRolesAuthoritieses;
	}

	public Set<SysAuthoritiesResourcesVO> getSysAuthoritiesResources() {
		return sysAuthoritiesResources;
	}

	public void setSysAuthoritiesResources(
			Set<SysAuthoritiesResourcesVO> sysAuthoritiesResources) {
		this.sysAuthoritiesResources = sysAuthoritiesResources;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public List<SysAuthoritiesVO> getChildren() {
		return children;
	}

	public void setChildren(List<SysAuthoritiesVO> children) {
		this.children = children;
	}

}
