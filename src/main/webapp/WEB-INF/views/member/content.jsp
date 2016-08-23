<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   <!-- 줄 -->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
	<div class="box">
		<div style="width: 300px; margin: 0 auto; text-align: center;">
		<h1>회원관리</h1> <br />
		<ol style="text-align: left">
			<li><a id="regist" href="#">등록</a></li>
			<li><a id="list" href="#">전체보기</a></li>
			<li><a id="detail" href="#">내 정보보기</a></li>
			<li><a id="update"href="#">내정보수정</a></li>
			<li><a id="delete"href="#">탈퇴</a></li>
			<li><a id="find_by" href="#">검색</a></li>
			<li><a id="count" href="#">회원수</a></li>
		</ol>
		<a href="#"><img src="${img}/home.png" alt="home" width="50" height="50"/></a>
		<a href="#"><img src="${img}/logout.png" alt="home" width="50" height="50"/></a>
		</div>
	</div>	
