package org.sid.secu;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sid.entities.AppUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
		throws AuthenticationException {
	AppUser appuser = null ;
	//String username=request.getParameter("username");
	//String username=request.getParameter("password");
	
	try {
		appuser = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
	System.out.println("***********");
	System.out.println("username"+appuser.getUsername());
	
	System.out.println("username"+appuser.getPassword());
	System.out.println("username"+appuser.getRoles());
	return  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appuser.getUsername(),appuser.getPassword()));
}

public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
	super();
	this.authenticationManager = authenticationManager;
}

@Override
	protected void successfulAuthentication(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User  springUser= (User) authResult.getPrincipal();
		String jwt= Jwts.builder()
				.setSubject(springUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
				.claim("roles",springUser.getAuthorities())
				.compact();
		response.addHeader(SecurityConstants.HEADRE_STRING, SecurityConstants.TOKEN_PREFIX+jwt);
		
	}
}
