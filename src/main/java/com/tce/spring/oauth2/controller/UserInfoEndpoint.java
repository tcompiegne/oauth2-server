package com.tce.spring.oauth2.controller;

import java.security.Principal;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserInfoEndpoint {

	@RequestMapping(value = "/userinfo")
	@ResponseBody
	public Object loginInfo(Principal principal) {
		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
		return oAuth2Authentication.getUserAuthentication().getPrincipal();
	}

}
