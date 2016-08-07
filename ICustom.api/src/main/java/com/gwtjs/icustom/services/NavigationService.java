package com.gwtjs.icustom.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.icustom.entity.NavigationVO;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface NavigationService {
	
	@GET @Path("findNavigationSiteMenu")
	List<NavigationVO> findNavigationSiteMenu();
	
	@GET @Path("findNavigationTree")
	List<NavigationVO> findNavigationTree();
	
	@GET @Path("findNavigationTree/{parentId}")
	List<NavigationVO> findNavigationTree(@PathParam("parentId")Integer parentId);
	
	@GET @Path("findNavigationList")
	List<NavigationVO> findNavigationList();
	
	@GET @Path("findNavigationList/{itemId}")
	List<NavigationVO> findNavigationList(NavigationVO record);
	
	@GET @Path("findNavigation/{itemId}")
    NavigationVO selectByPrimaryKey(@PathParam("itemId")Integer itemId);
	
	@GET @Path("findNavItemId")
	Integer selectByItemId();
	
	@POST @Path("batchInsert")
	ResultWrapper batchInsert(List<NavigationVO> list);
	
	@POST @Path("insert")
	ResultWrapper insert(NavigationVO record);

	@POST @Path("insertSelective")  //多余的方法　
	ResultWrapper insertSelective(NavigationVO record);
	
	@DELETE @Path("batchRemove")
	ResultWrapper batchRemoveNavigationPks(List<NavigationVO> list);
	
	@DELETE @Path("deleteBy/{itemId}")
	ResultWrapper deleteByPrimaryKey(@PathParam("itemId")Integer itemId);
	
	@POST @Path("updateBySelective")  //多余的方法　
	ResultWrapper updateByPrimaryKeySelective(NavigationVO record);

	@POST @Path("updateByKey")
	ResultWrapper updateByPrimaryKey(NavigationVO record);
    
}
