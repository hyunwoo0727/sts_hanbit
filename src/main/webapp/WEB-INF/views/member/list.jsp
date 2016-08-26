<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section id="content">
	<div class="panel panel-default">
	  <!-- Default panel contents -->
	  <div class="panel-heading">학생 목록</div>
	  <!-- Table -->
	  <table id="member_list" class="table">
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
	</div>
	<a href="#"><img id="img_admin_home"/></a>
	<a href="#"><img id="img_logout"/></a>
</section>
