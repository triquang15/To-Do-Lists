package com.devteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devteam.entity.Backlog;
import com.devteam.entity.ProjectTask;
import com.devteam.repository.BacklogRepository;
import com.devteam.repository.ProjectTaskRepository;

@Service
public class ProjectTaskService {
	@Autowired
	private BacklogRepository backlogRepository;

	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
		Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
		projectTask.setBacklog(backlog);
		Integer backlogSequence = backlog.getPTSequence();
		backlogSequence++;
		
		backlog.setPTSequence(backlogSequence);

		projectTask.setProjectSequence(projectIdentifier + "-" + backlogSequence);
		projectTask.setProjectIdentifier(projectIdentifier);

		if (projectTask.getPriority() == null) {
			projectTask.setPriority(3);
		}

		if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
			projectTask.setStatus("TO_DO");
		}

		return projectTaskRepository.save(projectTask);
	}
}
