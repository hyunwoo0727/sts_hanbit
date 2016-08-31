<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<section id="admin_content" class="row" style="margin-top: 30px;">
	<div class="col-sm-6 col-md-4">
		<div class="thumbnail">
			<img id="img_admin_member">
			<div class="caption">
				<h3></h3>
				<p></p>
			</div>
		</div>
	</div>
	<div class="col-sm-6 col-md-4">
		<div class="thumbnail">
			<img id="img_admin_account">
			<div class="caption">
				<h3></h3>
				<p></p>
			</div>
		</div>
	</div>
	<div class="col-sm-6 col-md-4">
		<div class="thumbnail">
			<img id="img_admin_grade">
			<div class="caption">
				<h3></h3>
				<p></p>
			</div>
		</div>
	</div>
</section>
<script>
$(function() {
	$('#img_admin_member').attr('src',session.getImgPath()+'/default/member_mng.png').css('width','100px').css('height','100px');
	$('#img_admin_account').attr('src',session.getImgPath()+'/default/account_mng.png').css('width','100px').css('height','100px');
	$('#img_admin_grade').attr('src',session.getImgPath()+'/default/grade_mng.png').css('width','100px').css('height','100px');
});
</script>
