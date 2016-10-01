package com.gwtjs.security.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.security.entity.SysAuthoritiesResourcesVO;

@Path("/authorityResourcesService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IAuthorityResourcesService {
	
	@GET
	@Path("/findAuthoritiesResources/{authId}")
	List<SysAuthoritiesResourcesVO> findAuthoritiesResources(@PathParam("authId") long authId);
	
	@PUT
	@Path("batchRemovePks")
	ResultWrapper batchRemovePks(List<SysAuthoritiesResourcesVO> list);
	
	@POST
	@Path("batchInsert")
	ResultWrapper batchInsert(List<SysAuthoritiesResourcesVO> list);
	
}
