package com.gwtjs.security.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.security.entity.SysAuthoritiesResourcesVO;

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
