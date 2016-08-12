package com.gwtjs.lookup.services;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtjs.lookup.entity.LookupItemVO;

/**
 * lookup 条目
 * @author aGuang
 *
 */
@Path("/lookupItemService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ILookupItemService {
	
	@PUT @Path("deleteByPrimaryKey")
	int deleteByPrimaryKey(BigDecimal regId);
	
	@POST @Path("insert")
    int insert(LookupItemVO record);
	
	@POST @Path("insertSelective")
    int insertSelective(LookupItemVO record);
	
	@GET @Path("selectByPrimaryKey")
    LookupItemVO selectByPrimaryKey(BigDecimal regId);
	
	@POST @Path("updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LookupItemVO record);
	
	@POST @Path("updateByPrimaryKey")
    int updateByPrimaryKey(LookupItemVO record);

	@GET @Path("selectList")
	List<LookupItemVO> selectList();

	@GET @Path("selectListCount")
	int selectListCount(LookupItemVO record);
	
	@DELETE @Path("batchRemovePks")
	int batchRemovePks(List<LookupItemVO> records);
	
	@POST @Path("batchUpdate")
	int batchUpdate(List<LookupItemVO> records);

	@POST @Path("batchInsert")
	int batchInsert(List<LookupItemVO> records);
    
}
