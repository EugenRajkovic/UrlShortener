package com.rajkovic.UrlShortener.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.rajkovic.UrlShortener.model.URL;
import com.rajkovic.UrlShortener.services.UrlService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RedirectResource {

	private UrlService urlService = new UrlService();
	
	@GET
	@Path("/{shortUrl}")
	public Response redirect(@PathParam("shortUrl") String shortUrl) throws URISyntaxException {
		URL url = urlService.getUrl(shortUrl);
		return Response.seeOther(new URI(url.getUrl())).build();
	}	
	
}
