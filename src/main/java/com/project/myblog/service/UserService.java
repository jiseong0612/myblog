package com.project.myblog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.myblog.model.User;
import com.project.myblog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}

	@Transactional(readOnly = true)
 	public User login(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).orElseThrow(() -> {
			return new IllegalStateException("해당 사용자는 없습니다.");
		});
	}

}
