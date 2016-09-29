package com.gwtjs.security.services.impl;

import javax.inject.Named;

import com.gwtjs.security.dao.IAuthoritiesResourcesDAO;
import com.gwtjs.security.services.IAuthoritiesResourcesService;

@Named("authoritiesResourcesService")
public class AuthoritiesResourcesService implements IAuthoritiesResourcesService {
	
	private IAuthoritiesResourcesDAO authoritiesResourcesDao;
	
}
