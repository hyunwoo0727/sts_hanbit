<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="box">
		<h1>목록보기</h1>
		<table id="member_list">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>REGDATE</th>
				<th>BIRTH</th>
				<th>EMAIL</th>
				<th>PHONE</th>
			</tr>
			<c:forEach items="${list}" var="member">
				<tr>
					<td><a href="${context}/member.do?action=find_by_id&page=detail&keyword=${member.id}">${member.id}</a></td>
					<td>${member.name}</td>
					<td>${member.regDate}</td>
					<td>${member.birth}</td>
					<td>${member.email }</td>
					<td>${member.phone }</td>
				</tr>
			</c:forEach>
			
		</table>
		<a href="${context}/global.do"><img src="${img}/home.png" alt="home" width="50" height="50"/></a>
		<a href="${context}/member.do?action=logout"><img src="${img}/logout.png" alt="home" width="50" height="50"/></a>
	</div>
