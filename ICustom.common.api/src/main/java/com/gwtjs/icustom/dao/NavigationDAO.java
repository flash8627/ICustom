package com.gwtjs.icustom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.icustom.entity.NavigationVO;

/**
 * 栏目，菜单，导航
 * @author aGuang
 *
 */
public interface NavigationDAO extends BaseSqlMapper<NavigationVO> {
	
	NavigationVO findNavigationTreeRoot();
	
	List<NavigationVO> findNavigationList(NavigationVO record);
	
	int batchInsert(List<NavigationVO> list);
	
	int batchRemoveNavigationPks(List<NavigationVO> list);
	
	int deleteByPrimaryKey(@Param("itemId")Integer itemId);

    int insert(NavigationVO record);

    int insertSelective(NavigationVO record);
    
    Integer selectByItemId();
    
    NavigationVO selectByPrimaryKey(@Param("itemId")Integer itemId);

    int updateByPrimaryKeySelective(NavigationVO record);

    int updateByPrimaryKey(NavigationVO record);
	
}
