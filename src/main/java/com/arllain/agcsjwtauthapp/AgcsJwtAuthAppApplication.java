package com.arllain.agcsjwtauthapp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.arllain.agcsjwtauthapp.services.UserService;


@SpringBootApplication
public class AgcsJwtAuthAppApplication {

	@Autowired
	  UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AgcsJwtAuthAppApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
