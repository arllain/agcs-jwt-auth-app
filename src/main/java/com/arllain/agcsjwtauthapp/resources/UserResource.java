package com.arllain.agcsjwtauthapp.resources;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arllain.agcsjwtauthapp.domain.User;
import com.arllain.agcsjwtauthapp.dto.UserDataDTO;
import com.arllain.agcsjwtauthapp.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author arllain
 *
 */

@RestController
@RequestMapping()
@Api(tags = "users")
public class UserResource {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/signup")
	@ApiOperation(value = "${UserController.signup}")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 422, message = "E-mail already exists") })
	public String signup(@ApiParam("Signup User") @Valid @RequestBody UserDataDTO user) {
		return userService.signup(modelMapper.map(user, User.class));
	}

}
