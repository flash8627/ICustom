package com.gwtjs.lookup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.lookup.entity.LookupVO;

public interface ILookupDAO extends BaseSqlMapper<LookupVO> {
	
	//
	LookupVO findByItem(LookupVO record);
	
	//
	LookupVO findItem(@Param("classId")Integer classId);

	//
	PagedResult<LookupVO> findLookupPage(LookupVO record,PagerVO page);

	//
	int batchRemovePks(List<LookupVO> records);

	//
	int batchUpdate(List<LookupVO> records);

	//
	int batchInsert(List<LookupVO> records);

}
