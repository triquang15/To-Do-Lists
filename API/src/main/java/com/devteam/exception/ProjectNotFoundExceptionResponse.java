package com.devteam.exception;

public class ProjectNotFoundExceptionResponse {
	private String projectNotFound;

	/**
	 * @param projectNotFound
	 */
	public ProjectNotFoundExceptionResponse(String projectNotFound) {
		this.projectNotFound = projectNotFound;
	}

	public String getProjectNotFound() {
		return projectNotFound;
	}

	public void setProjectNotFound(String projectNotFound) {
		this.projectNotFound = projectNotFound;
	}

}
