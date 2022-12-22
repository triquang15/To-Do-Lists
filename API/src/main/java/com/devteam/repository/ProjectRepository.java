package com.devteam.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devteam.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	Iterable<Project> findAllById(Iterable<Long> iterable);
}
