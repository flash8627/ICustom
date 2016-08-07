package com.gwtjs.international.dao;

import java.math.BigDecimal;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.international.entity.LanguageVO;

public interface InternationalDAO extends BaseSqlMapper<LanguageVO> {

    int deleteByPrimaryKey(BigDecimal regId);

    int insert(LanguageVO record);

    int insertSelective(LanguageVO record);

    LanguageVO selectByPrimaryKey(BigDecimal regId);

    int updateByPrimaryKeySelective(LanguageVO record);

    int updateByPrimaryKey(LanguageVO record);
    
}
