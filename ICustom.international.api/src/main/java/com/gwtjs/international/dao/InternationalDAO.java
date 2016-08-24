package com.gwtjs.international.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.international.entity.LanguageVO;

public interface InternationalDAO extends BaseSqlMapper<LanguageVO> {

	//
	LanguageVO findItem(@Param("regId")Long regId);

	//
	List<LanguageVO> selectList(LanguageVO record,PagerVO page);
	
	//
	int selectListCount(LanguageVO record);
	
	//
	int batchRemovePks(List<LanguageVO> records);
	
	//
	int batchUpdate(List<LanguageVO> records);

	//
	int batchInsert(List<LanguageVO> records);
	
}
