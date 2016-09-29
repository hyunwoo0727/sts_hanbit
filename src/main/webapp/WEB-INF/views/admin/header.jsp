<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<nav id="header" class="navbar navbar-inverse" style="height: 15%;">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
   	  <img id="admin_header_brand" alt="hanbit" src="${img}/default/hanbit.png"/>
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
			
			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">test</button>
			</form>
			<ul id="user_menu" class="nav navbar-nav navbar-right" style="padding-top: 10px;">
				<li>
					<div style="font-weight: bold; font-size: x-large;height: 49px;color: white;">
 					관리자 모드
 					</div>
				</li>
				<li>
					<button id="btn_exit" type="button" class="btn btn-default btn-lg" style="height: 40px;">
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
						<li><a href="#">비밀번호 변경</a></li>
						<li role="separator" class="divider"></li>
					</ul>
				</li>
			</ul>
		</div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<script type="text/javascript">
$('#admin_header_brand').addClass('pointer').attr('src',session.getImgPath()+'/default/hanbit.png').attr('alt','hanbit').css('width','80px').css('height','70px').css('padding-bottom','5px');
$("#admin_header").on('click','#btn_logout',function(){
	controller.move('member','logout');
});
</script>