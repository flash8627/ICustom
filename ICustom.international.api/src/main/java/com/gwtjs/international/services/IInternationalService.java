package com.gwtjs.international.services;

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

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PagerVO;
import com.gwtjs.core.entity.ResultWrapper;
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
	@Path("findRecords/{pageSize}/{curPage}")
	public PagedResult<LanguageVO> findListRecords(@QueryParam("")LanguageVO record, @PathParam("")PagerVO page);
	
	@GET @Path("findItem/{lanId}")
	ResultWrapper findItem(@PathParam("lanId")Long lanId);
	
	@GET @Path("i18n/{lanCode}/{lanType}")
	LanguageVO i18n(@PathParam("")LanguageVO record);
	
	@GET @Path("findLanguageList/{pageSize}/{curPage}")
	PagedResult<LanguageVO> findLanguageList(@QueryParam("")LanguageVO record,@PathParam("")PagerVO page);
	
	/*@DELETE*/@PUT @Path("batchRemovePks")
	ResultWrapper batchRemovePks(List<LanguageVO> records);
	
	@PUT @Path("batchUpdate")
	ResultWrapper batchUpdate(List<LanguageVO> records);
	
	@POST @Path("batchInsert")
	ResultWrapper batchInsert(List<LanguageVO> records);
	
}
