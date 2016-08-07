package com.gwtjs.lookup.dao;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.lookup.entity.LookupVO;

public interface ILookupDAO extends BaseSqlMapper<LookupVO> {

    int deleteByPrimaryKey(String classId);

    int insert(LookupVO record);

    int insertSelective(LookupVO record);

    LookupVO selectByPrimaryKey(String classId);

    int updateByPrimaryKeySelective(LookupVO record);

    int updateByPrimaryKey(LookupVO record);
    
}
