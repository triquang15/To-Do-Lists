package com.devteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devteam.entity.Project;
import com.devteam.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project) {
		return projectRepository.save(project);
	}
}
