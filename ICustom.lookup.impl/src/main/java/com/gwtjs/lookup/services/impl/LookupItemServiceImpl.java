package com.gwtjs.lookup.services.impl;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Named;

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
	public int deleteByPrimaryKey(BigDecimal regId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(LookupItemVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(LookupItemVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LookupItemVO selectByPrimaryKey(BigDecimal regId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(LookupItemVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(LookupItemVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
