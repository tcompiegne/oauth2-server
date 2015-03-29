package com.tce.spring.oauth2.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

/**
 * Same as {@link SimpleUrlLogoutSuccessHandler} but retrieve targetUrl form the request target_url parameter
 *
 */
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{

	private static final String LOGOUT_URL_PARAMETER = "target_url";
	
	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		String logoutRedirectUrl = request.getParameter(LOGOUT_URL_PARAMETER);
		if (logoutRedirectUrl != null && !logoutRedirectUrl.isEmpty()) {
			setTargetUrlParameter(LOGOUT_URL_PARAMETER);
		}
		return super.determineTargetUrl(request, response);
	}
	
}
