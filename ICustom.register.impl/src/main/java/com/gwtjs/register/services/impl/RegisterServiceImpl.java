package com.gwtjs.register.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.register.dao.IRegisterDAO;
import com.gwtjs.register.entity.RegisterVO;
import com.gwtjs.register.services.IRegisterService;

/**
 * 数据字典
 * 
 * @author aGuang
 *
 */
@Named("registerService")
public class RegisterServiceImpl implements IRegisterService {

	@Inject
	private IRegisterDAO registerDAO;

	@Override
	public int deleteByPrimaryKey(Long regId) {
		return registerDAO.deleteByPrimaryKey(regId);
	}

	@Override
	public int insert(RegisterVO record) {
		return registerDAO.insert(record);
	}

	@Override
	public int insertSelective(RegisterVO record) {
		return registerDAO.insertSelective(record);
	}

	@Override
	public RegisterVO selectByPrimaryKey(Long regId) {
		// TODO Auto-generated method stub
		return registerDAO.selectByPrimaryKey(regId);
	}

	@Override
	public int updateByPrimaryKeySelective(RegisterVO record) {
		return registerDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(RegisterVO record) {
		return registerDAO.updateByPrimaryKey(record);
	}

	@Override
	public List<RegisterVO> selectList(RegisterVO record,PagerVO page) {
		return registerDAO.selectList(record, page);
	}

	@Override
	public int selectListCount(RegisterVO record) {
		return registerDAO.selectListCount(record);
	}

	@Override
	public int batchRemovePks(List<RegisterVO> records) {
		return registerDAO.batchRemovePks(records);
	}

	@Override
	public int batchUpdate(List<RegisterVO> records) {
		return registerDAO.batchUpdate(records);
	}

	@Override
	public int batchInsert(List<RegisterVO> records) {
		return registerDAO.batchInsert(records);
	}

}
