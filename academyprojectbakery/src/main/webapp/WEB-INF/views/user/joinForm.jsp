<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/action_page.php">
		<div class="form-group">
			<label for="username">Username</label> <input type="text"
				class="form-control" placeholder="Enter Username" id="username">
		</div>
		<div class="form-group">
			<label for="userid">User Id</label> <input type="text"
				class="form-control" placeholder="Enter User Id" id="userid">
		</div>
		<div class="form-group">
			<label for="email">Email</label> <input type="email"
				class="form-control" placeholder="Enter Email" id="email">
		</div>
		<div class="form-group">
			<label for="address">Address</label> <input type="text"
				class="form-control" placeholder="Enter Address" id="address">
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" placeholder="Enter password" id="password">
		</div>
	</form>
	<button type="submit" class="btn btn-primary" id="btn-save">회원가입</button>
</div>
<script src="/js/user.js"></script>
<br />
<%@ include file="../layout/footer.jsp"%>
