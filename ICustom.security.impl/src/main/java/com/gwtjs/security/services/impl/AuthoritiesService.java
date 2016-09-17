package com.gwtjs.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.security.dao.IAuthoritiesDAO;
import com.gwtjs.security.entity.SysAuthoritiesVO;
import com.gwtjs.security.services.IAuthoritiesService;

@Named("authoritiesService")
public class AuthoritiesService implements IAuthoritiesService {
	
	@Inject
	private IAuthoritiesDAO authoritiesDAO;
	
	@Override
	public List<SysAuthoritiesVO> findAuthoritiesList(SysAuthoritiesVO auth) {
		List<SysAuthoritiesVO> records = authoritiesDAO.findItems(auth);
		/*for (SysAuthoritiesVO record : records) {
			List<SysAuthoritiesVO> children = getTree(record);
			record.setChildren(children);
		}*/
		return records;
	}

	/**
	 * 分页的lookup 条目
	 */
	@Override
	public PagedResult<SysAuthoritiesVO> findRecords(SysAuthoritiesVO record, PagerVO page) {
		PagedResult<SysAuthoritiesVO> paged = new PagedResult<SysAuthoritiesVO>();
		PagerVO pageVO = new PagerVO();
		pageVO.setTotalRows(authoritiesDAO.selectListCount(record, page));
		if (pageVO.getTotalRows() > 0) {
			paged.setPageVO(pageVO);
			paged.setResult(authoritiesDAO.selectList(record, page));
		}
		return paged;
	}

	@Override
	public ResultWrapper findItem(Integer regId) {
		return ResultWrapper.successResult(authoritiesDAO.findItem(regId));
	}

	@Override
	public ResultWrapper batchRemovePks(List<SysAuthoritiesVO> records) {
		return ResultWrapper.successResult(authoritiesDAO.batchRemovePks(records));
	}

	@Override
	public ResultWrapper batchUpdate(List<SysAuthoritiesVO> records) {
		records = setRecordsUser(records);
		authoritiesDAO.batchUpdate(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchInsert(List<SysAuthoritiesVO> records) {
		records = setRecordsUser(records);
		authoritiesDAO.batchInsert(records);
		List<SysAuthoritiesVO> result = new ArrayList<SysAuthoritiesVO>();
		for (SysAuthoritiesVO reg : records) {
			SysAuthoritiesVO vo = authoritiesDAO.getByPathAuthorities(reg);
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
	private List<SysAuthoritiesVO> setRecordsUser(List<SysAuthoritiesVO> records) {
		List<SysAuthoritiesVO> result = new ArrayList<SysAuthoritiesVO>();
		long createdUser = new Long(10001);

		for (SysAuthoritiesVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}
	
}
