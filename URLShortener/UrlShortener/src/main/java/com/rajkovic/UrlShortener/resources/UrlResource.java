package com.rajkovic.UrlShortener.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.rajkovic.UrlShortener.helper.RandomStringGenerator;
import com.rajkovic.UrlShortener.model.ShortURL;
import com.rajkovic.UrlShortener.model.URL;
import com.rajkovic.UrlShortener.services.UrlService;

@Path("/register")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UrlResource {

	private UrlService urlService = new UrlService();
	@Context UriInfo UriInfo;
	
	@POST
	public Response registerUrl(URL url, @Context HttpServletRequest sr) {
		url.setShortUrl(RandomStringGenerator.generateString(5));
		urlService.addUrl(sr.getAttribute("Logged").toString(),url);
		return Response.status(Status.OK)
				.entity(new ShortURL(UriInfo.getBaseUriBuilder().path(url.getShortUrl()).build().toString()))
				.build();
	}
	
	@GET
	public List<URL> getUrls(){
		return urlService.getUrls();
	}
}
