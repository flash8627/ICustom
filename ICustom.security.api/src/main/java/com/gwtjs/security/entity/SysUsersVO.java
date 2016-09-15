package com.gwtjs.security.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import com.gwtjs.common.entity.BaseResource;
import com.gwtjs.security.CustomUserDetails;

public class SysUsersVO extends BaseResource implements CustomUserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -601015534390564069L;

	private long userId;
	private String userAccount;
	private String username;
	private String password;
	private String userDesc;
	private int userEnabled;
	private int issys;
	private String userDept;
	private String userDuty;
	private String subSystem;
	private Date validStart;// 有效期开始
	private Date validEnd;// 有效期结束
	// 一个用户具有多个角色。
	private Set<SysUsersRolesVO> sysUsersRoleses = new HashSet<SysUsersRolesVO>(
			0);

	private Set<GrantedAuthority> authorities;

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}

	@Override
	public String getUserAccount() {
		// TODO Auto-generated method stub
		return userAccount;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUserDesc() {
		// TODO Auto-generated method stub
		return userDesc;
	}

	public int getIssys() {
		return issys;
	}

	public String getSubSystem() {
		return subSystem;
	}

	@Override
	public String getUserDept() {
		// TODO Auto-generated method stub
		return userDept;
	}

	@Override
	public String getUserDuty() {
		// TODO Auto-generated method stub
		return userDuty;
	}

	@Override
	public Set<SysUsersRolesVO> getSysUsersRoleses() {
		// TODO Auto-generated method stub
		return sysUsersRoleses;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return userEnabled==1?true:false;
	}

	public int getUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(int userEnabled) {
		this.userEnabled = userEnabled;
	}

	public Date getValidStart() {
		return validStart;
	}

	public void setValidStart(Date validStart) {
		this.validStart = validStart;
	}

	public Date getValidEnd() {
		return validEnd;
	}

	public void setValidEnd(Date validEnd) {
		this.validEnd = validEnd;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserPassword(String password) {
		this.password = password;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public void setIssys(int issys) {
		this.issys = issys;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	public void setUserDuty(String userDuty) {
		this.userDuty = userDuty;
	}

	public void setSubSystem(String subSystem) {
		this.subSystem = subSystem;
	}

	public void setSysUsersRoleses(Set<SysUsersRolesVO> sysUsersRoleses) {
		this.sysUsersRoleses = sysUsersRoleses;
	}

	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = (Set<GrantedAuthority>) authorities;
	}

	public SysUsersVO() {

	}

	public SysUsersVO(Set<GrantedAuthority> authorities,
			boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, long userId, String userAccount,
			String password, String username, String userDesc, int userEnabled,
			int issys, String userDept, String userDuty, String subSystem,
			Date validStart, Date validEnd, Set<SysUsersRolesVO> sysUsersRoleses) {
		super();
		if (((userAccount == null) || "".equals(userAccount))
				|| (password == null)) {
			throw new IllegalArgumentException(
					"Cannot pass null or empty values to constructor");
		}
		this.authorities = Collections
				.unmodifiableSet(sortAuthorities(authorities));
		this.userId = userId;
		this.userAccount = userAccount;
		this.password = password;
		this.username = username;
		this.userDesc = userDesc;
		this.userEnabled = userEnabled;
		this.issys = issys;
		this.userDept = userDept;
		this.userDuty = userDuty;
		this.subSystem = subSystem;
		this.validStart = validStart;
		this.validEnd = validEnd;
		this.sysUsersRoleses = sysUsersRoleses;
	}

	public boolean equals(Object rhs) {
		if (!(rhs instanceof SysUsersVO) || (rhs == null)) {
			return false;
		}

		SysUsersVO user = (SysUsersVO) rhs;

		// 具有的权限。
		if (!authorities.equals(user.authorities)) {
			return false;
		}

		// 通过Spring Security构建一个用户时，用户名和密码不能为空。
		return (this.getPassword().equals(user.getPassword())
				&& this.getUsername().equals(user.getUsername())
				&& (this.isAccountNonExpired() == user.isAccountNonExpired())
				&& (this.isAccountNonLocked() == user.isAccountNonLocked())
				&& (this.isCredentialsNonExpired() == user
						.isCredentialsNonExpired()) && (this.isEnabled() == user
				.isEnabled()));
	}

	public int hashCode() {
		int code = 9792;

		// 若该用户不是登录人员，则可以允许没有authorities。
		if (null != getUsername() && null != getAuthorities()) {
			for (GrantedAuthority authority : getAuthorities()) {

				code = code * (authority.hashCode() % 7);
			}
		}

		if (this.getPassword() != null) {
			code = code * (this.getPassword().hashCode() % 7);
		}

		if (this.getUsername() != null) {
			code = code * (this.getUsername().hashCode() % 7);
		}

		if (this.isAccountNonExpired()) {
			code = code * -2;
		}

		if (this.isAccountNonLocked()) {
			code = code * -3;
		}

		if (this.isCredentialsNonExpired()) {
			code = code * -5;
		}

		if (this.isEnabled()) {
			code = code * -7;
		}

		return code;
	}

	private static SortedSet<GrantedAuthority> sortAuthorities(
			Collection<GrantedAuthority> authorities) {
		Assert.notNull(authorities,
				"Cannot pass a null GrantedAuthority collection");
		// Ensure array iteration order is predictable (as per
		// UserDetails.getAuthorities() contract and SEC-717)
		SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(
				new AuthorityComparator());

		for (GrantedAuthority grantedAuthority : authorities) {
			Assert.notNull(grantedAuthority,
					"GrantedAuthority list cannot contain any null elements");
			sortedAuthorities.add(grantedAuthority);
		}

		return sortedAuthorities;
	}

	private static class AuthorityComparator implements
			Comparator<GrantedAuthority>, Serializable {
		private static final long serialVersionUID = 6173956575005152011L;

		public int compare(GrantedAuthority g1, GrantedAuthority g2) {
			// Neither should ever be null as each entry is checked before
			// adding it to the set.
			// If the authority is null, it is a custom authority and should
			// precede others.
			if (g2.getAuthority() == null) {
				return -1;
			}

			if (g1.getAuthority() == null) {
				return 1;
			}

			return g1.getAuthority().compareTo(g2.getAuthority());
		}
	}

}
