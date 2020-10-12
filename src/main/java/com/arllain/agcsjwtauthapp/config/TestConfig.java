package com.arllain.agcsjwtauthapp.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.arllain.agcsjwtauthapp.domain.Telephone;
import com.arllain.agcsjwtauthapp.domain.User;
import com.arllain.agcsjwtauthapp.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		
		Telephone tel1 = new Telephone(34270008, 81, "+55");
		Telephone tel2 = new Telephone(999912248, 81, "+55");
		User user = new User(null, "John", "Doe", "user@email.com", passwordEncoder.encode("123456"), 
				Instant.now(), Instant.now(), Arrays.asList(tel1, tel2));
		
		userRepository.save(user);
	}

}
