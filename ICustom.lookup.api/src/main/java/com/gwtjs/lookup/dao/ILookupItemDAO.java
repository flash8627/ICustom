package com.gwtjs.lookup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.lookup.entity.LookupItemVO;

public interface ILookupItemDAO extends BaseSqlMapper<LookupItemVO> {
	
	//
	LookupItemVO findItem(@Param("itemId")Long itemId);

	//
	List<LookupItemVO> selectList(LookupItemVO record,PagerVO page);

	//
	int selectListCount(LookupItemVO record);
	
	//
	int batchRemovePks(List<LookupItemVO> records);

	//
	int batchUpdate(List<LookupItemVO> records);

	//
	int batchInsert(List<LookupItemVO> records);

}