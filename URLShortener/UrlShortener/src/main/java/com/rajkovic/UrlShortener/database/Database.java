package com.rajkovic.UrlShortener.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rajkovic.UrlShortener.model.Account;
import com.rajkovic.UrlShortener.model.URL;

public class Database {

	public static Map<String, String> accounts = new HashMap<>();
	public static Map<String, URL> urls = new HashMap<>();
	public static Map<String, URL> accountUrls = new HashMap<>();
	
	public static void addAccount(Account account) {
		accounts.put(account.getAccountId(), account.getPassword());
	}
	
	public static Boolean accountExists(Account account) {
		return accounts.containsKey(account.getAccountId());		
	}
	
	public static Boolean checkUsernamePassword(String accountId, String password) {
		return (accounts.containsKey(accountId) && accounts.containsValue(password));
	}
	
	public static void addUrl(String accountId, URL url) {
		urls.put(url.getShortUrl(), url);
		accountUrls.put(accountId, url);
	}

	public static List<URL> getUrls() {
		return new ArrayList<URL>(accountUrls.values());
	}
	
	public static URL getUrl(String shortUrl) {
		if(urls.keySet().contains(shortUrl))
		{
			urls.get(shortUrl).increaseVisitedUrlCounter();			
		}		
		return urls.get(shortUrl);
	}

	public static HashMap<String, Integer> getStatistics(String accountId) {
		HashMap<String,Integer> statistics = new HashMap<>();			
		for (String account : accountUrls.keySet()) {
			if(account.equals(accountId)) {				
				statistics.put(accountUrls.get(account).getUrl(), accountUrls.get(account).getVisitedUrlCounter());
			}
		}				
		return statistics;
	}
} 
