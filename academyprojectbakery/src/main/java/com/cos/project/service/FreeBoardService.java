package com.cos.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.project.model.FreeBoards;
import com.cos.project.model.Users;
import com.cos.project.repository.FreeboardRepository;

@Service
public class FreeBoardService {

	@Autowired
	private FreeboardRepository freeboardRepository;

	@Transactional
	public void 글쓰기(FreeBoards freeboard, Users user) { // title, content
		freeboard.setCount(0);
		freeboard.setUsers(user);
		freeboardRepository.save(freeboard);
	}
	@Transactional(readOnly = true)
	public Page<FreeBoards> 글목록(Pageable pageable) {
		return freeboardRepository.findAll(pageable);
	}
	
	@Transactional
	/* (readOnly = true) 조회수 상승을 위해*/
	
	public FreeBoards 글상세보기(int num) {
		FreeBoards fb=freeboardRepository.findByNum(num).orElseThrow(() -> {
			return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
		});
		int count=fb.getCount();
		count=count+1;
		fb.setCount(count);
		return freeboardRepository.findByNum(num).orElseThrow(() -> {
			return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
		});
	}
	
	
	@Transactional(readOnly = true)
	public FreeBoards 수정글상세보기(int num) {
		return freeboardRepository.findByNum(num).orElseThrow(() -> {
			return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
		});
	}
	@Transactional
	public void 글삭제하기(int num) {
		freeboardRepository.deleteById(num);
	}
	@Transactional
	public void 글수정하기(int num, FreeBoards requestBoard) {
		FreeBoards freeboard = freeboardRepository.findById(num).orElseThrow(() -> {
			return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을 수 없습니다.");
		}); 
		freeboard.setTitle(requestBoard.getTitle());
		freeboard.setContent(requestBoard.getContent());
	}
	
	 

}
