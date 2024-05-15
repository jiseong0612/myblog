package com.project.myblog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.myblog.config.security.PrincipalDetail;
import com.project.myblog.dto.ResponseDTO;
import com.project.myblog.model.Board;
import com.project.myblog.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardApiController {
	private final BoardService boardService;

	@PostMapping("/api/board")
	public ResponseDTO<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail) {

		boardService.save(board, principalDetail.getUser());
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDTO<Integer>deleteById(@PathVariable(name = "id") int id){
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), boardService.deleteById(id));
	}
	
	@PutMapping("/api/board/{id}")
	public ResponseDTO<Integer>update(@PathVariable(name = "id") int id, @RequestBody Board board){
		boardService.update(id, board);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}

}
