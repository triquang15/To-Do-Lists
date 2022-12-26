package com.devteam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;

import com.devteam.entity.ProjectTask;
import com.devteam.service.ProjectTaskService;
import com.devteam.service.ValidationErrorService;

@RestController
@RequestMapping("/api/backlog")
@CrossOrigin
public class BacklogController {
	@Autowired
	private ProjectTaskService projectTaskService;

	@Autowired
	private ValidationErrorService validationErrorService;

	@PostMapping("/{backlog_id}")
	public ResponseEntity<?> addProjectTask(@Valid @RequestBody ProjectTask projectTask, BindingResult result,
			@PathVariable String backlog_id) {

		ResponseEntity<?> errorMaps = validationErrorService.mapValidationErrorService(result);
		if (errorMaps != null)
			return errorMaps;

		ProjectTask newProjectTask = projectTaskService.addProjectTask(backlog_id, projectTask);

		return new ResponseEntity<ProjectTask>(newProjectTask, HttpStatus.CREATED);

	}
}
