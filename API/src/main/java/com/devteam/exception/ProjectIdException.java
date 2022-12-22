package com.devteam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public ProjectIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
