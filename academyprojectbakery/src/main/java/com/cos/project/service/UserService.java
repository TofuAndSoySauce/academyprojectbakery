package com.cos.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.project.repository.UserRepository;
import com.cos.project.modle.Users;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Integer 회원가입(Users user){
		try {
			userRepository.save(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return -1;
	}

}
