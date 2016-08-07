package com.gwtjs.lookup.services.impl;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Named;

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
	public int deleteByPrimaryKey(BigDecimal regId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(LookupVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(LookupVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LookupVO selectByPrimaryKey(BigDecimal regId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(LookupVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(LookupVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
