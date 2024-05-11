package com.project.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.myblog.model.User;
import com.project.myblog.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserRepository userRepository;
	
	@PostMapping("/user/join")
	public User join(@RequestBody User user) {
		
		return userRepository.save(user);
	}
	
}
