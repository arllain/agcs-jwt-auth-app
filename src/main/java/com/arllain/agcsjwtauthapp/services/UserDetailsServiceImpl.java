package com.arllain.agcsjwtauthapp.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arllain.agcsjwtauthapp.domain.User;
import com.arllain.agcsjwtauthapp.repositories.UserRepository;

/**
 * @author arllain
 *
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
	    final User user = userRepository.findByEmail(email);

	    if (user == null) {
	      throw new UsernameNotFoundException("Email '" + email + "' not found");
	    }

	    return org.springframework.security.core.userdetails.User//
	        .withUsername(email)//
	        .password(user.getPassword())//
	        .authorities(new ArrayList<>())//
	        .accountExpired(false)//
	        .accountLocked(false)//
	        .credentialsExpired(false)//
	        .disabled(false)//
	        .build();
	  }
}
