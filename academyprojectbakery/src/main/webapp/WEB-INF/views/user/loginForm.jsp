<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/auth/loginProc" method="POST">
		<div class="form-group">
			<label for="username">Username</label> <input type="text"
				class="form-control" placeholder="Enter Username" 
				id="username" name="username">
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" placeholder="Enter password" 
				id="password" name="password">
		</div>
		</form>
		<button type="submit" id="btn-login" class="btn btn-primary">로그인</button>
</div>
<script src="/blog/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>