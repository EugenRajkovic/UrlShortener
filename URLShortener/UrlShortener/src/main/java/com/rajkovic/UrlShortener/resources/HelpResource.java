package com.rajkovic.UrlShortener.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

@Path("/help")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class HelpResource {

	@GET
	public Viewable getHelp() {
		return new Viewable("/help.jsp",null);
	}
}
