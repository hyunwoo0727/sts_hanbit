<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<section id="content">
	<form class="navbar-form navbar-left" role="search" style="width: 100%;">
		<div class="form-group">
			<div class="col-lg-6" style="width: 100%;">
				<select id="account_option" style="width: 100px;height: 30px;">
					<option value="open">개 설</option>
					<option value="delete">해 지</option>
				</select>
			<input type="text" id="input_open_account" name="keyword" class="form-control" placeholder="비밀번호" style="width: 50%;">
			<input type="text" id="input_delete_account" name="keyword" class="form-control" placeholder="계좌번호" style="width: 50%;display: none;">
			<button type="submit" class="btn btn-primary">실 행</button>
			</div>	
		</div>
	</form>
</section>