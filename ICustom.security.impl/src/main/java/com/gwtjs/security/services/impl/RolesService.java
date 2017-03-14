package com.gwtjs.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PagerVO;
import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.security.dao.ISysRolesDAO;
import com.gwtjs.security.entity.SysRolesVO;
import com.gwtjs.security.services.IRolesService;

@Named("rolesService")
public class RolesService implements IRolesService {
	
	@Inject
	private ISysRolesDAO rolesDao;
	
	@Override
	public ResultWrapper findItem(long roleId) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(rolesDao.findItem(roleId));
	}

	@Override
	public PagedResult<SysRolesVO> findRolesList(SysRolesVO record, PagerVO page) {
		return rolesDao.findSysRoles(record, page);
	}

	@Override
	public ResultWrapper batchRemovePks(List<SysRolesVO> records) {
		// TODO Auto-generated method stub
		rolesDao.batchRemovePks(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchUpdate(List<SysRolesVO> records) {
		records = setRecordsRoles(records);
		rolesDao.batchUpdate(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchInsert(List<SysRolesVO> records) {
		records = setRecordsRoles(records);
		rolesDao.batchInsert(records);
		return genericResult(records);
	}

	private ResultWrapper genericResult(List<SysRolesVO> list)
	{
		List<SysRolesVO> records = new ArrayList<SysRolesVO>();
		for (SysRolesVO user : list) {
			records.add(rolesDao.findByItem(user));
		}
		return ResultWrapper.successResult(records);
	}
	
	/**
	 * 设置当前操作用户 
	 * @param records
	 * @return
	 */
	private List<SysRolesVO> setRecordsRoles(List<SysRolesVO> records){
		List<SysRolesVO> result = new ArrayList<SysRolesVO>();
		long createdUser = new Long(1);
		
		for (SysRolesVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}
	
}
