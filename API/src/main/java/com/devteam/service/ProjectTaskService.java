package com.devteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devteam.entity.Backlog;
import com.devteam.entity.Project;
import com.devteam.entity.ProjectTask;
import com.devteam.exception.ProjectNotFoundException;
import com.devteam.repository.BacklogRepository;
import com.devteam.repository.ProjectRepository;
import com.devteam.repository.ProjectTaskRepository;

@Service
public class ProjectTaskService {
	@Autowired
	private BacklogRepository backlogRepository;

	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	@Autowired
	private ProjectRepository projectRepository;

	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
		try {
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
		} catch (Exception e) {
			throw new ProjectNotFoundException("Project not found");
		}

	}

	public List<ProjectTask> findBacklogById(String backlog_id) {

		Project project = projectRepository.findByProjectIdentifier(backlog_id);
		if (project == null) {
			throw new ProjectNotFoundException("Project with ID: " + backlog_id + " does not exist");
		}

		return projectTaskRepository.findByProjectIdentifierOrderByPriority(backlog_id);
	}

	public ProjectTask findByProjectSequence(String backlog_id, String pt_id) {
		Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
		if (backlog == null) {
			throw new ProjectNotFoundException("Project with ID: " + backlog_id + " does not exist");
		}

		ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);
		if (projectTask == null) {
			throw new ProjectNotFoundException("Project Task " + pt_id + " not found");
		}

		if (!projectTask.getProjectIdentifier().equals(backlog_id)) {
			throw new ProjectNotFoundException("Project Task " + pt_id + " does not exist in project: " + backlog_id);
		}

		return projectTask;
	}

	public ProjectTask updateProjectSequence(ProjectTask updatedTask, String backlog_id, String pt_id) {
		ProjectTask projectTask = findByProjectSequence(backlog_id, pt_id);

		projectTask = updatedTask;

		return projectTaskRepository.save(projectTask);
	}
	
	 public void deletePTByProjectSequence(String backlog_id, String pt_id){
	        ProjectTask projectTask = findByProjectSequence(backlog_id, pt_id);

	        projectTaskRepository.delete(projectTask);
	    }
}
