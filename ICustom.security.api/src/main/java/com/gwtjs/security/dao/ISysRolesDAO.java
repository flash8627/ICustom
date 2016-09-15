package com.gwtjs.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysRolesVO;

public interface ISysRolesDAO  extends BaseSqlMapper<SysRolesVO>  {
	
	//
	SysRolesVO findByItem(SysRolesVO record);
	
	//
	SysRolesVO findItem(@Param("roleId")long roleId);

	//
	List<SysRolesVO> selectList(SysRolesVO record,PagerVO page);

	//
	int selectListCount(SysRolesVO record,PagerVO page);

	//
	int batchRemovePks(List<SysRolesVO> records);

	//
	int batchUpdate(List<SysRolesVO> records);

	//
	int batchInsert(List<SysRolesVO> records);
	
}
