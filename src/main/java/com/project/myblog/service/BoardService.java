package com.project.myblog.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		
		boardRepository.save(board);
	}

	public Page<Board> getList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

}
