<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pgSize" value="10"/>
<c:choose>
	<c:when test="${totCount % pgSize eq 0 }">
		<c:set var="totPg" value="${totCount/pgSize}" />
	</c:when>
	<c:otherwise>
		<c:set var="totPg" value="${totCount/pgSize+1}" />
	</c:otherwise>
</c:choose>
<c:set var="startPg" value="${pgNum - ((pgNum-1)%pgSize) }" />
<c:choose>
	<c:when test="${startPg + pgSize-1 le totPg }">
		<c:set var="lastPg" value="${startPg + pgSize-1}" />
	</c:when>
	<c:otherwise>
		<c:set var="lasgPg" value="${totPg }" />
	</c:otherwise>
</c:choose>
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
</div>