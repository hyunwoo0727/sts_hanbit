<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
* {
	box-sizing: border-box;
}

ul {
	list-style-type: none;
}

body {
	font-family: Verdana, sans-serif;
}

.month {
	padding: 70px 25px;
	width: 100%;
	background: #1abc9c;
}

.month ul {
	margin: 0;
	padding: 0;
}

.month ul li {
	color: white;
	font-size: 20px;
	text-transform: uppercase;
	letter-spacing: 3px;
}

.month .prev {
	float: left;
	padding-top: 10px;
}

.month .next {
	float: right;
	padding-top: 10px;
}

.weekdays {
	margin: 0;
	padding: 10px 0;
	background-color: #ddd;
}

.weekdays li {
	display: inline-block;
	width: 13.6%;
	color: #666;
	text-align: center;
}

.days {
	padding: 10px 0;
	background: #eee;
	margin: 0;
}

.days li {
	list-style-type: none;
	display: inline-block;
	width: 13.6%;
	text-align: center;
	margin-bottom: 5px;
	font-size: 12px;
	color: #777;
}

.active_day {
	padding: 5px;
	background-color: #1abc9c;
	color: white !important
}

/* Add media queries for smaller screens */
@media screen and (max-width:720px) {
	.weekdays li, .days li {
		width: 13.1%;
	}
}

@media screen and (max-width: 420px) {
	.weekdays li, .days li {
		width: 12.5%;
	}
	.active_day {
		padding: 2px;
	}
}

@media screen and (max-width: 290px) {
	.weekdays li, .days li {
		width: 12.2%;
	}
}
</style>

<section class="box">
	<article class="month">
		<ul>
			<li class="prev">❮</li>
			<li class="next">❯</li>
			<li><span id="span_year" style="font-size: 18px">2016</span><br>
			<span id="span_month">August</span>
			<input type="hidden" id="year" />
			<input type="hidden" id="month" />
			<input type="hidden" id="day" />
			</li>
		</ul>
	</article>

	<ul class="weekdays">
		<li>Mo</li>
		<li>Tu</li>
		<li>We</li>
		<li>Th</li>
		<li>Fr</li>
		<li>Sa</li>
		<li>Su</li>
	</ul>

	<ul class="days">
		<li>1</li>
		<li>2</li>
		<li>3</li>
		<li>4</li>
		<li>5</li>
		<li>6</li>
		<li>7</li>
		<li>8</li>
		<li>9</li>
		<li>10</li>
		<li>11</li>
		<li>12</li>
		<li>13</li>
		<li>14</li>
		<li>15</li>
		<li>16</li>
		<li>17</li>
		<li>18</li>
		<li>19</li>
		<li>20</li>
		<li>21</li>
		<li>22</li>
		<li>23</li>
		<li>24</li>
		<li>25</li>
		<li>26</li>
		<li>27</li>
		<li>28</li>
		<li>29</li>
		<li>30</li>
		<li>31</li>
	</ul>
	<form class="navbar-form navbar-left" role="search"
		style="width: 100%;">
		<div class="form-group">
			<div class="col-lg-6" style="width: 100%;">
				<select style="width: 100px; height: 30px;">
					<option value="id"></option>
					<option value="name">ID</option>
					<option value="gender">NAME</option>
				</select> <input type="text" name="keyword" class="form-control"
					placeholder="Search" style="width: 50%;">
				<button type="submit" class="btn btn-primary">SEARCH</button>
			</div>
		</div>
	</form>
</section>
<script type="text/javascript">
$(function() {
	$('.days li').each(function(index) {
		$(this).click(function(index) {
		/* 	alert($(this).text());
			$(this).addClass('active_day'); */
		})
	})
})
</script>