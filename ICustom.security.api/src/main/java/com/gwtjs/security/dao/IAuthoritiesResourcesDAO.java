package com.gwtjs.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysAuthoritiesResourcesVO;

public interface IAuthoritiesResourcesDAO extends BaseSqlMapper<SysAuthoritiesResourcesVO> {
	
	List<String> loadResource(String auth);
	
	List<SysAuthoritiesResourcesVO> findAuthoritiesResources(@Param("authId") long authId);
	
	SysAuthoritiesResourcesVO findAuthoritiesResourcesItem(SysAuthoritiesResourcesVO ar);
	
	int batchRemovePks(List<SysAuthoritiesResourcesVO> list);
	
	int batchInsert(List<SysAuthoritiesResourcesVO> list);
	
}
