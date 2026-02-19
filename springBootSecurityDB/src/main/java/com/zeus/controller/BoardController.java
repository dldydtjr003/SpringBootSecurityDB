package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/list")
	public String list() {
		log.info("list : 모두가 접근 가능");
		return "board/list";
	}

	@GetMapping("/register")
	public String register() {
		log.info("registerForm : 모두가 접근 가능");
		return "board/register";
	}
}
