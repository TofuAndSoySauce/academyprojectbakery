package com.cos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreeBoardController {
	
	@GetMapping({"","/"})
	public String index() {
		return "index";
	}

}
