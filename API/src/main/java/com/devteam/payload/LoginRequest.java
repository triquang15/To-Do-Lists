package com.devteam.payload;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

	@NotBlank(message = "Username can not blank")
	private String username;

	@NotBlank(message = "Password can not blank")
	private String password;

}
