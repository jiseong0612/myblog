package com.project.myblog.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.myblog.model.User;
import com.project.myblog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUsersService implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		
		User user = userRepository.findByUsername(username).orElseThrow(() -> {
			return new UsernameNotFoundException("존재하지 않는 회원 입니다.");
		});
		
		return new PrincipalDetail(user);
	}

}
