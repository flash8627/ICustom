package com.gwtjs.security.entity;

import java.util.HashSet;
import java.util.Set;

import com.gwtjs.common.entity.BaseResource;

public class SysAuthoritiesVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7323278301594838580L;
	private long authorityId;
	private String authorityName;
	private String authorityDesc;
	private boolean enabled;
	private boolean issys;
	private Set<SysRolesAuthoritiesVO> sysRolesAuthoritieses = new HashSet<SysRolesAuthoritiesVO>(
			0);
	private Set<SysAuthoritiesResourcesVO> sysAuthoritiesResources = new HashSet<SysAuthoritiesResourcesVO>(
			0);

	public SysAuthoritiesVO() {
	}

	public SysAuthoritiesVO(long authorityId, String authorityName,
			String authorityDesc, Boolean enabled, Boolean issys,
			Set<SysRolesAuthoritiesVO> sysRolesAuthoritieses,
			Set<SysAuthoritiesResourcesVO> sysAuthoritiesResources) {
		super();
		this.authorityId = authorityId;
		this.authorityName = authorityName;
		this.authorityDesc = authorityDesc;
		this.enabled = enabled;
		this.issys = issys;
		this.sysRolesAuthoritieses = sysRolesAuthoritieses;
		this.sysAuthoritiesResources = sysAuthoritiesResources;
	}

	public long getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(long authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityDesc() {
		return authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
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

}
