package com.project.myblog.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.myblog.service.BoardService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	@GetMapping("/")
	public String index(Model model, @PageableDefault(size = 3, direction = Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.getList(pageable).getContent());
		return "index";
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "board/writeForm";
	}
	
	
}
