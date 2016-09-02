<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="apple-touch-icon" sizes="57x57"
	href="${img}/favicons/apple-touch-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60"
	href="${img}/favicons/apple-touch-icon-60x60.png">
<link rel="icon" type="image/png"
	href="${img}/favicons/favicon-32x32.png" sizes="32x32">
<link rel="icon" type="image/png"
	href="${img}/favicons/favicon-16x16.png" sizes="16x16">
<link rel="manifest" href="${img}/favicons/manifest.json">
<link rel="shortcut icon" href="${img}/favicons/favicon.ico">
<!-- Normalize -->
<link rel="stylesheet" type="text/css" href="${css}/normalize.css">
<!-- Owl -->
<link rel="stylesheet" type="text/css" href="${css}/owl.css">
<!-- Animate.css -->
<link rel="stylesheet" type="text/css" href="${css}/animate.css">
<!-- Font Awesome -->
<link rel="stylesheet" type="text/css"
	href="${font}/font-awesome-4.1.0/css/font-awesome.min.css">
<!-- Elegant Icons -->
<link rel="stylesheet" type="text/css"
	href="${font}/eleganticons/et-icons.css">
<!-- Main style -->
<link rel="stylesheet" type="text/css" href="${css}/cardio.css">
<section id="services" class="box section-padded">
	<div>
		<div class="row text-center title">
			<h2>Services</h2>
			<h4 class="light muted">Achieve the best results with our wide
				variety of training options!</h4>
		</div>
		<div class="row services">
			<div class="col-md-4">
				<div id="kaup" class="service">
					<div class="icon-holder">
						<img src="${img}/icons/kaup.png" alt="" class="icon">
					</div>
					<h4 class="heading">KAUP</h4>
					<p class="description">A elementum ligula lacus ac quam
						ultrices a scelerisque praesent vel suspendisse scelerisque a
						aenean hac montes.</p>
				</div>
			</div>
			<div class="col-md-4">
				<div id="rsp" class="service">
					<div class="icon-holder">
						<img src="${img}/icons/rsp.png" alt="" class="icon">
					</div>
					<h4 class="heading">ROCK SISSOR PAPER</h4>
					<p class="description">A elementum ligula lacus ac quam
						ultrices a scelerisque praesent vel suspendisse scelerisque a
						aenean hac montes.</p>
				</div>
			</div>
			<div class="col-md-4">
				<div id="lotto" class="service">
					<div class="icon-holder">
						<img src="${img}/icons/lotto.png" alt="" class="icon">
					</div>
					<h4 class="heading">LOTTO DRAWING</h4>
					<p class="description">A elementum ligula lacus ac quam
						ultrices a scelerisque praesent vel suspendisse scelerisque a
						aenean hac montes.</p>
				</div>
			</div>
		</div>
	</div>
	<div class="cut cut-bottom"></div>
</section>
<section id="team" class="section gray-bg">
	<div class="container">
		<div class="row title text-center">
			<h2 class="margin-top">Major Subject</h2>
			<h4 class="light muted">We're a dream team!</h4>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="team text-center">
					<div class="cover"
						style="background:url('${img}/team/team-cover1.jpg'); background-size:cover;">
						<div class="overlay text-center">
							<h3 class="white">$69.00</h3>
							<h5 class="light light-white">1 - 5 sessions / month</h5>
						</div>
					</div>
					<img src="${img}/team/team1.jpg" alt="Team Image" class="avatar">
					<div class="title">
						<h4>Java</h4>
						<h5 class="muted regular">Server Program Language</h5>
					</div>
					<button id="major_subject_1" data-toggle="modal" data-target="#modal1"
						class="btn btn-blue-fill">과목 정보 보기</button>
					<input type="hidden" value="java">
				</div>
			</div>
			<div class="col-md-4">
				<div class="team text-center">
					<div class="cover"
						style="background:url('${img}/team/team-cover2.jpg'); background-size:cover;">
						<div class="overlay text-center">
							<h3 class="white">$69.00</h3>
							<h5 class="light light-white">1 - 5 sessions / month</h5>
						</div>
					</div>
					<img src="${img}/team/team2.jpg" alt="Team Image" class="avatar">
					<div class="title">
						<h4>Javascript</h4>
						<h5 class="muted regular">UI Programming language</h5>
					</div>
					<button id="major_subject_2" data-toggle="modal" data-target="#modal1"
						class="btn btn-blue-fill ripple">과목 정보 보기</button>
					<input type="hidden" value="javascript">	
				</div>
			</div>
			<div class="col-md-4">
				<div class="team text-center">
					<div class="cover"
						style="background:url('${img}/team/team-cover3.jpg'); background-size:cover;">
						<div class="overlay text-center">
							<h3 class="white">$69.00</h3>
							<h5 class="light light-white">1 - 5 sessions / month</h5>
						</div>
					</div>
					<img src="${img}/team/team3.jpg" alt="Team Image" class="avatar">
					<div class="title">
						<h4>SQL</h4>
						<h5 class="muted regular">Database Language</h5>
					</div>
					<button id="major_subject_3" data-toggle="modal" data-target="#modal1"
						class="btn btn-blue-fill ripple">과목 정보 보기</button>
					<input type="hidden" value="sql">
				</div>
			</div>
		</div>
	</div>
