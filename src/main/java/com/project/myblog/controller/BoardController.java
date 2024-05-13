package com.project.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardController {

	@GetMapping("/writeForm")
	public String writeForm() {
		return "board/writeForm";
	}
	
}
