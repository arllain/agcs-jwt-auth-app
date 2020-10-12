package com.arllain.agcsjwtauthapp.resources;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arllain.agcsjwtauthapp.domain.User;
import com.arllain.agcsjwtauthapp.dto.UserDataDTO;
import com.arllain.agcsjwtauthapp.dto.UserResponseDTO;
import com.arllain.agcsjwtauthapp.dto.UserSignInDTO;
import com.arllain.agcsjwtauthapp.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

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
			@ApiResponse(code = 400, message = "Validation error"), //
			@ApiResponse(code = 422, message = "E-mail already exists") })
	public String signup(@ApiParam("User Signup") @Valid @RequestBody UserDataDTO user) {
		return userService.signup(modelMapper.map(user, User.class));
	}

	@PostMapping("/signin")
	@ApiOperation(value = "${UserController.signin}")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Validation error"), //
			@ApiResponse(code = 401, message = "Invalid e-mail or password") })
	public String signin(@ApiParam("User SignIn") @Valid @RequestBody UserSignInDTO user) {
		return userService.signin(modelMapper.map(user, User.class));
	}

	@GetMapping(value = "/me")
	@ApiOperation(value = "${UserController.me}", response = UserResponseDTO.class, authorizations = {
			@Authorization(value = "apiKey") })
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Validation error"), //
			@ApiResponse(code = 401, message = "Unauthorized"), //
			@ApiResponse(code = 440, message = "Unauthorized - invalide session") })
	public UserResponseDTO whoami(HttpServletRequest req) {
		return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
	}

}
