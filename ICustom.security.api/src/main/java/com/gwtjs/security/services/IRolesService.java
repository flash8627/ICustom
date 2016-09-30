package com.gwtjs.security.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.security.entity.SysRolesVO;


@Path("/rolesService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IRolesService {
	
	@GET @Path("findItem/{roleId}")
	ResultWrapper findItem(@PathParam("roleId")long roleId);
	
	@GET @Path("findRolesList/{pageSize}/{curPage}")
	PagedResult<SysRolesVO> findRolesList(@QueryParam("")SysRolesVO record,@PathParam("")PagerVO page);

	@GET @Path("findRolesListCount")
	ResultWrapper findRolesListCount(@PathParam("")SysRolesVO record);

	@PUT @Path("batchRemovePks")
	ResultWrapper batchRemovePks(List<SysRolesVO> records);

	@PUT @Path("batchUpdate")
	ResultWrapper batchUpdate(List<SysRolesVO> records);

	@POST @Path("batchInsert")
	ResultWrapper batchInsert(List<SysRolesVO> records);
	
}
