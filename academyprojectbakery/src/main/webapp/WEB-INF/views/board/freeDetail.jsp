<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">
	<button class="btn btn-secondary" onclick="history.back()">back</button>
	<sec:authorize access="hasRole('ROLE_USER')">
		<c:if test="${freeboard.users.num==principal.user.num}">
			<button id="btn-delete" class="btn btn-danger">delete</button>
			<a href="/board/${freeboard.num}/freeUpdateForm" class="btn btn-warning">update</a>
		</c:if>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<button id="btn-delete" class="btn btn-danger" value="${freeboard.users.num}">delete </button>
		
	</sec:authorize>
	<div>
	<br />
	<br />
	
	<div>
		조회수:<span id="count"><i>${freeboard.count}</i></span>
		글번호:<span id="num"><i>${freeboard.num}</i></span>
		작성자:<span><i>${freeboard.users.username}</i></span>
	</div>
	<h3>${freeboard.title}</h3>
	</div>
	<hr>
	<div>
		<div>${freeboard.content}</div>
	</div>
	<hr />

</div>
<br>
<script type="text/javascript" src="/js/freeboard.js">

</script>
<%@ include file="../layout/footer.jsp" %>
