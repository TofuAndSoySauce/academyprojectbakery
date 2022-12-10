<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>	
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Bootstrap Example</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>





<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js">
</script>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark sticky-top">
		<a class="navbar-brand" href="/">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<sec:authorize access="isAnonymous()">
				<ul class="header_right_menu">
					<li class="menu_item"><a href="/auth/freeBoard">자유게시판</a></li>
					<li class="menu_item"><a href="/auth/loginForm">로그인</a></li>
					<li class="menu_item"><a href="/auth/joinForm">회원가입</a></li>
				</ul>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_USER')">
				<ul class="header_right_menu">
					<li class="menu_item"><a href="/auth/freeBoard">자유게시판</a></li>
					<li class="menu_item"><a href="/user/myPage">마이페이지</a></li>
					<li class="menu_item"><a href="/logout">로그아웃</a></li>
				</ul>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
				<ul class="header_right_menu">
					<li class="menu_item"><a href="/auth/freeBoard">자유게시판</a></li>
					<li class="menu_item"><a href="/admin/adminPage">관리자페이지</a></li>
					<li class="menu_item"><a href="/logout">로그아웃</a></li>
				</ul>
			</sec:authorize>
		
		</div>
	</nav>
	<br />