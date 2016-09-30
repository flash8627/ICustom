package com.gwtjs.security.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.security.entity.SysRolesAuthoritiesVO;

/**
 * 系统角色的权限
 * @author aGuang
 *
 */
@Path("/roleAuthoritiesService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IRoleAuthoritiesService {
	
	@PUT
	@Path("/batchRemovePks")
	ResultWrapper batchRemovePks(List<SysRolesAuthoritiesVO> list);
	
	@POST
	@Path("/batchInsert")
	ResultWrapper batchInsert(List<SysRolesAuthoritiesVO> list);
	
	@GET
	@Path("/findByRoleAuthorities")
	SysRolesAuthoritiesVO findByRoleAuthorities(SysRolesAuthoritiesVO vo);
	
	@GET
	@Path("/findRoleAuthorities")
	List<SysRolesAuthoritiesVO> findRoleAuthorities(SysRolesAuthoritiesVO vo);
	
}
