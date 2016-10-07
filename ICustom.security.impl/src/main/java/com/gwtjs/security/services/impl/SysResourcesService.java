package com.gwtjs.security.services.impl;

import java.util.ArrayList;
import java.util.Date;
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
	private ISysResourcesDAO resourcesDAO;

	private static final Logger log = LoggerFactory.getLogger(SysResourcesService.class);
	@Override
	public Integer selectByItemId() {
		// TODO Auto-generated method stub
		return resourcesDAO.selectByItemId();
	}

	/**
	 * 站点菜单
	 */
	@Override
	public List<SysResourcesVO> findResourcesSiteMenu() {
		SysResourcesVO nav = resourcesDAO.findResourcesTreeRoot();
		List<SysResourcesVO> menus = this.findMenus(nav.getResourceId());
		for (SysResourcesVO menu : menus) {
			List<SysResourcesVO> child = this
					.findMenus(menu.getResourceId());
			if(child.size()>0){
				menu.setChildren(child);
			}
		}
		return menus;
	}
	
	private List<SysResourcesVO> findMenus(long parentId) {
		List<SysResourcesVO> list = this.findSiteMenuChildren(parentId);
		for (SysResourcesVO record : list) {
			if (record.isLeaf()) {
				List<SysResourcesVO> children = this
						.findSiteMenuChildren(record.getResourceId());
				record.setChildren(children);
			}
		}
		return list;
	}
	
	/**
	 * 重载封装
	 * 
	 * @param parentId
	 * @return
	 */
	private List<SysResourcesVO> findSiteMenuChildren(long parentId) {
		SysResourcesVO record = new SysResourcesVO();
		record.setParentId(parentId);
		return resourcesDAO.findMenuList(record);
	}
	
	@Override
	public List<SysResourcesVO> findResourcesTree(long parentId) {
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
	
	@Override
	public List<SysResourcesVO> findResourcesTree() {
		SysResourcesVO record = resourcesDAO.findResourcesTreeRoot();
		List<SysResourcesVO> list = new ArrayList<SysResourcesVO>();

		if(record!=null && record.isLeaf()){
			List<SysResourcesVO> children = this.findResourcesChildren(record.getResourceId());
			record.setChildren(children);
		}
		list.add(record);
		log.debug("", list);
		return list;
	}

	@Override
	public List<SysResourcesVO> findResourcesList() {
		SysResourcesVO record = new SysResourcesVO();
		return this.findResourcesList(record);
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
		return resourcesDAO.findResourcesList(record);
	}

	@Override
	public List<SysResourcesVO> findResourcesList(SysResourcesVO record) {
		return resourcesDAO.findResourcesList(record);
	}

	@Override
	public SysResourcesVO selectByPrimaryKey(long resourceId) {
		return resourcesDAO.selectByPrimaryKey(resourceId);
	}

	@Override
	public ResultWrapper batchInsert(List<SysResourcesVO> list) {
		int msg = resourcesDAO.batchInsert(list);
		return ResultWrapper.successResult(msg, list);
	}

	@Override
	public ResultWrapper batchRemoveResourcesPks(List<SysResourcesVO> list) {
		int msg = resourcesDAO.batchRemoveResourcesPks(list);
		return ResultWrapper.successResult(msg, list);
	}

	@Override
	public ResultWrapper deleteByPrimaryKey(long resourceId) {
		int msg = resourcesDAO.deleteByPrimaryKey(resourceId);
		return ResultWrapper.successResult(msg);
	}

	@Override
	public ResultWrapper insert(SysResourcesVO record) {
		//Integer resourceId = resourcesDAO.selectByItemId();
		//record.setItemId(resourceId);
		record.setCreatedUser(new Long("10001"));
		record.setCreatedDate(new Date());
		int msg = resourcesDAO.insert(record);
		return ResultWrapper.successResult(msg, record);
	}

	@Override
	public ResultWrapper updateByPrimaryKey(SysResourcesVO record) {
		int msg = resourcesDAO.updateByPrimaryKey(record);
		return ResultWrapper.successResult(msg, record);
	}
	
}
