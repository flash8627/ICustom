package com.gwtjs.international.services;

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
import com.gwtjs.international.entity.LanguageVO;

/**
 * 国际化
 * @author aGuang
 *
 */
@Path("/internationalService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IInternationalService {
	
	@GET
	@Path("findListRecords/{pageSize}/{curPage}")
	public PagedResult<LanguageVO> findListRecords(@QueryParam("")LanguageVO record, @PathParam("")PagerVO page);
	
	@GET @Path("findItem/regId")
	LanguageVO findItem(@PathParam("")Long regId);
	
	@GET @Path("findLanguageList/{pageSize}/{curPage}")
	List<LanguageVO> findLanguageList(@QueryParam("")LanguageVO record,@PathParam("")PagerVO page);
	
	@GET @Path("findLanguageListCount")
	int findLanguageListCount(LanguageVO record);
	
	@DELETE @Path("batchRemovePks")
	int batchRemovePks(List<LanguageVO> records);
	
	@POST @Path("batchUpdate")
	int batchUpdate(List<LanguageVO> records);
	
	@POST @Path("batchInsert")
	int batchInsert(List<LanguageVO> records);
	
}
