package com.gwtjs.register.dao;

import java.math.BigDecimal;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.register.entity.RegisterVO;


public interface IRegisterDAO extends BaseSqlMapper<RegisterVO> {

    int deleteByPrimaryKey(BigDecimal regId);

    int insert(RegisterVO record);

    int insertSelective(RegisterVO record);

    RegisterVO selectByPrimaryKey(BigDecimal regId);

    int updateByPrimaryKeySelective(RegisterVO record);

    int updateByPrimaryKey(RegisterVO record);
    
}
