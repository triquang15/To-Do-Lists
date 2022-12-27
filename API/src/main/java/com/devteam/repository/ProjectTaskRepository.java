package com.devteam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.devteam.entity.ProjectTask;

public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
	
	List<ProjectTask> findByProjectIdentifierOrderByPriority(String id);
	
	ProjectTask findByProjectSequence(String sequence);
}
