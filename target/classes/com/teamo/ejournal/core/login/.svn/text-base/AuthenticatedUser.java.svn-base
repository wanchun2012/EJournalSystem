package com.teamo.ejournal.core.login;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AuthenticatedUser extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String displayName;
	
	private Integer userId;
	
	public String getDisplayName() {
		return displayName;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public AuthenticatedUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,
			String displayName, Integer userId) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		//extra fields
		this.displayName = displayName;
	    this.userId = userId;
	}

	@Override
	public String toString() {
		return "AuthenticatedUser [displayName=" + displayName + ", userId="
				+ userId + "]";
	}
	
}
