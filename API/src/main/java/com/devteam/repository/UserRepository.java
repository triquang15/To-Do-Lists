package com.devteam.repository;

import org.springframework.data.repository.CrudRepository;

import com.devteam.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
}
