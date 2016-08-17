<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<div class="box">
		<div style="width: 300px; margin: 0 auto; text-align: left;">
		<h1>계좌 관리</h1> <br />
		<ol>
			<li><a href="${context}/account.do?page=regist">통장개설</a></li>
			<li><a href="${context}/account.do?page=deposit">입금</a></li>
			<li><a href="${context}/account.do?page=withdraw">출금</a></li>
			<li><a href="${context}/account.do?page=update">수정</a></li>
			<li><a href="${context}/account.do?page=delete">해지</a></li>
			<li><a href="${context}/account.do?page=list">목록</a></li>
			<li><a href="${context}/account.do?page=search">계좌(계좌)</a></li>
			<li><a href="${context}/account.do?page=count">계좌수</a></li>
		</ol>
		<a href="${context}/home.do"><img src="${img}/home.png" alt="home" width="50" height="50"/></a>
		<a href="${context}/member.do?page=logout"><img src="${img}/logout.png" alt="home" width="50" height="50"/></a>
		</div>
</div>
