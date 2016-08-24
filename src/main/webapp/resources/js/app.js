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
		$('#admin_main').text('ADMIN MODE');
		$('.box a').addClass('pointer');
		app.move();
	}
	var move = function() {
		$('#header').click(function() {
			util.home();
		});
		$('#nav a').click(function(e) {
			util.move(e.target.getAttribute('id').split("_")[1],"main");
		});
		$('.box article a').click(function(e){
			var aid = e.target.getAttribute('id').split("_");
			if(aid.includes("admin")&&!admin.checkAdmin()){
				return;
			}
			util.move(aid[0],aid[1]);
		});
		$('#img_home').click(function() {
			util.home();
		})
		$('#img_logout').click(function() {
			util.move('member','logout');
		})
	}
	return {
		init : init,
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
					return true;
				}else{
					alert('비번이 틀려여');
					return false;
				}
			}
		}
	};
})();



var user = (function() {
	return {
		init : function() {
			$('#bt_bom').click(function(){util.move('douglas','bom')});
			$('#bt_dom').click(function(){util.move('douglas','dom')});
			$('#bt_kaup').click(function(){util.move('douglas','kaup')});
			$('#bt_account').click(function(){util.move('douglas','account')});	
		}
	};
})();

var account = (function() {
	var _account_no,_money;
	var setAccountNo = function(account_no){this._account_no = account_no;}
	var getAccountNo = function(){return this._account_no;}
	var setMoney = function(money){this._money=money;}
	var getMoney = function(){return this._money;}
	return {
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		creator_init : function() {
			$("#bt_spec_show").click(member.spec);
			$("#bt_make_account").click(account.open);
			$("#bt_deposit").click(account.deposit);
			$("#bt_withdraw").click(account.withdraw);
		},
		open : function() {
			setAccountNo(Math.floor((Math.random()*899999)+100001));
			setMoney(0);
			$("#account").innerHTML = getAccountNo();
			$(".databox #money").innerHTML = getMoney();
		},
		deposit : function() {
			if(!util.isNumber(getAccountNo())){
				alert('통장부터 만드셈');
				
			}
			setMoney(getMoney() + Number($("input[id=money]").value));
			$(".databox #money").innerHTML = getMoney();
		},
		withdraw : function() {
			if(!util.isNumber(getAccountNo())){
				alert('통장부터 만드셈');
				return;
			}
			var withdraw_money = Number($("input[id=money]").value);	
			if(getMoney() < withdraw_money){
				alert('출금액이 더 큼');
			}else{
				setMoney(getMoney() - withdraw_money);
				$(".databox #money").innerHTML = getMoney();
			}
		}
	};
})();

var member = (function() {
	var _name = '', _ssn='', _gender='', _age=0;
	var setName = function(name){this._name=name;}
	var getName = function(){return this._name;}
	var setSsn = function(ssn){this._ssn=ssn;}
	var getSsn = function(){return this._ssn;}
	var setGender = function(gender){this._gender=gender;}
	var getGender = function(){return this._gender;}
	var setAge = function(age){this._age=age;}
	var getAge = function(){return this._age;}
	return {
		setName : setName,
		getName : getName,
		setSsn : setSsn,
		getSsn : getSsn,
		setGender : setGender,
		getGender : getGender,
		setAge : setAge,
		getAge : getAge,
		
		spec : function() {
			setName($(".formbox #name").value);
			setSsn($("#ssn").value);
			var scode = Number(getSsn().split("-")[1]);
			var ageYear = Number(getSsn().substring(0,2));
			var gen = (scode+2)%2==0? '여':'남';
			console.log('gender',gen);
			setGender(gen);
			console.log('gender',getGender());			
			var nowYear = new Date().getFullYear();
			switch (scode) {
			case 1:	case 2:	case 5:	case 6:
				setAge(nowYear - (1900 + ageYear) + 1);
				break;
			case 9:	case 0:
				setAge(nowYear - (1800 + ageYear) + 1);
				break;
			default:
				setAge(nowYear - (2000 + ageYear) + 1);
				break;
			}
			
			$('.databox #name').innerHTML = getName();
			$('#age').innerHTML = getAge();
			$('#gender').innerHTML = getGender();
		}
	};
})();
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
			$('#member_regist').text('REGIST');
			$('#member_login').text('LOGIN');
		}
	};
})();
var grade = (function(){
	return {
		init : function() {
			
		}
	};
})();

var util = (function() {
	var _page,_directory;
	var setPage = function(page) {this._page = page;}
	var getPage = function() {	return this._page;	}
	var setDirectory = function(directory) {this._directory = directory;}
	var getDirectory = function() {	return this._directory;	}
	return {
		move : function(directory,page) {
			util.setDirectory(directory);
			util.setPage(page);
			location.href = app.getContextPath() + '/'+util.getDirectory()+'/'+util.getPage();
		},
		isNumber : function isNumber(value) {
			  return typeof value === 'number' && isFinite(value);
		},
		home : function() { location.href = app.getContextPath() + "/"; },
		setPage : setPage,
		getPage : getPage,
		setDirectory : setDirectory,
		getDirectory : getDirectory
	};	
})();
