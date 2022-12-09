package com.cos.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.project.modle.RoleType;
import com.cos.project.modle.Users;
import com.cos.project.service.UserService;
import com.cos.project.dto.ResponseDto;


@RestController
public class UserApiController {
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody Users user) {
		System.out.println("호출");
		
		user.setRoles(RoleType.USER);
		
		int result = UserService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK,result);
	}

}
