package com.gwtjs.security.entity;

import com.gwtjs.common.entity.BaseResource;

public class SysUsersRolesVO extends BaseResource {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6514505604498078008L;
	private long id;
	private SysUsersVO sysUsers;
	private SysRolesVO sysRoles;
	private boolean enabled;
	private String remarks;// REMARKS;

	public SysUsersRolesVO() {
	}

	public SysUsersRolesVO(long id, SysUsersVO sysUsers, SysRolesVO sysRoles,
			boolean enabled, String remarks) {
		super();
		this.id = id;
		this.sysUsers = sysUsers;
		this.sysRoles = sysRoles;
		this.enabled = enabled;
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SysUsersVO getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(SysUsersVO sysUsers) {
		this.sysUsers = sysUsers;
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
