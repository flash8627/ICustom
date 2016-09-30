package com.gwtjs.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.security.dao.IAuthoritiesResourcesDAO;
import com.gwtjs.security.entity.SysAuthoritiesResourcesVO;
import com.gwtjs.security.services.IAuthorityResourcesService;

@Named("authorityResourcesService")
public class AuthoritiesResourcesService implements
		IAuthorityResourcesService {

	private IAuthoritiesResourcesDAO authoritiesResourcesDao;

	@Override
	public List<SysAuthoritiesResourcesVO> findAuthoritiesResources(long authId) {
		return authoritiesResourcesDao.findAuthoritiesResources(authId);
	}

	@Override
	public ResultWrapper batchRemovePks(List<SysAuthoritiesResourcesVO> list) {
		authoritiesResourcesDao.batchRemovePks(list);
		return ResultWrapper.successResult(list);
	}

	@Override
	public ResultWrapper batchInsert(List<SysAuthoritiesResourcesVO> list) {
		list = setRecordsUser(list);
		authoritiesResourcesDao.batchInsert(list);
		List<SysAuthoritiesResourcesVO> result = new ArrayList<SysAuthoritiesResourcesVO>();
		for (SysAuthoritiesResourcesVO reg : list) {
			SysAuthoritiesResourcesVO vo = authoritiesResourcesDao.findAuthoritiesResourcesItem(reg);
			result.add(vo);
		}
		return ResultWrapper.successResult(result);
	}
	
	/**
	 * 设置当前操作用户
	 * 
	 * @param records
	 * @return
	 */
	private List<SysAuthoritiesResourcesVO> setRecordsUser(List<SysAuthoritiesResourcesVO> records) {
		List<SysAuthoritiesResourcesVO> result = new ArrayList<SysAuthoritiesResourcesVO>();
		long createdUser = new Long(10001);

		for (SysAuthoritiesResourcesVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}

}
