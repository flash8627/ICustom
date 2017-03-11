package com.gwtjs.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.security.dao.ISysUserDao;
import com.gwtjs.security.entity.SysUsersVO;
import com.gwtjs.security.services.IUserServices;

@Named("userServices")
public class UserServices implements IUserServices {

	@Inject
	private ISysUserDao userDao;

	/*@Override
	public PagedResult<SysUsersVO> findUserPage(SysUsersVO record, PagerVO page) {
		return userDao.findUserPage(record, page);
	}*/

	@Override
	public List<String> loadUserAuthorities(SysUsersVO record) {
		return userDao.loadUserAuthorities(record);
	}

	@Override
	public SysUsersVO findByUserAccount(SysUsersVO record) {
		// TODO Auto-generated method stub
		return userDao.findByUserAccount(record);
	}

	/**
	 * 分页的user 条目
	 */
	/*@Override
	public PagedResult<SysUsersVO> findListRecords(SysUsersVO record,
			PagerVO page) {
		return userDao.findUserByPage(record, page);
	}*/

	@Override
	public ResultWrapper findItem(long roleId) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(userDao.findItem(roleId));
	}

	@Override
	public PagedResult<SysUsersVO> findUserList(SysUsersVO record, PagerVO page) {
		return userDao.findUserByPage(record, page);
	}

	/*@Override
	public ResultWrapper findUserListCount(SysUsersVO record) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(userDao
				.selectListCount(record, null));
	}*/

	@Override
	public ResultWrapper batchRemovePks(List<SysUsersVO> records) {
		// TODO Auto-generated method stub
		userDao.batchRemovePks(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchUpdate(List<SysUsersVO> records) {
		records = setRecordsUser(records);
		userDao.batchUpdate(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchInsert(List<SysUsersVO> records) {
		records = setRecordsUser(records);
		userDao.batchInsert(records);
		return genericResult(records);
	}

	@Override
	public ResultWrapper updateUserPwd(SysUsersVO record) {
		userDao.updateUserPwd(record);
		return ResultWrapper.successResult(record);
	}

	@Override
	public ResultWrapper login(SysUsersVO record) {
		userDao.updateUserPwd(record);
		SysUsersVO user = userDao.findByUserAccount(record);
		if (user == null) {
			return ResultWrapper.faultResult("用户　不存在!", record);
		} else if (!user.getPassword().equals(record.getPassword())) {
			return ResultWrapper.faultResult("密码错误!", record);
		} else if (user.getUserEnabled() == 1) {
			return ResultWrapper.faultResult("用户已经被禁用,请联系管理员!", record);
		}
		return ResultWrapper.successResult(record);
	}

	private ResultWrapper genericResult(List<SysUsersVO> list) {
		List<SysUsersVO> records = new ArrayList<SysUsersVO>();
		for (SysUsersVO user : list) {
			records.add(userDao.findByItem(user));
		}
		return ResultWrapper.successResult(records);
	}

	/**
	 * 设置当前操作用户
	 * 
	 * @param records
	 * @return
	 */
	private List<SysUsersVO> setRecordsUser(List<SysUsersVO> records) {
		List<SysUsersVO> result = new ArrayList<SysUsersVO>();
		long createdUser = new Long(1);

		for (SysUsersVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}

}
