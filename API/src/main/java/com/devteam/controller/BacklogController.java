package com.devteam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

	@GetMapping("/{backlog_id}")
	public ResponseEntity<List<ProjectTask>> getProjectTaskBacklog(@PathVariable String backlog_id) {
		return new ResponseEntity<List<ProjectTask>>(projectTaskService.findBacklogById(backlog_id), HttpStatus.OK);
	}

	@GetMapping("/{backlog_id}/{pt_id}")
	public ResponseEntity<?> getProjectTask(@PathVariable String backlog_id, @PathVariable String pt_id) {
		ProjectTask projectTask = projectTaskService.findByProjectSequence(backlog_id, pt_id);

		return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
	}

	@PatchMapping("/{backlog_id}/{pt_id}")
	public ResponseEntity<?> updateProjectTask(@Valid @RequestBody ProjectTask projectTask, BindingResult result,
			@PathVariable String backlog_id, @PathVariable String pt_id) {

		ResponseEntity<?> errorMaps = validationErrorService.mapValidationErrorService(result);
		if (errorMaps != null)
			return errorMaps;

		ProjectTask updatedTask = projectTaskService.updateProjectSequence(projectTask, backlog_id, pt_id);

		return new ResponseEntity<ProjectTask>(updatedTask, HttpStatus.OK);
	}
	
	 @DeleteMapping("/{backlog_id}/{pt_id}")
	    public ResponseEntity<?> deleteProjectTask(@PathVariable String backlog_id, @PathVariable String pt_id){
	        projectTaskService.deletePTByProjectSequence(backlog_id, pt_id);

	        return new ResponseEntity<String>("Project Task "+pt_id+" was deleted successfully", HttpStatus.OK);
	    }
}
