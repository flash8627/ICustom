package com.gwtjs.security.service;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.gwtjs.core.test.SpringTestBase;
import com.gwtjs.security.entity.SysAuthoritiesResourcesVO;
import com.gwtjs.security.services.IAuthorityResourcesService;

public class AuthorityResourcesServiceTest extends SpringTestBase {
	
	@Inject
	private IAuthorityResourcesService authorityResourcesService;
	
	@Test
	public void testGetAuthResources()
	{
		long authId = new Long("32");
		List<SysAuthoritiesResourcesVO> list = authorityResourcesService.findAuthoritiesResources(authId);
		for (SysAuthoritiesResourcesVO ar : list) {
			System.out.println("\n"+ar.getId()+" : "+ar.getAuthId()+" : "+ar.getResourceId());
		}
	}
	
}
