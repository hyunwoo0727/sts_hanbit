<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/member.css" />
	<div class="box">
		<h1>회원 정보 수정</h1>
		<form action="${context}/member.do" method="post">
		<input type="hidden" name="action" value="update" />
		<input type="hidden" name="page" value="detail" />		
			<table id="member_detail">
				<tr>
					<td rowspan="6" style="width: 30%;"><img src="${img}/member/${user.profileImg}" alt="wwwe.com" width="300" height="300" /></td>
					<td class="fontBold bg_color_yellow" style="width: 20%;">ID</td>
					<td style="width: 40%;">${user.id}</td>
				</tr>
				<tr>
					<td class="fontBold bg_color_yellow">PW</td>
					<td><input type="text" name="pw" value="${user.pw}" /></td>			
				</tr>
				<tr>
					<td class="fontBold bg_color_yellow">NAME</td>
					<td>${user.name}</td>			
				</tr>
				<tr>
					<td class="fontBold bg_color_yellow">이메일</td>
					<td><input type="text" name="email" value="${user.email}" /></td>
				</tr>
				<tr>
					<td class="fontBold bg_color_yellow">전화번호</td>
					<td>${user.phone }</td>
				</tr>
				<tr>
					<td class="fontBold bg_color_yellow">성별</td>
					<td>${user.gender}</td>
				</tr>
				<tr>
					<td class="fontBold bg_color_yellow">생년월일</td>
					<td colspan="2">${user.birth}</td>
				</tr>
				<tr>
					<td class="fontBold bg_color_yellow">등록일</td>
					<td colspan="2">${user.regDate}</td>
				</tr>
			</table>	
			<input class="btn" type="submit" value="수정" /> <input class="btn" type="reset" value="취소" />
		</form>	
		<a href="${context}/global.do"><img src="${img}/home.png" alt="home" width="50" height="50"/></a>
		<a href="${context}/member.do?action=logout"><img src="${img}/logout.png" alt="home" width="50" height="50"/></a>
	</div>
