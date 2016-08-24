var member = (function() {	
	return{
		init : function() {
			$('#member_content').siblings("h1").text('MEMBER MANAGEMENT');
			$('#member_content_ol > li:first > a').text('SIGN UP').addClass('remove_underline');
			$('#member_content_ol > li:nth-child(2) > a').text('LIST').addClass('remove_underline');
			$('#member_content_ol > li:nth-child(3) > a').text('DETAIL').addClass('remove_underline');
			$('#member_content_ol > li:nth-child(4) > a').text('UPDATE').addClass('remove_underline');
			$('#member_content_ol > li:nth-child(5) > a').text('DELETE').addClass('remove_underline');
			$('#member_content_ol > li:nth-child(6) > a').text('SEARCH').addClass('remove_underline');
			$('#member_content_ol > li:nth-child(7) > a').text('COUNT').addClass('remove_underline');
	
		}
	};
})();