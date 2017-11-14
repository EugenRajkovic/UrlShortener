package com.rajkovic.UrlShortener.services;

import com.rajkovic.UrlShortener.database.Database;
import com.rajkovic.UrlShortener.model.Account;

public class AccountService {
	
	public void addAccount(Account account) {
		Database.addAccount(account);
	}
	
	public Boolean accountExists(Account account) {
		return Database.accountExists(account);
	}
}
