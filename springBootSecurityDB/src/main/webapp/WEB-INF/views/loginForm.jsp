<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>

</head>
<body>

	<h1>로그인</h1>
	<h2>
		<c:out value="${error}" />
	</h2>
	<h2>
		<c:out value="${logout}" />
	</h2>
	<!-- method, action, name, sec:csrfInput 무조건 똑같이 넣어야함 -->
	<form method="post" action="/login">
		<div>
			<input type="text" name="username" value="">
		</div>
		<div>
			<input type="password" name="password" value="">
		</div>
		<div>
			<input type="submit">
		</div>
		<!-- 사용 하려면 porm.xml에서 시큐리티 의존성 설정 -->
		<sec:csrfInput />
	</form>
</body>
</html>