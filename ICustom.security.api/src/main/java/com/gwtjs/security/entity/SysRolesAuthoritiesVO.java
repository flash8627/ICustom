package com.gwtjs.security.entity;

import com.gwtjs.common.entity.BaseResource;

public class SysRolesAuthoritiesVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 224904070055131977L;

	private long id;
	private SysAuthoritiesVO sysAuthorities;
	private SysRolesVO sysRoles;

	private boolean enabled;

	public SysRolesAuthoritiesVO() {
	}

	public SysRolesAuthoritiesVO(long id, SysAuthoritiesVO sysAuthorities,
			SysRolesVO sysRoles, boolean enabled) {
		super();
		this.id = id;
		this.sysAuthorities = sysAuthorities;
		this.sysRoles = sysRoles;
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

	public SysRolesVO getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(SysRolesVO sysRoles) {
		this.sysRoles = sysRoles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
