package com.rajkovic.UrlShortener.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {

	private String AccountId;
	private String success;
	private String description;
	private String password;
	

	public Account() {
		
	}

	public Account(String success, String description) {
		super();
		this.success = success;
		this.description = description;
	}

	public Account(String success, String description, String password) {
		super();
		this.success = success;
		this.description = description;
		this.password = password;
	}
	
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountId() {
		return AccountId;
	}

	public void setAccountId(String accountId) {
		AccountId = accountId;
	}
}
