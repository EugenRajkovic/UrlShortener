package com.rajkovic.UrlShortener.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.rajkovic.UrlShortener.helper.RandomStringGenerator;
import com.rajkovic.UrlShortener.model.Account;
import com.rajkovic.UrlShortener.services.AccountService;

@Path("/account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

	private AccountService accountService = new AccountService();
	
	@POST
	public Response openAccount(Account account) {
		if(accountService.accountExists(account)) {			
			return Response.ok(new Account("false","Account with that ID already exists. Please try again.")).build();
		}

		String password = RandomStringGenerator.generateString(8);
		account.setPassword(password);
		accountService.addAccount(account);
		return Response.status(Status.CREATED)
						.entity(new Account("true","Your account is opened.",password))
						.build();
	}
}
