package com.gwtjs.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.security.dao.IUserRolesDao;
import com.gwtjs.security.entity.SysUsersRolesVO;
import com.gwtjs.security.services.IUserRolesService;

@Named("userRolesServices")
public class UserRolesService implements IUserRolesService {
	
	@Inject
	private IUserRolesDao userRolesDao;

	@Override
	public List<SysUsersRolesVO> getUserRoles(long userId) {
		return userRolesDao.findUserRoles(userId);
	}

	@Override
	public ResultWrapper saveOrUpdate(List<SysUsersRolesVO> models) {
		
		//先删除原有的角色
		List<SysUsersRolesVO> list = new ArrayList<>();
		for (SysUsersRolesVO ur : models) {
			if(ur.getId()!=0){
				list.add(ur);
			}
		}
		if(list.size()>0){
			userRolesDao.batchRemovePks(list);
		}
		//删除后实体不存在，自动创建主键
		List<SysUsersRolesVO> records = setRecordsRoles(models);
		userRolesDao.batchInsert(records);
		return genericResult(records);
	}

	@Override
	public ResultWrapper delete(List<SysUsersRolesVO> models) {
		userRolesDao.batchRemovePks(models);
		return ResultWrapper.successResult(models); 
	}
	
	/**
	 * 构建返回
	 * @param list
	 * @return
	 */
	private ResultWrapper genericResult(List<SysUsersRolesVO> list)
	{
		List<SysUsersRolesVO> records = new ArrayList<SysUsersRolesVO>();
		for (SysUsersRolesVO userRole : list) {
			records.add(userRolesDao.findUserRole(userRole));
		}
		return ResultWrapper.successResult(records);
	}
	
	/**
	 * 设置当前操作用户 
	 * @param records
	 * @return
	 */
	private List<SysUsersRolesVO> setRecordsRoles(List<SysUsersRolesVO> records){
		List<SysUsersRolesVO> result = new ArrayList<SysUsersRolesVO>();
		long createdUser = new Long(1);
		
		for (SysUsersRolesVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}
	
}
