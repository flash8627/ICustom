package com.gwtjs.lookup.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.lookup.dao.ILookupDAO;
import com.gwtjs.lookup.entity.LookupVO;
import com.gwtjs.lookup.services.ILookupClassifyService;

/**
 * lookup分类
 * 
 * @author aGuang
 *
 */
@Named("lookupClassifyService")
public class LookupClassifyServiceImpl implements ILookupClassifyService {

	@Inject
	private ILookupDAO lookupDao;
	
	/**
	 * 分页的lookup 条目
	 */
	@Override
	public PagedResult<LookupVO> findListRecords(LookupVO record, PagerVO page) {
		PagedResult<LookupVO> paged = new PagedResult<LookupVO>();
		PagerVO pageVO = new PagerVO();
		pageVO.setTotalRows(lookupDao.selectListCount(record,page));
		if(pageVO.getTotalRows()>0){
			paged.setPageVO(pageVO);
			paged.setResult(lookupDao.selectList(record, page));
		}
		return paged;
	}
	
	@Override
	public ResultWrapper findItem(Integer classId) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(lookupDao.findItem(classId));
	}

	@Override
	public List<LookupVO> findLookupList(LookupVO record, PagerVO page) {
		return lookupDao.selectList(record, page);
	}

	@Override
	public ResultWrapper findLookupListCount(LookupVO record) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(lookupDao.selectListCount(record,null));
	}

	@Override
	public ResultWrapper batchRemovePks(List<LookupVO> records) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(lookupDao.batchRemovePks(records));
	}

	@Override
	public ResultWrapper batchUpdate(List<LookupVO> records) {
		records = setRecordsUser(records);
		return ResultWrapper.successResult(lookupDao.batchUpdate(records));
	}

	@Override
	public ResultWrapper batchInsert(List<LookupVO> records) {
		records = setRecordsUser(records);
		return ResultWrapper.successResult(lookupDao.batchInsert(records));
	}
	
	/**
	 * 设置当前操作用户 
	 * @param records
	 * @return
	 */
	private List<LookupVO> setRecordsUser(List<LookupVO> records){
		List<LookupVO> result = new ArrayList<LookupVO>();
		long createdUser = new Long(1);
		
		for (LookupVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}
	
}
