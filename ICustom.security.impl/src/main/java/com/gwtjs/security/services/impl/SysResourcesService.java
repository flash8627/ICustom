package com.gwtjs.security.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.security.dao.ISysResourcesDAO;
import com.gwtjs.security.entity.SysResourcesVO;
import com.gwtjs.security.services.ISysResourcesService;

@Named("resourcesService")
public class SysResourcesService implements ISysResourcesService {
	
	@Inject
	private ISysResourcesDAO resourcesDao;
	/**
	 * 站点菜单
	 */
	@Override
	public List<SysResourcesVO> findSiteMenu() {
		SysResourcesVO nav = resourcesDao.findSysResourcesTreeRoot();
		List<SysResourcesVO> menus = this.findSysResourcesTree(nav.getResourceId());
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
	
	@Override
	public SysResourcesVO findSysResourcesTreeRoot() {
		return resourcesDao.findSysResourcesTreeRoot();
	}

	@Override
	public int batchInsert(List<SysResourcesVO> list) {
		return resourcesDao.batchInsert(list);
	}

	@Override
	public int batchRemoveSysResourcesPks(List<SysResourcesVO> list) {
		return resourcesDao.batchRemoveSysResourcesPks(list);
	}

	@Override
	public int deleteByPrimaryKey(long resourceId) {
		return resourcesDao.deleteByPrimaryKey(resourceId);
	}

	@Override
	public Integer selectByItemId() {
		return resourcesDao.selectByItemId();
	}

	@Override
	public SysResourcesVO selectByPrimaryKey(long resourceId) {
		return resourcesDao.selectByPrimaryKey(resourceId);
	}

}
