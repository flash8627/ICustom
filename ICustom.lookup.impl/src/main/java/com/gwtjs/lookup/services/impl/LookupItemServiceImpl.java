package com.gwtjs.lookup.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.lookup.dao.ILookupItemDAO;
import com.gwtjs.lookup.entity.LookupItemVO;
import com.gwtjs.lookup.services.ILookupItemService;

/**
 * lookup 条目
 * 
 * @author aGuang
 *
 */
@Named("lookupItemService")
public class LookupItemServiceImpl implements ILookupItemService {

	@Inject
	private ILookupItemDAO lookupItemDao;
	
	/**
	 * 分页的lookup 条目
	 */
	@Override
	public PagedResult<LookupItemVO> findRecords(LookupItemVO record, PagerVO page) {
		PagedResult<LookupItemVO> paged = new PagedResult<LookupItemVO>();
		PagerVO pageVO = new PagerVO();
		pageVO.setTotalRows(lookupItemDao.selectListCount(record,page));
		if(pageVO.getTotalRows()>0){
			paged.setPageVO(pageVO);
			paged.setResult(lookupItemDao.selectList(record, page));
		}
		return paged;
	}

	@Override
	public ResultWrapper findLookupItems(String classId) {
		return ResultWrapper.successResult(lookupItemDao.findLookupItems(classId));
	}

	@Override
	public ResultWrapper findItem(String record) {
		return ResultWrapper.successResult(lookupItemDao.findItem(record));
	}

	@Override
	public ResultWrapper selectListCount(LookupItemVO record) {
		return ResultWrapper.successResult(lookupItemDao.selectListCount(record));
	}

	@Override
	public ResultWrapper batchRemovePks(List<LookupItemVO> records) {
		return ResultWrapper.successResult(lookupItemDao.batchRemovePks(records));
	}

	@Override
	public ResultWrapper batchUpdate(List<LookupItemVO> records) {
		records = setRecordsUser(records);
		return ResultWrapper.successResult(lookupItemDao.batchUpdate(records));
	}

	@Override
	public ResultWrapper batchInsert(List<LookupItemVO> records) {
		records = setRecordsUser(records);
		return ResultWrapper.successResult(lookupItemDao.batchInsert(records));
	}
	
	/**
	 * 设置当前操作用户 
	 * @param records
	 * @return
	 */
	private List<LookupItemVO> setRecordsUser(List<LookupItemVO> records){
		List<LookupItemVO> result = new ArrayList<LookupItemVO>();
		long createdUser = new Long(1);
		
		for (LookupItemVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}
	
}
