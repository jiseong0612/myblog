package com.project.myblog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.myblog.dto.ResponseDTO;
import com.project.myblog.model.RoleType;
import com.project.myblog.model.User;
import com.project.myblog.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {	
	private final PasswordEncoder passwordEncoder;
	private final UserService userService;

	@PostMapping("/auth/joinProc")	
	public ResponseDTO<Integer> save(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(RoleType.USER);

		userService.save(user);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}
	
}
