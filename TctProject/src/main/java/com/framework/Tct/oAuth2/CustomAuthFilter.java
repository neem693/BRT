package com.framework.Tct.oAuth2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.framework.Tct.Const.PublicConst;

public class CustomAuthFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		CustomAuthentication authRequest = getAuthRequest(request);
		setDetails(request, authRequest);
		return this.getAuthenticationManager().authenticate(authRequest);
	}

	private CustomAuthentication getAuthRequest(HttpServletRequest request) {
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		String domain = obtainDomain(request);

		if (username == null) {
			username = "";
		}
		if (password == null) {
			password = "";
		}
		if (domain == null) {
			domain = "";
		}

		CustomAuthentication auth = new CustomAuthentication(username, password);
		auth.setDomain(domain);

		return auth;
	}

	private String obtainDomain(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return request.getParameter(PublicConst.AUTHORITICATION_PARAM.DOMAIN);
	}
}