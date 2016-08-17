//var application = (function(){})();   IIFE PATTERN

var application = function() {  // ( ) 안에서만 살 수 있음.. 밖에선 인식 안됨.
	var getContextPath = function() {
		return sessionStorage.getItem("context");
	};
	var init = function(param) {
		document.querySelector("#bt_home").addEventListener('click',this.goHome,false);
		sessionStorage.setItem('context',param);
	};
	var goHome = function() {
		location.href = application.getContextPath() + "/home.do";
	}
	var to_douglas = function() {
		location.href = application.getContextPath() + "/douglas.do";		
	};
	return {
		init : init,
		to_douglas : to_douglas,
		getContextPath : getContextPath,
		goHome : goHome
	};	
}();

