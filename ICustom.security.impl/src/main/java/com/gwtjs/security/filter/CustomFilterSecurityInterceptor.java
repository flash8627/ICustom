package com.gwtjs.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * 该过滤器的主要作用就是通过spring著名的IoC生成securityMetadataSource。
 * securityMetadataSource相当于本包中自定义的MyInvocationSecurityMetadataSourceService。
 * 该MyInvocationSecurityMetadataSourceService的作用提从数据库提取权限和资源，装配到HashMap中，
 * 供Spring Security使用，用于权限校验。
 * @author aGuang
 */
public class CustomFilterSecurityInterceptor extends
		AbstractSecurityInterceptor implements Filter {

	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	public void destroy()	{
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("entered SSFilterInterceptor");

		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		System.out.println("username: " + ((UserDetails)principal).getUsername());
		System.out.println("password: " + ((UserDetails)principal).getPassword());
		

		FilterInvocation filterInvocation = new FilterInvocation(request, response, chain);

		InterceptorStatusToken statusToken = super.beforeInvocation(filterInvocation);

		filterInvocation.getChain().doFilter(filterInvocation.getHttpRequest(),
				filterInvocation.getResponse());

		this.afterInvocation(statusToken, null);
		System.out.println("left SSFilterInterceptor");
	}

	public void init(FilterConfig filter) throws ServletException {
	}

	@Override
	public Class<? extends Object> getSecureObjectClass()	{
		System.out.println("getSecureObjectClass invoked");
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource(){
		System.out.println("obtainSecurityMetadataSource invoked");
		return this.securityMetadataSource;
	}
	
	public void invoke(FilterInvocation fi) throws IOException,ServletException{
		
	}
	

	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource(){
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource)	{
		this.securityMetadataSource = securityMetadataSource;
	}

}
