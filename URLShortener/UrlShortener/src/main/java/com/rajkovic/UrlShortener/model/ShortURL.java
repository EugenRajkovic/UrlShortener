package com.rajkovic.UrlShortener.model;

public class ShortURL {

	private String shortUrl;

	public ShortURL(String shortUrl) {
		super();
		this.setShortUrl(shortUrl);
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
}
