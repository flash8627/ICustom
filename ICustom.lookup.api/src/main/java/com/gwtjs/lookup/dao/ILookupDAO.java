package com.gwtjs.lookup.dao;

import java.util.List;

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.lookup.entity.LookupVO;

public interface ILookupDAO extends BaseSqlMapper<LookupVO> {

	int deleteByPrimaryKey(Long classId);

	int insert(LookupVO record);

	int insertSelective(LookupVO record);

	LookupVO selectByPrimaryKey(Long classId);

	int updateByPrimaryKeySelective(LookupVO record);

	int updateByPrimaryKey(LookupVO record);

	List<LookupVO> selectList(LookupVO record,PagerVO page);

	int selectListCount(LookupVO record);

	int batchRemovePks(List<LookupVO> records);

	int batchUpdate(List<LookupVO> records);

	int batchInsert(List<LookupVO> records);

}
