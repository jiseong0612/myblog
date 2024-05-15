package com.project.myblog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.myblog.config.security.PrincipalDetail;
import com.project.myblog.dto.ResponseDTO;
import com.project.myblog.model.RoleType;
import com.project.myblog.model.User;
import com.project.myblog.service.UserService;

import jakarta.servlet.http.HttpSession;
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
	
	@PutMapping("/api/user/{id}")
	public ResponseDTO<Integer>update(HttpSession session, @PathVariable(name = "id") int id, @AuthenticationPrincipal PrincipalDetail principalDetail, @RequestBody User user){
		userService.update(id, user);
		
		//강제 로그인 시키는 방법이다.
		Authentication authentication = new UsernamePasswordAuthenticationToken(new PrincipalDetail(user), null, principalDetail.getAuthorities());	//권한 유지
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//이메일 수정 반영
//		principalDetail.getUser().setEmail(user.getEmail());
		
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}
	
}
