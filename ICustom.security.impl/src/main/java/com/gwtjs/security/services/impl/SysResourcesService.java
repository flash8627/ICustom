package com.gwtjs.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.security.dao.ISysResourcesDAO;
import com.gwtjs.security.entity.SysResourcesVO;
import com.gwtjs.security.services.ISysResourcesService;

@Named("resourcesService")
public class SysResourcesService implements ISysResourcesService {
	
	@Inject
	private ISysResourcesDAO resourcesDao;
	
	private static final Logger log = LoggerFactory.getLogger(SysResourcesService.class);
	
	/**
	 */
	@Override
	public List<SysResourcesVO> findSysResourcesTree() {
		SysResourcesVO record = resourcesDao.findSysResourcesTreeRoot();
		List<SysResourcesVO> list = new ArrayList<SysResourcesVO>();

		if(record!=null && record.isLeaf()){
			List<SysResourcesVO> children = this.findResourcesChildren(record.getResourceId());
			record.setChildren(children);
		}
		list.add(record);
		log.debug("", list);
		return list;
	}
	/**
	 * 管理界面第一个请求
	 */
	@Override
	public List<SysResourcesVO> findSysResourcesTree(long parentId) {
		
		List<SysResourcesVO> list = this.findResourcesChildren(parentId);
		for (SysResourcesVO record : list) {
			if (record.isLeaf()) {
				List<SysResourcesVO> children = this
						.findResourcesChildren(record.getResourceId());
				record.setChildren(children);
			}
		}
		return list;
	}
	
	/**
	 * 站点菜单
	 */
	@Override
	public List<SysResourcesVO> findSiteMenu() {
		SysResourcesVO res = resourcesDao.findSysResourcesTreeRoot();
		List<SysResourcesVO> menus = this.findSysResourcesTree(res.getResourceId());
		for (SysResourcesVO menu : menus) {
			List<SysResourcesVO> child = this
					.findSysResourcesTree(menu.getResourceId());
			if(child.size()>0){
				menu.setChildren(child);
			}
		}
		return menus;
	}
	
	/**
	 * 重载封装
	 * 
	 * @param parentId
	 * @return
	 */
	private List<SysResourcesVO> findResourcesChildren(long parentId) {
		SysResourcesVO record = new SysResourcesVO();
		record.setParentId(parentId);
		return resourcesDao.findResourcesList(record);
	}
	
	@Override
	public SysResourcesVO findSysResourcesTreeRoot() {
		return resourcesDao.findSysResourcesTreeRoot();
	}

	@Override
	public ResultWrapper batchInsert(List<SysResourcesVO> list) {
		resourcesDao.batchInsert(list);
		setActionUser(list);
		return ResultWrapper.successResult(list);
	}

	@Override
	public ResultWrapper batchUpdate(List<SysResourcesVO> list) {
		resourcesDao.batchUpdate(list);
		setActionUser(list);
		return ResultWrapper.successResult(list);
	}

	@Override
	public ResultWrapper batchRemove(List<SysResourcesVO> list) {
		 resourcesDao.batchRemove(list);
		return ResultWrapper.successResult(list);
	}

	@Override
	public ResultWrapper deleteByPrimaryKey(long resourceId) {
		resourcesDao.deleteByPrimaryKey(resourceId);
		return ResultWrapper.successResult();
	}

	@Override
	public Integer selectByItemId() {
		return resourcesDao.selectByItemId();
	}

	@Override
	public SysResourcesVO selectByPrimaryKey(long resourceId) {
		return resourcesDao.selectByPrimaryKey(resourceId);
	}
	
	private List<SysResourcesVO> setActionUser(List<SysResourcesVO> list){
		List<SysResourcesVO> result = new ArrayList<SysResourcesVO>();
		long createdUser = new Long(10001);
		for (SysResourcesVO res : list) {
			res.setCreatedUser(createdUser);
			res.setUpdateLastUser(createdUser);
			result.add(res);
		}
		return result;
	}

}
