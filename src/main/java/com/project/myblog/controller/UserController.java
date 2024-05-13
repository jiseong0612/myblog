package com.project.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.myblog.model.RoleType;
import com.project.myblog.model.User;
import com.project.myblog.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserRepository userRepository;
	
	@GetMapping("/user/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/user/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@PostMapping("/user/join")
	public User join1(@RequestBody User user) {
		
		return userRepository.save(user);
	}
	
	@PostMapping("/join")
	@ResponseBody
	public String join(User user) {
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());

		user.setRole(RoleType.USER);

		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
}
