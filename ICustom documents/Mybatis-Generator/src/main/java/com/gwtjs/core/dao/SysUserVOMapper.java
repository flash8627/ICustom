package com.gwtjs.core.dao;

import com.gwtjs.core.entity.SysUserVO;

public interface SysUserVOMapper {
    int insert(SysUserVO record);

    int insertSelective(SysUserVO record);
}