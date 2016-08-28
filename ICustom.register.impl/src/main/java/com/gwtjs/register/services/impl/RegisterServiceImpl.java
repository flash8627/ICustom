package com.gwtjs.register.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagedResult;
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
	
	/**
	 * 分页的lookup 条目
	 */
	@Override
	public PagedResult<RegisterVO> findListRecords(RegisterVO record, PagerVO page) {
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
	public RegisterVO findItem(Integer regId) {
		return registerDAO.findItem(regId);
	}

	@Override
	public PagedResult<RegisterVO> findRegisterList(RegisterVO record, PagerVO page) {
		return findListRecords(record, page);
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
