package com.gwtjs.security.dao;

import java.util.List;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysResourcesVO;

public interface ISysResourcesDAO extends BaseSqlMapper<SysResourcesVO>  {
	
	List<SysResourcesVO> findResourcesList(SysResourcesVO record);
	
	//
	SysResourcesVO findSysResourcesTreeRoot();

	//
	int batchInsert(List<SysResourcesVO> list);

	//
	int batchRemoveSysResourcesPks(List<SysResourcesVO> list);

	//
	int deleteByPrimaryKey(long resourceId);

	//
	Integer selectByItemId();

	//
	SysResourcesVO selectByPrimaryKey(long resourceId);

}
