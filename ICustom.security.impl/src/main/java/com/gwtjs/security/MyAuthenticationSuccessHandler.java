package com.gwtjs.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.gwtjs.security.entity.SysUsersVO;
import com.gwtjs.security.services.IUserServices;

@Component
public class MyAuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {
	
	@Autowired
	private IUserServices userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		// 认证成功后，获取用户信息并添加到session中
		UserDetails details = (UserDetails) authentication.getPrincipal();
		SysUsersVO record = new SysUsersVO();
		record.setUserAccount(details.getUsername());
		SysUsersVO user = userService.findByUserAccount(record);
		//在session中取用户信息
		request.getSession().setAttribute("user", user);
		
		super.onAuthenticationSuccess(request, response, authentication);
	
	}
	
}
