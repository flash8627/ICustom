package com.gwtjs.international.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.common.entity.ResultWrapper;
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

	/**
	 * 分页的lookup 条目
	 */
	@Override
	public PagedResult<LanguageVO> findListRecords(LanguageVO record,
			PagerVO page) {
		PagedResult<LanguageVO> paged = new PagedResult<LanguageVO>();
		PagerVO pageVO = new PagerVO();
		pageVO.setTotalRows(internationalDao.selectListCount(record, page));
		if (pageVO.getTotalRows() > 0) {
			paged.setPageVO(pageVO);
			paged.setResult(internationalDao.selectList(record, page));
		}
		return paged;
	}

	@Override
	public ResultWrapper findItem(Long lanId) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(internationalDao.findItem(lanId));
	}

	@Override
	public LanguageVO i18n(LanguageVO record) {
		// TODO Auto-generated method stub
		return internationalDao.i18n(record);
	}

	@Override
	public PagedResult<LanguageVO> findLanguageList(LanguageVO record, PagerVO page) {
		PagedResult<LanguageVO> paged = new PagedResult<LanguageVO>();
		PagerVO pageVO = new PagerVO();
		pageVO.setTotalRows(internationalDao.selectListCount(record, page));
		if (pageVO.getTotalRows() > 0) {
			paged.setPageVO(pageVO);
			paged.setResult(internationalDao.selectList(record, page));
		}
		return paged;
	}

	@Override
	public ResultWrapper findLanguageListCount(LanguageVO record) {
		return ResultWrapper.successResult(internationalDao
				.selectListCount(record));
	}

	@Override
	public ResultWrapper batchRemovePks(List<LanguageVO> records) {
		return ResultWrapper.successResult(internationalDao
				.batchRemovePks(records));
	}

	@Override
	public ResultWrapper batchUpdate(List<LanguageVO> records) {
		records = setRecordsUser(records);
		internationalDao.batchUpdate(records);
		return generResult(records);
	}
	
	/**
	 * 构建返回的对象
	 * @param records
	 * @return
	 */
	private ResultWrapper generResult(List<LanguageVO> records)
	{
		List<LanguageVO> result = new ArrayList<>();
		for (LanguageVO lan : records) {
			System.out.println(lan);
			LanguageVO temp = internationalDao.findByItem(lan);
			if(temp!=null){
				result.add(temp);
			}
			
		}
		return ResultWrapper.successResult(result);
	}

	@Override
	public ResultWrapper batchInsert(List<LanguageVO> records) {
		records = setRecordsUser(records);
		/*int flag = */internationalDao.batchInsert(records);
		
		return generResult(records);
	}

	/**
	 * 设置当前操作用户
	 * 
	 * @param records
	 * @return
	 */
	private List<LanguageVO> setRecordsUser(List<LanguageVO> records) {
		List<LanguageVO> result = new ArrayList<LanguageVO>();
		long createdUser = new Long(1);

		for (LanguageVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}

}
