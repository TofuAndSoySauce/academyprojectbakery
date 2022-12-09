package com.cos.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.project.dto.ResponseDto;
import com.cos.project.model.Users;
import com.cos.project.service.UserService;


/*@RestController
public class UserApiController {
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody Users user) {
		System.out.println("호출");
		
		user.setRoles(RoleType.USER);
		
		int result = UserService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK,result);
	}*/


@RestController
public class UserApiController {
	
	@Autowired //의존성 주입
	private UserService userService; 
	
	
	@PostMapping("/auth/joinProc") //회원가입 로직 실행
	public ResponseDto<Integer> save(@RequestBody Users user){
		System.out.println("UserApiController 호출됨");
		
		
		
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	
	}
	
	
	
	
	//회원정보 수정
	 
	
	@PutMapping("/user") 
	public ResponseDto<Integer>
	update(@RequestBody Users user){ 
	userService.회원수정(user); 
	return new ResponseDto<Integer>(HttpStatus.OK.value(),1); }
	

	
	
	
}