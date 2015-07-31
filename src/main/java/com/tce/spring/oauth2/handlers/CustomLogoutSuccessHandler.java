/*******************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Titouan COMPIEGNE
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *******************************************************************************/
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
