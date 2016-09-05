package com.gwtjs.lookup.services;

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
	
	@GET @Path("findItem/{itemId}")
	ResultWrapper findItem(@PathParam("itemId")Integer itemId);
	
	@GET @Path("findRecords/{pageSize}/{curPage}")
	PagedResult<LookupItemVO> findRecords(@QueryParam("")LookupItemVO record,@PathParam("")PagerVO page);
	
	@GET @Path("findLookupItems/{classId}")
	ResultWrapper findLookupItems(@PathParam("classId")Integer classId);

	@GET @Path("selectListCount")
	ResultWrapper selectListCount(LookupItemVO record);
	
	@PUT @Path("batchRemovePks")
	ResultWrapper batchRemovePks(List<LookupItemVO> records);
	
	@PUT @Path("batchUpdate")
	ResultWrapper batchUpdate(List<LookupItemVO> records);

	@POST @Path("batchInsert")
	ResultWrapper batchInsert(List<LookupItemVO> records);
    
}
