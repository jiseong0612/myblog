package com.project.myblog.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.myblog.model.Board;
import com.project.myblog.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	/**
	 * { "content": [ { "id": 1, "title": "test", "content":
	 * "\u003Cp\u003E123123123wrwrwarwa\u003C/p\u003E", "count": 0, "user": { "id":
	 * 1, "username": "test", "password":
	 * "$2a$10$ZfD4tt1poBhodFCupVbpIuCRxZ/PbB6JLMy9G/pTDBfRk/c3FAPvG", "email":
	 * "123", "role": "USER", "createDate": "2024-05-13T14:28:09.295+00:00" },
	 * "reply": [], "createDate": "2024-05-13T14:28:33.661+00:00" } ], "pageable": {
	 * "pageNumber": 0, "pageSize": 3, "sort": { "empty": true, "unsorted": true,
	 * "sorted": false }, "offset": 0, "paged": true, "unpaged": false },
	 * "totalElements": 1, "totalPages": 1, "last": true, "size": 3, "number": 0,
	 * "sort": { "empty": true, "unsorted": true, "sorted": false }, "first": true,
	 * "numberOfElements": 1, "empty": false }
	 * 
	 * @param model
	 * @param pageable
	 * @return
	 */
	//글 목록
	@GetMapping("/")
	public String index(Model model, @PageableDefault(size = 3, direction = Direction.DESC) Pageable pageable) {
		Page<Board> page = boardService.getList(pageable);
		model.addAttribute("boards", page.getContent());
		return "index";
	}
	
	//작성화면
	@GetMapping("/writeForm")
	public String writeForm() {
		return "board/writeForm";
	}

	//상세화면
	@GetMapping("/board/{id}")
	public String findById(@PathVariable(name = "id") int id, Model model){
		model.addAttribute("board", boardService.findById(id));
		return "board/deatil";
	}
	
	//수정화면
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable(name = "id") int id, Model model){
		model.addAttribute("board", boardService.findById(id));
		return "board/updateForm";
	}

}
