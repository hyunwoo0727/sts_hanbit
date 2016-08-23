<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../global/header.jsp" />
<jsp:include page="../../global/nav.jsp" />
	<style>
	table {
		font-family: arial, sans-serif;
		border-collapse: collapse;
		width: 100%;
	}
	td, th {
		border: 1px solid #dddddd;
		text-align: left;
		padding: 8px;
	}
	tr:nth-child(even) {
		background-color: #dddddd;
	}
	</style>
	<div class="box">
		검색 결과 <br />
		<table>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>REGDATE</th>
				<th>BIRTH</th>
			</tr>
		</table>
		<a href="${context}/global.do"><img src="${img}/home.png" alt="home" width="50" height="50"/></a>
		<a href="${context}/member.do?action=logout"><img src="${img}/logout.png" alt="home" width="50" height="50"/></a>
	</div>
<jsp:include page="../../global/footer.jsp" />
<jsp:include page="../../global/end.jsp" />