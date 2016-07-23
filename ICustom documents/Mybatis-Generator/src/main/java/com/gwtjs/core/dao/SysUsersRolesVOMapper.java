package com.gwtjs.core.dao;

import com.gwtjs.core.entity.SysUsersRolesVO;

public interface SysUsersRolesVOMapper {
    int insert(SysUsersRolesVO record);

    int insertSelective(SysUsersRolesVO record);
}