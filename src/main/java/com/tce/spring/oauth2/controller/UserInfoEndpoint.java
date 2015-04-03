package com.tce.spring.oauth2.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserInfoEndpoint {

	@RequestMapping(value = "/userinfo")
	@ResponseBody
	public Principal loginInfo(Principal principal) {
		return principal;
	}

}
