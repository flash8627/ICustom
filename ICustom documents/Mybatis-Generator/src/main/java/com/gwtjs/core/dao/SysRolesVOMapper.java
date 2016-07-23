package com.gwtjs.core.dao;

import com.gwtjs.core.entity.SysRolesVO;

public interface SysRolesVOMapper {
    int insert(SysRolesVO record);

    int insertSelective(SysRolesVO record);
}