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

	/**
	 * 显示视图使用
	 */
	private long roleId;
	private long authId;
	private String authName;
	private String authCode;
	private String authDesc;

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

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
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

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthDesc() {
		return authDesc;
	}

	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}

}
