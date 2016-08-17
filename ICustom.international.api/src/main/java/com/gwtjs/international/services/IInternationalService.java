package com.gwtjs.international.services;

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
	
	@PUT @Path("deleteByPrimaryKey")
	int deleteByPrimaryKey(Long regId);
	
	@POST @Path("insert")
    int insert(LanguageVO record);
	
	@POST @Path("insertSelective")
    int insertSelective(LanguageVO record);
	
	@GET @Path("selectByPrimaryKey")
    LanguageVO selectByPrimaryKey(Long regId);
	
	@POST @Path("updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LanguageVO record);
	
	@POST @Path("updateByPrimaryKey")
    int updateByPrimaryKey(LanguageVO record);
	
	@GET @Path("findLanguageList")
	List<LanguageVO> findLanguageList(@PathParam("")LanguageVO record,@PathParam("")PagerVO page);
	
	@GET @Path("findLanguageListCount")
	int findLanguageListCount(LanguageVO record);
	
	@DELETE @Path("batchRemovePks")
	int batchRemovePks(List<LanguageVO> records);
	
	@POST @Path("batchUpdate")
	int batchUpdate(List<LanguageVO> records);
	
	@POST @Path("batchInsert")
	int batchInsert(List<LanguageVO> records);
	
}
