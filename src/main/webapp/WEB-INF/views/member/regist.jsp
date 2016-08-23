<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
	<div class="box" style="width: 700px;">
		<form action="${context}/member.do" method="post">
			<input type="hidden" name="action" value="regist" />
			<input type="hidden" name="page" value="login" />
			<span class="meta">이름</span> <input type="text" name="name" /> <br/>
			<span class="meta">ID</span> <input type="text" name="id" /> <br/>
			<span class="meta">비밀번호</span> <input type="password" name="pw"/> <br/>
			<span class="meta">EMAIL</span> <input type="text" name="email" /> <br/>
			<span class="meta">SSN</span> <input type="text" name="ssn" /> <br/>
			<span class="meta">전화번호(-포함)</span> <input type="text" name="phone" /> <br/>
			<span class="meta">전공</span> 
			<input type="radio" name="major" value="computer" checked /> 컴공학부
			<input type="radio" name="major" value="mgmt" /> 경영학부
			<input type="radio" name="major" value="math" />수학부 
			<input type="radio" name="major" value="eng" /> 영문학부 <br /> <br />
			<span class="meta">수강과목</span>  
			<input type="checkbox" name="subject" value="java"/> Java
			<input type="checkbox" name="subject" value="SQL"/> SQL
			<input type="checkbox" name="subject" value="cpp"/> C++
			<input type="checkbox" name="subject" value="python"/> 파이썬
			<input type="checkbox" name="subject" value="delphi"/> 델파이
			<input type="checkbox" name="subject" value="HTML"/> HTML <br /> <br /><br />
			
			<input class="btn" type="submit" value="회원가입" />
			<input class="btn" type="reset" value="취 소"/>
		</form> 
	</div>
