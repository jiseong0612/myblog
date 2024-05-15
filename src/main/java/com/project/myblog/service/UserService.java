package com.project.myblog.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.myblog.model.User;
import com.project.myblog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}

	@Transactional
	public void update(int id, User updateUser) {
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("회원 업데이트 실패.");
		});
		
		String encodePw = passwordEncoder.encode(updateUser.getPassword()); //6036
		
		user.setPassword(encodePw);
		user.setEmail(updateUser.getEmail());
	}

}
