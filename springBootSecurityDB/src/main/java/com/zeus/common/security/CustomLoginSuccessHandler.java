package com.zeus.common.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	private RequestCache requestCache = new HttpSessionRequestCache(); 
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
	        throws ServletException, IOException {
	    log.info("onAuthenticationSuccess - 로그인 성공!");

	    // 1. [추가] 세션에 저장된 이전 요청 정보를 지워버립니다. 
	    // 브라우저가 몰래 요청한 .well-known 같은 쓰레기 정보를 삭제하는 과정입니다.
	    requestCache.removeRequest(request, response); 

	    // 2. [수정] savedRequest가 있든 없든, 무조건 게시판 목록으로 보냅니다.
	    // 기존의 if(savedRequest != null) {...} 블록을 아래 한 줄로 대체하세요.
	    response.sendRedirect("/"); 
	    
	    // 인증 과정에서 발생한 예외 정보를 세션에서 제거 
	    clearAuthenticationAttribute(request);  
	}

	// 인증 과정에서 발생한 예외 정보를 세션에서 제거합니다.
	private void clearAuthenticationAttribute(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		// 세션에서 인증 예외 속성을 제거한다.
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}
