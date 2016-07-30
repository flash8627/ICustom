package com.gwtjs.core.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.core.entity.NavigationVO;
import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.core.dao.NavigationDAO;
import com.gwtjs.core.services.NavigationService;

@Named("navigationService")
public class NavigationServiceImpl implements NavigationService {
	
	private static final Logger log = LoggerFactory
		      .getLogger(NavigationServiceImpl.class);
	
	/**
	 * 站点菜单
	 */
	@Override
	public List<NavigationVO> findNavigationSiteMenu() {
		NavigationVO nav = navigationDAO.findNavigationTreeRoot();
		List<NavigationVO> menus = this.findNavigationTree(nav.getItemId());
		for (NavigationVO menu : menus) {
			List<NavigationVO>child = this.findNavigationTree(menu.getItemId());
			if(child.size()>0){
				menu.setChildren(child);
			}
		}
		return menus;
	}
	
	@Inject
	private NavigationDAO navigationDAO;
	
	@Override
	public List<NavigationVO> findNavigationTree(Integer parentId) {
		List<NavigationVO> list = this.findNavigationChildren(parentId);
		for (NavigationVO record : list) {
			if(record.isLeaf()){
				List<NavigationVO> children = this.findNavigationChildren(record.getItemId());
				record.setChildren(children);
			}
		}
		return list;
	}
	
	@Override
	public List<NavigationVO> findNavigationTree() {
		NavigationVO record = navigationDAO.findNavigationTreeRoot();
		List<NavigationVO> list = new ArrayList<NavigationVO>();
		
		if(record!=null && record.isLeaf()){
			List<NavigationVO> children = this.findNavigationChildren(record.getItemId());
			record.setChildren(children);
		}
		list.add(record);
		log.debug("", list);
		return list;
	}
	
	@Override
	public List<NavigationVO> findNavigationList() {
		NavigationVO record = new NavigationVO();
		return this.findNavigationList(record);
	}
	
	/**
	 * 重载封装
	 * @param parentId
	 * @return
	 */
	private List<NavigationVO> findNavigationChildren(Integer parentId) {
		NavigationVO record = new NavigationVO();
		record.setParentId(parentId);
		return navigationDAO.findNavigationList(record);
	}

	@Override
	public List<NavigationVO> findNavigationList(NavigationVO record) {
		return navigationDAO.findNavigationList(record);
	}
	
	@Override
	public NavigationVO selectByPrimaryKey(Integer itemId) {
		return navigationDAO.selectByPrimaryKey(itemId);
	}

	@Override
	public ResultWrapper batchInsert(List<NavigationVO> list) {
		int msg = navigationDAO.batchInsert(list);
		return ResultWrapper.successResult(msg,list);
	}

	@Override
	public ResultWrapper batchRemoveNavigationPks(List<NavigationVO> list) {
		int msg = navigationDAO.batchRemoveNavigationPks(list);
		return ResultWrapper.successResult(msg, list);
	}

	@Override
	public ResultWrapper deleteByPrimaryKey(Integer itemId) {
		int msg = navigationDAO.deleteByPrimaryKey(itemId);
		return ResultWrapper.successResult(msg);
	}

	@Override
	public ResultWrapper insert(NavigationVO record) {
		Integer itemId = navigationDAO.selectByItemId();
		record.setItemId(itemId);
		record.setCreatedUser(new Long("10001"));
		record.setCreatedDate(new Date());
		int msg = navigationDAO.insert(record);
		return ResultWrapper.successResult(msg, record);
	}

	@Override
	public ResultWrapper insertSelective(NavigationVO record) {
		int msg = navigationDAO.insertSelective(record);
		return ResultWrapper.successResult(msg, record);
	}

	@Override
	public ResultWrapper updateByPrimaryKeySelective(NavigationVO record) {
		int msg = navigationDAO.updateByPrimaryKeySelective(record);
		return ResultWrapper.successResult(msg, record);
	}

	@Override
	public ResultWrapper updateByPrimaryKey(NavigationVO record) {
		int msg = navigationDAO.updateByPrimaryKey(record);
		return ResultWrapper.successResult(msg, record);
	}
	
	
    
}
