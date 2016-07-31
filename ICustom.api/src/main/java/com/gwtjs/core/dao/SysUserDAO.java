package com.gwtjs.core.dao;

import com.gwtjs.core.entity.SysUserVO;
import com.gwtjs.core.mapper.BaseSqlMapper;

public interface SysUserDAO extends BaseSqlMapper<SysUserVO> {
	
	int deleteByPrimaryKey(long userId);

    int insert(SysUserVO record);

    int insertSelective(SysUserVO record);

    SysUserVO selectByPrimaryKey(long userId);

    int updateByPrimaryKeySelective(SysUserVO record);

    int updateByPrimaryKey(SysUserVO record);
	
}
