var app = (function() {  // ( ) 안에서만 살 수 있음.. 밖에선 인식 안됨.
	var init = function(param) {
		session.init(param);
		user.init();
		account.init();
		member.init();
		grade.init();
		this.onCreate();
	}
	var setContentView = function() {
		// layout & global
		$('#footer').addClass('bottom');
		$('#nav').css('width','100%').css('padding','0px');
		$('#content').addClass('box').addClass('font_large');
		$('#content > article').css('width','300px').addClass('el_center').addClass('text_left');
		$('#global_content').addClass('box');
		$('#global_content h2').append('<small>서비스를 이용하시려면</small> 회원가입<small>을 하셔야 합니다</small>');
		$('#global_content #member_login').addClass('btn btn-primary').css('margin-bottom','10px');
		$('#global_content #member_regist').addClass('btn btn-primary').css('margin-bottom','10px');
		$('#admin_main').text('ADMIN MODE');
		$('.box a').addClass('pointer');
	}
	var onCreate = function() {
		this.setContentView();
		$('#header').click(function() {
			controller.home();
		});
		$('#nav a').click(function(e) {
			controller.move(e.target.getAttribute('id').split("_")[1],"main");
		});
		$('.box article a').click(function(e){
			var aid = e.target.getAttribute('id').split("_");
			if(aid.includes("admin")&&!admin.checkAdmin()){
				return;
			}
			controller.move(aid[0],aid[1]);
		});
		$('#bt_bom').click(function(){controller.move('douglas','bom')});
		$('#bt_dom').click(function(){controller.move('douglas','dom')});
		$('#bt_kaup').click(function(){controller.move('douglas','kaup')});
		$('#bt_account').click(function(){controller.move('douglas','account')});
	}
	return {init : init,setContentView : setContentView, onCreate : onCreate};	
})();

