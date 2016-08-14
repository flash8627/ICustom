package com.gwtjs.lookup.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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

	@Override
	public int deleteByPrimaryKey(Long regId) {
		// TODO Auto-generated method stub
		return lookupItemDao.deleteByPrimaryKey(regId);
	}

	@Override
	public int insert(LookupItemVO record) {
		// TODO Auto-generated method stub
		return lookupItemDao.insert(record);
	}

	@Override
	public int insertSelective(LookupItemVO record) {
		// TODO Auto-generated method stub
		return lookupItemDao.insertSelective(record);
	}

	@Override
	public LookupItemVO selectByPrimaryKey(Long regId) {
		// TODO Auto-generated method stub
		return lookupItemDao.selectByPrimaryKey(regId);
	}

	@Override
	public int updateByPrimaryKeySelective(LookupItemVO record) {
		// TODO Auto-generated method stub
		return lookupItemDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(LookupItemVO record) {
		// TODO Auto-generated method stub
		return lookupItemDao.updateByPrimaryKey(record);
	}

	@Override
	public List<LookupItemVO> selectList(LookupItemVO record,PagerVO page) {
		// TODO Auto-generated method stub
		return lookupItemDao.selectList(record, page);
	}

	@Override
	public int selectListCount(LookupItemVO record) {
		// TODO Auto-generated method stub
		return lookupItemDao.selectListCount(record);
	}

	@Override
	public int batchRemovePks(List<LookupItemVO> records) {
		// TODO Auto-generated method stub
		return lookupItemDao.batchRemovePks(records);
	}

	@Override
	public int batchUpdate(List<LookupItemVO> records) {
		// TODO Auto-generated method stub
		return lookupItemDao.batchUpdate(records);
	}

	@Override
	public int batchInsert(List<LookupItemVO> records) {
		// TODO Auto-generated method stub
		return 0;
	}

}
