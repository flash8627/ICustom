package com.gwtjs.security.entity;

import java.util.HashSet;
import java.util.Set;

import com.gwtjs.core.entity.BaseResource;

public class SysRolesVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6350828764328566490L;
	private long roleId;
	private String roleName;
	private String roleCode;
	private String roleDesc;
	private int enabled;
	private int issys;

	// 系统用户，这层可以省
	private Set<SysUsersRolesVO> sysUsersRoles = new HashSet<SysUsersRolesVO>(0);
	// 系统权限
	private Set<SysRolesAuthoritiesVO> sysRolesAuthorities = new HashSet<SysRolesAuthoritiesVO>(
			0);

	public SysRolesVO(long roleId, String roleName, String roleCode,
			String roleDesc, int enabled, int issys,
			Set<SysUsersRolesVO> sysUsersRoles,
			Set<SysRolesAuthoritiesVO> sysRolesAuthorities) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.roleDesc = roleDesc;
		this.enabled = enabled;
		this.issys = issys;
		this.sysUsersRoles = sysUsersRoles;
		this.sysRolesAuthorities = sysRolesAuthorities;
	}

	public SysRolesVO() {
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public int getEnabled() {
		return enabled;
	}

	public int getIssys() {
		return issys;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public void setIssys(int issys) {
		this.issys = issys;
	}

	public Set<SysUsersRolesVO> getSysUsersRoles() {
		return sysUsersRoles;
	}

	public void setSysUsersRoles(Set<SysUsersRolesVO> sysUsersRoles) {
		this.sysUsersRoles = sysUsersRoles;
	}

	public Set<SysRolesAuthoritiesVO> getSysRolesAuthorities() {
		return sysRolesAuthorities;
	}

	public void setSysRolesAuthorities(
			Set<SysRolesAuthoritiesVO> sysRolesAuthorities) {
		this.sysRolesAuthorities = sysRolesAuthorities;
	}

}
