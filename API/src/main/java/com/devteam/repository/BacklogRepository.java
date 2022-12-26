package com.devteam.repository;

import org.springframework.data.repository.CrudRepository;

import com.devteam.entity.Backlog;

public interface BacklogRepository extends CrudRepository<Backlog, Long>{
	
	Backlog findByProjectIdentifier(String identifier);
}
