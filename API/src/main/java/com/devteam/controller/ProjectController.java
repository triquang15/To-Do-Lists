package com.devteam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devteam.entity.Project;
import com.devteam.service.ProjectService;
import com.devteam.service.ValidationErrorService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ValidationErrorService validationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

		ResponseEntity<?> errorMap = validationErrorService.mapValidationErrorService(result);
		if(errorMap != null) return errorMap;

		Project createProject = projectService.saveOrUpdate(project);

		return new ResponseEntity<Project>(createProject, HttpStatus.CREATED);
	}

}
