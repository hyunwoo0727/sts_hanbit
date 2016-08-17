<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<jsp:include page="../global/nav.jsp" />
	<div class="box">
	<embed src="${img}/cat.gif" type="" /> <br />
	탈퇴 페이지 <br/>
	<form action="${context}/member.do">
		비밀번호 확인 : <input type="password" name="pw" />
		<input type="hidden" name="id" value="${user.id}" />
		<input class="btn" type="submit" value="탈퇴" />
		<input type="hidden" name="action" value="delete" />
		<input type="hidden" name="directory" value="home" />
	</form>
	<a href="${context}/global.do"><img src="${img}/home.png" alt="home" width="50" height="50"/></a>
		<a href="${context}/member.do?action=logout"><img src="${img}/logout.png" alt="home" width="50" height="50"/></a>
	</div>
<jsp:include page="../global/footer.jsp" />
<jsp:include page="../global/end.jsp" />