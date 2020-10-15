<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
</head>
<body>
	<sec:authorize access="isAnonymous()">
		<a href="/login">로그인</a>
		<a href="/join">회원가입</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<p>
			principal :
			<sec:authentication property="principal" />
			</p>
		<a href="/logout">로그아웃</a>
		<a href="/">메인화면</a>
	</sec:authorize>


</body>
</html>