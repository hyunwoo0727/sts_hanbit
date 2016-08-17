<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<jsp:include page="../global/nav.jsp" />	
	<div class="box">
	<h2>현재 회원은 ${cnt } 명 입니다</h2>  <br />
	<a href="${context}/global.do"><img src="${img}/home.png" alt="home" width="50" height="50"/></a>
	<a href="${context}/member.do?action=logout"><img src="${img}/logout.png" alt="home" width="50" height="50"/></a>
	</div>
	
<jsp:include page="../global/footer.jsp" />
<jsp:include page="../global/end.jsp" />