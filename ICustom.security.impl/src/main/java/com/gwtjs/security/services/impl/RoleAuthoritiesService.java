package com.gwtjs.security.services.impl;

import javax.inject.Named;

import com.gwtjs.security.dao.IRoleAuthoritiesDao;
import com.gwtjs.security.services.IRoleAuthoritiesService;

@Named("roleAuthoritiesService")
public class RoleAuthoritiesService implements IRoleAuthoritiesService {
	
	private IRoleAuthoritiesDao roleAuthoritiesDao;
	
}
