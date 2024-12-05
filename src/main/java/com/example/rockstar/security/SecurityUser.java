package com.example.rockstar.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.rockstar.entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SecurityUser implements UserDetails {
	
	private final User user;
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return user.getRoles()
				.stream()
				.map(r -> new SimpleGrantedAuthority(r.getName()))
				.collect(Collectors.toUnmodifiableList() );
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return  user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getName();
	}
	
	

}
