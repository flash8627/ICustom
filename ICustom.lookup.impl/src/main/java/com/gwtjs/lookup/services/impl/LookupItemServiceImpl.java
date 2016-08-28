package com.gwtjs.lookup.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
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
	public List<LookupItemVO> findLookupItems(String classId) {
		return lookupItemDao.findLookupItems(classId);
	}

	@Override
	public LookupItemVO findItem(String record) {
		return lookupItemDao.findItem(record);
	}

	@Override
	public int selectListCount(LookupItemVO record) {
		return lookupItemDao.selectListCount(record);
	}

	@Override
	public int batchRemovePks(List<LookupItemVO> records) {
		return lookupItemDao.batchRemovePks(records);
	}

	@Override
	public int batchUpdate(List<LookupItemVO> records) {
		return lookupItemDao.batchUpdate(records);
	}

	@Override
	public int batchInsert(List<LookupItemVO> records) {
		return lookupItemDao.batchInsert(records);
	}

}
