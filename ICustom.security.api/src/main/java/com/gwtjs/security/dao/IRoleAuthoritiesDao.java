package com.gwtjs.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.security.entity.SysRolesAuthoritiesVO;

public interface IRoleAuthoritiesDao {
	
	ResultWrapper batchRemovePks(List<SysRolesAuthoritiesVO> list);
	
	ResultWrapper batchInsert(List<SysRolesAuthoritiesVO> list);
	
	SysRolesAuthoritiesVO findByRoleAuthorities(SysRolesAuthoritiesVO vo);
	
	List<SysRolesAuthoritiesVO> findRoleAuthorities(@Param("roleId")long roleId);
	
}
