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
import com.gwtjs.lookup.entity.LookupVO;


/**
 * lookup分类
 * @author aGuang
 *
 */
@Path("/lookupClassifyService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ILookupClassifyService {
	
	@GET
	@Path("findListRecords/{pageSize}/{curPage}")
	public PagedResult<LookupVO> findListRecords(@QueryParam("")LookupVO record, @PathParam("")PagerVO page);
	
	@GET @Path("findItem/{classId}")
	ResultWrapper findItem(@PathParam("classId")Integer classId);
	
	@GET @Path("findLookupList/{pageSize}/{curPage}")
	PagedResult<LookupVO> findLookupList(@QueryParam("")LookupVO record,@PathParam("")PagerVO page);

	@GET @Path("findLookupListCount")
	ResultWrapper findLookupListCount(@PathParam("")LookupVO record);

	@PUT @Path("batchRemovePks")
	ResultWrapper batchRemovePks(List<LookupVO> records);

	@PUT @Path("batchUpdate")
	ResultWrapper batchUpdate(List<LookupVO> records);

	@POST @Path("batchInsert")
	ResultWrapper batchInsert(List<LookupVO> records);
    
}
