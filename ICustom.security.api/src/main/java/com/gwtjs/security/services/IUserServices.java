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
import com.gwtjs.security.entity.SysUsersVO;

/**
 * 系统用户
 * @author aGuang
 *
 */
@Path("/userServices")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IUserServices {
	
	@GET
	@Path("findListRecords/{pageSize}/{curPage}")
	public PagedResult<SysUsersVO> findListRecords(@QueryParam("")SysUsersVO record, @PathParam("")PagerVO page);
	
	@GET @Path("findItem/{userId}")
	ResultWrapper findItem(@PathParam("userId")long userId);
	
	@GET @Path("findUserList/{pageSize}/{curPage}")
	PagedResult<SysUsersVO> findUserList(@QueryParam("")SysUsersVO record,@PathParam("")PagerVO page);

	@GET @Path("findUserListCount")
	ResultWrapper findUserListCount(@PathParam("")SysUsersVO record);

	@PUT @Path("batchRemovePks")
	ResultWrapper batchRemovePks(List<SysUsersVO> records);

	@PUT @Path("batchUpdate")
	ResultWrapper batchUpdate(List<SysUsersVO> records);

	@POST @Path("batchInsert")
	ResultWrapper batchInsert(List<SysUsersVO> records);
	
	@POST @Path("updateUserPwd")
	public ResultWrapper updateUserPwd(SysUsersVO record);
	
	@POST @Path("login")
	public ResultWrapper login(SysUsersVO record) ;
	
	/**
	 *@author aGuang 2011-3-30 下午03:51:48
	 *@param account
	 *@param session
	 *@return  字符数组
	 */
	
	/**用户权限名称*/@GET @Path("loadUserAuthorities")
	List<String> loadUserAuthorities(SysUsersVO record);
	
	/**
	 * 根据用户账号返回SysUsers实例对象。
	 * 
	 * @author aGuang 2011-4-8 下午01:53:05
	 *@param userAccount
	 *            用户账号，比如admin等。
	 *@return SysUsers实例对象。
	 */@GET @Path("findByUserAccount")
	public SysUsersVO findByUserAccount(SysUsersVO record);
	
}
