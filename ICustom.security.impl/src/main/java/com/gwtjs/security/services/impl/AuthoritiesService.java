package com.gwtjs.security.services.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.security.dao.IAuthoritiesDAO;
import com.gwtjs.security.services.IAuthoritiesService;

@Named("authoritiesService")
public class AuthoritiesService implements IAuthoritiesService {
	
	@Inject
	private IAuthoritiesDAO authoritiesDAO;
	
}
