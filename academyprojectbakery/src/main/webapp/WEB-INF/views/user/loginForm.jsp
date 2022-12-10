<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/auth/loginProc" method="POST">
		<div class="form-group">
			<label for="username">Username</label>
			<input id="username" type="text" class="form-control" placeholder="Enter Username" name="username">
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" placeholder="Enter password" 
				id="password" name="password">
		</div>
		<button type="submit" id="btn-login" class="btn btn-primary">로그인</button>
		</form>
		
</div>

<%@ include file="../layout/footer.jsp"%>