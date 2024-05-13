package com.project.myblog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.myblog.dto.ResponseDTO;
import com.project.myblog.model.User;
import com.project.myblog.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {
	private final UserService userService;

	@PostMapping("api/user/login")
	public ResponseDTO<Integer> login(@RequestBody User user, HttpSession session) {
		session.setAttribute("principal", userService.login(user));
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}

	@PostMapping("/api/user")
	public ResponseDTO<Integer> save(@RequestBody User user) {
		userService.save(user);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}

}
