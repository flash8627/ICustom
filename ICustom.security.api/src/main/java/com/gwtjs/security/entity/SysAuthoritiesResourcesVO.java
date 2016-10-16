package com.gwtjs.security.entity;

import com.gwtjs.common.entity.BaseResource;

public class SysAuthoritiesResourcesVO extends BaseResource {

	/**
	 */
	private static final long serialVersionUID = 1683008013429473929L;
	private long id;
	private SysAuthoritiesVO sysAuthorities;
	private SysResourcesVO sysResources;
	private boolean enabled;
	private long authId;
	private long resourceId;

	public SysAuthoritiesResourcesVO() {
		super();
	}

	public SysAuthoritiesResourcesVO(long id, SysAuthoritiesVO sysAuthorities,
			SysResourcesVO sysResources, boolean enabled) {
		super();
		this.id = id;
		this.sysAuthorities = sysAuthorities;
		this.sysResources = sysResources;
		this.enabled = enabled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SysAuthoritiesVO getSysAuthorities() {
		return sysAuthorities;
	}

	public void setSysAuthorities(SysAuthoritiesVO sysAuthorities) {
		this.sysAuthorities = sysAuthorities;
	}

	public SysResourcesVO getSysResources() {
		return sysResources;
	}

	public void setSysResources(SysResourcesVO sysResources) {
		this.sysResources = sysResources;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public long getAuthId() {
		return authId;
	}

	public void setAuthId(long authId) {
		this.authId = authId;
	}

	public long getResourceId() {
		return resourceId;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}
	
	

}
