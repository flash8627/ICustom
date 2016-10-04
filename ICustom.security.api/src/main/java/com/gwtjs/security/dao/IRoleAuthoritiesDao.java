package com.gwtjs.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysRolesAuthoritiesVO;

public interface IRoleAuthoritiesDao extends BaseSqlMapper<SysRolesAuthoritiesVO>{
	
	int batchRemovePks(List<SysRolesAuthoritiesVO> list);
	
	int batchInsert(List<SysRolesAuthoritiesVO> list);
	
	SysRolesAuthoritiesVO findByRoleAuthorities(SysRolesAuthoritiesVO vo);
	
	List<SysRolesAuthoritiesVO> findRoleAuthorities(@Param("roleId")long roleId);
	
}
