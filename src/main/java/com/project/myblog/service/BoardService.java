package com.project.myblog.service;

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

	//게시글 목록 조회
	@Transactional(readOnly = true)
	public Page<Board> getList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	//게시글 상세 조회, 조회수 업데이트
	@Transactional
	public Board findById(int id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글 상세보기 실패.");
		});
		
		board.setCount(board.getCount() + 1);	//조회수 업데이트
		
		return board;
	}
	
	//게시글 작성
	@Transactional
	public void save(Board board, User user) {
		board.setCount(0);
		board.setUser(user);

		boardRepository.save(board);
	}
	
	//게시글 삭제
	@Transactional
	public int deleteById(int id) {
		System.out.println(id);
		int result = boardRepository.deleteById(id);
		System.out.println(result);
		System.out.println(result);
		System.out.println(result);
		
		
		return result;
	}

	//게시글 수정
	@Transactional
	public Integer update(int id, Board reqBoard) {
		//게시글 영속화
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글 찾기 실패.");
		});
		
		//게시글 업데이트
		board.setTitle(reqBoard.getTitle());
		board.setContent(reqBoard.getContent());
		
		//해당 메서드 종료시 트랜젝션 종료, 변경 사항 자동 업데이트(더티체킹)
		boardRepository.save(board);
		return null;
	}

}
