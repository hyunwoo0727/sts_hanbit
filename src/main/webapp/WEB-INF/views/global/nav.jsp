<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="nav" style="width: 100%; padding: 0px;">
	<div
		style="float: right; font-weight: bold; font-size: xx-large; background-color: #333; color: white; height: 49px;">
		<%-- ${user.name }  --%>님 환영합니다</div>
	<ul>
		<li><a href="#" id="a_member">회원관리</a></li>
		<li><a href="#" id="a_grade">성적관리</a></li>
		<li><a href="#" id="a_account">계좌관리</a></li>
		<li><a href="#" id="a_school">학교소개</a></li>
	</ul>
</div>
<!-- <script type="text/javascript">
	$(function() {
		$('#nav a').click(function(e) {
			var aid = e.target.getAttribute('id');
			var ctx = sessionStorage.getItem("context");
			switch (aid) {
				case "a_school":
					location.href = ctx + "/global.do?page=school_info";
					break;
				default:
					location.href = ctx + "/"+aid.split("_")[1]+".do";
					break;
			}
		});
	})
</script> -->