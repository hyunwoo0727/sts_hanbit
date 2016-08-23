var admin = (function() {
	var _pass;
	var getPass = function() { return this._pass };
	var setPass = function(pass) { this._pass = pass; };
	return {
		init : function() {
			$("#a_admin").click(admin.checkAdmin);
		},
		setPass : setPass,
		getPass : getPass,
		checkAdmin : function() {
			var isAdmin = confirm('관리자셈?');
			if(!isAdmin){
				alert('관리자만 접근 가능');
			}else{
				var password = prompt('관리자 비번 입력');
				if(password ==1){
					location.href = sessionStorage.getItem("context") + "/global.do";
				}else{
					alert('비번이 틀려여');
				}
			}
		}
	};
})();