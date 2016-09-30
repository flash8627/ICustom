package com.gwtjs.security.dao;

import java.util.List;

import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.security.entity.SysRolesAuthoritiesVO;

public interface IRoleAuthoritiesDao {
	
	ResultWrapper batchRemovePks(List<SysRolesAuthoritiesVO> list);
	
	ResultWrapper batchInsert(List<SysRolesAuthoritiesVO> list);
	
	SysRolesAuthoritiesVO findByRoleAuthorities(SysRolesAuthoritiesVO vo);
	
	List<SysRolesAuthoritiesVO> findRoleAuthorities(SysRolesAuthoritiesVO vo);
	
}
