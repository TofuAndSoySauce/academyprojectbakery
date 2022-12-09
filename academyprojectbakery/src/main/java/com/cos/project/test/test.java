package com.cos.project.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class test {
	
	@GetMapping("/test/b")
	public String b() {
		return "main";
	}

}
