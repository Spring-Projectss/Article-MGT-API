package com.sovathana.app.auth;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SimpleUrlAuthSuccessHandler implements AuthenticationSuccessHandler{

	protected Log logger = LogFactory.getLog(this.getClass());
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// Handle Request
		handle(request, response, auth);
		// Clear Session
		clearAuthAttribute(request);
	}
	
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException{
		// Get targetUrl base on USER ROLE
		String targetUrl = determineTargetUrl(auth);
		
		// Is request is already response.
		if(response.isCommitted()){
			logger.debug("Response has already been commited. Unable to redirect to " + targetUrl);
			return;
		}
		
		// Redirect to targetUrl
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	protected String determineTargetUrl(Authentication auth) {
		
		String targetUrl = "";
		
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		
		for(GrantedAuthority ga : authorities){
			if (ga.getAuthority().equals("ROLE_USER")){
				targetUrl = "/home";
				break;
			}else if(ga.getAuthority().equals("ROLE_ADMIN")){
				targetUrl = "/admin";
				break;
			}else if(ga.getAuthority().equals("ROLE_DEVELOPER")){
				targetUrl = "/swagger-ui.html";
				break;
			}
		}
		
		return targetUrl;
	}
	
	protected void clearAuthAttribute(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session == null){
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
	
	public void setRedirectStrategy(RedirectStrategy redirectStrategy){
		this.redirectStrategy = redirectStrategy;
	}
	
	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
