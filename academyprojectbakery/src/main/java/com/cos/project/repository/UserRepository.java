package com.cos.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.project.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByUsername(String username);
	Optional<Users> findByUserid(String userid);
	Optional<Users> findByNum(int num);
}