var admin = (function() {
	var _pass;
	var getPass = function() { return this._pass };
	var setPass = function(pass) { this._pass = pass; };
	return {setPass : setPass,getPass : getPass,
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
	var init = function(){
		this.onCreate();
	}
	var setContentView = function(){
		$('#img_home').attr('src',session.getImgPath()+'/home.png').attr('alt','home').css('width','50').css('height','50');
		$('#img_logout').attr('src',session.getImgPath()+'/logout.png').attr('alt','logout').css('width','50').css('height','50');
	}
	var onCreate = function(){
		this.setContentView();
		$('#img_logout').click(function() {
			controller.move('member','logout');
		})
		$('#img_home').click(function() {
			controller.home();
		})
	};
	return {
		init : init,
		setContentView : setContentView,
		onCreate : onCreate
	};
})();
var account = (function() {
	var _account_no,_money;
	var setAccountNo = function(account_no){this._account_no = account_no;}
	var getAccountNo = function(){return this._account_no;}
	var setMoney = function(money){this._money=money;}
	var getMoney = function(){return this._money;}
	var init = function(){
		this.onCreate();
	}
	var setContentView = function(){
		$('#account_content').siblings("h1").text('ACCOUNT MANAGEMENT');
	}
	var onCreate = function(){
		this.setContentView();
		$("#bt_spec_show").click(member.spec);
		$("#bt_make_account").click(account.open);
		$("#bt_deposit").click(account.deposit);
		$("#bt_withdraw").click(account.withdraw);
	};
	return {
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		init : init,
		setContentView : setContentView,
		onCreate : onCreate,
		open : function() {
			this.setAccountNo(Math.floor((Math.random()*899999)+100001));
			this.setMoney(0);
			$("#account").innerHTML = this.getAccountNo();
			$(".databox #money").innerHTML = this.getMoney();
		},
		deposit : function() {
			if(!util.isNumber(this.getAccountNo())){
				alert('통장부터 만드셈');
			}
			setMoney(this.getMoney() + Number($("input[id=money]").value));
			$(".databox #money").innerHTML = this.getMoney();
		},
		withdraw : function() {
			if(!util.isNumber(getAccountNo())){
				alert('통장부터 만드셈');
				return;
			}
			var withdraw_money = Number($("input[id=money]").value);	
			if(this.getMoney() < withdraw_money){
				alert('출금액이 더 큼');
			}else{
				this.setMoney(this.getMoney() - withdraw_money);
				$(".databox #money").innerHTML = this.getMoney();
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
	var init = function(){
		this.onCreate();
	}
	var setContentView = function(){
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
		$('#member_regist_content').addClass('box').css('width','50%');
		$('#member_regist_content span').addClass('float_left').addClass('text_left').addClass('font_bold').css('width','200px');
		$('#member_regist_content #bt_join').addClass('btn').addClass('btn-primary');
		$('#member_regist_content #bt_cancel').addClass('btn').addClass('btn-danger');
		$('#member_regist_form').addClass('form-horizontal');
		$('#member_regist_form > div:nth-child(8) > div > div').addClass('checkbox');
		$('#member_regist_form > div').addClass('form-group');
		$('#member_regist_form div:nth-child(7) label:gt(0)').addClass('radio-inline');
		$('#member_regist_form div:nth-child(8) label:gt(0)').addClass('checkbox-inline');
		$('.form-group > div').addClass('col-sm-10');
		$('.form-group > label').addClass('col-sm-2').addClass('control-label');
		$('.col-sm-10 > input').addClass('form-control');
	}
	var onCreate = function(){
		this.setContentView();
	}
	return {
		setName : setName,
		getName : getName,
		setSsn : setSsn,
		getSsn : getSsn,
		setGender : setGender,
		getGender : getGender,
		setAge : setAge,
		getAge : getAge,
		init : init,
		setContentView : setContentView,
		onCreate : onCreate,
		spec : function() {
			this.setName($(".formbox #name").value);
			this.setSsn($("#ssn").value);
			var scode = Number(this.getSsn().split("-")[1]);
			var ageYear = Number(this.getSsn().substring(0,2));
			var gen = (scode+2)%2==0? '여':'남';
			this.setGender(gen);
			var nowYear = new Date().getFullYear();
			switch (scode) {
			case 1:	case 2:	case 5:	case 6:
				this.setAge(nowYear - (1900 + ageYear) + 1);
				break;
			case 9:	case 0:
				this.setAge(nowYear - (1800 + ageYear) + 1);
				break;
			default:
				this.setAge(nowYear - (2000 + ageYear) + 1);
				break;
			}
			$('.databox #name').innerHTML = this.getName();
			$('#age').innerHTML = this.getAge();
			$('#gender').innerHTML = this.getGender();
		}
	};
})();
var grade = (function(){
	var init = function(){
		this.onCreate();
	}
	var setContentView = function(){
		// grade style
		$('#grade_content').siblings("h1").text('GRADE MANAGEMENT');
		$('#grade_content_ol > li:first > a').text('REGIST').addClass('remove_underline');
		$('#grade_content_ol > li:nth-child(2) > a').text('UPDATE').addClass('remove_underline');
		$('#grade_content_ol > li:nth-child(3) > a').text('DELETE').addClass('remove_underline');
		$('#grade_content_ol > li:nth-child(4) > a').text('LIST').addClass('remove_underline');
		$('#grade_content_ol > li:nth-child(5) > a').text('COUNT').addClass('remove_underline');
		$('#grade_content_ol > li:nth-child(6) > a').text('SEARCH').addClass('remove_underline');
	}
	var onCreate = function(){
		this.setContentView();
	};
	
	return {
		init : init,
		setContentView : setContentView,
		onCreate : onCreate
	};
})();

























var controller = (function() {
	var _page,_directory;
	var setPage = function(page) {this._page = page;}
	var getPage = function() {	return this._page;	}
	var setDirectory = function(directory) {this._directory = directory;}
	var getDirectory = function() {	return this._directory;	}
	return {
		move : function(directory,page) {
			this.setDirectory(directory);
			this.setPage(page);
			location.href = session.getContext() + '/'+this.getDirectory()+'/'+this.getPage();
		},
		home : function() { location.href = session.getContext() + "/"; },
		setPage : setPage,
		getPage : getPage,
		setDirectory : setDirectory,
		getDirectory : getDirectory
	};	
})();
var util = (function() {
	return {
		isNumber : function isNumber(value) {
			  return typeof value === 'number' && isFinite(value);
		}
	};
})();
var session = (function() {
	var _context,_js,_css,_img;
	var setContext = function(context){this._context=context;}
	var getContext = function(){return this._context;}
	var setJsPath = function(js){this._js=js;}
	var getJsPath = function(){return this._js;}
	var setCssPath = function(css){this._css=css;}
	var getCssPath = function(){return this._css;}
	var setImgPath = function(img){this._img=img;}
	var getImgPath = function(){return this._img;}
	return {
		init : function(param) {
			this.setContext(param);
			this.setJsPath(param+'/resources/js');
			this.setCssPath(param+'/resources/css');
			this.setImgPath(param+'/resources/img');
		},
		setContext : setContext,
		getContext : getContext,
		setJsPath : setJsPath,
		getJsPath : getJsPath,
		setCssPath : setCssPath,
		getCssPath : getCssPath,
		setImgPath : setImgPath,
		getImgPath : getImgPath
	}
})();