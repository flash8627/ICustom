package com.gwtjs.security.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtjs.common.entity.ResultWrapper;
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
	
	@GET @Path("findSiteMenu")
	List<SysResourcesVO> findSiteMenu();
	
	@GET @Path("findResourcesTree")
	List<SysResourcesVO> findSysResourcesTree();
	
	@GET @Path("findResourcesTree/{parentId}")
	List<SysResourcesVO> findSysResourcesTree(@PathParam("parentId")long parentId);
	
	@GET
	@Path("/findResourcesTreeRoot")
	SysResourcesVO findSysResourcesTreeRoot();
	
	@GET
	@Path("/findByResource/{resourceId}")
	SysResourcesVO selectByPrimaryKey(@PathParam("")long resourceId);
	
	@POST
	@Path("/batchInsert")
	ResultWrapper batchInsert(List<SysResourcesVO> list);
	
	@PUT
	@Path("/batchUpdate")
	ResultWrapper batchUpdate(List<SysResourcesVO> list);

	@PUT
	@Path("/batchRemove")
	ResultWrapper batchRemove(List<SysResourcesVO> list);

	@DELETE
	@Path("/deleteByKey/{resourceId}")
	ResultWrapper deleteByPrimaryKey(@PathParam("resourceId")long resourceId);

	@GET
	@Path("/selectByItemId")
	Integer selectByItemId();

}
