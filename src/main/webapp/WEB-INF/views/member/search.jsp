<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section id="content">
	<form id="member_find_form" class="navbar-form navbar-left" role="search" style="width: 100%;">
		<div class="form-group">
			<div class="col-lg-6" style="width: 100%;">
				<select name="select_option" style="width: 100px;height: 30px;">
					<option value="id">ID</option>
					<option value="name">NAME</option>
					<option value="gender">GENDER</option>
				</select>
			<input type="text" name="keyword" class="form-control" placeholder="Search" style="width: 50%;">
		<!-- 	<input type="hidden" /> -->
			<button id="btn_search" type="submit" class="btn btn-primary">SEARCH</button>
			</div>
		</div>
	</form>
</section>