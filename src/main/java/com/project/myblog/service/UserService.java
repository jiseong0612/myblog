package com.project.myblog.service;

import org.springframework.stereotype.Service;

import com.project.myblog.model.User;
import com.project.myblog.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}

}
