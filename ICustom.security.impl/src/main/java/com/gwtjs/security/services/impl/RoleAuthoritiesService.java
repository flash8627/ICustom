package com.gwtjs.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.security.dao.IRoleAuthoritiesDao;
import com.gwtjs.security.entity.SysRolesAuthoritiesVO;
import com.gwtjs.security.services.IRoleAuthoritiesService;

@Named("roleAuthoritiesService")
public class RoleAuthoritiesService implements IRoleAuthoritiesService {
	
	@Inject
	private IRoleAuthoritiesDao roleAuthoritiesDao;

	@Override
	public ResultWrapper batchRemovePks(List<SysRolesAuthoritiesVO> list) {
		roleAuthoritiesDao.batchRemovePks(list);
		return ResultWrapper.successResult(list);
	}

	@Override
	public ResultWrapper batchInsert(List<SysRolesAuthoritiesVO> list) {
		list = setRecordsUser(list);
		roleAuthoritiesDao.batchInsert(list);
		List<SysRolesAuthoritiesVO> result = new ArrayList<SysRolesAuthoritiesVO>();
		for (SysRolesAuthoritiesVO reg : list) {
			SysRolesAuthoritiesVO vo = roleAuthoritiesDao.findByRoleAuthorities(reg);
			result.add(vo);
		}
		return ResultWrapper.successResult(result);
	}

	@Override
	public SysRolesAuthoritiesVO findByRoleAuthorities(SysRolesAuthoritiesVO vo) {
		return roleAuthoritiesDao.findByRoleAuthorities(vo);
	}

	@Override
	public List<SysRolesAuthoritiesVO> findRoleAuthorities(long roleId) {
		List<SysRolesAuthoritiesVO>result = roleAuthoritiesDao.findRoleAuthorities(roleId);
		return result;
	}
	
	/**
	 * 设置当前操作用户
	 * 
	 * @param records
	 * @return
	 */
	private List<SysRolesAuthoritiesVO> setRecordsUser(List<SysRolesAuthoritiesVO> records) {
		List<SysRolesAuthoritiesVO> result = new ArrayList<SysRolesAuthoritiesVO>();
		long createdUser = new Long(10001);

		for (SysRolesAuthoritiesVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}

}
