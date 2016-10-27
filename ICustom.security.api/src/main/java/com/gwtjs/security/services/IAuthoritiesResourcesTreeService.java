package com.gwtjs.security.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtjs.security.entity.SysResourcesVO;

@Path("/authoritiesResourcesTreeService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IAuthoritiesResourcesTreeService {
	
	@GET
	@Path("/findAuthResourcesTree")
	List<SysResourcesVO> findAuthResourcesTreeRoot();
	
	@GET
	@Path("/findAuthResourcesTree/{parentId}")
	List<SysResourcesVO> findAuthResourcesTree(@PathParam("")SysResourcesVO record);
	
}
