package com.gwtjs.lookup.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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

	@Override
	public int deleteByPrimaryKey(Long regId) {
		return lookupDao.deleteByPrimaryKey(regId);
	}

	@Override
	public int insert(LookupVO record) {
		// TODO Auto-generated method stub
		return lookupDao.insert(record);
	}

	@Override
	public int insertSelective(LookupVO record) {
		// TODO Auto-generated method stub
		return lookupDao.insertSelective(record);
	}

	@Override
	public LookupVO selectByPrimaryKey(Long regId) {
		// TODO Auto-generated method stub
		return lookupDao.selectByPrimaryKey(regId);
	}

	@Override
	public int updateByPrimaryKeySelective(LookupVO record) {
		// TODO Auto-generated method stub
		return lookupDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(LookupVO record) {
		// TODO Auto-generated method stub
		return lookupDao.updateByPrimaryKey(record);
	}

	@Override
	public List<LookupVO> findLookupList(LookupVO record,PagerVO page) {
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
