package com.gwtjs.register.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.common.entity.ResultWrapper;
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
	
	/**
	 * 分页的lookup 条目
	 */
	@Override
	public PagedResult<RegisterVO> findRecords(RegisterVO record, PagerVO page) {
		PagedResult<RegisterVO> paged = new PagedResult<RegisterVO>();
		PagerVO pageVO = new PagerVO();
		pageVO.setTotalRows(registerDAO.selectListCount(record,page));
		if(pageVO.getTotalRows()>0){
			paged.setPageVO(pageVO);
			paged.setResult(registerDAO.selectList(record, page));
		}
		return paged;
	}
	
	@Override
	public ResultWrapper findItem(Integer regId) {
		return ResultWrapper.successResult(registerDAO.findItem(regId));
	}

	@Override
	public PagedResult<RegisterVO> findRegisterList(RegisterVO record, PagerVO page) {
		return findRecords(record, page);
	}

	@Override
	public ResultWrapper batchRemovePks(List<RegisterVO> records) {
		return ResultWrapper.successResult(registerDAO.batchRemovePks(records));
	}

	@Override
	public ResultWrapper batchUpdate(List<RegisterVO> records) {
		records = setRecordsUser(records);
		return ResultWrapper.successResult(registerDAO.batchUpdate(records));
	}

	@Override
	public ResultWrapper batchInsert(List<RegisterVO> records) {
		records = setRecordsUser(records);
		return ResultWrapper.successResult(registerDAO.batchInsert(records));
	}
	
	/**
	 * 设置当前操作用户 
	 * @param records
	 * @return
	 */
	private List<RegisterVO> setRecordsUser(List<RegisterVO> records){
		List<RegisterVO> result = new ArrayList<RegisterVO>();
		long createdUser = new Long(1);
		
		for (RegisterVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}

}
