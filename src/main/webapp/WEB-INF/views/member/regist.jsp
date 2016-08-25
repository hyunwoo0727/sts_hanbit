<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
	<section id="member_regist_content">
		<form id="member_regist_form" action="${context}/member.do" method="post">
			<div>
			    <label for="exampleInputEmail1">NAME</label>
			    <div><input type="text" id="username" placeholder="NAME"></div>
			</div>
			<div>
			    <label for="exampleInputEmail2">ID</label>
			    <div><input type="text" id="id" placeholder="ID"></div>
			</div>
			<div>
			    <label for="exampleInputEmail3">PASSWORD</label>
			    <div><input type="password" id="password" placeholder="PASSWORD"></div>
			</div>
			<div>
			    <label for="exampleInputEmail4">EMAIL</label>
			    <div><input type="email" id="email" placeholder="abc@email.com"></div>
			</div>
			<div>
			    <label for="exampleInputEmail5">SSN</label>
			    <div><input type="text" id="ssn" placeholder="ex)000000-1"></div>
			</div>
			<div>
			    <label for="exampleInputEmail6">PHONE</label>
			    <div><input type="text" id="phone" placeholder="ex)010-0000-0000"></div>
			</div>
			<div>
				<label for="exampleInputEmail7">MAJOR</label>
				<div>
					<label><input type="radio" name="major" id="inlineRadio1" value="computer" checked>컴공학부</label>
					<label><input type="radio" name="major" id="inlineRadio2" value="mgmt">경영학부</label>
					<label><input type="radio" name="major" id="inlineRadio3" value="math">수학부</label>
					<label><input type="radio" name="major" id="inlineRadio3" value="eng">영문학부</label>
				</div>
			</div>
			<div>
				<label for="exampleInputEmail5">SUBJECT</label>
				<div>
					<div>
						<label><input type="checkbox" id="inlineCheckbox1" name="subject" value="java">Java</label>
						<label><input type="checkbox" id="inlineCheckbox2" name="subject" value="SQL">SQL</label>
						<label><input type="checkbox" id="inlineCheckbox3" name="subject" value="cpp">C++</label>
						<label><input type="checkbox" id="inlineCheckbox4" name="subject" value="python">파이썬</label>
						<label><input type="checkbox" id="inlineCheckbox5" name="subject" value="delphi">델파이</label>
						<label><input type="checkbox" id="inlineCheckbox6" name="subject" value="HTML">HTML</label>
					</div>
				</div>
			</div>
			<input id="bt_join" type="submit" value="회원가입" />
			<input id="bt_cancel" type="reset" value="취 소"/>
		</form> 
	</section>
