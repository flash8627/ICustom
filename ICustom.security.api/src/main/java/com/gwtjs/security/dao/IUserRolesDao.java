package com.gwtjs.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysUsersRolesVO;

public interface IUserRolesDao extends BaseSqlMapper<SysUsersRolesVO>{
	
	List<SysUsersRolesVO> findUserRoles(@Param("userId")long userId);
	
	SysUsersRolesVO findUserRole(SysUsersRolesVO userRole);
	
	int batchInsert(List<SysUsersRolesVO> list);
	
	int batchRemovePks(List<SysUsersRolesVO> list);
	
}
