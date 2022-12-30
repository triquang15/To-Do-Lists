package com.devteam.validator;

public class UserDtoResponse {
	private String username;

	/**
	 * @param username
	 */
	public UserDtoResponse(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
