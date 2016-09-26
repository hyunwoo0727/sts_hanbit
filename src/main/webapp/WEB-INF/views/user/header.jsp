<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<nav id="header" class="navbar navbar-inverse" style="height: 15%;">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
   	  <img id="user_header_brand"/>
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">성적 정보<span class="caret"></span></a>
					<ul id="ul_grade" class="dropdown-menu">
						<li><a href="#">최근 성적</a></li>
						<li><a href="#">지난 성적</a></li>
						<li role="separator" class="divider"></li>
					
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">계좌 정보<span class="caret"></span></a>
					<ul id="ul_account" class="dropdown-menu">
						<li><a href="#">계좌 정보</a></li>
						<li><a href="#">계좌 생성</a></li>
						<li><a href="#">입/출금</a></li>
						<li><a href="#">해 지</a></li>
						<li role="separator" class="divider"></li>
					</ul>
				</li>
			</ul>
			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">과목별 조회</button>
			</form>
			<ul id="user_menu" class="nav navbar-nav navbar-right" style="padding-top: 10px;">
				<li>
					<div style="font-weight: bold; font-size: x-large;height: 49px;color: white;">
 					${user.name }님 환영합니다
 					</div>
				</li>
				<li>
					<button id="btn_logout" type="button" class="btn btn-default btn-lg" style="height: 40px;">
						<span class="glyphicon glyphicon-off" aria-hidden="true"></span>
					</button>
				</li>
				<li class="dropdown" style="height: 60px;">
					<a href="#"	class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="padding: 0px 0px 0px 5px;">
						<button type="button" class="btn btn-default btn-lg" style="height: 40px;">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</button>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a id="member_content" href=#>마이페이지</a></li>
						<li><a id="member_detail" href=#>내 정보 보기</a></li>
						<li><a id="member_update" href=#>내 정보 수정</a></li>
						<li><a id="member_delete" href=#>회원탈퇴</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">비밀번호 변경</a></li>
					</ul>
				</li>
			</ul>
		</div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<script type="text/javascript">
	$("#pub_header").on('click','#btn_logout',function(){
		controller.move('member','logout');
	});
	$('#pub_header').on('click','#member_detail',function(e){
		member.detail();
	})
</script>