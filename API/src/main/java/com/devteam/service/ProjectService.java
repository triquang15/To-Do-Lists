package com.devteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devteam.entity.Project;
import com.devteam.exception.ProjectIdException;
import com.devteam.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdate(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException(
					"Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
		}

	}
}
