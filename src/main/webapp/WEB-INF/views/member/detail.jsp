<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<section class="box" style="width: 70%;">
	<h1>회원 정보</h1>
	<table id="member_details">
		<tr>
			<td rowspan="6" style="width: 30%;"><img id="profile_img" width="300" height="300" src="${ctp}/resources/img/member/${user.profileImg }" /></td>
			<td style="width: 20%;">ID</td>
			<td style="width: 40%;">${user.memId}</td>
		</tr>
		<tr>
			<td>NAME</td>
			<td>${user.name}</td>			
		</tr>
		<tr>
			<td>이메일</td>
			<td>${user.email }</td>
		</tr>
		<tr>
			<td>학과</td>
			<td>${user.majorSeq }</td>
		</tr>
		<tr>
			<td>번호</td>
			<td>${user.phone }</td>
		</tr>
		<tr>
			<td>성별</td>
			<td >${user.gender }</td>
		</tr>
		<tr>
			<td>수강과목</td>
			<td colspan="2">${user.subjects }</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td colspan="2"><%-- ${user.birth } --%></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td colspan="2">${user.regDate }</td>
		</tr>
	</table>	
	<a href="#"><img id="img_home"/></a>
</section>	