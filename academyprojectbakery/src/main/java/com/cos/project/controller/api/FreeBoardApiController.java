package com.cos.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.project.config.auth.PrincipalDetail;
import com.cos.project.dto.ResponseDto;
import com.cos.project.model.FreeBoards;
import com.cos.project.service.FreeBoardService;

@RestController
public class FreeBoardApiController {
		
		@Autowired
		private FreeBoardService freeBoardService;	
		
		@PostMapping("/api/freeboard")
		public ResponseDto<Integer> save(@RequestBody FreeBoards freeboard, @AuthenticationPrincipal PrincipalDetail principal ) {
			freeBoardService.글쓰기(freeboard,principal.getUser());
			return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		}
		@DeleteMapping("/api/freeboard/{num}")
		public ResponseDto<Integer> deleteById(@PathVariable int num){
			System.out.println(num);
			freeBoardService.글삭제하기(num);
			return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		}
		@PutMapping("/api/freeboard/{num}")
		public ResponseDto<Integer> update(@PathVariable int num,@RequestBody FreeBoards freeboard){
			System.out.println("FreeBoardApiController:update id"+num);
			System.out.println("FreeBoardApiController:update title"+freeboard.getTitle());
			freeBoardService.글수정하기(num,freeboard);
			return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		}
}

