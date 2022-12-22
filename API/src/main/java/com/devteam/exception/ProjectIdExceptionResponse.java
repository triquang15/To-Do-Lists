package com.devteam.exception;

public class ProjectIdExceptionResponse {
	private String projectIdentifier;

	/**
	 * @param projectIdentifier
	 */
	public ProjectIdExceptionResponse(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

}