</section>
<section id="pricing" class="section">
	<div class="container">
		<div class="row title text-center">
			<h2 class="margin-top white">Pricing</h2>
			<h4 class="light white">Choose your favorite pricing plan and
				sign up today!</h4>
		</div>
		<div class="row no-margin">
			<div class="col-md-7 no-padding col-md-offset-5 pricings text-center">
				<div class="pricing">
					<div class="box-main active" data-img="img/contentbg.jpg">
						<h4 class="white">Yoga Pilates</h4>
						<h4 class="white regular light">
							$850.00 <span class="small-font">/ year</span>
						</h4>
						<a href="#" data-toggle="modal" data-target="#modal1"
							class="btn btn-white-fill">Sign Up Now</a> <i
							class="info-icon icon_question"></i>
					</div>
					<div class="box-second active">
						<ul class="white-list text-left">
							<li>One Personal Trainer</li>
							<li>Big gym space for training</li>
							<li>Free tools &amp; props</li>
							<li>Free locker</li>
							<li>Free before / after shower</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<section class="section section-padded blue-bg">
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="owl-twitter owl-carousel">
					<div class="item text-center">
						<i class="icon fa fa-twitter"></i>
						<h4 class="white light">To enjoy the glow of good health, you
							must exercise.</h4>
						<h4 class="light-white light">#health #training #exercise</h4>
					</div>
					<div class="item text-center">
						<i class="icon fa fa-twitter"></i>
						<h4 class="white light">To enjoy the glow of good health, you
							must exercise.</h4>
						<h4 class="light-white light">#health #training #exercise</h4>
					</div>
					<div class="item text-center">
						<i class="icon fa fa-twitter"></i>
						<h4 class="white light">To enjoy the glow of good health, you
							must exercise.</h4>
						<h4 class="light-white light">#health #training #exercise</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- <div class="modal fade" id="modal1" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content modal-popup">
			<a href="#" class="close-link"><i class="icon_close_alt2"></i></a>
			<h3 class="white">Sign Up</h3>
			<form action="" class="popup-form">
				<input type="text" class="form-control form-white"
					placeholder="Full Name"> <input type="text"
					class="form-control form-white" placeholder="Email Address">
				<div class="dropdown">
					<button id="dLabel" class="form-control form-white dropdown"
						type="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Pricing Plan</button>
					<ul class="dropdown-menu animated fadeIn" role="menu"
						aria-labelledby="dLabel">
						<li class="animated lightSpeedIn"><a href="#">1 month
								membership ($150)</a></li>
						<li class="animated lightSpeedIn"><a href="#">3 month
								membership ($350)</a></li>
						<li class="animated lightSpeedIn"><a href="#">1 year
								membership ($1000)</a></li>
						<li class="animated lightSpeedIn"><a href="#">Free trial
								class</a></li>
					</ul>
				</div>
				<div class="checkbox-holder text-left">
					<div class="checkbox">
						<input type="checkbox" value="None" id="squaredOne" name="check" />
						<label for="squaredOne"><span>I Agree to the <strong>Terms
									&amp; Conditions</strong></span></label>
					</div>
				</div>
				<button type="submit" class="btn btn-submit">Submit</button>
			</form>
		</div>
	</div>
</div> -->
<script src="${js}/owl.carousel.min.js"></script>
<script src="${js}/wow.min.js"></script>
<script src="${js}/typewriter.js"></script>
<script src="${js}/jquery.onepagenav.js"></script>
<script src="${js}/main.js"></script>
<script type="text/javascript">
$(function() {
	$('#kaup').addClass('pointer').click(function(){controller.move('member','kaup')});
	$('#rsp').addClass('pointer').click(function(){controller.move('member','rsp')});
	$('#lotto').addClass('pointer').click(function(){controller.move('member','lotto')});
	$('#team .col-md-4 button').click(function() {
		controller.moveWithKey('subject','detail',$(this).siblings('input[type=hidden]').attr('value'));
	})	
})

	
	/* $('.modal-popup .close-link').click(function(event){
		event.preventDefault();
		$('#modal1').modal('hide');
	}); */
/* 	$('#major_subject_1').click(function() {controller.moveWithKey('subject','detail')});
	$('#major_subject_2').click(function() {});
	$('#major_subject_3').click(function() {}); */
</script>