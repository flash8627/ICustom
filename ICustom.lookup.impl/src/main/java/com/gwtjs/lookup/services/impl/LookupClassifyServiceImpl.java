package com.gwtjs.lookup.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
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
		pageVO.setTotalRows(lookupDao.selectListCount(record));
		if(pageVO.getTotalRows()>0){
			paged.setPageVO(pageVO);
		}
		return paged;
	}
	
	@Override
	public LookupVO findItem(String classId) {
		// TODO Auto-generated method stub
		return lookupDao.findItem(new Long(classId));
	}

	@Override
	public List<LookupVO> findLookupList(LookupVO record, PagerVO page) {
		return lookupDao.selectList(record, page);
	}

	@Override
	public int findLookupListCount(LookupVO record) {
		// TODO Auto-generated method stub
		return lookupDao.selectListCount(record);
	}

	@Override
	public int batchRemovePks(List<LookupVO> records) {
		// TODO Auto-generated method stub
		return lookupDao.batchRemovePks(records);
	}

	@Override
	public int batchUpdate(List<LookupVO> records) {
		// TODO Auto-generated method stub
		return lookupDao.batchUpdate(records);
	}

	@Override
	public int batchInsert(List<LookupVO> records) {
		// TODO Auto-generated method stub
		return lookupDao.batchInsert(records);
	}

}
