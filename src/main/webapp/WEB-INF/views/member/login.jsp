<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<div class="box">
	<form action="${context}/member.do" method="post">
		<span class="meta">ID</span> <input type="text" name="id" /> <br /> 
		<span class="meta">비밀번호</span> <input	type="password" name="pw" /> <br /> 
		<br /><br /> 
		<input class="btn" type="submit" value="로그인" /> <input	class="btn" type="reset" value="취 소" />
		<input type="hidden" name="action" value="login" />
		<input type="hidden" name="directory" value="global" />
	</form>
</div>
<jsp:include page="../global/footer.jsp" />
<jsp:include page="../global/end.jsp" />