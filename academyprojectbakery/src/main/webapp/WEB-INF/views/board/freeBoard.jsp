<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<sec:authorize access="hasRole('ROLE_USER')">
		<button  class="nav-link" onclick="location.href='/board/freeSaveForm'; count();">게시판작성</button>
	</sec:authorize>	
		
		<c:forEach var="freeboard" items="${freeboards.content}">
			<div class="card m-2">
				<div class="card-body">
					<h4 class="card-title">${freeboard.title}</h4>
					<a href="/auth/board/${freeboard.num}" class="btn btn-primary">상세보기</a>
				</div>	
			</div>
		</c:forEach>
		<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${freeboards.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${freeboards.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${freeboards.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${freeboards.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${freeboards.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${freeboards.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
		  
		 
		</ul>
	</div>
	<br/>
	<%@ include file="../layout/footer.jsp" %>

</body>
</html>