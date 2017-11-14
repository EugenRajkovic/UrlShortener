package com.rajkovic.UrlShortener.services;

import java.util.HashMap;
import java.util.List;

import com.rajkovic.UrlShortener.database.Database;
import com.rajkovic.UrlShortener.model.URL;

public class UrlService {

	public void addUrl(String accountId, URL url) {
		Database.addUrl(accountId, url);
	}

	public List<URL> getUrls() {
		return Database.getUrls();
	}	
	
	public URL getUrl(String shortUrl) {
		return Database.getUrl(shortUrl);
	}
	
	public HashMap<String,Integer> getStatistics(String accountId){
		return Database.getStatistics(accountId);
	}
}
