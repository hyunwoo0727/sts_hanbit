var member = (function() {	
	return{
		init : function() {
			var ctx = sessionStorage.getItem("context");
			$('.box li a').click(function(e){
				location.href= ctx+"/member/" + e.target.getAttribute('id');
			});
			
		}
	};
})();