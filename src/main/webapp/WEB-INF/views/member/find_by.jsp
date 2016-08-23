<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<style type="text/css">
	iframe.ifrm{
		border: none; width: 400px; height: 400px;
	}
	</style>
	<div class="box">
		<h1>ID 검색</h1>
		<form action="${context}/member.do" method="get">
			검색어 : <input type="text" name="keyword" placeholder="검색할 ID"/> <br />	
			<input type="hidden" name="action" value="find_by_id" />
			<input type="hidden" name="page" value="detail" />
			<input type="submit" value="검색" />
			<input type="reset" value="취소" />
		</form>
		<form action="${context}/member.do" method="get">
			검색어 : <input type="text" name="keyword" placeholder="검색할 이름"/> <br />	
			<input type="hidden" name="action" value="find_by_name" />
			<input type="hidden" name="page" value="list" />
			<input type="submit" value="검색" />
			<input type="reset" value="취소" />
		</form>
		<a href="${context}/global.do"><img src="${img}/home.png" alt="home" width="50" height="50"/></a>
		<a href="${context}/member.do?action=logout"><img src="${img}/logout.png" alt="home" width="50" height="50"/></a>
	</div>
