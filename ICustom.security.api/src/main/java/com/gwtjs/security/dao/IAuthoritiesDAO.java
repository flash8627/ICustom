package com.gwtjs.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysAuthoritiesVO;

public interface IAuthoritiesDAO  extends BaseSqlMapper<SysAuthoritiesVO>  {
	
	//
	SysAuthoritiesVO getByPathAuthorities(SysAuthoritiesVO reg);
	
	//
	SysAuthoritiesVO findItem(@Param("authId")Integer authId);
	
	List<SysAuthoritiesVO> findAuthoritiesList(SysAuthoritiesVO record);
	
	//
	List<SysAuthoritiesVO> selectList(SysAuthoritiesVO record,PagerVO page);
	
	List<SysAuthoritiesVO> findItems(SysAuthoritiesVO record);

	//
	int selectListCount(SysAuthoritiesVO record,PagerVO page);
	
	//
	int batchRemovePks(List<SysAuthoritiesVO> records);

	//
	int batchUpdate(List<SysAuthoritiesVO> records);

	//
	int batchInsert(List<SysAuthoritiesVO> records);
	
}
