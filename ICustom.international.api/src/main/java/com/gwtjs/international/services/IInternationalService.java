package com.gwtjs.international.services;

import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	int deleteByPrimaryKey(BigDecimal regId);
	
	@POST @Path("insert")
    int insert(LanguageVO record);
	
	@POST @Path("insertSelective")
    int insertSelective(LanguageVO record);
	
	@GET @Path("selectByPrimaryKey")
    LanguageVO selectByPrimaryKey(BigDecimal regId);
	
	@POST @Path("updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LanguageVO record);
	
	@POST @Path("updateByPrimaryKey")
    int updateByPrimaryKey(LanguageVO record);
    
}
