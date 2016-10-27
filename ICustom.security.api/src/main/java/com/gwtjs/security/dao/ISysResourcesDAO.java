package com.gwtjs.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysResourcesVO;

/**
 * 栏目，菜单，导航
 * @author aGuang
 *
 */
public interface ISysResourcesDAO extends BaseSqlMapper<SysResourcesVO> {
	
	//菜单专用
	List<SysResourcesVO> findMenuList(SysResourcesVO record);
	
	//1027新增
	List<SysResourcesVO> findAuthResourcesTree(SysResourcesVO record);
	
	//1027新增
	List<SysResourcesVO> findAuthResourcesTreeRoot();
	
	SysResourcesVO findResourcesGridTreeRoot();
	
	List<SysResourcesVO> findResourcesList(SysResourcesVO record);
	
	int batchInsert(List<SysResourcesVO> list);
	
	int batchRemoveResourcesPks(List<SysResourcesVO> list);
	
	int deleteByPrimaryKey(@Param("resourceId") long resourceId);

    int insert(SysResourcesVO record);

    Integer selectByItemId();
    
    SysResourcesVO selectByPrimaryKey(@Param("resourceId") long resourceId);

    int updateByPrimaryKey(SysResourcesVO record);
	
}

