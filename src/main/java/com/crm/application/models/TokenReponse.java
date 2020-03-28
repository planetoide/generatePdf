package com.crm.application.models;

public class TokenReponse {
	public Boolean success;
	public String token;
	
	public TokenReponse() {
	}

	public TokenReponse(Boolean success, String token) {
		super();
		this.success = success;
		this.token = token;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
