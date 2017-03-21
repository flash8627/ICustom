package com.gwtjs.security.custom.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.gwtjs.security.dao.IAuthoritiesDAO;
import com.gwtjs.security.dao.IAuthoritiesResourcesDAO;

/**
 * <h2>Custom Invocation Security Metadata Source Service</h2>
 * <p>
 * 资源源数据定义，将所有的资源和权限对应关系建立起来，即定义某一资源可以被哪些角色去访问
 * </p>
 * @author aGuang
 *
 */
@Named("customSecurityMetadataSourceService")
public class CustomSecurityMetadataSourceService implements
		FilterInvocationSecurityMetadataSource {

	@Inject
	private IAuthoritiesDAO authoritiesDAO;
	@Autowired
	private IAuthoritiesResourcesDAO authoritiesResourcesDao;

	//private UrlMatcher urlMatcher = new AntUrlPathMatcher();

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public CustomSecurityMetadataSourceService() {
		loadResourceDefine();
	}

	private void loadResourceDefine() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring.xml", "classpath*:config/spring-security-beans.xml",
				"classpath*:config/spring-security-config.xml",
				"classpath*:spring-*.xml");

		/*
		 * SessionFactory sessionFactory = (SessionFactory) context
		 * .getBean("sessionFactory"); Session session =
		 * sessionFactory.openSession();
		 */

		authoritiesDAO = (IAuthoritiesDAO) context.getBean("authoritiesDAO");
		authoritiesResourcesDao = (IAuthoritiesResourcesDAO) context
				.getBean("authoritiesResourcesDao");
		System.out
				.println("---get all system authorites-------------------------"
						+ authoritiesDAO);
		System.out
				.println("---get all system authorites resources-------------"
						+ authoritiesResourcesDao);

		// 在Web服务器启动时，提取系统中的所有权限。
		// String sql = "select authority_name from sys_authorities";

		List<String> as = authoritiesDAO.getSysAuthorities();

		/*
		 * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
		 * aGuang
		 */
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		for (String auth : as) {
			ConfigAttribute ca = new SecurityConfig(auth);

			List<String> rs = authoritiesResourcesDao.loadResource(auth);

			for (String url : rs) {
				/*
				 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。
				 * aGuang
				 */
				if (resourceMap.containsKey(url)) {

					Collection<ConfigAttribute> value = resourceMap.get(url);
					value.add(ca);
					resourceMap.put(url, value);
				} else {
					Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
					atts.add(ca);
					resourceMap.put(url, atts);
				}

			}

		}

	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {

		return null;
	}

	// 根据URL，找到相关的权限配置。
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		// object 是一个URL，被用户请求的url。
		/*String url = ((FilterInvocation) object).getRequestUrl();
		int firstQuestionMarkIndex = url.indexOf("?");
		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (urlMatcher.pathMatchesUrl(url, resURL)) {
				return resourceMap.get(resURL);
			}
		}
		return null;*/
		HttpServletRequest request = ((FilterInvocation)object).getHttpRequest();  
        
        RequestMatcher matcher = null;  
        String resUrl = null;  
        for (Iterator<String> iter = resourceMap.keySet().iterator(); iter.hasNext(); ) {  
            resUrl = iter.next();  
            matcher = new AntPathRequestMatcher(resUrl);  
            if (null != resUrl && matcher.matches(request)) {  
                return resourceMap.get(resUrl);  
            }
        }  
          
        return null;
        
	}

	@Override
	public boolean supports(Class<?> arg0) {

		return true;
	}

	public void setAuthoritiesDAO(IAuthoritiesDAO authoritiesDAO) {
		this.authoritiesDAO = authoritiesDAO;
	}

	public void setAuthoritiesResourcesDao(
			IAuthoritiesResourcesDAO authoritiesResourcesDao) {
		this.authoritiesResourcesDao = authoritiesResourcesDao;
	}
	
	

}
