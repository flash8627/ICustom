package com.gwtjs.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.gwtjs.core.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysAuthoritiesVO;

@Component
public interface IAuthoritiesDAO extends BaseSqlMapper<SysAuthoritiesVO> {
	
	//权限框架专用
	List<String> getSysAuthorities();
	
	/* 以下为维护数据专用　 */
	//
	SysAuthoritiesVO getByPathAuthorities(SysAuthoritiesVO reg);
	
	//
	SysAuthoritiesVO findItem(@Param("authId")Integer authId);
	
	//
	List<SysAuthoritiesVO> findAuthoritiesList(SysAuthoritiesVO record,PagerVO page);
	
	//
	List<SysAuthoritiesVO> findAuthoritiesTree(SysAuthoritiesVO record);

	//
	int findAuthoritiesListCount(SysAuthoritiesVO record,PagerVO page);
	
	//
	int batchRemovePks(List<SysAuthoritiesVO> records);

	//
	int batchUpdate(List<SysAuthoritiesVO> records);

	//
	int batchInsert(List<SysAuthoritiesVO> records);
	
}
