<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div id="content">
	<form id="member_login_form" class="form-signin" method="post">
		<h2 class="form-signin-heading">Please sign in</h2>
		<label for="inputEmail" class="sr-only"></label> 
		<input type="text" name="userid" class="form-control"	placeholder="USER ID" required autofocus>
		<label for="inputPassword" class="sr-only">Password</label> 
		<input type="password" name="userpw" id="inputPassword" class="form-control" placeholder="PASSWORD" required>
		<input type="hidden"/>
		<div class="checkbox">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	</form>
</div>