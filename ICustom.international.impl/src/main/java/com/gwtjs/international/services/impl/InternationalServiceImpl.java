package com.gwtjs.international.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.international.dao.InternationalDAO;
import com.gwtjs.international.entity.LanguageVO;
import com.gwtjs.international.services.IInternationalService;

/**
 * 国际化
 * 
 * @author aGuang
 *
 */
@Named("internationalService")
public class InternationalServiceImpl implements IInternationalService {

	@Inject
	private InternationalDAO internationalDao;

	@Override
	public int deleteByPrimaryKey(Long regId) {
		return internationalDao.deleteByPrimaryKey(regId);// internationalDao.deleteByPrimaryKey(regId);
	}

	@Override
	public int insert(LanguageVO record) {
		// TODO Auto-generated method stub
		return internationalDao.insert(record);
	}

	@Override
	public int insertSelective(LanguageVO record) {
		// TODO Auto-generated method stub
		return internationalDao.insertSelective(record);
	}

	@Override
	public LanguageVO selectByPrimaryKey(Long regId) {
		// TODO Auto-generated method stub
		return internationalDao.selectByPrimaryKey(regId);
	}

	@Override
	public int updateByPrimaryKeySelective(LanguageVO record) {
		return internationalDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(LanguageVO record) {
		return internationalDao.updateByPrimaryKey(record);
	}

	@Override
	public List<LanguageVO> findLanguageList(LanguageVO record,PagerVO page) {
		return internationalDao.selectList(record, page);
	}

	@Override
	public int findLanguageListCount(LanguageVO record) {
		return internationalDao.selectListCount(record);
	}

	@Override
	public int batchRemovePks(List<LanguageVO> records) {
		return internationalDao.batchRemovePks(records);
	}

	@Override
	public int batchUpdate(List<LanguageVO> records) {
		return internationalDao.batchUpdate(records);
	}

	@Override
	public int batchInsert(List<LanguageVO> records) {
		return internationalDao.batchInsert(records);
	}

}
