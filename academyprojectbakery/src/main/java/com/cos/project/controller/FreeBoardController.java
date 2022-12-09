package com.cos.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.project.dto.ResponseDto;
import com.cos.project.service.FreeBoardService;

@Controller
public class FreeBoardController {
	
	@Autowired
	FreeBoardService freeboardService;
	
		@GetMapping({"","/"})
		public String index() {
			return "main";
		}

		/*
		 * @GetMapping({"/auth/board/freeBoard"}) public String index1(Model
		 * model,@PageableDefault(size=3,sort="num",direction=Sort.Direction.DESC)
		 * Pageable pageable) { model.addAttribute("freeboards",
		 * freeboardService.글목록(pageable)); return "board/freeBoard"; //index파일 }
		 */
		@GetMapping({"/auth/board/freeBoard"})
		public String index(Model model,@PageableDefault(size=3,sort="num",direction=Sort.Direction.DESC) Pageable pageable) {
			System.out.println("a");
			
			model.addAttribute("freeboards", freeboardService.글목록(pageable));
			return "board/freeBoard"; //index파일
		}
		//USER 권한이 필요
		@GetMapping({"/board/freeSaveForm"})
		public String freeSaveForm() {
			return "board/freeSaveForm";
		}
		
		//글 상세보기
		@GetMapping("/auth/board/{num}")
		public String findByNum(@PathVariable int num, Model model) {
			
			model.addAttribute("freeboard",freeboardService.글상세보기(num));
			return "board/freeDetail";
		}
		
		
		//글수정하기
		@GetMapping("/board/{num}/freeUpdateForm")
		public String updateForm(@PathVariable int num, Model model) {
			model.addAttribute("freeboard",freeboardService.수정글상세보기(num));
			return "board/freeUpdateForm";
		}
	
}
