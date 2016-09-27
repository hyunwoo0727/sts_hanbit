<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="box" style="width: 90%;">
	<article style='padding-top: 0'>
		<ul class="list-group">
			<li class="list-group-item">총 학생수 ${totCount} 명</li>
		</ul>
		<div class="panel panel-primary">
			<div class="panel-heading">성적 리스트</div>
			<div class="panel-body"></div>
			<table id="member_list">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>REGDATE</th>
					<th>GENDER</th>
					<th>BIRTH</th>
					<th>EMAIL</th>
					<th>PHONE</th>
					<th>EDIT</th>
				</tr>
				<tbody>
					<c:forEach items="${list}" var="user">
						<tr>
							<td><a href="#">${user.memId}</a></td>
							<td>${user.name}</td>
							<td>${user.regDate}</td>
							<td>${user.gender}</td>
							<td>${user.ssn.substring(0,user.ssn.length())}</td>
							<td>${user.email}</td>
							<td>${user.phone}</td>
							<td>수정 / 삭제</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<nav aria-label="Page navigation" style="height: 20%;">
				<ul class="pagination">
					<c:if test="${startPg - pgSize gt 0 }">
						<li><a href="${ctp}/member/list/${startPg-pgSize}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:forEach begin="${startPg }" end="${lastPg }" step="1" varStatus="i">
						<c:choose>
							<c:when test="${i.index == pgNum }">
								<font color="red">${i.index }</font>
							</c:when>
							<c:otherwise>
								<a href="${ctp}/member/list/${i.index }">${i.index }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${startPg + pgSize le totPg}">
						<li><a href="${ctp}/member/list/${startPg-pgSize}" aria-label="Next"> <span aria-hidden="true">&laqui;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
			<div align="center">
				<form action="${ctp}/member/search">
					<select name="keyField" id="">
						<option value="name" selected>이름</option>
						<option value="mem_id">ID</option>
					</select>
					<input type="text" name="keyword">
					<input type="submit" value="검 색">
				</form>
			</div>
	</article>
</section>