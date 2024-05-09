package com.project.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {

	@GetMapping("/test")
	@ResponseBody
	public String getMethodName(@RequestParam("name") String name) {
		return "my name is..." +name;
	}
	
}
