package com.devteam.repository;

import org.springframework.data.repository.CrudRepository;

import com.devteam.entity.ProjectTask;

public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {

}
