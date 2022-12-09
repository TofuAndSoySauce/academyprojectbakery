package com.cos.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.project.model.FreeBoards;

public interface FreeboardRepository extends JpaRepository<FreeBoards,Integer> {

	Optional<FreeBoards> findByNum(int num);


	 	
}
