<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   <!-- 줄 -->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
	<div class="box">
		<div style="width: 300px; margin: 0 auto; text-align: left;">
		<h1>회원관리</h1> <br />
		<ol>
			<li><a href="${context}/member.do?action=list&page=list">전체보기</a></li>
			<li><a href="${context}/member.do?page=detail">내 정보보기</a></li>
			<li><a href="${context}/member.do?page=update">내정보수정</a></li>
			<li><a href="${context}/member.do?page=delete">탈퇴</a></li>
			<li><a href="${context}/member.do?page=find_by">검색</a></li>
			<li><a href="${context}/member.do?action=count&page=count">회원수</a></li>
		</ol>
		<a href="${context}/global.do"><img src="${img}/home.png" alt="home" width="50" height="50"/></a>
		<a href="${context}/member.do?action=logout"><img src="${img}/logout.png" alt="home" width="50" height="50"/></a>
		</div>
	</div>	
