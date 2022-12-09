package com.cos.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.project.modle.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {


}
