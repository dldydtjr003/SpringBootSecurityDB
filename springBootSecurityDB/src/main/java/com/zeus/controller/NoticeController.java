package com.zeus.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/notice")
public class NoticeController {

	@GetMapping("/list")
	public void list() {
		log.info("notice list : 모두가 접근 가능");
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/register")
	public void register() {
		log.info("notice register : 로그인한 관리자 접근 가능");
	}
}
