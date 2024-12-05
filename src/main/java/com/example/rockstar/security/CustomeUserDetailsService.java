package com.example.rockstar.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.rockstar.dao.UserDao;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CustomeUserDetailsService implements UserDetailsService {

		private final UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
		return userDao.findUserName(userNameOrEmail)
				.map(SecurityUser:: new)
				.orElseThrow(()-> new UsernameNotFoundException(userNameOrEmail));
	}

	
}
