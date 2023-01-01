package com.devteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devteam.entity.Backlog;
import com.devteam.entity.Project;
import com.devteam.entity.User;
import com.devteam.exception.ProjectIdException;
import com.devteam.exception.ProjectNotFoundException;
import com.devteam.repository.BacklogRepository;
import com.devteam.repository.ProjectRepository;
import com.devteam.repository.UserRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private BacklogRepository backlogRepository;

	@Autowired
	private UserRepository userRepository;

	public Project saveOrUpdate(Project project, String username) {

		if (project.getId() != null) {
			Project existingProject = projectRepository.findByProjectIdentifier(project.getProjectIdentifier());

			if (existingProject != null && (!existingProject.getProjectLeader().equals(username))) {
				throw new ProjectNotFoundException("Project not found in your account");
			} else if(existingProject == null) {
				throw new ProjectNotFoundException("Project with ID: " + project.getProjectIdentifier()+ " cannot be updated because it doesn't exist");
			}
		}
		
		try {

			User user = userRepository.findByUsername(username);
			project.setUser(user);
			project.setProjectLeader(user.getUsername());
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());

			if (project.getId() == null) {
				Backlog backlog = new Backlog();
				project.setBacklog(backlog);
				backlog.setProject(project);
				backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			}

			if (project.getId() != null) {
				project.setBacklog(
						backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
			}

			return projectRepository.save(project);

		} catch (Exception e) {
			throw new ProjectIdException(
					"Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
		}

	}

	public Project findByProjectIdentifier(String projectId, String username) {
		Project project = projectRepository.findByProjectIdentifier(projectId);

		if (project == null) {
			throw new ProjectIdException("Project  '" + projectId + "' does not exists");
		}

		if (!project.getProjectLeader().equals(username)) {
			throw new ProjectNotFoundException("Project not found in your account");
		}
		return project;
	}

	public Iterable<Project> findAllProject(String username) {
		return projectRepository.findAllByProjectLeader(username);
	}

	public void deleteProjectByIdentifier(String projectId, String username) {

		projectRepository.delete(findByProjectIdentifier(projectId, username));
	}
}
