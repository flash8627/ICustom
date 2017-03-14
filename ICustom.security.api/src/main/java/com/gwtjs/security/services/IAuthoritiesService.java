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

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PagerVO;
import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.security.entity.SysAuthoritiesVO;

@Path("/authoritiesService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IAuthoritiesService {
	
	@GET
	@Path("/findAuthoritiesList/{pageSize}/{curPage}")
	public PagedResult<SysAuthoritiesVO> findAuthoritiesList(@QueryParam("") SysAuthoritiesVO record, @PathParam("")PagerVO page);
	
	@GET
	@Path("/findItem/{authId}")
	ResultWrapper findItem(@PathParam("authId")Integer authId);
	
	@GET
	@Path("/findAuthoritiesTree/{parentId}")
	List<SysAuthoritiesVO> findAuthoritiesTree(@PathParam("")SysAuthoritiesVO record);

	@PUT
	@Path("batchRemovePks")
	ResultWrapper batchRemovePks(List<SysAuthoritiesVO> records);

	@PUT
	@Path("batchUpdate")
	ResultWrapper batchUpdate(List<SysAuthoritiesVO> records);

	@POST
	@Path("batchInsert")
	ResultWrapper batchInsert(List<SysAuthoritiesVO> records);
	
}
