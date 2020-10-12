package com.arllain.agcsjwtauthapp.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author arllain
 *
 */
@RestController
@RequestMapping("/")
public class HomeResource {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String home() {
		return "<html>\n" + "<header><title>AGCS JWT Authentication API</title></header>\n" + "<body>\n"
				+ "<br> You can find the source code in  <a href=\"https://github.com/arllain/agcs-jwt-auth-app/\">https://github.com/arllain/agcs-jwt-auth-app</a>\n"
				+ "</body>\n" + "</html>";
	}

}
