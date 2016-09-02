<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<section class="formbox">
	<p>회원정보 입력</p>
	이름 : <input type="text" id="name" name="name" value="" /> <br />
	SSN : <input type="text" id="ssn" name="ssn" value="" /> <br />
	<button id="bt_spec_show">회원정보 생성</button>
	<button id="bt_make_account">통장개설</button>
</section>
<section class="databox">
	<p>회원 정보</p>
	이름 : <article id="name"></article>
	나이 : <article id="age"></article>
	성별 : <article id="gender"></article>
	계좌번호 : <article id="account"></article>
	잔액 : <article id="money"></article> 
</section>
<section class="formbox">
	<p>입/출금</p>
	금액 : <input type="text" id="money" name="money" value="" /> <br />
	<button id="bt_deposit">입금</button>
	<button id="bt_withdraw">출금</button>
</section>
