<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<section id="content">
	<div class="panel panel-default">
	  <!-- Default panel contents -->
	  <div class="panel-heading">계좌목록</div>
	  <!-- Table -->
	  <table id="member_list" class="table">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>ACCOUNT NO</th>
			<th>MONEY</th>
		</tr>
		<c:forEach items="${list}" var="account">
			<tr>
				<td>${account.id}</td>
				<td>${account.name }</td>
				<td><a href="${context}/member.do?action=find_by_id&page=detail&keyword=${member.id}">${account.accountNo }</a></td>
				<td>${account.money }</td>
			</tr>
		</c:forEach>
	</table>	
	</div>
	<a href="#"><img id="img_home"/></a>
	<a href="#"><img id="img_logout"/></a>
</section>