var app = (function() {  // ( ) 안에서만 살 수 있음.. 밖에선 인식 안됨.
	var getContextPath = function() {
		return sessionStorage.getItem("context");
	}
	var init = function(param) {
		app.move();
		sessionStorage.setItem('context',param);
	}
	var to_douglas = function() {
		location.href = app.getContextPath() + "/douglas.do";		
	}
	var move = function() {
		$("#header").click(function() {
			location.href = app.getContextPath() + "/";
		});
		$('#nav a').click(function(e) {
			location.href = app.getContextPath()+"/"+e.target.getAttribute('id').split("_")[1]+"/main";
		});
	}
	
	return {
		init : init,
		to_douglas : to_douglas,
		getContextPath : getContextPath,
		move : move
	};	
})();

