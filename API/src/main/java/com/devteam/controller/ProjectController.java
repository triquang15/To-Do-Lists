package com.devteam.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devteam.entity.Project;
import com.devteam.service.ProjectService;
import com.devteam.service.ValidationErrorService;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ValidationErrorService validationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result,
			Principal principal) {

		ResponseEntity<?> errorMap = validationErrorService.mapValidationErrorService(result);
		if (errorMap != null)
			return errorMap;

		Project createProject = projectService.saveOrUpdate(project, principal.getName());

		return new ResponseEntity<Project>(createProject, HttpStatus.CREATED);
	}

	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId, Principal principal) {
		Project project = projectService.findByProjectIdentifier(projectId, principal.getName());

		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	@GetMapping("/all")
	public Iterable<Project> getAllProject(Principal principal) {
		return projectService.findAllProject(principal.getName());
	}
	
	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteProject(@PathVariable String projectId, Principal principal) {
		projectService.deleteProjectByIdentifier(projectId, principal.getName());
		
		return new ResponseEntity<String>("Project with ID " + projectId + " was deleted", HttpStatus.OK);
	}

}
