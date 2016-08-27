package com.gwtjs.lookup.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
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
	
	@GET @Path("findItem/{recordId}")
	LookupItemVO findItem(@PathParam("")LookupItemVO record);
	
	@GET @Path("findListRecords/{pageSize}/{curPage}")
	PagedResult<LookupItemVO> findListRecords(@QueryParam("")LookupItemVO record,@PathParam("")PagerVO page);
	
	@GET @Path("findLookupItemList/{pageSize}/{curPage}")
	List<LookupItemVO> selectList(@QueryParam("")LookupItemVO record,@PathParam("")PagerVO page);

	@GET @Path("selectListCount")
	int selectListCount(LookupItemVO record);
	
	@DELETE @Path("batchRemovePks")
	int batchRemovePks(List<LookupItemVO> records);
	
	@POST @Path("batchUpdate")
	int batchUpdate(List<LookupItemVO> records);

	@POST @Path("batchInsert")
	int batchInsert(List<LookupItemVO> records);
    
}
