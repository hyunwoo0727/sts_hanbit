<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/member.css" />
	<div class="box" style="width: 70%;">
		<h1>회원 정보</h1>
		<table id="member_detail">
			<tr>
				<td rowspan="6" style="width: 30%;"><img src="${img}/member/${user.profileImg}" width="300" height="300" /></td>
				<td class="fontBold bg_color_yellow" style="width: 20%;">ID</td>
				<td style="width: 40%;">${user.id}</td>
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">NAME</td>
				<td>${user.name}</td>			
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">이메일</td>
				<td>${user.email }</td>
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">학과</td>
				<td>${user.major }</td>
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">번호</td>
				<td>${user.phone }</td>
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">성별</td>
				<td >${user.gender }</td>
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">수강과목</td>
				<td colspan="2">${user.subjects }</td>
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">생년월일</td>
				<td colspan="2">${user.birth }</td>
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">등록일</td>
				<td colspan="2">${user.regDate }</td>
			</tr>
		</table>	
		<a href="${context}/global.do"><img src="${img}/home.png" alt="home" width="50" height="50"/></a>
		<a href="${context}/member.do?action=logout"><img src="${img}/logout.png" alt="home" width="50" height="50"/></a>	
	</div>
