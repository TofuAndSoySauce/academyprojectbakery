package com.cos.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.project.model.RoleType;
import com.cos.project.model.Users;
import com.cos.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encodeer;
	

	@Transactional
	public void 회원가입(Users user) {
		
		String rawPassword=user.getPassword(); //원본
		String encPassword=encodeer.encode(rawPassword); //암호화
		user.setPassword(encPassword);
		user.setRoles(RoleType.USER);
		userRepository.save(user); // 하나의 트랙잭션
	}
		
	//회원정보 수정
	@Transactional
	public void 회원수정(Users user) {
		//수정시에는 영속성 컨텍스트 Users오브젝트를 영속화 시키고,
		//여속화된 Users오브젝트를 수정
		//select를 해서 Users오브젝트를DB로 부터 가져오는 이유는 영속화를 하기 위해서 
		Users persistance=userRepository.findByNum(user.getNum()).orElseThrow(()->{
			return new IllegalArgumentException("회원 찾기 실패");
		});
		String rawPassword=user.getPassword();
		String encPassword=encodeer.encode(rawPassword);
		persistance.setPassword(encPassword);
		persistance.setEmail(user.getEmail());
		
	}

}
