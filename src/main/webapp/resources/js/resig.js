var grade = (function(){
	return {
		init : function() {
			$('#grade_content').addClass('box');
			$('#grade_content > article').css('width','300px').css('margin','0 auto').css('text-align','left');
			$('#title').css('font-size','30px');
			$('#grade_content li a').click(function(e) {
				location.href = sessionStorage.getItem("context")+"/grade.do?page="+e.target.getAttribute('id').split("_")[1];	
			})
		}
	};
})();