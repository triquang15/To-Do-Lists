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

import com.devteam.entity.User;
import com.devteam.service.UserService;
import com.devteam.service.ValidationErrorService;
import com.devteam.validator.UserValidator;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ValidationErrorService errorService;
	
	@Autowired
	private UserValidator userValidator;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result) {
		userValidator.validate(user, result);
		
		ResponseEntity<?> errorMap = errorService.mapValidationErrorService(result);
		if (errorMap != null)
			return errorMap;

		User newUser = userService.saveUser(user);

		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
}
