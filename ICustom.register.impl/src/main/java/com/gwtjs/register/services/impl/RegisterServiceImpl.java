package com.gwtjs.register.services.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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
	public int deleteByPrimaryKey(BigDecimal regId) {
		return registerDAO.deleteByPrimaryKey(regId);
	}

	@Override
	public int insert(RegisterVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(RegisterVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RegisterVO selectByPrimaryKey(BigDecimal regId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(RegisterVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(RegisterVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RegisterVO> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectListCount(RegisterVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int batchRemovePks(List<RegisterVO> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int batchUpdate(List<RegisterVO> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int batchInsert(List<RegisterVO> records) {
		// TODO Auto-generated method stub
		return 0;
	}

}
