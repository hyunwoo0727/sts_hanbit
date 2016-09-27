<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<article class="box">
	<h1>목록보기</h1>
	<table id="member_list">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>REGDATE</th>
			<th>BIRTH</th>
			<th>EMAIL</th>
			<th>PHONE</th>
			<th>grade</th>
		</tr>
		<c:forEach items="${list}" var="member">
			<tr>
				<td><a href="#">${member.memId}</a></td>
				<td>${member.name}</td>
				<td>${member.regDate}</td>
				<td>${member.ssn.substring(0,member.ssn.length())}</td>
				<td>${member.email}</td>
				<td>${member.phone}</td>
				<td>grade자리</td>
			</tr>
		</c:forEach>
	</table>
</article>