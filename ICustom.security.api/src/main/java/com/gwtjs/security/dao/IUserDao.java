package com.gwtjs.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysUsersVO;

@Repository(value = "userDao")
public interface IUserDAO  extends BaseSqlMapper<SysUsersVO>  {
	
	//
	PagedResult<SysUsersVO> queryUserByPage(SysUsersVO record);
	
	/**
	 *@author aGuang 2011-3-30 下午03:51:48
	 *@param account
	 *@param session
	 *@return  字符数组
	 */
	/**用户权限名称*/
	List<String> loadUserAuthorities(SysUsersVO record);
	
	/**
	 * 根据用户账号返回SysUsers实例对象。
	 * 
	 * @author aGuang 2011-4-8 下午01:53:05
	 *@param userAccount
	 *            用户账号，比如admin等。
	 *@return SysUsers实例对象。
	 */
	public SysUsersVO findByUserAccount(SysUsersVO record);
	
	//
	SysUsersVO findByItem(SysUsersVO record);
	
	//
	SysUsersVO findItem(@Param("userId")long userId);

	PagedResult<SysUsersVO> findUserByPage(SysUsersVO record,PagerVO page);

	//
	int batchRemovePks(List<SysUsersVO> records);

	//
	int batchUpdate(List<SysUsersVO> records);

	//
	int batchInsert(List<SysUsersVO> records);
	
	int updateUserPwd(SysUsersVO record);
	
}
