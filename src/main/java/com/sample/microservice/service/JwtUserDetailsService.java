package com.sample.microservice.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("user".equals(username)) {
			return new User("user", "$2a$10$7qmtueOe1GfjNA7K9pMa8OIZ3uIu2Bpe/sCqFqs5YJwvBiv1d/xeK", new ArrayList<>()); // Password:
																														// "password"
																														// encoded
																														// using
																														// BCrypt
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
