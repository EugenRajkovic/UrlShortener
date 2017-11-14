package com.rajkovic.UrlShortener.resources;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.rajkovic.UrlShortener.services.UrlService;

@Path("/statistic")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StatisticResource {

	UrlService urlService = new UrlService();
	
	@GET
	@Path("/{AccountId}")
	public HashMap<String,Integer> getStatistics(@PathParam("AccountId") String accountId, @Context HttpServletRequest sr) {		
		return urlService.getStatistics(sr.getAttribute("Logged").toString());
	}
}
