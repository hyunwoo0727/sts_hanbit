<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<section id="grade_content">
	<h1 id="title">성적 관리</h1> <br />
		<article>
		<ol>
			<li><a href="#" id="a_regist">등록</a></li>
			<li><a href="#" id="a_update">수정</a></li>
			<li><a href="#" id="a_delete">삭제</a></li>
			<li><a href="#" id="a_list">목록</a></li>
			<li><a href="#" id="a_count">카운트</a></li>
			<li><a href="#" id="a_search">검색</a></li>
		</ol>
		<a href="${context}/global.do" id="home"><img src="${img}/home.png" alt="home" width="50" height="50"/></a>
		<a href="${context}/member.do?action=logout" id="logout"><img src="${img}/logout.png" alt="home" width="50" height="50"/></a>
		</article>
</section>
<script src="${js}/resig.js"></script>
<script type="text/javascript">
$(function() {
	grade.init();
});
</script>