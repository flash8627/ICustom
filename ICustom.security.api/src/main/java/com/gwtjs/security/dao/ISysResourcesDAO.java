package com.gwtjs.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysResourcesVO;

public interface ISysResourcesDAO extends BaseSqlMapper<SysResourcesVO>  {
	
	List<SysResourcesVO> findResourcesList(SysResourcesVO record);
	
	//
	SysResourcesVO findSysResourcesTreeRoot();

	//
	int batchInsert(List<SysResourcesVO> list);

	//
	int batchUpdate(List<SysResourcesVO> list);
	
	//
	int batchRemove(List<SysResourcesVO> list);

	//
	int deleteByPrimaryKey(@Param("resourceId")long resourceId);

	//
	Integer selectByItemId();

	//
	SysResourcesVO selectByPrimaryKey(@Param("resourceId")long resourceId);

}
