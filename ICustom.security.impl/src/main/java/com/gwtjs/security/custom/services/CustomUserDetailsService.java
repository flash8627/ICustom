package com.gwtjs.security.custom.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gwtjs.security.entity.SysUsersVO;
import com.gwtjs.security.services.IUserServices;

@Named("userDetailsManager")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserServices userServices;

	@Override
	public UserDetails loadUserByUsername(String account)
			throws UsernameNotFoundException, DataAccessException {

		SysUsersVO record = new SysUsersVO();
		record.setUserAccount(account);

		/*
		 * if (null == userDao) { userDao = new SysUsersDaoImpl(); }
		 */

		// 得到用户的权限
		Collection<GrantedAuthority> auths = this
				.loadUserAuthoritiesByName(record);

		// 根据用户名取得一个SysUsers对象，以获取该用户的其他信息。
		SysUsersVO user = userServices.findByUserAccount(record);
		user.setAuthorities(auths);
		// auths, accountNonExpired, accountNonLocked, credentialsNonExpired,
		// userId, userAccount, password, account, userDesc, userEnabled,
		// issys, userDept, userDuty, subSystem, validStart, validEnd,
		// sysUsersRoleses
		return user;
	}

	private List<GrantedAuthority> loadUserAuthoritiesByName(SysUsersVO record) {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

		List<String> query = userServices.loadUserAuthorities(record);
		GrantedAuthority auth = null;
		for (String str : query) {
			auth = new SimpleGrantedAuthority(str);
			auths.add(auth);
		}
		return auths;
	}

	public void setUserServices(IUserServices userServices) {
		this.userServices = userServices;
	}

}
