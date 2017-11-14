package com.rajkovic.UrlShortener.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class URL {

	private String url;
	private int redirectType = 302;
	private String shortUrl;
	private int visitedUrlCounter;
	
	public URL() {
		
	}
	
	public URL(String shortUrl) {
		super();
		this.shortUrl = shortUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getRedirectType() {
		return redirectType;
	}

	public void setRedirectType(int redirectType) {
		this.redirectType = redirectType;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public int getVisitedUrlCounter() {
		return visitedUrlCounter;
	}

	public void increaseVisitedUrlCounter() {
		this.visitedUrlCounter += 1;
	}
	
}
