package com.gwtjs.register.services;

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

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.register.entity.RegisterVO;

/**
 * 数据字典
 * 
 * @author aGuang
 *
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IRegisterService {

	@PUT
	@Path("deleteByPrimaryKey")
	int deleteByPrimaryKey(Long regId);

	@POST
	@Path("insert")
	int insert(RegisterVO record);

	@POST
	@Path("insertSelective")
	int insertSelective(RegisterVO record);

	@GET
	@Path("selectByPrimaryKey")
	RegisterVO selectByPrimaryKey(Long regId);

	@POST
	@Path("updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(RegisterVO record);

	@POST
	@Path("updateByPrimaryKey")
	int updateByPrimaryKey(RegisterVO record);

	@GET
	@Path("selectList")
	List<RegisterVO> selectList(@PathParam("")RegisterVO record,@PathParam("")PagerVO page);

	@DELETE
	@Path("batchRemovePks")
	int batchRemovePks(List<RegisterVO> records);

	@POST
	@Path("batchUpdate")
	int batchUpdate(List<RegisterVO> records);

	@POST
	@Path("batchInsert")
	int batchInsert(List<RegisterVO> records);

}
