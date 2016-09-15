/*
 * @(#) CustomUserDetails.java  2011-4-13 下午01:44:14
 *
 * Copyright 2011 by aGuang 
 */
package com.gwtjs.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.gwtjs.security.entity.SysUsersRolesVO;

public interface CustomUserDetails extends UserDetails {

	// 用户id
	public long getUserId();

	// 用户账户
	public String getUserAccount();

	// 用户名
	public String getUsername();

	// 用户密码
	public String getPassword();

	// 用户描述或简介
	public String getUserDesc();

	// 用户是否能用
	public boolean isEnabled();

	// 所属的单位
	public String getUserDept();

	// 用户职位
	public String getUserDuty();

	// 用户相对应的角色集
	public Set<SysUsersRolesVO> getSysUsersRoleses();

}
