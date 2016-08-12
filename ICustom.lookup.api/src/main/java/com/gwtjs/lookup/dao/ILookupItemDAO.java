package com.gwtjs.lookup.dao;

import java.util.List;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.lookup.entity.LookupItemVO;

public interface ILookupItemDAO extends BaseSqlMapper<LookupItemVO> {

	int deleteByPrimaryKey(String itemId);

	int insert(LookupItemVO record);

	int insertSelective(LookupItemVO record);

	LookupItemVO selectByPrimaryKey(String itemId);

	int updateByPrimaryKeySelective(LookupItemVO record);

	int updateByPrimaryKey(LookupItemVO record);

	List<LookupItemVO> selectList();

	int selectListCount(LookupItemVO record);

	int batchRemovePks(List<LookupItemVO> records);

	int batchUpdate(List<LookupItemVO> records);

	int batchInsert(List<LookupItemVO> records);

}