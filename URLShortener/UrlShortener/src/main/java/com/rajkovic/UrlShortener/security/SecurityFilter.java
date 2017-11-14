package com.rajkovic.UrlShortener.security;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

import com.rajkovic.UrlShortener.database.Database;

@Provider
@PreMatching
public class SecurityFilter implements ContainerRequestFilter{

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization"; 
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String[] SECURED_URL_PREFIXES = {"register","statistic"};
	
	@Context HttpServletRequest sr;
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String path = requestContext.getUriInfo().getPath();
		if (isPathSecured(path)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if (authHeader != null && authHeader.size() > 0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = Base64.decodeAsString(authToken);
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String accountId = tokenizer.nextToken();
				String password = tokenizer.nextToken();

				if (Database.checkUsernamePassword(accountId, password)) {
					sr.setAttribute("Logged", accountId);
					return;
				}
			}
			Response unauthorizedStatus = Response.status(Status.UNAUTHORIZED)
					.entity("User cannot access the resource.").build();
			requestContext.abortWith(unauthorizedStatus);
		}
	}
	
	
	private Boolean isPathSecured(String path) {
		for (String prefix : SECURED_URL_PREFIXES) {
			if(path.contains(prefix)) {
				return true;
			}
		}
		return false;
	}
}
