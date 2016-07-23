package com.gwtjs.core.dao;

import com.gwtjs.core.entity.NavigationVO;
import java.math.BigDecimal;

public interface NavigationVOMapper {
    int deleteByPrimaryKey(BigDecimal itemId);

    int insert(NavigationVO record);

    int insertSelective(NavigationVO record);

    NavigationVO selectByPrimaryKey(BigDecimal itemId);

    int updateByPrimaryKeySelective(NavigationVO record);

    int updateByPrimaryKey(NavigationVO record);
}