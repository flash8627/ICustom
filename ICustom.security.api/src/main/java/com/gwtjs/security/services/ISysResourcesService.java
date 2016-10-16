package com.gwtjs.security.services;

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
import com.gwtjs.security.entity.SysResourcesTreeVO;
import com.gwtjs.security.entity.SysResourcesVO;

/**
 * 系统资源  系统导航
 * @author aGuang
 *
 */
@Path("/resourcesService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ISysResourcesService {
	
	@GET @Path("findResourcesSiteMenu")
	List<SysResourcesVO> findResourcesSiteMenu();
	
	@GET @Path("findResourcesTree")
	List<SysResourcesTreeVO> findResourcesTree();
	
	@GET @Path("findResourcesTree/{parentId}")
	List<SysResourcesTreeVO> findResourcesTree(@PathParam("parentId")long parentId);
	
	@GET @Path("findResourcesGridTree")
	List<SysResourcesVO> findResourcesGridTree();
	
	@GET @Path("findResourcesGridTree/{parentId}")
	List<SysResourcesVO> findResourcesGridTree(@PathParam("parentId")long parentId);
	
	@GET @Path("findResourcesList")
	List<SysResourcesVO> findResourcesList();
	
	@GET @Path("findResourcesList/{resourceId}")
	List<SysResourcesVO> findResourcesList(SysResourcesVO record);
	
	@GET @Path("findResources/{resourceId}")
    SysResourcesVO selectByPrimaryKey(@PathParam("resourceId")long resourceId);
	
	@GET @Path("findResourcesPrimaryId")
	Integer selectByItemId();
	
	@POST @Path("batchInsert")
	ResultWrapper batchInsert(List<SysResourcesVO> list);
	
	@POST @Path("insert")
	ResultWrapper insert(SysResourcesVO record);

	@DELETE @Path("batchRemove")
	ResultWrapper batchRemoveResourcesPks(List<SysResourcesVO> list);
	
	@DELETE @Path("deleteBy/{resourceId}")
	ResultWrapper deleteByPrimaryKey(@PathParam("resourceId")long resourceId);
	
	@POST @Path("updateByKey")
	ResultWrapper updateByPrimaryKey(SysResourcesVO record);

}
