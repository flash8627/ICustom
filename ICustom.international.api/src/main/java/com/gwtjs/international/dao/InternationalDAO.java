package com.gwtjs.international.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.international.entity.LanguageVO;

public interface InternationalDAO extends BaseSqlMapper<LanguageVO> {
	
	//
	LanguageVO findByItem(LanguageVO lan);
	
	//
	LanguageVO findItem(@Param("lanId")Long lanId);
	
	//
	LanguageVO i18n(LanguageVO record);

	//
	PagedResult<LanguageVO> findLanguagePage(LanguageVO record,PagerVO page);
	
	//
	int batchRemovePks(List<LanguageVO> records);
	
	//
	int batchUpdate(List<LanguageVO> records);

	//
	int batchInsert(List<LanguageVO> records);
	
}
