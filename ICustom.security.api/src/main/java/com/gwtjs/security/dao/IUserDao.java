package com.gwtjs.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysUsersVO;

public interface IUserDAO  extends BaseSqlMapper<SysUsersVO>  {
	
	//
	SysUsersVO login(SysUsersVO record);
	//
	SysUsersVO findByItem(SysUsersVO record);
	
	//
	SysUsersVO findItem(@Param("userId")long userId);

	//
	List<SysUsersVO> selectList(SysUsersVO record,PagerVO page);

	//
	int selectListCount(SysUsersVO record,PagerVO page);

	//
	int batchRemovePks(List<SysUsersVO> records);

	//
	int batchUpdate(List<SysUsersVO> records);

	//
	int batchInsert(List<SysUsersVO> records);
	
	int updateUserPwd(SysUsersVO record);
	
}
