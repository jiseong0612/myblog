package com.project.myblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.myblog.model.RoleType;
import com.project.myblog.model.User;
import com.project.myblog.repository.UserRepository;

@Controller
public class IndexController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PutMapping("/user/{id}")
	@ResponseBody
	public User updateUser(@PathVariable(name = "id") int id, @RequestBody User reqUser) {
		System.out.println(reqUser.toString());
		return reqUser;
	}

	@GetMapping("/user/{id}")
	@ResponseBody
	public User detail(@PathVariable(name = "id") int id) {
		//람다식 익명함수
		User user =  userRepository.findById(id).orElseThrow(() -> {
			return new IllegalStateException("해당 사용자는 없습니다.");
		});
		
		//직접 구현
//		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalStateException>() {
//			@Override
//			public IllegalStateException get() {
//				return new IllegalStateException("해당 사용자는 없습니다.");
//			}
//		});
		
		return user;
	}

}
