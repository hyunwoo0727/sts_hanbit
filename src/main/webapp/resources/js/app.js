var app = (function() {  // ( ) 안에서만 살 수 있음.. 밖에선 인식 안됨.
	var getContextPath = function() {
		return sessionStorage.getItem("context");
	}
	var js = function() {
		return sessionStorage.getItem('js');
	}
	var css = function() {
		return sessionStorage.getItem('css');
	}
	var img = function() {
		return sessionStorage.getItem('img');
	}
	var init = function(param) {
		sessionStorage.setItem('context',param); 
		sessionStorage.setItem('js',param+'/resources/js');
		sessionStorage.setItem('css',param+'/resources/css');
		sessionStorage.setItem('img',param+'/resources/img');
		$('#img_home').attr('src',app.img()+'/home.png').attr('alt','home').css('width','50').css('height','50');
		$('#img_logout').attr('src',app.img()+'/logout.png').attr('alt','logout').css('width','50').css('height','50');
		$('#content').addClass('box').addClass('font_large');
		$('#content > article').css('width','300px').addClass('el_center').addClass('text_left');
		
		
		$('#global_content').addClass('box');
		$('#global_content h2').text('서비스를 이용하시려면 회원가입을 하셔야 합니다');
		$('#member_regist').text('REGIST');
		$('#member_login').text('LOGIN');
		$('#a_admin').text('ADMIN MODE');
		
		$('.box a').addClass('pointer');
		app.move();
	}
	var to_douglas = function() {
		location.href = app.getContextPath() + "/douglas.do";		
	}
	var move = function() {
		$('#header').click(function() {
			location.href = app.getContextPath() + "/";
		});
		$('#nav a').click(function(e) {
			location.href = app.getContextPath()+"/"+e.target.getAttribute('id').split("_")[1]+"/main";
		});
		$('.box article a').click(function(e){
			if(e.target.getAttribute('id').includes("admin")&&!admin.checkAdmin()){
				return;
			}
			var aid = e.target.getAttribute('id').split("_");
			location.href= app.getContextPath()+"/"+aid[0]+"/" + aid[1];
		});
		$('#img_home').click(function() {
			location.href = app.getContextPath() + "/";
		})
		$('#img_logout').click(function() {
			location.href = app.getContextPath() + "/";
		})
	}
	return {
		init : init,
		to_douglas : to_douglas,
		getContextPath : getContextPath,
		move : move,
		js : js,
		css : css,
		img : img
	};	
})();

var admin = (function() {
	var _pass;
	var getPass = function() { return this._pass };
	var setPass = function(pass) { this._pass = pass; };
	return {
		setPass : setPass,
		getPass : getPass,
		checkAdmin : function() {
			var isAdmin = confirm('관리자셈?');
			if(!isAdmin){
				alert('관리자만 접근 가능');
			}else{
				var password = prompt('관리자 비번 입력');
				if(password ==1){
					location.href = app.getContextPath() + "/global.do";
				}else{
					alert('비번이 틀려여');
					return false;
				}
			}
		}
	};
})();