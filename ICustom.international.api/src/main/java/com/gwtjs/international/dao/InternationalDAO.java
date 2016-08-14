package com.gwtjs.international.dao;

import java.util.List;

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.international.entity.LanguageVO;

public interface InternationalDAO extends BaseSqlMapper<LanguageVO> {

	int deleteByPrimaryKey(Long regId);

	int insert(LanguageVO record);

	int insertSelective(LanguageVO record);

	LanguageVO selectByPrimaryKey(Long regId);

	int updateByPrimaryKeySelective(LanguageVO record);

	int updateByPrimaryKey(LanguageVO record);
	
	List<LanguageVO> selectList(LanguageVO record,PagerVO page);
	
	int selectListCount(LanguageVO record);
	
	int batchRemovePks(List<LanguageVO> records);
	
	int batchUpdate(List<LanguageVO> records);

	int batchInsert(List<LanguageVO> records);
	
}
