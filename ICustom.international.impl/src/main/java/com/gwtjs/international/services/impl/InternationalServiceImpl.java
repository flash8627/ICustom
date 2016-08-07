package com.gwtjs.international.services.impl;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.international.dao.InternationalDAO;
import com.gwtjs.international.entity.LanguageVO;
import com.gwtjs.international.services.IInternationalService;

/**
 * 国际化
 * @author aGuang
 *
 */
@Named("internationalService")
public class InternationalServiceImpl implements IInternationalService{
	
	@Inject
	private InternationalDAO internationalDao;
	
	@Override
	public int deleteByPrimaryKey(BigDecimal regId) {
		return 0;//internationalDao.deleteByPrimaryKey(regId);
	}

	@Override
	public int insert(LanguageVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(LanguageVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LanguageVO selectByPrimaryKey(BigDecimal regId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(LanguageVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(LanguageVO record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
