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

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.security.entity.SysUsersRolesVO;

/**
 * 系统用户的角色
 * @author aGuang
 *
 */
@Path("/userRolesService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IUserRolesService {
	
	@GET
	@Path("getUserRoles/{userId}/0")
	List<SysUsersRolesVO> getUserRoles(@PathParam("userId")long userId);
	
	@POST @Path("saveOrUpdate")
	ResultWrapper saveOrUpdate(List<SysUsersRolesVO> models);
	
	@PUT @Path("delete")
	ResultWrapper delete(List<SysUsersRolesVO> models);
	
}
