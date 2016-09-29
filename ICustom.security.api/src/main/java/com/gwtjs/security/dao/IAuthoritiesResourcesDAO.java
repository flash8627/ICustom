package com.gwtjs.security.dao;

import java.util.List;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.security.entity.SysAuthoritiesVO;

public interface IAuthoritiesResourcesDAO extends BaseSqlMapper<SysAuthoritiesVO> {
	
	List<String> loadResource(String auth);
}
