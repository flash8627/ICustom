package com.gwtjs.lookup.services;

import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
	@PUT @Path("deleteByPrimaryKey")
	int deleteByPrimaryKey(BigDecimal regId);
	
	@POST @Path("insert")
    int insert(LookupVO record);
	
	@POST @Path("insertSelective")
    int insertSelective(LookupVO record);
	
	@GET @Path("selectByPrimaryKey")
	LookupVO selectByPrimaryKey(BigDecimal regId);
	
	@POST @Path("updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LookupVO record);
	
	@POST @Path("updateByPrimaryKey")
    int updateByPrimaryKey(LookupVO record);
    
}
