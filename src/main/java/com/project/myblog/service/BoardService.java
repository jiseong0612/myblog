package com.project.myblog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.myblog.model.Board;
import com.project.myblog.model.User;
import com.project.myblog.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;

	@Transactional
	public void save(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		
		System.out.println(board.getContent());
		System.out.println(board.getContent());
		System.out.println(board.getContent());
		System.out.println(board.getContent());
		System.out.println(board.getContent());
		System.out.println(board.getContent());
		boardRepository.save(board);
	}

}
