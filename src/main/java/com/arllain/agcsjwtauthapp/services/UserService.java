package com.arllain.agcsjwtauthapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.arllain.agcsjwtauthapp.domain.User;
import com.arllain.agcsjwtauthapp.repositories.UserRepository;
import com.arllain.agcsjwtauthapp.security.JwtTokenProvider;
import com.arllain.agcsjwtauthapp.services.exception.AuthenticationCustomException;
import com.arllain.agcsjwtauthapp.services.exception.ObjectFoundException;

/**
 * @author arllain
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * @param user
	 * @return
	 */
	public String signup(User user) {
		if (!userRepository.existsByEmail(user.getEmail())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return jwtTokenProvider.createToken(user.getEmail());
		} else {
			throw new ObjectFoundException("E-mail already exists");

		}
	}

	/**
	 * @param user
	 * @return
	 */
	public String signin(User user) {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			return jwtTokenProvider.createToken(userRepository.findByEmail(user.getEmail()).getEmail());
		} catch (AuthenticationException e) {
			throw new AuthenticationCustomException("Invalid e-mail or password");
		}
	}

}
